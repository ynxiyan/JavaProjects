# [MySQL安装](https://www.cnblogs.com/ynxiyan/p/17026442.html)

### 一、官网下载mysql安装包

```http
https://www.mysql.com/
```

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014712718-954838013.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014711921-2026945224.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014711406-894281248.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014710901-2002037536.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014710446-884798594.png)

### 安装其它版本windows安装包

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014709979-276511368.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014709377-1104335637.png)

### macbook安装

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014708821-2097504670.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014708255-1418697727.png)

### 二、安装mysql windows案例

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014707717-1880747514.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014707210-1916422371.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014706595-1025992938.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014706007-1206008557.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014705528-1448875783.png)

![img](https://img2023.cnblogs.com/blog/2854528/202301/2854528-20230105014704880-1448771445.png)

### 三、配置环境变量，启动mysql服务

```bash
# 查看mysql服务启动 win+r打开运行窗口,输入services.msc打开服务窗口，找到服务名查看

# 通过管理员启动cmd win+x打开面板,选择命令提示符(管理员运行)

#启动mysql服务
net start mysql服务名

#停止mysql服务
net stop mysql服务名

#重启mysql服务
net restart mysql服务名

# 删除windows服务
sc delete 服务名


# mysql压缩包版本命令
# 安装mysql服务
mysqld install mysql服务名

# 删除mysql服务
mysqld remove mysql服务名
```

 

### 四、cmd或terminal.app启动mysql 命令行工具(后续通过可视化工具操作)

```bash
mysql -u root -p

# -h url地址  -P 端口号 默认端口号3306和本机localhost(127.0.0.1)可以省略
# 创建数据库
create database 数据库名;

# 删除数据库
drop database 数据库名;

# 使用选择数据库
use 数据库名;

# 显示当前所有数据库
show databases;

# 使用数据库后，显示当前这个数据库里所有的表
show tables;



```

 
