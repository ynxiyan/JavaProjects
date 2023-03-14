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
      <dependency>
          <groupId>com.alibaba</groupId>
          <artifactId>fastjson</artifactId>
          <version>1.2.83</version>
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



#### 2.响应







所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)