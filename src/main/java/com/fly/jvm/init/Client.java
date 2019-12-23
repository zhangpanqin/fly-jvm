package com.fly.jvm.init;

import org.junit.jupiter.api.Test;

/**
 * @author 张攀钦
 * @date 2019-12-23-12:32
 * @description
 */
public class Client {

    /**
     * 访问 final 域不会触发类的加载
     *
     * Student 和 People 类都没有加载
     */

    @Test
    public void run1() {
        System.out.println(Student.STATIC_FINAL);
    }

    /**
     * 加载了 People 类
     */
    @Test
    public void run2() {
        System.out.println(Student.STATIC);
    }
}
