# [Maven高级应用](https://www.cnblogs.com/ynxiyan/p/17227080.html)

### 一、分模块开发与设计

---

**分模块开发的意义**

将原始模块按照功能拆分成若干个子模块，方便模块间的相互调用，接口共享

**分模块开发的步骤：**

1. 创建Maven模块

2. 书写模块代码

   - 分模块开发需要先针对模块功能进行设计，再进行编码；

   - 不会先将工程开发完毕，然后进行拆分；

   - 拆分方式可以按照功能拆也可以按照模块拆

3. 通过maven指令安装模块到本地仓库(install 指令)
   - 团队内部开发需要发布模块功能到团队内部可共享的仓库中(私服)



### 二、依赖管理

---

```xml
<!--设置当前项目所依赖的所有jar--> 
<dependencies> 
    <!--设置具体的依赖--> 
    <dependency> 
        <!--依赖所属群组id--> 
        <groupId>org.springframework</groupId> 
        <!--依赖所属项目id--> 
        <artifactId>spring-webmvc</artifactId> 
        <!--依赖版本号--> 
        <version>5.2.10.RELEASE</version>
    </dependency> 
</dependencies>
```

#### 1. 依赖传递

![image-20230317103520111](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230317155217009-2134059135.png)

#### 2. 可选依赖与排除依赖

1. 可选依赖

   可选依赖指对外隐藏当前所依赖的资源---不透明

   ```xml
   <!--可选依赖是隐藏当前工程所依赖的资源，隐藏后对应资源将不具有依赖传递--> 
   <optional>true</optional>
   ```

2. 排除依赖

   排除依赖指主动断开依赖的资源，被排除的资源无需指定版本---不需要

   ```xml
   <!--排除依赖是隐藏当前资源对应的依赖关系--> 
   <exclusions> 
       <exclusion> 
           <groupId></groupId> 
           <artifactId></artifactId>
       </exclusion> 
   </exclusions>
   ```



### 三、聚合与继承

---

#### 1. 聚合

所谓的聚合就是将多个模块组织成一个整体，同时进行项目构建的过程称为聚合

**聚合工程：**通常是一个不具有业务功能的"空"工程（有且仅有一个pom文件），聚合工程主要是用来管理项目

**作用：**

- 使用聚合工程可以将多个工程编组，通过对聚合工程进行构建，实现对所包含的模块进行同步构建
- 当工程中某个模块发生更新（变更）时，必须保障工程中与已更新模块关联的模块同步更新， 此时可以使用聚合工程来解决批量模块同步构建的问题

**聚合工程创建步骤：**

1. 创建一个空的maven项目

2. 将项目的打包方式改为pom

   ```xml
   <!--设置项目打包方式--> 
   <packaging>pom</packaging>
   ```

   **打包方式：**

   ```markdown
   # jar:默认情况，说明该项目为java项目
   # war:说明该项目为web项目
   # pom:说明该项目为聚合或继承项目
   ```

3. 在pom.xml添加所要管理的项目

   ```xml
   <!--设置管理的模块名称--> 
   <modules> 
       <module>../maven_02_ssm</module> 
       <module>../maven_03_model</module> 
       <module>../maven_04_dao</module>
   </modules>
   ```

4. 使用聚合统一管理项目(compile 指令)

**说明：**聚合工程管理的项目在进行运行的时候，会按照项目与项目之间的依赖关系来自动决定执行的顺序和pom.xml里配置的顺序无关

#### 2. 继承

所谓的继承就是描述的是两个工程间的关系，与java中的继承相似，子工程可以继承父工程中的配置信 息，常见于依赖关系的继承

作用：
			简化配置、减少版本冲突

**继承的使用步骤：**

1. 将子项目共同使用的jar包都抽取出来，维护在父项目（聚合工程）的pom.xml中

2. 在子项目的pom.xml里配置继承自父项目（聚合工程）的pom.xml

   ```xml
   <!--配置当前工程继承自parent工程--> 
   <parent> 
       <groupId>com.itheima</groupId> 
       <artifactId>maven_01_parent</artifactId> 
       <version>1.0-RELEASE</version> 
       <relativePath>../maven_01_parent/pom.xml</relativePath>
   </parent>
   ```

