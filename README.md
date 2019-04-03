# Chaosblade 网页版执行器

## Chaosblade 简介
阿里开源的混沌实验(崩溃测试*_*)工具,可对各种服务进行异常操作,比如延时返回结果,抛出Excepiton,模拟cpu满载等情况.

具体请查看 https://github.com/chaosblade-io/chaosblade

## 本项目主要功能
命令行太难用,可视化才能推广.本项目就是为了能直接上手Chaosblade而开发的友好的web界面

## 主要工作
* 遍历了blade的命令的各种参数,组成树结构,再进行可视化组合.
* 在网页上显示shell命令的执行结果.
* 存储历史命令.
* 存储历史返回值.
* 命令样例供参考.
* 上下键翻历史命令.


## 看时间会增加的功能
* 登录认证.

## 安装使用
本项目为SpringBoot项目,下载后在根目录执行编译.
```bash
mvn clean package -Dmaven.test.skip=true
```
启动需要自行设置端口号.还有blade.path参数(chaosbalde执行文件位置),ex.
```bash
 blade.path: /root/go/src/github.com/chaosblade-io/chaosblade/target/chaosblade-0.0.1/blade
```

# 重要备注
仅供在Linux环境下,且安装golang环境,且安装chaosbalde的情况下使用