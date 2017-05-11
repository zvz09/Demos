package com.zvz.mybatis.test;

import com.zvz.mybatis.domain.CsdnblogEntity;
import com.zvz.mybatis.domain2.MovecarVerificaEntity;
import com.zvz.mybatis.service.ICsdnblogService;
import com.zvz.mybatis.service.IMethodLogService;
import com.zvz.mybatis.service.IMovecarVerifica;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;

/**
 * Created by lilipo on 2017/5/2.
 */
public class MybatisTest {


    @Test
    public void test01(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
       /* UserService userService = (UserService) ac.getBean("userService");
        System.out.println(userService.get(1));
        System.out.println(userService.get2(1));

        FlowService flowService = (FlowService) ac.getBean("flowService");
        System.out.println(flowService.get("94003d29-a7b0-42f0-839c-fa609b209ff1"));*/

        System.out.println(ac);

        ICsdnblogService csdnblogService = (ICsdnblogService)ac.getBean("csdnblogService");

        IMovecarVerifica verifica = (IMovecarVerifica)ac.getBean("movecarVerificaImpl");

        IMethodLogService methodLogService = (IMethodLogService)ac.getBean("methodLogServiceImpl");
        System.out.print("Mysql 数据库数据:");
        System.out.println(csdnblogService.queryObject(1).getAuthor());


        System.out.print("Oracle 数据库数据:");
        System.out.println(verifica.queryObject(188).getMobile());

        System.out.print("sqlserver 数据库数据:");
        System.out.println(methodLogService.queryObject(1).toString());
    }

    @Test
    public void test02(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

        ICsdnblogService csdnblogService = (ICsdnblogService)ac.getBean("csdnblogService");

        IMovecarVerifica verifica = (IMovecarVerifica)ac.getBean("movecarVerificaImpl");

        MovecarVerificaEntity verificaEntity = new MovecarVerificaEntity();

        verificaEntity.setMobile("111111111");
        verificaEntity.setCode("159874");
        verificaEntity.setIsvalid(0);
        verificaEntity.setSendtime(new Timestamp(System.currentTimeMillis()));

        verifica.save(verificaEntity);

        System.out.println("verificaEntity_ID==="+verificaEntity.getId());
    }

    @Test
    public void test03(){

        ApplicationContext ac = new ClassPathXmlApplicationContext("atomikosContext.xml");
        System.out.println(ac);

        ICsdnblogService csdnblogService = (ICsdnblogService)ac.getBean("csdnblogService");

        CsdnblogEntity csdnblogEntity = new CsdnblogEntity();
        csdnblogEntity.setAuthor("ccc");
        csdnblogEntity.setAuthorUrl("ccc");
        csdnblogEntity.setContext("ccc");
        csdnblogEntity.setUrl("cc");
        csdnblogEntity.setLabel("cc");
        csdnblogEntity.setTitle("ccc");
        csdnblogEntity.setCreatDate(new Timestamp(System.currentTimeMillis()));

        MovecarVerificaEntity verificaEntity = new MovecarVerificaEntity();
        verificaEntity.setMobile("111111111");
        verificaEntity.setCode("159874");
        verificaEntity.setIsvalid(0);
        verificaEntity.setSendtime(new Timestamp(System.currentTimeMillis()));

        csdnblogService.saveAll(csdnblogEntity,verificaEntity,true);

    }
}
