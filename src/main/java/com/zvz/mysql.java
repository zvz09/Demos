package com.zvz;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import com.mysql.jdbc.Connection;
import org.junit.Test;

import java.lang.reflect.Type;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lilipo on 2017/4/28.
 */
public class mysql {

    public static final char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    public static Random random = new Random();

    @Test
    public void cc() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //引用代码此处需要修改，address为数据IP，Port为端口号，DBName为数据名称，UserName为数据库登录账户，Password为数据库登录密码
            con = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.10.100:3306/test",
                    "root", "root");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(con);

        try {
            testConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void testConnection(Connection con1) throws SQLException {
        try {
            String sql = "select * from oner_alarm";        //查询表名为“oner_alarm”的所有内容
            Statement stmt = con1.createStatement();        //创建Statement
            ResultSet rs = stmt.executeQuery(sql);          //ResultSet类似Cursor
            while (rs.next()) {
                System.out.println(rs.getString("id"));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {

        } finally {
            if (con1 != null)
                try {
                    con1.close();
                } catch (SQLException e) {
                }
        }
    }

    @Test
    public void cccc() {
//定义一些变量，用来格式化输出。
        double d = 345.678;
        String s = "你好！";
        int i = 1234;
//"%"表示进行格式化输出，"%"之后的内容为格式的定义。
     /*   System.out.printf("%f",d); //"f"表示格式化输出浮点数。
        System.out.println();
        System.out.printf("%9.2f",d); //"9.2"中的9表示输出的长度，2表示小数点后的位数。
        System.out.println();
        System.out.printf("%+9.2f",d); //"+"表示输出的数带正负号。
        System.out.println();
        System.out.printf("%-9.4f",d); //"-"表示输出的数左对齐（默认为右对齐）。
        System.out.println();
        System.out.printf("%+-9.3f",d); //"+-"表示输出的数带正负号且左对齐。
        System.out.println();
        System.out.printf("%d",i); //"d"表示输出十进制整数。
        System.out.println();
        System.out.printf("%o",i); //"o"表示输出八进制整数。
        System.out.println();
        System.out.printf("%x",i); //"d"表示输出十六进制整数。
        System.out.println();
        System.out.printf("%#x",i); //"d"表示输出带有十六进制标志的整数。
        System.out.println();*/
        System.out.println(String.format("%s傻瓜的撒个机会", s)); //"d"表示输出字符串。
       /* System.out.println();
        System.out.printf("输出一个浮点数：%f，一个整数：%d，一个字符串：%s",d,i,s);
//可以输出多个变量，注意顺序。
        System.out.println();
        System.out.printf("字符串：%2$s，%1$d的十六进制数：%1$#x",i,s);
//"X$"表示第几个变量。*/

    }
}
