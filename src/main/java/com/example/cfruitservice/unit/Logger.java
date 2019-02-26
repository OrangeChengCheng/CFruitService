package com.example.cfruitservice.unit;


import com.example.cfruitservice.MySQLConn;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;


@Service
public class Logger {

    public static void recordRequestOperate(String requestParam, HttpServletRequest request) {
        String requestName = request.getRequestURL().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String requestDate = df.format(new Date());

        Connection connection = null;
        try {
            //获取数据库连接
            connection = MySQLConn.getConnection();

            //mysql查询语句
            String sql = "INSERT INTO requestlogs (requestName,requestParam,requestDate) VALUES (?,?,?)";

            PreparedStatement prst=(PreparedStatement) connection.prepareStatement(sql);
            prst.setString(1,requestName);
            prst.setString(2,requestParam);
            prst.setString(3,requestDate);
            prst.executeUpdate();

            MySQLConn.closeResultSet(prst, null);
        } catch (Exception e) {
            System.out.println("catch");
            System.out.println(e);
            e.printStackTrace();
        }finally {
            MySQLConn.closeConn(connection);
        }

    }
}
