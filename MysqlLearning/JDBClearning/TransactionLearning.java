package JDBClearning;

import java.sql.*;

public class TransactionLearning {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        conn=JdbcUtils.getConnection();

        //关闭数据库的自动提交功能，自动会开启事务
        conn.setAutoCommit(false); //开启事务
        String sql1="update account set money=money-100 where name = 'A'";
        stmt=conn.prepareStatement(sql1);
        stmt.executeUpdate();
         //人为设置错误  看看只执行sql1不执行sql2的情况


        String sql2="update account set money=money+100 where name = 'B'";
        stmt=conn.prepareStatement(sql2);
        stmt.executeUpdate();

        //提交事务

        try{
            conn.commit();

        System.out.println("成功！");

        }catch(SQLException e){
           try{
               conn.rollback();

           }catch(SQLException e1){
               e1.printStackTrace();
           }
        }
        finally {
                conn.setAutoCommit(true);
                JdbcUtils.release(conn, stmt, rs);


        }


    }
}
