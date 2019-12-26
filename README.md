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
### Gc 工具
```text
[Gc 日志分析 GCViewer](https://github.com/chewiebug/GCViewer)
Jvisualvm
jmc
```
