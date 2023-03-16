# [SpringMVC](https://www.cnblogs.com/ynxiyan/p/17214319.html)

### 一、SpringMVC的概述

---

SpringMVC是隶属于Spring框架的一部分，主要是用来进行Web开发，是对Servlet进行了封装。

SpringMVC是处于Web层的框架，所以其主要的作用就是用来接收前端发过来的请求和数据然后经过 处理并将处理的结果响应给前端

**定义：**SpringMVC是一种基于Java实现MVC模型的轻量级Web框架

**优点：**使用简单、开发便捷(相比于Servlet) 、灵活性强



### 二、SpringMVC入门

---

1. 导入相应坐标

   ```xml
   <dependencies>
       <!--    springmvc-->
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-webmvc</artifactId>
           <version>5.2.10.RELEASE</version>
       </dependency>
       <!--      servlet-->
       <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>javax.servlet-api</artifactId>
           <version>4.0.0</version>
           <scope>provided</scope>
       </dependency>
   </dependencies>
   <build>
       <plugins>
           <plugin>
               <groupId>org.apache.tomcat.maven</groupId>
               <artifactId>tomcat7-maven-plugin</artifactId>
               <version>2.2</version>
           </plugin>
       </plugins>
   </build>
   ```

2. 创建springmvc控制器

   ```java
   //声明控制器
   @Controller
   public class UserController {
       //设置当前操作的访问路径
       @RequestMapping("/save")
       //设置当前操作的返回值类型
       @ResponseBody
       public String save(){
           System.out.println("UserController");
           return "{'model':'springmvc'}";
       }
   }
   ```

3. 初始化SpringMVC环境

   ```java
   //声明该类为springmvc的配置类
   @Configuration
   //规定包扫描
   @ComponentScan("com.springmvc_demo")
   public class SpringMvcConfig {
   }
   ```

4. 初始化Servlet容器

   ```java
   public class ServletContainersInitConfig extends AbstractDispatcherServletInitializer {
       /**
        * 加载SpringMVC容器配置
        *
        * @return 返回初始化后的SpringMVC容器
        */
       protected WebApplicationContext createServletApplicationContext() {
           //创建AnnotationConfigWebApplicationContext对象
           AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
           //注册SpringMVC容器
           applicationContext.register(SpringMvcConfig.class);
           return applicationContext;
       }
   
       /**
        * 设置归属于SpringMVC处理的请求路径
        *
        * @return 返回所有请求路径
        */
       protected String[] getServletMappings() {
           return new String[]{"/"};
       }
   
       /**
        * 加载Spring容器配置
        *
        * @return
        */
       protected WebApplicationContext createRootApplicationContext() {
           return null;
       }
   }
   ```

- AbstractDispatcherServletInitializer类是SpringMVC提供的快速初始化Web3.0容器 的抽象类

- AbstractDispatcherServletInitializer提供了三个接口方法供用户实现 
  - createServletApplicationContext方法，创建Servlet容器时，加载SpringMVC对应的bean并放入WebApplicationContext对象范围中，而WebApplicationContext的作用 范围为ServletContext范围，即整个web容器范围
  - getServletMappings方法，设定SpringMVC对应的请求映射路径，即SpringMVC拦截哪些 请求
  - createRootApplicationContext方法，如果创建Servlet容器时需要加载非SpringMVC对应的bean,使用当前方法进行，使用方式和createServletApplicationContext相同。 
  - createServletApplicationContext用来加载SpringMVC环境
  - createRootApplicationContext用来加载Spring环境

1. 删除web.xml

**注解：**

| 名称            | 说明                                             |
| --------------- | ------------------------------------------------ |
| @Controller     | 设定SpringMVC的核心控制器bean                    |
| @RequestMapping | 设置当前控制器方法请求访问路径                   |
| @ResponseBody   | 设置当前控制器方法响应内容为当前返回值，无需解析 |



### 三、bean加载控制

---

在加载Spring控制的bean的时候排除掉SpringMVC控制的bean

* 方式一:Spring加载的bean设定扫描范围为精准范围，例如service包、dao包等

  SpringConfig:

  ```java
  //规定包扫描
  @ComponentScan({"com.springmvc_demo.service", "com.springmvc_demo.dao"})
  ```

* 方式二:Spring加载的bean设定扫描范围为com.springmvc,排除掉controller包中的bean

  SpringConfig:

  ```java
  @ComponentScan(value="com.springmvc_demo", excludeFilters=@ComponentScan.Filter( type = FilterType.ANNOTATION, classes = Controller.class
  	)
  )
  ```

  ```markdown
  # excludeFilters属性：设置扫描加载bean时，排除的过滤规则
  # type属性：设置排除规则，当前使用按照bean定义时的注解类型进行排除
      ANNOTATION：按照注解排除
      ASSIGNABLE_TYPE:按照指定的类型过滤
      ASPECTJ:按照Aspectj表达式排除，基本上不会用
      REGEX:按照正则表达式排除
      CUSTOM:按照自定义规则排除
  # classes属性：设置排除的具体注解类，当前设置排除@Controller定义的bean
  ```

