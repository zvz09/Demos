package com.zvz.velocity;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class HelloVelocity {
    public static void main(String[] args) throws Exception {
// 初始化并取得Velocity引擎
        VelocityEngine ve = new VelocityEngine();
// 取得velocity的模版
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();
//取得velocity的模版
        Template t = ve.getTemplate("Velocity/hellovelocity.vm", "utf-8");
// 取得velocity的上下文context
        VelocityContext context = new VelocityContext();
// 把数据填入上下文
        context.put("name", "Liang");
        context.put("date", (new Date()).toString());
// 为后面的展示，提前输入List数值
        List temp = new ArrayList();
        temp.add("item1");
        temp.add("item2");
        context.put("list", temp);
        List tempBean = new ArrayList();
        tempBean.add(new UserInfo("1", "张三", "福建"));
        tempBean.add(new UserInfo("2", "李四", "湖南"));
        context.put("listBean", tempBean);
// 输出流
        StringWriter writer = new StringWriter();
// 转换输出
        t.merge(context, writer);
// 输出信息
        System.out.println(writer.toString());
// 输出到文件
        FileOutputStream of = new FileOutputStream("e:/velocity.txt");
        of.write(writer.toString().getBytes("GBK"));
        of.flush();
        of.close();
    }
}