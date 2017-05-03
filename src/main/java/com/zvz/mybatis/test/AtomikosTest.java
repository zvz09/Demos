package com.zvz.mybatis.test;

import com.zvz.mybatis.service.ICsdnblogService;
import com.zvz.mybatis.service.IMovecarVerifica;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lilipo on 2017/5/3.
 */
public class AtomikosTest {

    @Test
    public void test01(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("atomikosContext.xml");
       /* UserService userService = (UserService) ac.getBean("userService");
        System.out.println(userService.get(1));
        System.out.println(userService.get2(1));

        FlowService flowService = (FlowService) ac.getBean("flowService");
        System.out.println(flowService.get("94003d29-a7b0-42f0-839c-fa609b209ff1"));*/

        System.out.println(ac);

        ICsdnblogService csdnblogService = (ICsdnblogService)ac.getBean("csdnblogService");

        IMovecarVerifica verifica = (IMovecarVerifica)ac.getBean("movecarVerificaImpl");
        System.out.print("Mysql 数据库数据:");
        System.out.println(csdnblogService.queryObject(9).getAuthor());


        System.out.print("Oracle 数据库数据:");
        System.out.println(verifica.queryObject(188).getMobile());
    }
}