* 方式三:不区分Spring与SpringMVC的环境，加载到同一个环境中



### 四、请求与响应

---

#### 1. 请求

##### 1-1. 设置请求映射路径

![image-20230314150018274](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171241555-300472827.png)

```java
//设置当前控制器的请求路径前缀
@RequestMapping("/user")
```

当类上和方法上都添加了@RequestMapping注解，前端发送请求的时候，要和两个注解的value值相加匹配才能访问到

@RequestMapping注解value属性前面加不加/都可以

##### 1-2. 请求方式

- GET

  ![image-20230314150923438](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171241096-1853009979.png)

  处理GET请求中文乱码

  ```xml
  <groupId>org.apache.tomcat.maven</groupId>
  <artifactId>tomcat7-maven-plugin</artifactId>
  <version>2.2</version>
  <configuration>
      <!--                    访问路径编解码字符集-->
      <uriEncoding>UTF-8</uriEncoding>
  </configuration>
  ```

- POST

  ![image-20230314150957302](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171240544-1696363915.png)

  处理POST中文乱码

  ```java
  /**
   * 处理中文乱码
   *
   * @return 返回初始化后的中文乱码过滤器
   */
  @Override
  protected Filter[] getServletFilters() {
      //创建CharacterEncodingFilter对象
      CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
      //设置字符编码为UTF-8
      encodingFilter.setEncoding("UTF-8");
      encodingFilter.setForceEncoding(true);
      return new Filter[]{encodingFilter};
  }
  ```
  

##### 1-3. 请求参数

![image-20230314164036616](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171240038-1645950367.png)

1. 普通参数

   url地址传参，地址参数名与形参变量名相同，定义形参即可接收参数

   如果形参与地址参数名不一致使用@RequestParam注解指定

   ![image-20230314164211534](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171239625-928946787.png)

   ![image-20230314164458424](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171239156-868180998.png)

2. 对象类型参数

   请求参数名与形参对象属性名相同，定义对象类型形参即可接收参数

   ![image-20230314164248364](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171238766-619376856.png)

   <a style="color:red">注意：</a>请求参数key的名称要和对象中属性的名称一致，否则无法封装。

3. 嵌套对象类型参数

   请求参数名与形参对象属性名相同，按照对象层次结构关系即可接收嵌套对象属性参数

   ![image-20230314164316691](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171238378-71929808.png)

   <a style="color:red">注意：</a>请求参数key的名称要和对象中属性的名称一致，否则无法封装

4. 数组类型参数

   请求参数名与形参对象属性名相同且请求参数为多个，定义数组类型即可接收参数

   ![image-20230314164335397](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171237978-1871336614.png)

5. 集合类型参数

   请求参数名与形参集合对象名相同且请求参数为多个，使用@RequestParam注解绑定参数关系

   ![image-20230314164353502](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171237583-1596904859.png)

   ![image-20230314164417627](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171237192-297146952.png)

##### 1-4. 请求参数（JSON）

前置操作

- 导入相应坐标

  ```xml
  <dependencies>
      <!--        jackson-->
      <dependency>
          <groupId>com.fasterxml.jackson.core</groupId>
          <artifactId>jackson-databind</artifactId>
          <version>2.9.0</version>
      </dependency>
  </dependencies>
  ```

- 开启SpringMVCjson数据转java对象

  ```java
  //开启json数据转java对象
  @EnableWebMvc
  ```

  ![image-20230314170354346](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171236804-1240560185.png)

- 在方法形参添加@RequestBody注解

  ![image-20230314170419533](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171236431-1084711223.png)

1. json数组

   ![image-20230314165851593](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171236073-2099557210.png)

   ![image-20230314170136119](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171235651-298653770.png)

2. json对象数组

   ![image-20230314170307884](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171235275-640567809.png)

   ![image-20230314170324079](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171234824-1228508774.png)

3. json对象

   ![image-20230314170207523](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171234371-1519602440.png)

   ![image-20230314170222408](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230314171233848-1430754234.png)

**@RequestBody与@RequestParam区别**

区别：

- @RequestParam用于接收url地址传参，表单传参[application/x-www-formurlencoded]
- @RequestBody用于接收json数据[application/json]

应用：

- 后期开发中，发送json格式数据为主，@RequestBody应用较广
- 如果发送非json格式数据，选用@RequestParam接收请求参数

##### 1-5. 日期类型的参数传递

举例：

后端方法

```java
@RequestMapping("/dataParam") 
@ResponseBody 
public String dataParam(Date date,Date date1) {
    System.out.println("参数传递 date ==> "+date); 
    return "{'module':'data param'}";
}
```

