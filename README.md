### 程序计数器
### 虚拟机栈
### 本地方法栈
### 方法区
### java heap

### 常量池
 `运行时常量池(Runtime Constant Pool)` 位于 `元数据空间 (Metaspace)`。当类加载到内存中后，Jvm 就会将 `Class常量池中` 的内容存放到 `运行时常量池中`。
 
Class 文件中的 `常量池表(Constant Pool Table)` 存放编译期生成的各种字面量和符号的引用。在类加载后 `常量池表(Constant Pool Table)` 的内容存放到 `运行时常量池`。

`字符串常量池` 位于 `堆 Heap`。

### 查看默认参数

```powershell

# 查看所有默认 jvm 参数
java -XX:+PrintFlagsFinal -version

# 查看 JVM 正在使用哪个 GC
java -XX:+PrintCommandLineFlags -version

# 查看 GC 详细信息
java -XX:+PrintGCDetails -version
```

### 类从加载到虚拟机内存到卸载，整个生命周期
`加载`-> `验证`->`准备`->`解析`-> `初始化`->`使用`->`卸载`
### Gc 工具
```text
[Gc 日志分析 GCViewer](https://github.com/chewiebug/GCViewer)
Jvisualvm
jmc
```

虚拟机没有进行强制约束类的加载时机，对初始化阶段进行了限定

- 遇到 new ,getstatic,putstatic或invokestatic，类没有发生初始化，先触发初始化。
- 通过反射对类进行调用，类没有发生初始化，先触发初始化。
- 初始化一个类，发现父类没有初始化，先初始化父类
- 执行的主类没有初始化，先初始化 主类
- 