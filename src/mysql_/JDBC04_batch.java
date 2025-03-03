package mysql_;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBC04_batch {
    @Test
    public void noBatchInsert() throws SQLException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        String sql = "insert into admin2 values(null,?,?)";
        System.out.println("开始执行");
        long time = System.currentTimeMillis();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 5000; i++) {
            ps.setString(1, "jack" + i);
            ps.setString(2, "666");
            ps.executeUpdate();
        }
        JDBCUtils.close(conn, ps, null);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
    }

    @Test
    public void batchInsert() throws SQLException {
        Connection conn = null;
        conn = JDBCUtils.getConnection();
        String sql = "insert into admin3 values(null,?,?)";
        System.out.println("开始执行");
        long time = System.currentTimeMillis();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < 5000; i++) {
            ps.setString(1, "jack" + i);
            ps.setString(2, "666");
            //  排队 当有一千条语句的时候在执行
            ps.addBatch();
            if ((i + 1) % 1000 == 0) {
                ps.executeBatch();
                ps.clearBatch();
            }
        }
        JDBCUtils.close(conn, ps, null);
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time);
    }

    public static void main(String[] args) {

    }
}
