package mysql_;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBC08_TestDruid {
    @Test
    void testDruid() throws SQLException {
        Connection conn = null;
        String sql = "select * from goods";
        conn = JDBCUtilsByDruid.getConnection();
        System.out.println(conn.getClass());
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            System.out.println(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
        }
        JDBCUtilsByDruid.close(conn, ps, rs);

    }
}