前端请求

```http
http://localhost/dataParam?date=2088/08/08&date1=2088-08-08
```

发送请求和数据后，页面会报400，控制台会报出一个错误，错误的原因是在将2088-08-08转换成日期类型的时候失败了，原因是 SpringMVC默认支持的字符串转日期的格式为yyyy/MM/dd,而我们现在传递的不符合其默认格式， SpringMVC就无法进行格式转换，所以报错

**解决方法：**

使用@DateTimeFormat注解

![image-20230315091959595](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171312478-1539910637.png)

```java
@RequestMapping("/dataParam") 
@ResponseBody 
public String dataParam(Date date, 
                        @DateTimeFormat(pattern="yyyy-MM-dd") Date date1, @DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss") Date date2) 
{
    System.out.println("参数传递 date ==> "+date); 
    System.out.println("参数传递 date1(yyyy-MM-dd) ==> "+date1); System.out.println("参数传递 date2(yyyy/MM/dd HH:mm:ss) ==> "+date2); 
    return "{'module':'data param'}";
}
```

#### 2.响应

SpringMVC在接收到请求和数据后，进行了一些处理，当然这个处理可以是转发给Service， Service层再调用Dao层完成的

1. 响应页面

   ```java
   @RequestMapping("/toJumpPage") 
   //注意 
   //1.此处不能添加@ResponseBody,如果加了该注入，会直接将page.jsp当字符串返回前端 //2.方法需要返回String 
   public String toJumpPage(){ 
       System.out.println("跳转页面"); 
       return "page.jsp";
   }
   ```

2. 响应数据

   ![image-20230315095238922](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171312103-78413959.png)

   **说明：**

   ```markdown
   * 该注解可以写在类上或者方法上
   * 写在类上就是该类下的所有方法都有@ReponseBody功能，当方法上有@ReponseBody注解后
           - 方法的返回值为字符串，会将其作为文本内容直接响应给前端
           - 方法的返回值为对象，会将对象转换成JSON响应给前端
   ```

   - 文本数据

     ```java
     @RequestMapping("/toText") 
     //注意此处该注解就不能省略，如果省略了,会把response text当前页面名称去查找，如果没有会报404错误 
     @ResponseBody 
     public String toText(){ 
         System.out.println("返回纯文本数据"); 
         return "response text";
     }
     ```

   - json数据

     ```java
     @RequestMapping("/toJsonPOJO") 
     //注意此处返回值为实体类对象，设置返回值为实体类类型，即可实现返回对应对象的json数据，需要依赖@ResponseBody和@EnableWebMvc注解
     @ResponseBody 
     public User toJsonPOJO(){ 
         System.out.println("返回json对象数据"); 
         User user = new User(); 
         user.setName("itcast"); 
         user.setAge(15); 
         return user;
     }
     ```

   - json集合对象

     ```java
     @RequestMapping("/toJsonList") 
     @ResponseBody 
     public List<User> toJsonList(){ 
         System.out.println("返回json集合数据"); 
         User user1 = new User(); 
         user1.setName("传智播客"); 
         user1.setAge(15);
         User user2 = new User(); 
         user2.setName("黑马程序员"); 
         user2.setAge(12);
         List<User> userList = new ArrayList<User>(); 
         userList.add(user1); 
         userList.add(user2);
         return userList; 
     }
     ```

#### 3. 类型转换器

![image-20230315092547285](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171311565-1936242568.png)

**HttpMessageConverter**接口是实现对象与JSON之间的转换工作

- 所以Converter除了前面所说的功能外，它还可以实现:
  - 对象转Json数据(POJO -> json)
  - 集合转Json数据(Collection -> json)

**注意：**在SpringMVC的配置类把@EnableWebMvc当做标配配置上去，不要省略



### 五、REST风格

---

REST（Representational State Transfer），表现形式状态转换,它是一种软件架构风格（访问网络资源的格式）

**REST的优点：**

​			隐藏资源的访问行为，无法通过地址得知对资源是何种操作、书写简化

![image-20230315100630178](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171311090-453765127.png)

**注意：**

- 上述行为是约定方式，约定不是规范，可以打破，所以称REST风格，而不是REST规范
  - REST提供了对应的架构方式，按照这种架构设计项目可以降低开发的复杂性，提高系统的可伸缩性
  - REST中规定GET/POST/PUT/DELETE针对的是查询/新增/修改/删除

- 描述模块的名称通常使用复数，也就是加s的格式描述，表示此类资源，而非单个资源
- 根据REST风格对资源进行访问称为RESTful后期开发中，大多是都是遵从REST风格来访问我们的后台服务，所以可以说以后都是基于RESTful来进行开发

#### 1. RESTful入门

