package com.zvz.Gson;

import com.google.gson.Gson;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by lilipo on 2017/5/2.
 */
public class GsonTest {

    public static final char[] chars = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C', 'V', 'B', 'N', 'M'};
    public static Random random = new Random();


    @Test
    public void gson() {
        Gson gson = new Gson();
        String listJsonStr = "[\"1\",\"a\",\"3\",\"rt\",\"5\"]";

        Type type = new TypeToken<ArrayList<String>>() {
        }.getType();
        ArrayList<String> sList = gson.fromJson(listJsonStr, type);

        System.out.println(sList.toString());

        ArrayList<User> users = new ArrayList<User>();
        for (Integer i = 0; i <= 10; i++) {
            users.add(new User(i, i));
        }

        String s = gson.toJson(users);
        System.out.println(s);

        Type usertype = new TypeToken<ArrayList<User>>() {
        }.getType();
        ArrayList<User> users1 = gson.fromJson(s, usertype);
        System.out.println(users1.toString());
    }

    private static void log(String msg) {
        System.out.println(msg);
    }

    @Test
    public void gson2() {
        String studentJsonStr = "{\"name\":\"xuanyouwu\",\"age\":26}";
        log("------>studentJsonStr:" + studentJsonStr);
        JsonPrimitive jsonPrimitive = new JsonPrimitive(studentJsonStr);
        log("------>jsonPrimitive:" + jsonPrimitive);
        log("------>jsonPrimitive:" + jsonPrimitive.toString());
        log("------>jsonPrimitive:" + jsonPrimitive.getAsString());

        JsonPrimitive jsonPrimitive2 = new JsonPrimitive("this is String");
        log("------>jsonPrimitive2:" + jsonPrimitive2);
        log("------>jsonPrimitive2:" + jsonPrimitive2.toString());
        log("------>jsonPrimitive2:" + jsonPrimitive2.getAsString());

    }

    public static int getRandNum(int min, int max) {
        int randNum = min + (int) (Math.random() * ((max - min) + 1));
        return randNum;
    }

    /**
     * 产生随机的六位数
     *
     * @return
     */
    public String getSix() {
        Random rad = new Random();
        String result = rad.nextInt(1000000) + "";
        if (result.length() != 6) {
            return getSix();
        }
        return result;
    }

    public String getRandomString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <= 5; i++) {
            sb.append(chars[random.nextInt(chars.length)]);
            ;
        }
        return sb.toString();
    }


    private class User {
        private Integer no;
        private Integer id;

        public User(Integer no, Integer id) {
            this.no = no;
            this.id = id;
        }

        public Integer getNo() {
            return no;
        }

        public void setNo(Integer no) {
            this.no = no;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }
    }
}
