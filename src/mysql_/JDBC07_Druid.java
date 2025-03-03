package mysql_;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBC07_Druid {
    @Test
    public void testDruid() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("src/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(props);
        Connection connection = dataSource.getConnection();
        long time = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            Connection conn = dataSource.getConnection();
            conn.close();
            connection.close();
        }
        System.out.println(System.currentTimeMillis() - time);
    }

    public static void main(String[] args) {

    }
}
