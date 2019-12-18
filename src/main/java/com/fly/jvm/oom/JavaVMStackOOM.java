package com.fly.jvm.oom;

/**
 * @author 张攀钦
 * @date 2019-12-18-11:09
 * @description -Xss 256K
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 */
public class JavaVMStackOOM {
    public static void main(String[] args) {
        while(true){
            new Thread(new Runnable(){
                public void run() {
                    try {
                        Thread.sleep(10000000);
                    } catch(InterruptedException e) { }
                }
            }).start();
        }
    }
}
