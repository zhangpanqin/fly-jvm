package com.fly.jvm.init;

/**
 * @author 张攀钦
 * @date 2019-12-23-12:32
 * @description
 */
public class Student extends People {
    public Student() {
        System.out.println("Student 构造方法");
    }

    static {
//        People 静态 final 常量
        System.out.println("初始化阶段："+Student.Student_STATIC_FINAL);
        // null
        System.out.println("初始化阶段："+Student.Student_STATIC);

        System.out.println("Student 静态代码块");
    }

    // 编译阶段就处理了
    public static final String Student_STATIC_FINAL = "People 静态 final 常量";

    {
        System.out.println("Student 代码块");
    }

    public static String Student_STATIC = "People 静态非常量";
}
