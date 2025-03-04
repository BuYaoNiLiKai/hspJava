package mysql_;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBC_ApachTest {

    // apache dbutils 尝试
    @Test
    void testApacheUseMy() throws SQLException {
        Connection conn = null;
        String sql = "select * from goods";
        conn = JDBCUtilsByDruid.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ArrayList<Goods> goodsList = new ArrayList<Goods>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("goods_name");
            double price = rs.getDouble("price");
            Goods goods = new Goods(id, name, price);
            goodsList.add(goods);
        }
        JDBCUtilsByDruid.close(conn, ps, rs);
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }


    }

    @Test
    void testApache() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        System.out.println(conn);
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from goods";
        List<Goods> goodsList = queryRunner.query(conn, sql, new BeanListHandler<Goods>(Goods.class));
        for (Goods goods : goodsList) {
            System.out.println(goods);

        }
        JDBCUtilsByDruid.close(conn, null, null);

//        queryRunner.query(conn, sql, new BeanHandler<Goods>(Goods.class),1).var;

    }

    @Test
    void testSingel() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        System.out.println(conn);
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from goods where id = ?";

        Goods query = queryRunner.query(conn, sql, new BeanHandler<Goods>(Goods.class), 1);
        System.out.println(query);
        JDBCUtilsByDruid.close(conn, null, null);
    }

    @Test
    void testScaler() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        System.out.println(conn);
        QueryRunner queryRunner = new QueryRunner();
        String sql = "select * from goods where id = ?";
        // 单行单列
        Object obj = queryRunner.query(conn, sql, new ScalarHandler<>(), 1);
        System.out.println(obj);
        JDBCUtilsByDruid.close(conn, null, null);
    }

    @Test
    void testDML() throws SQLException {
        Connection conn = JDBCUtilsByDruid.getConnection();
        System.out.println(conn);
        QueryRunner queryRunner = new QueryRunner();
        String sql = "update goods set goods_name = ? where id = ?";
        // 单行单列
        int affectRow = queryRunner.update(conn, sql, "apple", 3);
        System.out.println(affectRow);
        JDBCUtilsByDruid.close(conn, null, null);
    }
}