1. 设定http请求动作（动词）

   ```java
   //设置当前请求方法为POST，表示REST风格中的添加操作 
   @RequestMapping(value = "/users",method = RequestMethod.POST) @ResponseBody 
   public String save() { 
       System.out.println("user save..."); 
       return "{'module':'user save'}";
   }
   ```

   ![image-20230315105946712](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171310564-2073502385.png)

2. 设定请求参数（路径变量）

   ```java
   //设置当前请求方法为DELETE，表示REST风格中的删除操作 
   @RequestMapping(value = "/users/{id}",method = RequestMethod.DELETE) @ResponseBody 
   public String delete(@PathVariable Integer id) { 					     	System.out.println("user delete..." + id);
      return "{'module':'user delete'}";
   }
   ```

   ![image-20230315105903752](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171310020-1971582232.png)

   **注意：**

   - 如果方法形参的名称和路径{}中的值不一致可以使用以下做法解决：

     ![image-20230315105711458](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171309590-2092744283.png)

   - 如果有多个参数需要传递可以使用以下方法解决：

     ![image-20230315105819707](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171309042-900000466.png)

#### 2. @RequestBody、@RequestParam、@PathVariable的区别与应用

**区别：**

- @RequestParam用于接收url地址传参或表单传参
- @RequestBody用于接收json数据
- @PathVariable用于接收路径参数，使用{参数名称}描述路径参数

**应用：**

- 在后期开发中，发送请求参数超过1个时，以json格式为主，@RequestBody应用较广
- 如果发送非json格式数据，选用@RequestParam接收请求参数
- 当参数数量较少时，例如1个，采用RESTful进行开发，可以使用@PathVariable接收请求路径变量，通常用于传递id值

#### 3. RESTful快速开发

![image-20230315111645034](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171308632-688514757.png)

```java
//@Controller
//@ResponseBody
@RestController
@RequestMapping("/books")
public class BookController {
    //    @RequestMapping(value = "/books", method = RequestMethod.POST)
    @PostMapping
    public String save(@RequestBody Book book) {
        System.out.println("book save..." + book);
        return "{'module':'book save'}";
    }

    //    @RequestMapping(value = "/books/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        System.out.println("book delete..." + id);
        return "{'module':'book delete'}";
    }

    //    @RequestMapping(value = "/books", method = RequestMethod.PUT)
    @PutMapping
    public String update(@RequestBody Book book) {
        System.out.println("book update..." + book);
        return "{'module':'book update'}";
    }

    //    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("book getById..." + id);
        return "{'module':'book getById'}";
    }

    //    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @GetMapping
    public String getAll() {
        System.out.println("book getAll...");
        return "{'module':'book getAll'}";
    }
}
```

![image-20230315111703877](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171308195-1115589610.png)



### 六、SSM整合

---

前置操作，导入相应坐标

```xml
<dependencies>
    <!--    SpringMVC-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.10.RELEASE</version>
    </dependency>
    <!--    MySQL-->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.32</version>
    </dependency>
    <!--    Druid-->
    <dependency>
        <groupId>com.alibaba</groupId>
        <artifactId>druid</artifactId>
        <version>1.1.10</version>
    </dependency>
    <!--    Spring整合JDBC-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.10.RELEASE</version>
    </dependency>
    <!--    MyBatis-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.5</version>
    </dependency>
    <!--        Spring整合MyBatis-->
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>1.3.0</version>
    </dependency>
    <!--    Junit-->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
    </dependency>
    <!--    Spring整合Junit-->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-test</artifactId>
        <version>5.2.10.RELEASE</version>
    </dependency>
    <!--Servlet-->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.0</version>
        <scope>provided</scope>
    </dependency>
    <!--        jackson-->
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.9.0</version>
    </dependency>
</dependencies>
<build>
    <plugins>
        <plugin>
            <!--        tomcat-->
            <groupId>org.apache.tomcat.maven</groupId>
            <artifactId>tomcat7-maven-plugin</artifactId>
            <version>2.2</version>
            <configuration>
                <!--          设置解编码集-->
                <uriEncoding>UTF-8</uriEncoding>
            </configuration>
        </plugin>
    </plugins>
</build>
```

#### 1. 配置整合

