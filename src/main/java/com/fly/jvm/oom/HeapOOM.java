package com.fly.jvm.oom;

import java.util.ArrayList;

/**
 * @author 张攀钦
 * @date 2019-12-18-10:23
 * @description 堆溢出
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 默认当前项目下，定义文件地址
 * -XX:HeapDumpPath=
 *
 * 对象占用内存不到 20M,就OOM了，因为 java 堆还包括元空间内存
 * -XX:MaxMetaspaceSize=1m
 */
public class HeapOOM {
    static class OMMObject{}

    /**
     * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
     */
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        while (true){
            objects.add(new HeapOOM.OMMObject());
        }
    }
}
