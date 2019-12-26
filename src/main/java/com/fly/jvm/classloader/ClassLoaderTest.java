package com.fly.jvm.classloader;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Objects;

/**
 * @author 张攀钦
 * @date 2019-12-24-20:13
 * @description 类加载验证
 * 类的唯一标识由 全限定类型+classloader
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
                ClassLoader loader=new ClassLoader() {
                    @SneakyThrows
                    @Override
                    public Class<?> loadClass(String name) throws ClassNotFoundException {
                        final String s = name.substring(name.lastIndexOf(".") + 1) + ".class";
                        final InputStream resourceAsStream = getClass().getResourceAsStream(s);
                        if(Objects.isNull(resourceAsStream)){
                            return super.loadClass(name);
                        }
                        final byte[] bytes = new byte[resourceAsStream.available()];
                        resourceAsStream.read(bytes);
                        return defineClass(name,bytes,0,bytes.length);
                    }
                };

        final Object aClass = loader.loadClass("com.fly.jvm.classloader.ClassLoaderTest");
//        false
        System.out.println(aClass instanceof ClassLoaderTest);

    }
}
