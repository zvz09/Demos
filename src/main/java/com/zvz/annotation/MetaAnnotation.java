package com.zvz.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 1.演示四种元注解的用法
 * @Target
 * @Retention
 * @Document
 * @Inherited
 *
 * @author JoyoungZhang@gmail.com
 *
 */
@ZvzTargetType
@ZvzRetentionRuntime
@ZvzDocument
@ZvzInherited
public class MetaAnnotation {
    @ZvzTargetField
    private String info;

    @ZvzTargetConstructor
    public MetaAnnotation(@ZvzTargetParamter String info) {
        this.info = info;
    }

    @ZvzTargetMethod
    public void test(){
        @ZvzTargetLocalVariable
        String infoInner = "sa";
    }
}

@Target(ElementType.TYPE) @interface ZvzTargetType{}                        //接口、类、枚举、注解
@Target(ElementType.FIELD) @interface ZvzTargetField{}                      //字段、枚举的常量
@Target(ElementType.METHOD) @interface ZvzTargetMethod{}                    //方法
@Target(ElementType.PARAMETER) @interface ZvzTargetParamter{}               //方法参数
@Target(ElementType.CONSTRUCTOR) @interface ZvzTargetConstructor{}          //构造函数
@Target(ElementType.LOCAL_VARIABLE) @interface ZvzTargetLocalVariable{}     //局部变量
@Target(ElementType.ANNOTATION_TYPE) @interface ZvzTargetAnnotationType{}   //注解
@Target(ElementType.PACKAGE) @Retention(RetentionPolicy.RUNTIME) @interface ZvzTargetPackage{public String version() default "";}   //包
@ZvzTargetAnnotationType @interface ZvzTargetAll{}

@Retention(RetentionPolicy.SOURCE) @interface ZvzRetentionSource{}
@Retention(RetentionPolicy.CLASS) @interface ZvzRetentionClass{}
@Retention(RetentionPolicy.RUNTIME) @interface ZvzRetentionRuntime{}

@Documented @interface ZvzDocument{}

@Inherited @interface ZvzInherited{}