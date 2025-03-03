package mysql_;

import com.mysql.cj.jdbc.Driver;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBC02_Conne {
    public static void main(String[] args) {

    }

    @Test
    public void connect1() throws SQLException {
        // 注册驱动
        Driver driver = new Driver();
        // 得到链接
        String url = "jdbc:mysql://localhost:3306/zpc_db2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zpc521..00");
        Connection conn = driver.connect(url, properties);
        System.out.println(conn);
        conn.close();

    }

    @Test
    public void connect2() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 使用反射
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/zpc_db2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "zpc521..00");
        Connection conn = driver.connect(url, properties);
        System.out.println(conn);
        conn.close();
    }

    // 使用DriverManager替代Driver 进行统一管理
    @Test
    public void connect3() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 使用反射
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/zpc_db2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        Properties properties = new Properties();
        String user = "root";
        String password = "zpc521..00";
        properties.setProperty("user", user);
        properties.setProperty("password", password);
        DriverManager.registerDriver(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        connection.close();
    }

    // 使用class.formane 自动完成注册 简化代码 最多
    @Test
    public void connect4() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // 在加载dirver类的时候 完成了注册
        Class<?> clazz = Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/zpc_db2?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "root";
        String password = "zpc521..00";
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);

    }

    @Test
    public void connect5() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("./src/mysql_/mysql.properties"));
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driver = props.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);


    }

    @Test
    public void practice() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("./src/mysql_/mysql.properties"));
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driver = props.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        //得到链接
        String createSql = "create table news (id INT,name VARCHAR(255))";
        Statement statement = connection.createStatement();
        int res = statement.executeUpdate(createSql);
        System.out.println("创建完成");
        String insertSql1 = "insert into news (id,name) values(1,'zpc')";
        String insertSql2 = "insert into news (id,name) values(2,'qzy')";
        String insertSql3 = "insert into news (id,name) values(3,'qzc')";
        String insertSql4 = "insert into news (id,name) values(4,'zy')";
        String insertSql5 = "insert into news (id,name) values(5,'qy')";
        statement.executeUpdate(insertSql1);
        statement.executeUpdate(insertSql2);
        statement.executeUpdate(insertSql3);
        statement.executeUpdate(insertSql4);
        statement.executeUpdate(insertSql5);
        String selectSql = "select * from news";
        ResultSet resultSet = statement.executeQuery(selectSql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
        }
        String updateSql = "update news set name = '宗培超' where id = 1";
        statement.executeUpdate(updateSql);
        String deleteSql = "delete from news where id = 3";

        statement.executeUpdate(deleteSql);
        resultSet = statement.executeQuery(selectSql);
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id") + " " + resultSet.getString("name"));
        }
        statement.close();
        connection.close();


    }
}