3. 优化子项目依赖版本问题

   在父工程（聚合工程）的pom.xml里定义依赖管理

   ```xml
   <!--定义依赖管理--> 
   <dependencyManagement> 
       <dependencies> 
           <dependency> 
               <groupId>junit</groupId> 
               <artifactId>junit</artifactId> 
               <version>4.12</version> 
               <scope>test</scope>
           </dependency> 
       </dependencies> 
   </dependencyManagement>
   ```

   在子项目的pom.xml里添加定义好的依赖

   ```xml
   <dependency> 
       <groupId>junit</groupId> 
       <artifactId>junit</artifactId> 
       <scope>test</scope>
   </dependency>
   ```

   **注意：**这里不能需要添加版本，这样做的好处就是当父工程dependencyManagement标签中的版 本发生变化后，子项目中的依赖版本也会跟着发生变化

#### 3. 聚合与继承的区别

作用：

- 聚合用于快速构建项目，对项目进行管理
- 继承用于快速配置和管理子项目中所使用jar包的版本

相同点：

- 聚合与继承的pom.xml文件打包方式均为pom，可以将两种关系制作到同一个pom文件中
- 聚合与继承均属于设计型模块，并无实际的模块内容

不同点：

- 聚合是在当前模块中配置关系，聚合可以感知到参与聚合的模块有哪些
- 继承是在子模块中配置关系，父模块无法感知哪些子模块继承了自己



### 四、属性与版本管理

---

1. 属性

   ![image-20230317135507079](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230317155216459-107556572.png)

   属性的使用步骤：

   1. 在父工程（聚合工程）中定义属性

      ```xml
      <!--定义属性--> 
      <properties> 
          <spring.version>5.2.10.RELEASE</spring.version> 
      </properties>
      ```

   2. 修改依赖的version

      ```xml
      <dependency> 
          <groupId>org.springframework</groupId> 
          <artifactId>spring-core</artifactId> 
          <!--引用属性--> 
          <version>${spring.version}</version>
      </dependency> 
      ```

2. 配置文件加载属性

   1. 在父工程（聚合工程）定义属性

      ```xml
      <properties> 
          <jdbc.url>jdbc:mysql://127.1.1.1:3306/ssm_db</jdbc.url>
      </properties>
      ```

   2. 在properties文件中引用属性

      ```properties
      jdbc.url=${jdbc.url}
      ```

   3. 设置maven过滤文件范围

      ```xml
      <build> 
          <resources> 
              <!-${project.basedir}: 当前项目所在目录,子项目继承了父项目，相当于所有的子项目都添加了资源目录的过滤--> 
              <resource> 
                <directory>${project.basedir}/src/main/resources</directory>
                <!--设置能够解析${}，默认是false -->
                <filtering>true</filtering>
              </resource> 
          </resources> 
      </build>
      ```

3. 版本管理

   **工程版本：**

   - SNAPSHOT（快照版本）
     项目开发过程中临时输出的版本，称为快照版本

     快照版本会随着开发的进展不断更新 

   - RELEASE（发布版本）
     项目开发到一定阶段里程碑后，向团队外部发布较为稳定的版本，这种版本所对应的构件文件 是稳定的即便进行功能的后续开发，也不会改变当前发布版本内容，这种版本称为发布版本

   **发布版本：**

   - alpha版:内测版，bug多不稳定内部版本不断添加新功能

   - beta版:公测版，不稳定(比alpha稳定些)，bug相对较多不断添加新功能

   - 纯数字版



### 五、多环境开发与应用

---