1. JdbcByDruid

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:25
    * @注释:Spring整合JdbcByDruid
    */
   public class JdbcByDruidConfig {
       //注册驱动
       @Value("${driverClassName}")
       private String driver;
       //数据库连接源
       @Value("${url}")
       private String url;
       //用户名
       @Value("${username}")
       private String username;
       //密码
       @Value("${password}")
       private String password;
       //初始连接大小
       @Value("${initialSize}")
       private int initialSize;
       //最小空闲连接大小
       @Value("${minIdle}")
       private int minIdle;
       //最大活动连接大小
       @Value("${maxActive}")
       private int maxActive;
       //最长等待时间
       @Value("${maxWait}")
       private int maxWait;
   
       /**
        * 初始化jdbcByDruid数据源连接池
        *
        * @return 返回初始化后的DruidDataSource对象
        */
       //声明为bean
       @Bean
       public DataSource druidDataSource() {
           //创建DruidDataSource对象
           DruidDataSource druidDataSource = new DruidDataSource();
           //设置JDBC驱动
           druidDataSource.setDriverClassName(driver);
           //设置数据库连接源
           druidDataSource.setUrl(url);
           //设置用户名
           druidDataSource.setUsername(username);
           //设置密码
           druidDataSource.setPassword(password);
           //设置初始连接大小
           druidDataSource.setInitialSize(initialSize);
           //设置最小空闲连接大小
           druidDataSource.setMinIdle(minIdle);
           //设置最大活动连接大小
           druidDataSource.setMaxActive(maxActive);
           //设置最长等待时间
           druidDataSource.setMaxWait(maxWait);
           return druidDataSource;
       }
   
       /**
        * 设置Spring事务管理器
        *
        * @param druidDataSource 传入数据库连接池对象
        * @return 返回配置好的事务处理器
        */
       //声明为bean
       @Bean
       public PlatformTransactionManager platformTransactionManager(DataSource druidDataSource) {
           //创建DataSourceTransactionManager对象
           DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
           //设置数据库连接源对象的事务管理器为Spring事务管理器
           dataSourceTransactionManager.setDataSource(druidDataSource);
           return dataSourceTransactionManager;
       }
   }
   ```

2. MyBatis

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:28
    * @注释:Spring整合MyBatis
    */
   public class MyBatisConfig {
       /**
        * 初始化SqlSessionFactory并设置相关参数
        *
        * @param jdbcByDruidConfig 传入jdbcByDruid的数据库连接池对象
        * @return 返回初始化后的SqlSession对象
        */
       //声明为bean
       @Bean
       public SqlSessionFactoryBean sqlSessionFactory(JdbcByDruidConfig jdbcByDruidConfig) {
           //创建SqlSessionFactoryBean对象
           SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
           //设置类型别名的包路径
           sqlSessionFactoryBean.setTypeAliasesPackage("com.springmvc_ssm.model");
           //设置数据源
           sqlSessionFactoryBean.setDataSource(jdbcByDruidConfig.druidDataSource());
           return sqlSessionFactoryBean;
       }
   
       /**
        * 设置Mapper自动代理的映射文件
        *
        * @return 返回初始化后的Mapper自动代理映射对象
        */
       //声明为bean
       @Bean
       public MapperScannerConfigurer mapperScannerConfigurer() {
           //创建mapper自动代理对象
           MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
           //设置包扫描路径
           mapperScannerConfigurer.setBasePackage("com.springmvc_ssm.dao");
           return mapperScannerConfigurer;
       }
   }
   ```

3. Spring

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:12
    * @注释:Spring配置
    */
   //声明该类为Spring的配置类
   @Configuration
   //规定包扫描
   @ComponentScan({"com.springmvc_ssm.service","com.springmvc_ssm.dao"})
   //导入Druid的配置文件信息
   @PropertySource("classpath:druid.properties")
   //开启注解式事务驱动
   @EnableTransactionManagement
   //开启注解式AOP开发
   //@EnableAspectJAutoProxy
   //导入其他配置类
   @Import({JdbcByDruidConfig.class, MyBatisConfig.class})
   public class SpringConfig {
   
   }
   ```

4. SpringMVC

   - ServletContainersInit

     ```java
     /**
      * @Author: XIYAN
      * @Date: 2023/3/14 10:48
      * @注释:Servlet容器与Spring容器的初始化配置
      */
     public class ServletContainersInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
         /**
          * 获取Spring容器的配置类
          *
          * @return 返回初始化后的Spring容器
          */
         protected Class<?>[] getRootConfigClasses() {
             return new Class[]{SpringConfig.class};
         }
     
         /**
          * 获取SpringMVC容器的配置类
          *
          * @return 返回初始化后的SpringMVC容器
          */
         protected Class<?>[] getServletConfigClasses() {
             return new Class[]{SpringMvcConfig.class};
         }
     
         /**
          * 获取归属于SpringMVC处理的请求路径
          *
          * @return 返回所有请求路径
          */
         protected String[] getServletMappings() {
             return new String[]{"/"};
         }
     
         /**
          * 处理中文乱码
          *
          * @return 返回初始化后的中文乱码过滤器
          */
         @Override
         protected Filter[] getServletFilters() {
             //创建CharacterEncodingFilter对象
             CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
             //设置字符编码为UTF-8
             encodingFilter.setEncoding("UTF-8");
             encodingFilter.setForceEncoding(true);
             return new Filter[]{encodingFilter};
         }
     }
     ```

   - SpringMVC

     ```java
     /**
      * @Author: XIYAN
      * @Date: 2023/3/14 10:45
      * @注释:SpringMVC的配置
      */
     //声明该类为springmvc的配置类
     @Configuration
     //规定包扫描
     @ComponentScan({"com.springmvc_ssm.controller", "com.springmvc_ssm.config"})
     //开启json数据转java对象
     @EnableWebMvc
     public class SpringMvcConfig {
     }
     ```

5. 静态资源过滤器

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 11:38
    * @注释:SpringMVC静态资源过滤
    */
   //声明该类为Spring的配置类
   @Configuration
   public class SpringMvcSupport extends WebMvcConfigurationSupport {
       /**
        * 静态资源过滤器
        *
        * @param registry
        */
       @Override
       protected void addResourceHandlers(ResourceHandlerRegistry registry) {
           //当访问/pages/**时，走/pages/路径
           registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
           //当访问/js/**时，走/js/路径
           registry.addResourceHandler("/js/**").addResourceLocations("/js/");
           //当访问/css/**时，走/css/路径
           registry.addResourceHandler("/css/**").addResourceLocations("/css/");
       }
   }
   ```

