package com.lzf;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        System.out.println(true);
//        System.out.println(false);
//        System.out.println();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Date today = null;
        try {
            today = simpleDateFormat.parse("2019-0");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("今天是：" + simpleDateFormat.format(today));
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        c.add(Calendar.MONTH, 1); //今天+1天
        Date tomorrow = c.getTime();
        System.out.println("明天是：" + simpleDateFormat.format(tomorrow));


        String a = "fasdfbe";
        String b = "fasdfbeb";
        System.out.println(a.substring(1, 4)); //beginIndex, endIndex|前包，后不包
        System.out.println((a.compareTo(b)) + ""); //a==b返回0；a<b返回负数；a>b返回正数

    }
}
