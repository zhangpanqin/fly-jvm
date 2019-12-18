package com.fly.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张攀钦
 * @date 2019-12-18-11:44
 * @description 字符创常量池 从 1.7 开始，从永久代剥离出来，存放到堆空间
 * -Xms10M -Xmx10m -XX:-UseGCOverheadLimit
 * 运行时常量池溢出 Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 */
public class RuntimePoolOOM {
    public static void main(String[] args) {
        try {
            List<String> list = new ArrayList<String>();
            for (int i = 0; ; i++) {
                System.out.println(i);
                list.add(String.valueOf("String" + i++).intern());
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
