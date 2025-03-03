package mysql_;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC06_C3P0 {
    @Test
    void testC3P0() throws SQLException, IOException, PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        Properties props = new Properties();
        props.load(new FileInputStream("./src/mysql_/mysql.properties"));
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driver = props.getProperty("driver");
        String url = props.getProperty("url");

        //
        cpds.setUser(user);
        cpds.setPassword(password);
        cpds.setJdbcUrl(url);
        cpds.setDriverClass(driver);
        //设置初始化链接数
        cpds.setInitialPoolSize(10);
        // 最大链接数
        cpds.setMaxPoolSize(50);

        cpds.setMinPoolSize(5);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection conn = cpds.getConnection();
            conn.close();
        }
        long time2 = System.currentTimeMillis();
        System.out.println("C3P0时间：" + (time2 - time));


    }

    // 使用c3p0提供的配置文件
    @Test
    void testC3P1() throws SQLException, IOException, PropertyVetoException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("potato");
        Connection conn = cpds.getConnection();
        System.out.println("链接成功");
        conn.close();
    }

    public static void main(String[] args) {

    }
}