#### 2. 功能测试

1. model

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 15:14
    * @注释:图书实体
    */
   //自动装配get、set方法
   @Data
   public class Book {
       //图书序号
       private Integer id;
       //图书类型
       private String type;
       //图书名称
       private String name;
       //图书简介
       private String description;
   
       public Book() {
       }
   
       public Book(Integer id, String type, String name, String description) {
           this.id = id;
           this.type = type;
           this.name = name;
           this.description = description;
       }
   
       @Override
       public String toString() {
           return "Book{" +
               "id=" + id +
               ", type='" + type + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               '}';
       }
   }
   ```

2. dao

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 15:15
    * @注释:图书数据层接口
    */
   public interface BookDao {
       /**
        * 新增图书信息
        *
        * @param book 传入图书对象
        */
       //mapper自动代理（插入）
       @Insert("insert into tbl_book (type,name,description) values(#{type},#{name},#{description})")
       void save(Book book);
   
       /**
        * 通过图书序号更新图书信息
        *
        * @param book 传入图书序号
        */
       //mapper自动代理（更新）
       @Update("update tbl_book set type = #{type}, name = #{name}, description = #{description} where id = #{id}")
       void update(Book book);
   
       /**
        * 通过图书序号删除图书信息
        *
        * @param id 传入图书序号
        */
       //mapper自动代理（删除）
       @Delete("delete from tbl_book where id = #{id}")
       void delete(Integer id);
   
       /**
        * 通过图书序号查询图书信息
        *
        * @param id 传入图书序号
        * @return 返回图书信息
        */
       //mapper自动代理（查询）
       @Select("select * from tbl_book where id = #{id}")
       Book getById(Integer id);
   
       /**
        * 查询全部图书信息
        *
        * @return 返回图书信息列表
        */
       //mapper自动代理（查询）
       @Select("select * from tbl_book")
       List<Book> getAll();
   }
   ```

