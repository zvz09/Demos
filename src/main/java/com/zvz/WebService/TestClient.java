package com.zvz.WebService;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
/**
 * Created by lilipo on 2017/5/4.
 */
public class TestClient {

    public static void main(String[] args) {
        try {
            //创建访问WSDL服务地址的URL
            URL url = new URL("http://localhost:8887/ws?wsdl");
            //通过QName指明服务的具体信息(<MyServiceImplService xmlns="http://service.zttc.org/">)
            QName sname = new QName("http://WebService.zvz.com/", "MyServiceImplService");
            //创建服务
            Service service = Service.create(url, sname);
            //实现接口
            IMyService ms = service.getPort(IMyService.class);
            System.out.println(ms.add(12, 33));
            //以上服务有问题，依然依赖于IMyService接口
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
