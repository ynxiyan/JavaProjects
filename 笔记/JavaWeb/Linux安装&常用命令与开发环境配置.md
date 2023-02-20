# [Linux安装&常用命令与开发环境配置](https://www.cnblogs.com/ynxiyan/p/17122100.html)

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

![2854528-20230215151432375-384660976](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230216114743831-1588333911.png)

图片来源于：[Linux常用命令手册_word文档在线阅读与下载_无忧文档 (51wendang.com)](https://www.51wendang.com/doc/93ed6337b9312c6105834214)

**使用技巧**

- Tab键自动补全
- 连续两次Tab键，给出操作提示
- 使用上下箭头快速调出曾经使用过的命令
- 使用clear命令或者Ctrl+l快捷键实现清屏

#### 3.目录操作

- -a显示所有文件及目录(.开头的隐藏文件也会列出)
- -l除文件名称外，同时将文件型态(d表示目录，-表示文件)、权限、拥有者、文件大小等信息详细列出

```bash
ls                  //查看当前目录下的所有目录和文件
ls -a               //查看当前目录下的所有目录和文件（包括隐藏的文件）
ls -l 或 ll         //列表查看当前目录下的所有目录和文件
ls /bin             //查看指定目录下的所有目录和文件 
```

#### 4.切换目录

- ~表示用户的home目录
- .表示目前所在的目录
- ..表示目前目录位置的上级目录

```bash
cd /
cd /etc
cd ~
cd .
cd ..
```

#### 5.创建目录

创建一级或多级空目录
语法 ： mkdir [-p] 目录名
说明：
-p: 表示是 parent 的意思 ， 当我们要创建多级目录时 ， 需要保证外层目录存在 ， 设置 -p 就是如果外层目录不存在就创建一个

```bash
mkdir aaa
mkdir -p 1/2/3
```

#### 6.删除目录与文件

删除空目录

语法:rmdir [-p] 目录名

- -p:当子目录被删除后使父目录为空目录的话，则一并删除

删除文件或者目录

语法:rm[-f] 文件名

​		rm[-rf] 文件名或目录名

- -r:将目录及目录中所有文件（目录）逐一删除，即递归删除
- -f:无需确认，直接删除

```bash
rm 文件名              //删除当前目录下的文件
rm -f 文件名           //删除当前目录的的文件（不询问）
rm -r 文件夹名         //递归删除当前目录下此名的目录
rm -rf 文件夹名        //递归删除当前目录下此名的目录（不询问）
rm -rf *              //将当前目录下的所有目录和文件全部删除
rm -rf /*             //将根目录下的所有文件全部删除
```

#### 7.复制目录及文件

- -r:如果复制的是目录需要使用此选项，此时将复制该目录下所有的子目录和文件

```bash
cp 1.txt
cp 2.txt ./9.txt			 //将2.txt复制到当前目录下并改名为9.txt
cp -r /usr/tmp/tool /opt     //将/usr/tmp目录下的tool目录复制到/opt目录下面
```

#### 8.移动、修改目录及文件

语法：mv 文件名/目录名 文件名/目录名 

移动目录及文件

```bash
mv bbb ddd				//当ddd存在时将bbb移入
mv a.txt bbb			//将a.txt移入bbb
```

修改目录及文件

```bash
mv bbb ddd				//当ddd不存在时将目录名改为ddd
mv a.txt b.txt			//将文件名改成b.txt
```

#### 9.创建文件

```bash
touch  a.txt   //在当前目录下创建名为a的txt文件（文件不存在），如果文件存在，将文件时间属性修改为当前系统时间
```

#### 10.查看文件内容

语法：cat[-n] 文件名

​				  -n表示查看文件时对文件内容进行行号输出

```bash
cat /etc/profile
cat -n /etc/profile
```

#### 11.分页查看文件

用于以分页的显示显示文件内容，特别是文件内容多的时候
语法 ： more 文件名
说明：
	回车 ： 滚动一行
	空格 ： 滚动一屏
	b ： 返回上一屏
	q 或者 ctrl+c: 退出 more 命令

```bash
more /etc/profile
```

#### 12.查看文件末尾的内容

语法：tail [-f] 文件名

说明：-f ： 动态读取文件末尾内容并显示 ， 通常用于日志文件的内容输出（默认显示10行）

数字形式：-20  动态读取文件的默认几行的内容并显示 ， 通常用于日志查看

-f形式 ： 该形式也是读取文件内容并显示 ， 但是会进入霸屏模式 ， 此时如果更改文件那么可以实时更新出来

```bash
tail /etc/profile
tail -20 /etc/profile
tail -f /itcast/my.log
```

#### 13.打包压缩命令

对文件进行打包、解包、压缩、解压

语法: tar [-zcxvf] fileName [files]

包文件后缀为.tar表示只是完成了打包，并没有压缩

包文件后缀为.tar.gz表示打包的同时还进行了压缩

说明:

- -z∶ z代表的是gzip，通过gzip命令处理文件，gzip可以对文件压缩或者解压
- -c: c代表的是create，即创建新的包文件
- -x: x代表的是extract，实现从包文件中还原文件
- -v: v代表的是verbose，显示命令的执行过程
- -f: f代表的是file，用于指定包文件的名称

打包、打包并压缩：

```bash
tar -cvf 1.tar ./			//将当前目录下的所有文件打包
tar -cvf 1.tar 1.txt		//将1.txt打包
tar -zcvf 1.tar.gz ./		//将当前目录下的所有文件打包并压缩
tar -zcvf 1.tar.gz 1.txt	//将1.txt打包并压缩
```

解包、解包并解压：

```bash
tar -xvf 1.tar					   //将1.tar解包到当前目录下
tar -zxvf 1.tar.gz				   //将1.tar.gz解包并解压到当前目录下
tar -zxvf 1.tar.gz ——C /usr/local  //将1.tar.gz解包并解压到usr/local目录下
```

#### 14.文本编辑命令

**文本编辑命令vi**

vi命令是Linux系统提供的一个文本编辑工具，可以对文件内容进行编辑，类似于Windows中的记事本

语法: vi fileName

```bash
vi 1.txt
```

说明:

vim是从vi发展来的一个功能更加强大的文本编辑工具，在编辑文件时可以对文本内容进行着色，方便我们对文件进行编辑处理，所以实际工作中vim更加常用。

**文本编辑命令vim**

要使用vim命令，需要我们自己完成安装。可以使用该命令来完成安装:

```bash
yum install vim
```

作用:对文件内容进行编辑，vim其实就是一个文本编辑器

语法:vim fileName

说明:

1、在使用vim命令编辑文件时，如果指定的文件存在则直接打开此文件。如果指定的文件不存在则新建文件。

2、vim在进行文本编辑时共分为三种模式，分别是命令模式(Command mode)，插入模式（Insert mode)和底行模式(Last line mode)。这三种模式之间可以相互切换。我们在使用vim时一定要注意我们当前所处的是哪种模式。

