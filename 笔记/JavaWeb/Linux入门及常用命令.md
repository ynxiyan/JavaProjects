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



### 二、安装Centos

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





# 未完待续。。。