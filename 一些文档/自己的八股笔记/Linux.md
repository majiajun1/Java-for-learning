# Linux

## 常用命令

文件相关：mv mkdir  cd ls

进程相关：ps top netstate

权限相关：chmod  chown   useradd groupadd

网络相关：netstat  ip   addr

测试相关：ping  



kill命令 杀进程

top -H  查线程

查端口：lsof   netstate



telnet命令测试端口

top也可以查CPU 核心数

free和top命令可以查看内存  





> CPU   100%怎么解决

top命令查占用高的进程

ps -T -p  查占用高的线程

jstack命令查线程堆栈信息 定位代码