3. service

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 15:15
    * @注释:图书业务层接口
    */
   //使用Spring管理事务
   @Transactional
   public interface BookService {
       /**
        * 新增图书信息
        *
        * @param book 传入图书对象
        * @return 返回执行结果
        */
       boolean save(Book book);
   
       /**
        * 通过图书序号修改图书信息
        *
        * @param book 传入图书序号
        * @return 返回执行结果
        */
       boolean update(Book book);
   
       /**
        * 通过图书序号删除图书信息
        *
        * @param id 传入图书序号
        * @return 返回执行结果
        */
       boolean delete(Integer id);
   
       /**
        * 通过图书序号查询图书信息
        *
        * @param id 传入图书序号
        * @return 返回图书信息
        */
       Book getById(Integer id);
   
       /**
        * 查询全部图书信息
        *
        * @return 返回图书信息列表
        */
       List<Book> getAll();
   }
   ```

   - 测试业务层接口

     ```java
     /**
      * @Author: XIYAN
      * @Date: 2023/3/15 16:08
      * @注释:图书业务层接口测试
      */
     //指定当前类为Spring的测试类
     @RunWith(SpringJUnit4ClassRunner.class)
     //加载Spring测试配置
     @ContextConfiguration(classes = SpringConfig.class)
     public class BookServiceTest {
         //自动装配Service
         @Autowired
         private BookService bookService;
     
         //测试新增图书信息
         @Test
         public void TestSave() {
             Book book = new Book();
             book.setName("111");
             book.setType("123");
             book.setDescription("123");
             System.out.println(bookService.save(book));
         }
     
         //测试通过图书序号更新图书信息
         @Test
         public void TestUpdate() {
             Book book = new Book();
             book.setName("222");
             book.setId(14);
             System.out.println(bookService.update(book));
         }
     
         //测试通过图书序号删除图书信息
         @Test
         public void TestDelete() {
             System.out.println(bookService.delete(13));
         }
     
         //测试通过图书序号查询图书信息
         @Test
         public void TestGetById() {
             System.out.println(bookService.getById(1));
         }
     
         //测试查询全部图书信息列表
         @Test
         public void TestGetByAll() {
             System.out.println(bookService.getAll());
         }
     }
     ```

4. controller

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 15:17
    * @注释:图书表现层功能实现
    */
   //使用基于RESTful开发的表现层功能
   @RestController
   //请求路径前缀
   @RequestMapping("/books")
   public class BookController {
       //自动装配Service
       @Autowired
       private BookService bookService;
   
       /**
        * 新增图书信息
        *
        * @param book 传入图书信息
        * @return
        */
       //POST请求
       @PostMapping
       //@RequestBody表示接收的请求参数为json数据
       public boolean save(@RequestBody Book book) {
           return bookService.save(book);
       }
   
       /**
        * 通过图书序号更新图书信息
        *
        * @param book 传入图书序号
        * @return
        */
       //PUT请求
       @PutMapping
       //@RequestBody表示接收的请求参数为json数据
       public boolean update(@RequestBody Book book) {
           return bookService.update(book);
       }
   
       /**
        * 通过图书序号删除图书信息
        *
        * @param id 传入图书序号
        * @return
        */
       //DELETE请求
       @DeleteMapping("/{id}")
       //@PathVariable表示当前参数来自路径参数
       public boolean delete(@PathVariable Integer id) {
           return bookService.delete(id);
       }
   
       /**
        * 通过图书序号查询图书信息
        *
        * @param id 传入图书序号
        * @return
        */
       //GET请求
       @GetMapping("/{id}")
       //@PathVariable表示当前参数来自路径参数
       public Book getById(@PathVariable Integer id) {
           return bookService.getById(id);
       }
   
       /**
        * 查询全部图书信息
        *
        * @return
        */
       //GET请求
       @GetMapping
       public List<Book> getAll() {
           return bookService.getAll();
       }
   }
   ```

   - 测试表现层功能实现

     ![image-20230315170838100](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171307695-1963836651.png)

     ![image-20230315170914577](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171307235-1677571574.png)

     ![image-20230315170950223](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171306821-1984229808.png)

     ![image-20230315171004650](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171306396-84746371.png)

     ![image-20230315171020336](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230315171305738-683762264.png)

#### 3. 表现层数据封装

1. 设置统一数据返回结果类

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/16 9:19
    * @注释:表现层数据封装
    */
   //自动装配get、set
   @Data
   public class Result {
       //状态码
       private Integer code;
       //数据
       private Object data;
       //消息
       private String msg;
   
       public Result() {
       }
   
       public Result(Integer code, Object data) {
           this.code = code;
           this.data = data;
       }
   
       public Result(Integer code, Object data, String msg) {
           this.code = code;
           this.data = data;
           this.msg = msg;
       }
   }
   ```

2. 定义状态码

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/16 9:26
    * @注释:状态码
    */
   public class Code {
       //新增成功
       public static final Integer SAVE_OK = 20011;
       //删除成功
       public static final Integer DELETE_OK = 20021;
       //更新成功
       public static final Integer UPDATE_OK = 20031;
       //查询成功
       public static final Integer GET_OK = 20041;
       //新增失败
       public static final Integer SAVE_ERROR = 20010;
       //删除失败
       public static final Integer DELETE_ERROR = 20020;
       //更新失败
       public static final Integer UPDATE_ERROR = 20030;
       //查询失败
       public static final Integer GET_ERROR = 20040;
       //系统错误
       public static final Integer SYSTEM_ERROR = 50001;
       //服务器访问超时
       public static final Integer SYSTEM_TIMEOUT_ERROR = 50002;
       //系统未知错误
       public static final Integer SYSTEM_UNKNOW_ERROR = 59999;
       //业务错误
       public static final Integer BUSINESS_ERROR = 60001;
   }
   ```

