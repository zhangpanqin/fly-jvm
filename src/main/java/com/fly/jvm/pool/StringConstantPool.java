package com.fly.jvm.pool;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 张攀钦
 * @date 2019-12-26-19:18
 * @description 字符串常量池位于 java 堆中。
 * -Xms60M -Xmx60m -XX:-UseGCOverheadLimit -XX:MetaspaceSize=50m -XX:MaxMetaspaceSize=50m
 */
public class StringConstantPool {
    private final static Map map =new HashMap<>();
    public static void main(String[] args) {
//        Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        List<String> list = new ArrayList<String>(100000);
        for (int i = 0; ; i++) {
            System.out.println(i);
            list.add(("Stringasdfasdfasdfasdf" + i).intern());
        }

    }
//    静态变量
//    Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

    @Test
    public void run2() {
        for (int i = 0; ; i++) {
            map.put(i,"Stringasdfasdfasdfasdf" + i);
        }
    }

    @Test
    public void run3() {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s6);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s5);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
    }

    public static final String a = "123";
    public static final String b = "456";

    @Test
    public void run4() {
        String c = "123456";
        String d = a + b;
        System.out.println(c == d);// true
    }

    public static final String c;
    public static final String d;

    static {
        c = "123";
        d = "456";
    }

    @Test
    public void run5() {
        String e = "123456";
        String f = c + d;
        System.out.println(e == f); // false
    }

    @Test
    public void run6() {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true


        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); //false
    }
}
