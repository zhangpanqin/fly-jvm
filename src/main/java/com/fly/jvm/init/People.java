package com.fly.jvm.init;

/**
 * @author 张攀钦
 * @date 2019-12-23-12:29
 * @description
 */
public class People {
    public static final String STATIC_FINAL = "People 静态 final 常量";

    public static String STATIC = "People 静态常量";

    public People() {
        System.out.println("People 构造方法");
    }

    static {
        System.out.println("People 静态代码块");
    }

    {
        System.out.println("People 代码块");
    }
}
