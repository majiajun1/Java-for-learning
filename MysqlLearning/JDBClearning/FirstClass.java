package JDBClearning;

import java.sql.*;

public class FirstClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动
        Class.forName("com.mysql.jdbc.Driver");//固定写法




        //2.用户信息和url
        String url="jdbc:mysql://localhost:3306/jdbcstudy" +
                "?useUnicode=true" +
                "&characterEncoding=utf8&useSSL=false"; //版本问题 要false
        String username="root";
        String password="123456";

        //3.连接成功，数据库对象
        Connection connection = DriverManager.getConnection(url, username, password);


        //4.执行sql的对象
        Statement statement = connection.createStatement();


        //5.执行sql的对象
        String sql="SELECT * FROM `users`";
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("NAME"));
            System.out.println(resultSet.getString("password"));

            System.out.println(resultSet.getString("email"));
            System.out.println(resultSet.getString("birthday"));
            System.out.println("=================================");
        }

        //6.释放连接
    }


}
