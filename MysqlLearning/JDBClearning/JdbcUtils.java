package JDBClearning;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String driver = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;



    static{
        try{
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);

            driver = properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");
            //1.驱动只需加载一次
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url, username, password);
    }


    //释放连接资源
    public static void release(Connection conn, Statement stmt, ResultSet rs) throws SQLException {
        if(rs!=null)
        {
            rs.close();
        }
        if(stmt!=null)
        {
            stmt.close();
        }
        if(conn!=null)
        {
            conn.close();
        }
    }
}
