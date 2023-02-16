# [JavaWeb的前期准备](https://www.cnblogs.com/ynxiyan/p/17123809.html)

### 一、概念

---

#### 1.什么是javaWeb

JavaWeb指的是，java语言编写的可以通过浏览器访问的程序，统称为JavaWeb，它基于请求和响应。

#### 2.什么是请求

请求指的是客户端向服务器发送数据，叫请求**Request**

#### 3.什么是响应

响应是指服务器给客户端回传数据，叫响应**Response**
注意：请求和响应是成对出现的 ， 有请求就会有响应

#### 4.软件的结构方式

```markdown
- B/S	浏览器 / 服务器架构 
- C/S	客户端 / 服务器架构
```

#### 5.Web资源的分类

- 静态资源：html、css、js等

- 动态资源：jsp页面、servlet程序、Vue

#### 6.常见的Web服务器

Tomcat: 由 Apache 组织提供的web服务器，轻量级，提供了 jsp 和 Servlet 支持，应用最广的服务器

JBoss ：javaEE规范、开源代码服务器



### 二、Tomcat

---

#### 1.目录介绍

```bash
bin				存放服务器的可执行文件
conf	  		存放服务器配置文件
lib		 		存放服务器所选的jar
logs	  		存放的是日志信息
temp			存放的服务器的临时数据
webapps	 部署web工程的目录
work 			tomcat的工作目录  jsp源码  session持久化目录
```

#### 2.安装及配置Tomcat

[阿帕奇雄猫® - 欢迎！ (apache.org)](https://tomcat.apache.org/)

运行后发现出现中文乱码，说明字符集不同，需要到Tomcat根目录下的conf子目录下的logging.properties文件里修改编码

将配置文件里的所有encoding = UTF-8都修改为encoding = GBK，使其识别中文，保存配置文件后，再次启动Tomcat解决中文乱码

#### 3.集成Tomcat到IDEA

##### 3-1.第一种：创建web项目

![image-20230215164907250](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215170330169-2033843953.png)

##### 3-2.第二种：创建普通项目后添加框架支持

![image-20230215165005047](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215170329735-2117584860.png)

#### 3-3.在IDEA里配置Tomcat

![image-20230215165309414](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215170329120-491125137.png)

##### 3-4.配置当前项目的Tomcat

![image-20230215165441448](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215170328353-309169890.png)



### 三、XML

---

#### 1.什么是xml

xml是可扩展的标记性语言

#### 2.xml的作用

```markdown
- 用来保存数据，这些数据具有自我描述性
- 可以用来作为项目或模块的配置文件
- 可以作为网络数据传输的格式----选择以Json为主
```

#### 3.xml语法

文档声明	元素	注释	文本

```xml
<?xml version="1.0" encoding="UTF-8" ?>
```

属性

```xml
version-版本
encoding-编码
```

#### 4.xml的书写与命名规范

```markdown
- id名可以包含字母、数组以及其他字符
- 标签名理论上可以是任何文字或字母，但是建议使用英文字母
- 标签要么是单标签要么是双标签且不能有空格
- 标签的属性要求使用双引号包起来
```



### 四、Maven

#### 1.什么是maven

Apache Maven是专门用于管理和构建Java项目的工具

主要功能：

- 让每个软件新建的项目都有一套标准的项目结构
- 有一套标准的项目构建流程（编译、测试、打包、发布）
- 提供一套非常完善的jar包依赖管理机制

#### 2.当前流行的构建工具

```markdown
* maven--市场占有大
* Gradle--不到maven的50%，增长趋势非常明显
* Ant
```

#### 3.安装maven

##### 3-1.安装maven

[Maven – 欢迎来到 Apache Maven](https://maven.apache.org/)

##### 3-2.添加环境变量

```
变量名：MAVEN_HOME
变量值：maven的安装路径
```

在Path里添加

```
%MAVEN_HOME%\bin
```

##### 3-3.配置本地下载仓库

到maven根目录下的conf子目录下的settings.xml文件里修改配置信息，查找localRepository找到maven默认的仓库地址将其修改成自己创建的repository文件夹

```xml
  <!-- localRepository
   | The path to the local repository maven will use to store artifacts.
   |
   | Default: ${user.home}/.m2/repository
  <localRepository>/path/to/local/repo</localRepository>
  -->

  <localRepository>D:\maven\repository</localRepository>
```

##### 3-4.配置阿里云私服

还是在当前文件查找\<mirror>，找到maven默认的远程仓库下载地址在下面添加一条阿里云私服的

```xml
  <mirrors>
    <!-- mirror
     | Specifies a repository mirror site to use instead of a given repository. The repository that
     | this mirror serves has an ID that matches the mirrorOf element of this mirror. IDs are used
     | for inheritance and direct lookup purposes, and must be unique across the set of mirrors.
     |
    <mirror>
      <id>mirrorId</id>
      <mirrorOf>repositoryId</mirrorOf>
      <name>Human Readable Name for this Mirror.</name>
      <url>http://my.repository.com/repo/path</url>
    </mirror>
     -->

   <mirror>
      	<id>aliyunmaven</id>
      	<mirrorOf>*</mirrorOf>
      	<name>阿里云公共仓库</name>
      	<url>https://maven.aliyun.com/repository/public</url>
    </mirror>

  </mirrors>
```

#### 4.maven的使用

常用命令：

```bash
mvn compile			编译当前项目
mvn clean			清理当前项目
mvn test			测试（运行测试）
mvn package			打包项目
mvn install			安装需要的插件
```

#### 5.依赖管理

如果需要在maven项目中使用jar包，可以使用坐标来引入

```xml
<!--    坐标引入jar包-->
<dependencies>
    <!--        mysql-->
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.32</version>
    </dependency>

    <!--        单元测试-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.2</version>
        <scope>test</scope>
    </dependency>

    <!--        JDBCutils-->
    <!-- https://mvnrepository.com/artifact/me.geso/jdbcutils -->
    <dependency>
        <groupId>me.geso</groupId>
        <artifactId>jdbcutils</artifactId>
        <version>2.2.0</version>
    </dependency>

    <!--        DButils-->
    <!-- https://mvnrepository.com/artifact/commons-dbutils/commons-dbutils -->
    <dependency>
        <groupId>commons-dbutils</groupId>
        <artifactId>commons-dbutils</artifactId>
        <version>1.7</version>
    </dependency>
    
    <!--        Driud-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.1.10</version>
        </dependency>
    
</dependencies>
```

**Maven中央仓库：**[Maven Repository: Search/Browse/Explore (mvnrepository.com)](https://mvnrepository.com/)

依赖范围：

```xml
<scope>...</scope>
```

​						 编译环境(main)	 测试环境(test)	  运行环境(打包以后)

![image-20230215194951486](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230215202545013-432628254.png)

默认值为：compile
