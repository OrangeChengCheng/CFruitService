package com.example.cfruitservice.cfruitservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;

@RestController
@SpringBootApplication
public class CfruitserviceApplication {


    //mysql驱动包名
    private static final String DRIVER_NAME = "com.mysql.cj.jdbc.Driver";
    //数据库连接地址
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cfruit";
    //用户名
    private static final String USER_NAME = "root";
    //密码
    private static final String PASSWORD = "chengkai";

    @RequestMapping("/hello")
    String index () {

        String text = "";
        Connection connection = null;
        try {
            System.out.println("try");
            //加载mysql的驱动类
            Class.forName(DRIVER_NAME);
            //获取数据库连接
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            //mysql查询语句
            String sql = "SELECT * FROM authors";
            PreparedStatement prst = connection.prepareStatement(sql);
            //结果集
            ResultSet rs = prst.executeQuery();
            while (rs.next()) {
                System.out.println("用户名:" + rs.getString("username"));
                text = text + "[]" + "用户名:" + rs.getString("username");
            }
            rs.close();
            prst.close();
        } catch (Exception e) {
            System.out.println("catch");
            System.out.println(e);
            e.printStackTrace();
        }finally {
            System.out.println("finally");
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("dfhjkh");
        return text;
    }




    public static void main(String[] args) {
        SpringApplication.run(CfruitserviceApplication.class, args);
    }

}
