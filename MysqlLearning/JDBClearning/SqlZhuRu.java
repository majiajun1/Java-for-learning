package JDBClearning;

import java.sql.*;

public class SqlZhuRu {
    public static void main(String[] args) throws SQLException {

        login2("zjx","123456");
        login2("'or'1=1","123456");
    }

    //登录业务
    public static void login(String username, String password) throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet resultSet = null;

        conn=JdbcUtils.getConnection();
        stmt=conn.createStatement();
        String sql="select * from users where Name='"+username+"' And Password='"+password+"'";
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

    public static void login2(String username, String password) throws SQLException {
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

         String sql3="select * from users where `name`=? and `password`=?";
         ps=conn.prepareStatement(sql3);
         ps.setString(1,username);
         ps.setString(2,password);
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
