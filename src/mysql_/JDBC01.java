package mysql_;


import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {
    public static void main(String[] args) throws SQLException {
        // 项目下创建文件夹 将jar包加载到项目

        // 注册驱动
        Driver driver = new Driver();
        // 得到链接
        String url = "jdbc:mysql://localhost:3306/zpc_db2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zpc521..00");
        Connection conn = driver.connect(url, properties);

        // 执行sql
        String sql = "delete from goods where id=2";
        Statement stmt = conn.createStatement();
        stmt.execute(sql);
        
//        ResultSet rs = stmt.executeQuery(sql);
//        while (rs.next()) {
//            System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3));
//        }

        // 用于执行静态的sql语句执行
        // 关闭
        conn.close();
    }
}