1. 多环境开发

   - 在父工程（聚合工程）配置多个环境,并指定默认激活环境

     ```xml
     <profiles> 
         <!--开发环境--> 
         <profile> 
             <id>env_dep</id> 
             <properties> 
                 <jdbc.url>jdbc:mysql://127.1.1.1:3306/ssm_db</jdbc.url>
             </properties> 
             <!--设定是否为默认启动环境--> 
             <activation> 
                 <activeByDefault>true</activeByDefault>
             </activation>
         </profile> 
         <!--生产环境--> 
         <profile> 
             <id>env_pro</id> 
             <properties> 
                 <jdbc.url>jdbc:mysql://127.2.2.2:3306/ssm_db</jdbc.url>
             </properties> 
         </profile>
         <!--测试环境--> 
         <profile> 
             <id>env_test</id> 
             <properties> 
                 <jdbc.url>jdbc:mysql://127.3.3.3:3306/ssm_db</jdbc.url>
             </properties> 
         </profile> 
     </profiles>
     ```

   - 使用多环境(构建过程)

     语法：mvn 指令 -P 环境定义ID[环境定义中获取]

     ```bash
     mvn install -P env_test
     ```

2. 跳过测试

   - 配置插件实现跳过测试

     ```xml
     <build> 
         <plugins> 
             <plugin> 
                 <artifactId>maven-surefire-plugin</artifactId> 
                 <version>2.12.4</version> <configuration> 
                 <skipTests>false</skipTests> <!--排除掉不参与测试的内容--> 
                 <excludes> 
                     <exclude>**/BookServiceTest.java</exclude>
                 </excludes> 
                 </configuration> 
             </plugin>
         </plugins>
     </build>
     ```

   **注意：**

   ```markdown
   - skipTests:如果为true，则跳过所有测试，如果为false，则不跳过测试
   - excludes：哪些测试类不参与测试，即排除，针对skipTests为false来设置的
   - includes: 哪些测试类要参与测试，即包含,针对skipTests为true来设置的
   ```

   - 命令行跳过测试

     语法：mvn 指令 -D skipTests

     ```bash
     mvn install -D skipTests
     ```



### 六、私服

---

私服其实就是公司内部搭建的用于存储Maven资源的服务器所以说私服是一台独立的服务器，用于解决团队内部的资源共享与资源同步问题

**Nexus：**

1. 使用cmd进入到解压目录下的nexus\bin,执行如下命令启动Nexus：

   ```bash
   nexus.exe /run nexus
   ```

2. 浏览器访问http://localhost:8081

修改基础配置信息

- 安装路径下etc目录中nexus-default.properties文件保存有nexus基础配置信息，例如 默认访问端口

修改服务器运行配置信息

- 安装路径下bin目录中nexus.vmoptions文件保存有nexus服务器启动对应的配置信息，例如 默认占用内存空间

1. 仓库分类

   ![image-20230320091723692](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320100304754-1332484876.png)

2. 本地仓库配置

   ![image-20230320092344116](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320100304095-419511487.png)

   - 配置私服的访问权限

     ```xml
     <server>
         <id>yn.xiyan_snapshot</id>
         <username>admin</username>
         <password>123456</password>
     </server>
     <server>
         <id>yn.xiyan_release</id>
         <username>admin</username>
         <password>123456</password>
     </server>
     ```

   - 配置服务器映射地址

     ```xml
     <mirror>
         <id>maven-public</id>
         <mirrorOf>*</mirrorOf>
         <name>本地私服</name>
         <url>http://localhost:8081/repository/maven-public/</url>
     </mirror>
     ```

     注意：为了避免阿里云Maven私服地址的影响，建议先将之前配置的阿里云Maven私服镜像地址注释掉

   - 配置上传位置

     ```xml
     <!--    配置当前工程保存在私服中的具体位置-->
     <distributionManagement>
         <!--    快照仓库配置-->
         <snapshotRepository>
             <id>yn.xiyan_snapshot</id>
             <name>快照</name>
             <url>http://localhost:8081/repository/yn.xiyan_snapshot/</url>
         </snapshotRepository>
         <!--    发布仓库配置-->
         <repository>
             <id>yn.xiyan_release</id>
             <name>发布</name> 				 
             <url>http://localhost:8081/repository/yn.xiyan_release/</url>
         </repository>
     </distributionManagement>
     ```

   - 发布指令

     ```bash
     mvn deploy
     ```




所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)