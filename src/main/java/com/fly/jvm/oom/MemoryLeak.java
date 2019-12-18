package com.fly.jvm.oom;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 张攀钦
 * @date 2019-12-18-15:06
 * @description 内存泄漏代码示例
 */
public class MemoryLeak {

    static class Key {
        Integer id;

        Key(Integer id) {
            this.id = id;
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }
    }

    public static void main(String[] args) {
        Map m = new HashMap();
        while (true){
            for (int i = 0; i < 10000; i++){
                if (!m.containsKey(new Key(i))){
                    m.put(new Key(i), "Number:" + i);
                }
            }
            System.out.println("m.size()=" + m.size());
        }
    }
}
