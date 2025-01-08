package JDBClearning;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;

public class JdbcUtils_DBCP
{
    private static DataSource ds=null;
 static{
        try{
            InputStream resourceAsStream = JdbcUtils_DBCP.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
            Properties properties = new Properties();
            properties.load(resourceAsStream);
            //创建数据源 工厂模式--》创建
            ds = BasicDataSourceFactory.createDataSource(properties);


        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
 }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();   //数据源中获取连接源
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
