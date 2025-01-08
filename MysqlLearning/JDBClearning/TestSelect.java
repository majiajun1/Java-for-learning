package JDBClearning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSelect {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        conn=JdbcUtils.getConnection();
        stmt=conn.createStatement();
        String sql="select * from users where id=1";
        resultSet=stmt.executeQuery(sql);
         while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("password"));

            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("birthday"));
            System.out.println("=================================");
        }
         JdbcUtils.release(conn, stmt, resultSet);
    }
}
