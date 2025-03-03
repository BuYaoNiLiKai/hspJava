package mysql_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JDBC03_injection {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
        String name;
        String pwd;
        System.out.println("请输入管理员的名字");
        name = scanner.nextLine();
        System.out.println("请输入密码");
        pwd = scanner.nextLine();

        Properties props = new Properties();
        props.load(new FileInputStream("./src/mysql_/mysql.properties"));
        String url = props.getProperty("url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        String driver = props.getProperty("driver");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
        Statement statement = connection.createStatement();
        String sql = "select name,pwd from admin where name = '" + name + "'" + " and pwd = '" + pwd + "'";
        System.out.println(sql);
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("恭喜 登录成功");
        } else {
            System.out.println("失败");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
