package JDBClearning;

import java.lang.reflect.Constructor;
import java.sql.*;

public class Lesson3 {
    public static void main(String[] args) throws SQLException {
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        conn=JdbcUtils.getConnection();

        //区别
        //使用问号占位符  代替参数
//        String sql="INSERT INTO users(id,`name`,`password`,`email`,`birthday`)" +
//                "VALUES (?,?,?,?,?)";
//
//        ps=conn.prepareStatement(sql);//预编译sql,先写sql
//
//        //手动给参数赋值
//        ps.setInt(1,5);
//        ps.setString(2,"mjj2");
//        ps.setString(3,"123456");
//        ps.setString(4,"mjj2@gmail.com");
//        ps.setDate(5, new java.sql.Date(System.currentTimeMillis()));

//
//        //删除
//        String sql2="delete from users where id=?";
//        ps=conn.prepareStatement(sql2);
//        ps.setInt(1,5);

         String sql3="select * from users where id=?";
         ps=conn.prepareStatement(sql3);
         ps.setInt(1,1);
         rs=ps.executeQuery();
         while(rs.next()){
             System.out.println(rs.getString("name"));

         }




        //执行
//        int i=ps.executeUpdate();
//        if(i>0)
//        {
//            System.out.println("插入成功");
//        }
//
        JdbcUtils.release(conn,ps,rs);



    }
}
