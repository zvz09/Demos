/**
 * <b>package-info不是平常类，其作用有三个:</b><br>
 * 1、为标注在包上Annotation提供便利；<br>
 * 2、声明包的私有类和常量；<br>
 * 3、提供包的整体注释说明。<br>
 *
 * @author JoyoungZhang@gmail.com
 */
@ZvzTargetPackage(version="1.0")
package com.zvz.annotation;
class PackageInfo{
    public void common(){
        System.out.println("sa");
    }
}

class PackageInfoGeneric<T extends Throwable>{
    private T obj;
    public void set(T obj){
        this.obj = obj;
    }
    public void common(){
        System.out.println(obj + "sa");
    }
}

interface packageInfoInteger{
    public void test();
}

class PackageConstants{
    public static final String ERROE_CODE = "100001";
}