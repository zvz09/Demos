package com.zvz.js;

import org.mozilla.javascript.Function;

public class JSFunction{
    private String name;

    private Function handle;

    public void setHandler(Function func)
    {
        this.handle = func;
    }

    public Function getHandler()
    {
        return this.handle;
    }


    public JSFunction(String s)
    {
        this.name = s;
    }

    public static void print(String s)
    {
        System.out.println(s);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
