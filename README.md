### 程序计数器
### 虚拟机栈
### 本地方法栈
### 方法区
### java heap

### 查看默认参数

```powershell
# 查看 JVM 正在使用哪个 GC
java -XX:+PrintCommandLineFlags -version
# 查看 GC 详细信息
java -XX:+PrintGCDetails -version
```

### 类从加载到虚拟机内存到卸载，整个生命周期
`加载`-> `验证`->`准备`->`解析`-> `初始化`->`使用`->`卸载`

虚拟机没有进行强制约束类的加载时机，对初始化阶段进行了限定

- 遇到 new ,getstatic,putstatic或invokestatic，类没有发生初始化，先触发初始化。
- 通过反射对类进行调用，类没有发生初始化，先触发初始化。
- 初始化一个类，发现父类没有初始化，先初始化父类
- 执行的主类没有初始化，先初始化 主类
- 