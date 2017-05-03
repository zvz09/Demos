package com.zvz.httpClient;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class HttpClientLoginTest {
    @Test
    // 获取一个HTML页面的内容，一个简单的get应用
    public void grabPageHTML() throws Exception {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet("http://www.baidu.com/");
        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        String html = EntityUtils.toString(entity, "GBK");

        // releaseConnection等同于reset，作用是重置request状态位，为下次使用做好准备。
        // 其实就是用一个HttpGet获取多个页面的情况下有效果；否则可以忽略此方法。
        httpget.releaseConnection();

        System.out.println(html);
    }

    // 下载一个文件到本地（本示范中为一个验证码图片）
    @Test
    public void downloadFile() throws Exception {
        String url = "http://www.lashou.com/account/captcha";
        File dir = new File("D:\\TDDOWNLOAD");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String destfilename = "D:\\TDDOWNLOAD\\yz.png";
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        File file = new File(destfilename);
        if (file.exists()) {
            file.delete();
        }

        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        InputStream in = entity.getContent();
        try {
            FileOutputStream fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[2048];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp);
            }
            fout.close();
        } finally {
            // 在用InputStream处理HttpEntity时，切记要关闭低层流。
            in.close();
        }

        httpget.releaseConnection();
    }

    @Test
    // Post方法，模拟表单提交参数登录到网站。
    // 结合了上面两个方法：grabPageHTML/downloadFile，同时增加了Post的代码。
    public void login2Lashou() throws Exception {
        // 第一步：先下载验证码到本地
        String url = "http://www.lashou.com/account/captcha";
        String destfilename = "D:\\TDDOWNLOAD\\yz.png";
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);
        File file = new File(destfilename);
        if (file.exists()) {
            file.delete();
        }

        HttpResponse response = httpclient.execute(httpget);
        HttpEntity entity = response.getEntity();
        InputStream in = entity.getContent();
        try {
            FileOutputStream fout = new FileOutputStream(file);
            int l = -1;
            byte[] tmp = new byte[2048];
            while ((l = in.read(tmp)) != -1) {
                fout.write(tmp);
            }
            fout.close();
        } finally {
            in.close();
        }
        httpget.releaseConnection();

        // 第二步：用Post方法带若干参数尝试登录，需要手工输入下载验证码中显示的字母、数字
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("请输入下载下来的验证码中显示的数字...");
        String yan = br.readLine();

        HttpPost httppost = new HttpPost("http://www.lashou.com/account/login/");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("user_id", "testuser007"));
        params.add(new BasicNameValuePair("pwd", "asdfg123"));
        params.add(new BasicNameValuePair("yan", yan));
        params.add(new BasicNameValuePair("save_user", "on"));
        params.add(new BasicNameValuePair("save_pwd", "on"));
        params.add(new BasicNameValuePair("sub", "登录"));
        httppost.setEntity(new UrlEncodedFormEntity(params));

        response = httpclient.execute(httppost);
        entity = response.getEntity();
        // 在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
        String postResult = EntityUtils.toString(entity, "GBK");
        // 我们这里只是简单的打印出当前Cookie值以判断登录是否成功。
        CookieStore cookieStore = ((AbstractHttpClient) httpclient).getCookieStore();
        List<Cookie> cookies = ((AbstractHttpClient) httpclient)
                .getCookieStore().getCookies();
        for (Cookie cookie : cookies)
            System.out.println("cookie begin***\n" + cookie + "\n cookie end");
        httppost.releaseConnection();

        // 第三步：打开会员页面以判断登录成功（未登录用户是打不开会员页面的）
        String memberpage = "http://www.lashou.com/account/orders/";
        httpget = new HttpGet(memberpage);
        response = httpclient.execute(httpget); // 必须是同一个HttpClient！
        entity = response.getEntity();
        String html = EntityUtils.toString(entity, "GBK");
        httpget.releaseConnection();

        System.out.println(html);
    }

    @Test
    public void testSystemIn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                System.in));
        String hello = reader.readLine();
        System.out.println(hello);
    }

    @Test
    // 设置已获取的cookie，查看需要登录后才能查看的页面
    public void testGetinfoByLoginCookie() throws Exception, IOException {
        DefaultHttpClient httpclient = new DefaultHttpClient();
        CookieStore cookieStore = new BasicCookieStore();
        BasicClientCookie cookie1 = new BasicClientCookie("ThinkID","5s4tmqem08gh091v3egoa7sqf7");
        cookie1.setDomain(".lashou.com");
        BasicClientCookie cookie2 = new BasicClientCookie("city_b","2419");
        cookie2.setDomain("lashou.com");
        BasicClientCookie cookie3 = new BasicClientCookie("client_key","1425104707wd157b4b24ff70adcb875a");
        cookie3.setDomain("lashou.com");
        BasicClientCookie cookie4 = new BasicClientCookie("login_name2","testuser007");
        cookie4.setDomain("lashou.com");
        BasicClientCookie cookie5 = new BasicClientCookie("pwd2","4c88a4062736c26572d3ec382868fa2b");
        cookie5.setDomain("lashou.com");
        cookieStore.addCookie(cookie1);
        cookieStore.addCookie(cookie2);
        cookieStore.addCookie(cookie3);
        cookieStore.addCookie(cookie4);
        cookieStore.addCookie(cookie5);
        List<Cookie> cookies = new ArrayList<Cookie>();
        httpclient.setCookieStore(cookieStore);

        List<Cookie> cookieList = httpclient.getCookieStore().getCookies();
        for(int i=0;i<cookieList.size();i++){
            System.out.println("cookie"+i+":"+cookieList.get(i));
        }

        // 设置已登录的cookie
        String memberpage = "http://www.lashou.com/account/orders/";
        HttpGet httpget = new HttpGet(memberpage);
        HttpResponse response = httpclient.execute(httpget); // 必须是同一个HttpClient！
        HttpEntity entity = response.getEntity();
        entity = response.getEntity();
        String html = EntityUtils.toString(entity, "GBK");
        httpget.releaseConnection();

        System.out.println(html);
    }


    @Test
    public void postTest() throws IOException {
        HttpClient httpclient = new DefaultHttpClient();

        HttpPost httppost = new HttpPost("http://localhost:8088/xmjcy/admin/login.do");
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("username", "admin"));
        params.add(new BasicNameValuePair("password", "123456"));
        params.add(new BasicNameValuePair("submit.x", "17"));
        params.add(new BasicNameValuePair("submit.y", "12"));
        httppost.setEntity(new UrlEncodedFormEntity(params));

        HttpResponse response = httpclient.execute(httppost);
        HttpEntity entity = response.getEntity();
        entity = response.getEntity();
        // 在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
        String postResult = EntityUtils.toString(entity, "GBK");
        System.out.println("postResult:"+postResult);

        httppost.releaseConnection();

        HttpPost httppostAdd = new HttpPost("http://localhost:8088/xmjcy/admin/content/o_save.do");
        List<NameValuePair> paramsAdd = new ArrayList<NameValuePair>();
        paramsAdd.add(new BasicNameValuePair("channelId", "267"));
        paramsAdd.add(new BasicNameValuePair("topicIds", ""));
        paramsAdd.add(new BasicNameValuePair("title", "qwertyyyyyyyy"));
        paramsAdd.add(new BasicNameValuePair("link", ""));
        paramsAdd.add(new BasicNameValuePair("shortTitle", ""));
        paramsAdd.add(new BasicNameValuePair("titleColor", ""));
        paramsAdd.add(new BasicNameValuePair("bold", "FALSE"));
        paramsAdd.add(new BasicNameValuePair("tagStr", "cccccccccccccccc"));
        paramsAdd.add(new BasicNameValuePair("description", ""));
        paramsAdd.add(new BasicNameValuePair("author", ""));
        paramsAdd.add(new BasicNameValuePair("origin", ""));
        paramsAdd.add(new BasicNameValuePair("originUrl", ""));
        paramsAdd.add(new BasicNameValuePair("topLevel", "0"));
        paramsAdd.add(new BasicNameValuePair("sortDate", ""));
        paramsAdd.add(new BasicNameValuePair("releaseDate", ""));
        paramsAdd.add(new BasicNameValuePair("typeId", "1"));
        paramsAdd.add(new BasicNameValuePair("recommend", "FALSE"));
        paramsAdd.add(new BasicNameValuePair("draft", "FALSE"));
        paramsAdd.add(new BasicNameValuePair("tplContent", ""));
        paramsAdd.add(new BasicNameValuePair("typeImg", ""));
        paramsAdd.add(new BasicNameValuePair("titleImg", ""));
        paramsAdd.add(new BasicNameValuePair("contentImg", ""));
        paramsAdd.add(new BasicNameValuePair("mediaPath", ""));
        paramsAdd.add(new BasicNameValuePair("txt", "<p>asdlhasdjhasjkdhjksahdkjsahdkhsakdhksjahdkjsahdkshakdhsakdhksahd</p>"));
        paramsAdd.add(new BasicNameValuePair("copyimg", "FALSE"));
        paramsAdd.add(new BasicNameValuePair("attr_ceshi1", ""));
        paramsAdd.add(new BasicNameValuePair("cid", ""));
        paramsAdd.add(new BasicNameValuePair("modelId", "1"));
        paramsAdd.add(new BasicNameValuePair("model.id", "1"));

        httppostAdd.setEntity(new UrlEncodedFormEntity(paramsAdd,"GBK"));

        HttpResponse response1 = httpclient.execute(httppostAdd);
        HttpEntity entity1 = response1.getEntity();
        // 在这里可以用Jsoup之类的工具对返回结果进行分析，以判断登录是否成功
        String postResultAdd = EntityUtils.toString(entity1, "GBK");
        System.out.println("postResultAdd:"+postResultAdd);
    }
}