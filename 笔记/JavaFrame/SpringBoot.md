# [SpringBoot](https://www.cnblogs.com/ynxiyan/p/17236972.html)

### 一、SpringBoot的入门

---

SpringBoot是由Pivotal团队提供的全新框架，其设计目的是用来简化Spring应用的初始搭建以及开发过程

|    spring    | 优化 |         SpringBoot          |
| :----------: | :--: | :-------------------------: |
|   配置繁琐   | ==>  |          自动配置           |
| 依赖设置繁琐 | ==>  |  起步依赖（简化依赖配置）   |
|              |      | 辅助功能（内置服务器，...） |

 **开发SpringBoot程序所包含的基础文件**

- pom.xml
- Application类

**使用步骤：**

1. 创建新模块，选择Spring初始化，并配置模块相关基础信息
2. 选择当前模块需要使用的技术集
3. 开发控制器类
4. 运行自动生成的Application类

**Spring程序与SpringBoot程序的对比：**

![image-20230320111258617](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320170122531-1577378154.png)

注意：基于idea开发SpringBoot程序需要确保朕网且能够加载到程序框架结构

**SpringBoot程序的快速启动：**

1. 运行maven打包指令

   ```bash
   mvn package
   ```

2. 运行maven指令

   ```bash
   java -jar xxxx.jar
   ```

注意：jar支持命令行启动需要依赖maven插件支持 ，请确认打包时是否具有SpringBoot对应的 maven 插件

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-maven-plugin</artifactId>
        </plugin>
    </plugins>
</build>
```



### 二、起步依赖

---

- starter
  - SpringBoot中常见项目名称，定义了当前项目使用的所有项目坐标，以达到减少依赖配置的目的

- parent
  - 所有SpringBoot项目要继承的项目，定义了若干个坐标版本号（依赖管理，而非依赖，以达到减少依赖冲突的目的

**在实际开发过程中：**

- 使用任意坐标时，仅书写GAV中的G和A，V由SpringBoot提供

  （GAV：groupId、artifactId、version）

- 如发生坐标错误，再指定version（要小心版本冲突）



### 三、基础配置

---

#### 1. 配置格式

- application.properties

  ```properties
  server.port=80
  ```

- application.yml / application.yaml

  ```yaml
  server:
    port: 80
  ```

优先级：properties > yml > yaml

#### 2. yaml

YAML（YAML Ain't Markup Language），一种数据序列化格式。这种格式的配置文件在近些年已经占有主导地位

**优点：**

- 容易阅读

  yaml 类型的配置文件比 xml 类型的配置文件更容易阅读，结构更加清晰 容易与脚本语言交互

- 以数据为核心，重数据轻格式

  yaml 更注重数据，而 xml 更注重格式

**YAML文件扩展名：**

- .yml (主流)
- .yaml

**语法规则：**

- 大小写敏感
- 属性层级关系使用多行描述，每行结尾使用冒号结束
- 使用缩进表示层级关系，同层级左侧对齐，只允许使用空格（不允许使用Tab键） 空格的个数并不重要，只要保证同层级的左侧对齐即可
- 属性值前面添加空格（属性名与属性值之间使用冒号+空格作为分隔）
- #表示注释

**<a>核心规则：数据前面要加空格与冒号隔开</a>**

数组格式：

```yaml
array:
  - item1
  - item2
```

数据读取方式：

1. 使用@Value注解

   ${一级属性名.二级属性名……}

   ```java
   @Value("${lesson}") 
   private String lesson;
   ```

2. 使用@Autowired注解加载环境对象

   ```java
   @Autowired 
   private Environment env;
   ```

3. 创建类，将数据封装成对象并使用@Component、@ConfigurationProperties和@Autowired注解读取配置

   ```java
   @Component 
   @ConfigurationProperties(prefix = "要读取的属性") 
   public class Enterprise {}
   -----------------------------
   @Autowired private 
   Enterprise enterprise;
   ```

**解决自定义对象封装数据警告：**

```xml
<dependency> 
    <groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-configuration-processor</artifactId> 
    <optional>true</optional>
</dependency>
```

#### 3. 多环境配置

1. yml \ yaml

   ```yaml
   #设置启用的环境 
   spring: 
     profiles: 
       active: dev
   ---
   #开发 
   spring: 
     profiles: dev
     
   server: 
     port: 80
   ---
   #生产 
   spring: 
     profiles: pro
     
   server: 
     port: 81
   ---
   #测试 
   spring: 
     profiles: test
     
   server: 
     port: 82
   ```

2. properties

   ```properties
   spring.profiles.active=pro
   ```

   application-dev.properties	application-pro.properties	application-test.properties

   每个文件表示一种环境

**命令行启动多环境：**

1. 启动时修改环境配置

   ```bash
   java –jar xxx.jar –-spring.profiles.active=test
   ```

2. 启动时修改端口

   ```bash
   java –jar xxx.jar –-server.port=88
   ```

**属性优先级：**

![image-20230320153909666](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320170122110-398180101.png)

图片来源于：[Core Features (spring.io)](https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config)

#### 4. 配置文件的分类

- 1级
  - classpath：application.yml
- 2级
  - classpath：config/application.yml
- 3级
  - file ：application.yml
- 4级
  - file ：config/application.yml

<a style="color:red">说明：</a>级别越高优先级越高



### 四、SpringBoot整合SSM

---

#### 1. 整合Junit

```java
@SpringBootTest
class SpringbootSsmApplicationTests {
    @Autowired
    private BookService bookService;

    @Test
    void contextLoads() {
        bookService.save();
    }
}
```

![image-20230320161902720](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320170121624-84003027.png)

#### 2. 整合MyBatis

1. 在创建SpringBoot项目时勾选需要的技术集

   ![image-20230320165817900](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230320170121021-1686661742.png)

2. 配置数据源

   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/spring_db?serverTimezone=UTC
       username: root
       password: 123456
       type: com.alibaba.druid.pool.DruidDataSource
   ```

3. 使用@Mapper注解，标注mapper接口

   ```java
   @Mapper
   public interface BookDao {
       @Select("select * from tbl_book where id=#{id}")
       Book selectById(Integer id);
   }
   ```

注：如果使用Druid数据库连接池需要导入Druid的坐标

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.1.10</version>
</dependency>
```





所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)