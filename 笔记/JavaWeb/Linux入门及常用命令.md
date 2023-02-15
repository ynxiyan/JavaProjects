# [Linux入门及常用命令](https://www.cnblogs.com/ynxiyan/p/17122100.html)

### 一、Linux学前分析

---

#### 1.为什么学习Linux

```markdown
- 企业用人需要
- 个人发展需要
```

#### 2.什么是Linux

linux 是一个开源、免费的操作系统，其稳定性、安全性、处理多并发已经得到业界的认可，目前很多企业级的项目 (c/c++/php/python/java/go)都会部署到 Linux/unix 系统上。

#### 3.Linux能干什么？

文件和目录的管理

部署	管理	日志解析	企业邮件服务等服务器管理

#### 4.常见操作系统

- 桌面操作系统

  ```markdown
  - Windows(用户数量多)
  - Mac(操作体验好)
  - Linux(用户数量少)
  ```

- 服务器操作系统

  ```markdown
  - Unix(稳定	付费)
  - Linux(安全	稳定	免费)
  - Windows Server(付费	占有率低)
  ```



### 二、安装Centos并配置远程服务

前置操作

```markdown
	安装VMware Workstation
```

#### 1.下载镜像

[下载 (centos.org)](https://www.centos.org/download/)

#### 2.安装的步骤

```markdown
- 创建虚拟机
- 安装系统
- 安装vmtools
- 设置共享文件夹
```

#### 3.安装SSH远程工具连接虚拟机

推荐xshell、finalShell

##### 3-1.配置Linux

默认情况下，linux是没有加载网卡的，我们需要设置网络配置文件

![image-20230215110554386](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215111115951-1867720284.png)

```bash
//登录到虚拟机
root
//密码
****
//进入到linux根目录
cd /
//进入etc目录
cd etc
//进入到sysconfig目录
cd sysconfig
//进入到network-scripts
cd network-scripts
//编辑网络配置文件
vi ifcfg-ens33
//修改ONBOOT
ONBOOT=yes
//保存并退出
:cq
//查询ip地址
ip addr
```

![image-20230215110655036](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215111115568-1380147489.png)

- 编辑配置文件的补充

​		按**i**进入输入模式

​		方向键移动光标到指定位置，使用delete或退格进行内容的修改

​		修改后按esc退出输入模式

- 修改后的网络配置文件

![image-20230215110117478](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215111115215-2129266264.png)



##### 3-2.连接linux虚拟机

![image-20230215110736807](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215111114629-859361788.png)



### 三、Linux 目录结构

---

linux 的文件系统是采用级层式的树状目录结构，在此结构中的最上层是根目录“/”，然后在此目录下再创建其他的目录。

**在 Linux 世界里，一切皆文件(!!)**

```bash
/bin        二进制文件，系统常规命令
/boot       系统启动分区，系统启动时读取的文件
/dev        设备文件
/etc        大多数配置文件
/home       普通用户的家目录
/lib        32位函数库
/lib64      64位库
/media      手动临时挂载点
/mnt        手动临时挂载点
/opt        第三方软件安装位置
/proc       进程信息及硬件信息
/root       临时设备的默认挂载点
/sbin       系统管理命令
/srv        数据
/var        数据
/sys        内核相关信息
/tmp        临时文件
/usr        用户相关设定
```



### 四、Linux命令

---

命令的组成：命令 参数名 参数值

#### 1.系统命令行的含义

```bash
root    	//用户名，root为超级用户
@       	//分隔符
localhost   //主机名称
~       	//当前所在目录，默认用户目录为~，会随着目录切换而变化
```

#### 2.常用命令

![view](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215151432375-384660976.jpg)

图片来源于：[Linux常用命令手册_word文档在线阅读与下载_无忧文档 (51wendang.com)](https://www.51wendang.com/doc/93ed6337b9312c6105834214)

#### 3.目录操作

```bash
ls                  //查看当前目录下的所有目录和文件
ls -a               //查看当前目录下的所有目录和文件（包括隐藏的文件）
ls -l 或 ll         //列表查看当前目录下的所有目录和文件
ls /bin             //查看指定目录下的所有目录和文件 
```

#### 4.删除目录与文件

```bash
rm 文件名              //删除当前目录下的文件
rm -f 文件名           //删除当前目录的的文件（不询问）
rm -r 文件夹名         //递归删除当前目录下此名的目录
rm -rf 文件夹名        //递归删除当前目录下此名的目录（不询问）
rm -rf *              //将当前目录下的所有目录和文件全部删除
rm -rf /*             //将根目录下的所有文件全部删除
```

#### 5.修改目录

```bash
mv 当前目录名 新目录名       //修改目录名，同样适用与文件操作
mv /usr/tmp/tool /opt     //将/usr/tmp目录下的tool目录剪切到/opt目录下面
```

#### 6.复制目录

```bash
cp /usr/tmp/tool /opt     //将/usr/tmp目录下的tool目录复制到/opt目录下面
```

#### 7.创建文件

```bash
touch  a.txt   //在当前目录下创建名为a的txt文件（文件不存在），如果文件存在，将文件时间属性修改为当前系统时间
```





# 未完待续。。。