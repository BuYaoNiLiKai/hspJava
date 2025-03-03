package mysql_;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

public class JDBC05_Problem {
    @Test
    void question() throws SQLException {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection conn = JDBCUtils.getConnection();
            conn.close();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("传统方式" + (endTime - startTime));
    }
}