3. 表现层功能实现（数据封装）

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/15 15:17
    * @注释:图书表现层功能实现
    */
   //使用基于RESTful开发的业务层功能
   @RestController
   //请求路径前缀
   @RequestMapping("/books")
   public class BookController {
       //自动装配Service
       @Autowired
       private BookService bookService;
   
       /**
        * 新增图书信息
        *
        * @param book 传入图书信息
        * @return
        */
       //POST请求
       @PostMapping
       //@RequestBody表示接收的请求参数为json数据
       public Result save(@RequestBody Book book) {
           boolean save = bookService.save(book);
           return new Result(save ? Code.SAVE_OK : Code.SAVE_ERROR, save);
       }
   
       /**
        * 通过图书序号更新图书信息
        *
        * @param book 传入图书序号
        * @return
        */
       //PUT请求
       @PutMapping
       //@RequestBody表示接收的请求参数为json数据
       public Result update(@RequestBody Book book) {
           boolean update = bookService.update(book);
           return new Result(update ? Code.UPDATE_OK : Code.UPDATE_ERROR, update);
       }
   
       /**
        * 通过图书序号删除图书信息
        *
        * @param id 传入图书序号
        * @return
        */
       //DELETE请求
       @DeleteMapping("/{id}")
       //@PathVariable表示当前参数来自路径参数
       public Result delete(@PathVariable Integer id) {
           boolean delete = bookService.delete(id);
           return new Result(delete ? Code.DELETE_OK : Code.DELETE_ERROR, delete);
       }
   
       /**
        * 通过图书序号查询图书信息
        *
        * @param id 传入图书序号
        * @return
        */
       //GET请求
       @GetMapping("/{id}")
       //@PathVariable表示当前参数来自路径参数
       public Result getById(@PathVariable Integer id) {
           Book book = bookService.getById(id);
           Integer code = book != null ? Code.GET_OK : Code.GET_ERROR;
           String message = book != null ? "" : "查询失败，请重试";
           return new Result(code, book, message);
       }
   
       /**
        * 查询全部图书信息
        *
        * @return
        */
       //GET请求
       @GetMapping
       public Result getAll() {
           List<Book> bookList = bookService.getAll();
           Integer code = bookList != null ? Code.GET_OK : Code.GET_ERROR;
           String message = bookList != null ? "" : "查询失败，请重试";
           return new Result(code, bookList, message);
       }
   }
   ```

#### 4. 异常处理器

集中的、统一的处理项目中出现的异常

![image-20230316095919468](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230316111122865-1947271281.png)

创建SpringMVC、RESTful的统一异常处理类

![image-20230316101609257](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230316111122202-672532983.png)

**注：**此注解自带@ResponseBody注解与@Component注解，具备对应的功能

![image-20230316101654631](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230316111121633-1627180569.png)

**注：**此类方法可以根据处理的异常不同，制作多个方法分别处理对应的异常

```java
/**
 * @Author: XIYAN
 * @Date: 2023/3/16 10:05
 * @注释:SpringMVC统一异常处理器
 */
//声明该类为SpringMVC、RESTful的统一异常处理类
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //标记拦截的异常类型（处理系统异常）
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException systemException) {
        //记录日志
        //发送消息给运维
        //发送邮箱将systemException对象给开发者
        return new Result(systemException.getCode(), null, systemException.getMessage());
    }

    //标记拦截的异常类型（处理业务异常）
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException businessException) {
        return new Result(businessException.getCode(), null, businessException.getMessage());
    }

    //标记拦截的异常类型（处理其他异常）
    @ExceptionHandler(Exception.class)
    public Result doException(Exception exception) {
        //记录日志
        //发送消息给运维
        //发送邮箱将exception对象给开发者
        return new Result(Code.SYSTEM_UNKNOW_ERROR, null, "系统繁忙，请稍后再试");
    }
}
```

<a style="color:red">注意：</a>发消息和记录日志对用户来说是不可见的，属于后台程序 

#### 5. 项目异常处理方案

- 业务异常（BusinessException） ：发送对应消息传递给用户，提醒规范操作；常见的就是提示用户名已存在或密码格式不正确等

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/3/16 10:31
   * @注释:处理业务异常
   */
  //自动装配get、set
  @Data
  public class BusinessException extends RuntimeException {
      //异常状态码
      private Integer code;
  
      public BusinessException(Integer code, String message) {
          super(message);
          this.code = code;
      }
  
      public BusinessException(Integer code, String message, Throwable cause) {
          super(message, cause);
          this.code = code;
      }
  }
  ```

- 系统异常（SystemException） ：发送固定消息传递给用户，安抚用户；如系统繁忙，请稍后再试、系统正在维护升级，请稍后再试、系统出问题，请联系系统管理员等发送特定消息给运维人员，提醒维护，可以发送短信、邮箱或者是公司内部通信软件

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/3/16 10:31
   * @注释:处理系统异常
   */
  //自动装配get、set
  @Data
  public class SystemException extends RuntimeException {
      //异常状态码
      private Integer code;
  
      public SystemException(Integer code, String message) {
          super(message);
          this.code = code;
      }
  
      public SystemException(Integer code, String message, Throwable cause) {
          super(message, cause);
          this.code = code;
      }
  }
  ```

- 其他异常（Exception） ：发送固定消息传递给用户，安抚用户；发送特定消息给编程人员，提醒维护（纳入预期范围内） 一般是程序没有考虑全，比如未做非空校验等





所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)