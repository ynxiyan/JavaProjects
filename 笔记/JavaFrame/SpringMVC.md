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
       @Override
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
       @Override
       protected String[] getServletMappings() {
           return new String[]{"/"};
       }
   
       /**
        * 加载Spring容器配置
        *
        * @return
        */
       @Override
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

