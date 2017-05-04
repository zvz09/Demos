package com.zvz.WebService;

import javax.xml.ws.Endpoint;

/**
 * Created by lilipo on 2017/5/4.
 *
 * 发布服务
 */
public class MyServer {

    /**
     * http://localhost:8887/ns?wsdl
     * @param args
     */
    public static void main(String[] args) {
        String address = "http://localhost:8887/ws";
        Endpoint.publish(address, new MyServiceImpl());
    }
}
