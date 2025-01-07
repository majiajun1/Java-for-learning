package JDBClearning;

import java.sql.*;

public class FirstClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法  静态代码块 自动注册




        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy" +
                "?useUnicode=true" +
                "&characterEncoding=utf8&useSSL=false"; //版本问题 要false
        String username="root";
        String password="123456";

        //3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);

//        connection.rollback();
//        connection.commit();
//        connection.setAutoCommit(false);

        //4.执行sql的对象
        Statement statement = connection.createStatement();

//        statement.execute();
//        statement.executeUpdate(); //更新、插入、删除  返回一个受影响的行数
//        statement.executeQuery();
//        statement.executeBatch();
        //5.执行sql的对象
        String sql="SELECT * FROM `users`";
        ResultSet resultSet = statement.executeQuery(sql);

//        resultSet.getObject();  不知道列的类型用这个
//        resultSet.getString();
//        resultSet.getInt();
//        resultSet.getFloat();
//        resultSet.getDate();
//        resultSet.getDate();

//        resultSet.beforeFirst();  //移动最前面
//        resultSet.afterLast();  //移动到最后
//        resultSet.previous();//移动到前一行
//        resultSet.absolute(1);//移动到指定行
        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("password"));

            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("birthday"));
            System.out.println("=================================");
        }

        //6.释放连接
        resultSet.close();
        statement.close();
        connection.close();
    }


}