```bash
vim 1.txt
```

针对vim中的三种模式说明如下:

![image-20230217104755877](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154836304-646185811.png)

##### 14-1.命令模式

命令模式下可以查看文件内容、移动光标（上下左右箭头、gg、G)，通过vim命令打开文件后，默认进入命令模式，另外两种模式需要首先进入命令模式，才能进入彼此

##### 14-2.插入模式

插入模式下可以对文件内容进行编辑

- 在命令模式下按下[i,a,o]任意一个，可以进入插入模式。进入插入模式后，下方会出现【insert】字样
- 在插入模式下按下ESC键，回到命令模式

##### 14-3.底行模式

底行模式下可以通过命令对文件内容进行查找、显示行号、退出等操作

- 在命令模式下按下[:,/]任意一个，可以进入底行模式
- 通过/方式进入底行模式后，可以对文件内容进行查找
- 通过:方式进入底行模式后，可以输入wq（保存并退出）、q!(不保存退出） 、 set nu(显示行号)

#### 15.查找

**查找命令find**

在指定目录下查找文件

语法:find dirName -option fileName

```bash
find . -name "*.java"		  //在当前目录及其子目录下查找.java结尾文件
find /itcast -name "*.java"	  //在/itcast目录及其子目录下查找.java结尾的文件
```

**查找命令grep**

从指定文件中查找指定的文本内容

语法: grep keywords fileName

```bash
grep Hello Helloworld.java//查找Helloworld.java文件中出现的Hello字符串的位置
grep hello *.java	//查找当前目录中所有.java结尾的文件中包含hello字符串的位置
```



### 五、配置开发环境

#### 1.安装JDK

1. 在opt目录下创建jdk文件夹

   ```bash
   mkdir /opt/jdk
   ```

2. 在usr/local目录下创建java文件夹

   ```bash
   mkdir /usr/local/java
   ```

3. 切换目录到jdk目录下

   ```bash
   cd /opt/jdk
   ```

4. 通过FinalShell将安装包上传到jdk目录下

   ![image-20230217153157826](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154835868-1866335795.png)

5. 解压安装包

   ```bash
   tar -zxvf 安装包名
   ```

6. 移动解压出来的jdk目录到usr/local/java目录下

   ```bash
   mv /opt/jdk/jdk目录 /usr/local/java
   ```

7. 配置环境变量

   ```bash
   vim /etc/profile
   ```

   ```bash
   export JAVA_HOME=/usr/local/java/jdk目录
   export PATH=$JAVA_HOME/bin:$PATH
   ```

8. 刷新环境变量

   ```bash
   source /etc/profile
   ```

9. 测试jdk

   ```bash
   java -version
   ```

   ![image-20230217153237568](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154835495-1465325461.png)

#### 2.安装tomcat

1. 在opt目录下创建tomcat文件夹

   ```bash
   mkdir /opt/tomcat
   ```

2. 切换目录到tomcat目录下

   ```bash
   cd /opt/tomcat
   ```

3. 通过FinalShell将安装包上传到tomcat目录下

   ![image-20230217153326017](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154835133-1307638345.png)

4. 解压安装包

   ```bash
   tar -zxvf 安装包名
   ```

5. 开启防火墙

   ```bash
   systemctl start firewalld
   ```

6. 开放8080端口

   ```bash
   firewall-cmd --zone=public --add-port=8080/tcp --permanent
   ```

7. 刷新防火墙

   ```bash
   firewall-cmd --reload
   ```

8. 进入bin目录下

   ```bash
   cd /tomcat/bin
   ```

9. 启动tomcat

   ```bash
   ./startup.sh
   ```

10. 检测tomcat是否启动

    ```bash
    ps -ef | grep tomcat
    ```

    ![image-20230217153421712](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154834767-1455702494.png)

11. 停止tomcat

    ```bash
    kill -9 进程id
    ```

#### 3.安装mysql

1. 卸载冲突软件

   注意：CentoS7自带mariadb，与MySQL数据库冲突

   ```bash
   rpm -e --nodeps mariadb-libs
   ```

2. 在opt目录下创建mysql文件夹

   ```bash
   mkdir /opt/mysql
   ```

3. 切换目录到mysql目录下

   ```bash
   cd /opt/mysql
   ```

4. 通过FinalShell将安装包上传到mysql目录下

   ![image-20230217153453279](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154834333-315610173.png)

5. 解压安装包

   ```bash
   tar -zxvf 安装包名
   ```

6. 按照顺序安装rpm软件包

   ```bash
   rpm -ivh mysql-community-common-~.rpm
   rpm -ivh mysql-community-libs-~.rpm
   rpm -ivh mysql-community-devel-~.rpm
   rpm -ivh mysql-community-libs-compat-~.rpm
   rpm -ivh mysql-community-client-~.rpm
   ```

7. 安装依赖

   ```bash
   yum install libaio
   yum install net-tools
   ```

8. 安装mysql服务

   ```bash
   rpm -ivh mysql-community-server-~.rpm
   ```

9. 启动mysql服务

   ```bash
   systemctl start mysqld
   ```

10. 登录mysql

11. 开启远程连接

    ```bash
    //设置密码安全策略
    set global validate_password_policy=0;
    //降低密码的安全等级
    set global validate_password_policy=LOW;
    //设置密码的最低长度
    set global validate_password_length=1;
    //开启远程连接
    grant all privileges on *.* to 'root'@'%' identified by '123456' with grant option;
    //更新权限
    flush privileges;
    ```

附加：

解决Linux错误 ERROR 1045 (28000): Access denied for user 'root'@'localhost' (using password: YES）

1. 修改mysql配置文件

   ```bash
   vim /etc/my.cnf
   ```

   在[mysqld]后面任意一行添加后保存并退出:wq

   ```bash
   skip-grant-tables
   ```

2. 重启mysql服务

   ```bash
   service mysqld restart
   ```

3. 免密登录mysql

4. 更新权限

   ```mysql
   flush privileges;
   ```

5. 修改密码

   ```mysql
    alter user 'root'@'localhost' identified by '密码';
   ```

6. 退出mysql

   ```mysql
   exit;
   ```

7. 还原配置文件（将第一步添加的信息删除）

8. 重启mysql服务

#### 4.安装maven

1. 在opt目录下创建maven文件夹

   ```bash
   mkdir /opt/maven
   ```

2. 切换目录到maven目录下

   ```bash
   cd /opt/maven
   ```

3. 通过FinalShell将安装包上传到maven目录下

   ![image-20230217154802349](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154833881-1013842124.png)

4. 解压安装包

   ```bash
   tar -zxvf 安装包名
   ```

5. 配置环境变量

   ```bash
   vim /etc/profile
   ```

   ```bash
   export MAVEN_HOME=/opt/maven/apache-maven-3.5.4
   export PATH=$MAVEN_HOME/bin:$PATH
   ```

6. 刷新环境变量

   ```bash
   source /etc/profile
   ```

7. 测试maven

   ```bash
   mvn -version
   ```

   ![image-20230217154740016](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230217154833270-1080279649.png)



部分笔记来源于：[Java项目实战——Linux入门 - Kizuna丨AI - 博客园 (cnblogs.com)](https://www.cnblogs.com/KizunaAI/p/16298278.html)
