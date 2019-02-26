package com.example.cfruitservice.unit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {

    public static void Log (String string) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        System.out.println("【 " + df.format(new Date()) + " 】->  " + string);
    }
}
