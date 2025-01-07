package JDBClearning;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lesson2 {
    public static void main(String[] args) throws SQLException {

        Connection conn=null;
        Statement st=null;


        conn=JdbcUtils.getConnection(); //获得数据库连接
        st=conn.createStatement(); //获得SQL的执行对象
        String sql="INSERT INTO users(id,`name`,`password`,`email`,`birthday`)" +
                "VALUES (5,'mjj2','123456','asdasdasd@qq,com','2020-01-01')";

        String sql2=
                "DELETE FROM users WHERE `id`=5";
        String sql3=
                "UPDATE users SET `name`='zjx' WHERE `name`='mjj'";
        int i=st.executeUpdate(sql3);
        if(i>0)
        {
            System.out.println("修改成功");
        }

        JdbcUtils.release(conn,st,null);



    }

}
