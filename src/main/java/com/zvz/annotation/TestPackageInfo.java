package com.zvz.annotation;

import java.io.IOException;

/**
 * 测试package-info.java文件的作用
 * 1、为标注在包上Annotation提供便利；<br>
 * 2、声明包的私有类和常量；<br>
 * @author JoyoungZhang@gmail.com
 *
 */
public class TestPackageInfo {


    /**
        1  package-info.java里不能声明public class(或 interface)
        2 刚开始p.isAnnotationPresent(ZvzTargetPackage.class)返回false，
            后来找到原因ZvzTargetPackage没有加上@Retention(RetentionPolicy.RUNTIME)。
     */

    public static void main(String[] args) {
        //1
        Package p = Package.getPackage("com.zvz.annotation");
        if(p != null && p.isAnnotationPresent(ZvzTargetPackage.class)){
            ZvzTargetPackage nav = p.getAnnotation(ZvzTargetPackage.class);
            if(nav != null){
                System.out.println("package version:" + nav.version());
            }
        }

        //2
        PackageInfo packageInfo = new PackageInfo();
        packageInfo.common();

        //泛型也能很好的工作，在pakcage-info.java里定义的类和普通类没什么区别
        PackageInfoGeneric<Exception> packageInfoGeneric = new PackageInfoGeneric<Exception>();
        packageInfoGeneric.set(new IOException("device io"));
        packageInfoGeneric.common();


        Sub sub = new Sub();
        sub.test();

        System.out.println(PackageConstants.ERROE_CODE);
    }
}

class Sub implements packageInfoInteger{

    public void test() {
        System.out.println("sub");
    }

}