package com.zvz.WebService;

import com.zvz.common.User;

import javax.jws.WebService;

@WebService(endpointInterface="com.zvz.WebService.IMyService")
public class MyServiceImpl implements IMyService {

    public int add(int a, int b) {
        System.out.println(a + "+" + b + "=" + (a + b));
        return a+b;
    }

    public int minus(int a, int b) {
        System.out.println(a + "-" + b + "=" + (a - b));
        return a-b;
    }

    public User login(String username, String password) {
        System.out.println(username + "is logining");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}