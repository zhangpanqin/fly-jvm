package com.fly.jvm.oom;

/**
 * @author 张攀钦
 * @date 2019-12-18-11:09
 * @description -Xss 256K
 */
public class JavaVmStackOverflow {

    private int a = 1;

    public void add() {
        a++;
        System.out.println("a:"+a);
        add();
    }

    public static void main(String[] args) {
        JavaVmStackOverflow javaVmStackOverflow = new JavaVmStackOverflow();
        try {
            javaVmStackOverflow.add();
        } catch (Exception e) {
            System.out.println("栈深度"+javaVmStackOverflow.a);
            throw e;
        }
    }
}
