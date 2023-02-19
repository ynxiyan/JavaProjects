# [Servlet](https://www.cnblogs.com/ynxiyan/p/17127204.html)

### 一、概述

---

1. servlet是javaEE规范之一，规范就是接口

2. servlet是javaWeb的三大组件之一

   ​	三大组件：servlet程序、filter过滤器、listener监听器

3. servlet是一个运行在服务器上的一个java小程序，他可以接收用户发送过来的**请求**并进行一定的**处理**后**响应**给客户端
4. servlet是一种动态web资源开发技术，使用servlet可以实现不同请求处理完毕以后显示不同的内容

### 二、手动实现servlet程序

---

1. 编写一个类，去实现servlet接口

2. 实现接口中的抽象方法，service()是功能执行的方法

3. 在新疆的类上添加@WebServlet注解

   ```java
   @WebServlet("/servlet1")
   public class MyServlet1 implements Servlet {
       /**
        * 初始化
        * @param servletConfig
        * @throws ServletException
        */
       @Override
       public void init(ServletConfig servletConfig) throws ServletException {
       }
   
       /**
        * 获取servlet配置
        * @return
        */
       @Override
       public ServletConfig getServletConfig() {
           return null;
       }
   
       /**
        * 服务
        * @param servletRequest
        * @param servletResponse
        * @throws ServletException
        * @throws IOException
        */
       @Override
       public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
           System.out.println("servlet1服务");
       }
   
       /**
        * 获取servlet信息
        * @return
        */
       @Override
       public String getServletInfo() {
           return null;
       }
   
       /**
        * 销毁
        */
       @Override
       public void destroy() {
   
       }
   }
   ```

#### 1.ServletConfig(servlet配置的信息类)

ServletConfig的三个作用：

1. 获取xml中servlet程序的别名

   ```java
   servletConfig.getServletName();
   ```

2. 获取初始化参数

   ```java
   servletConfig.getInitParameter("user");
   ```

3. 获取ServletContext对象(servlet的上下文，存储当前项目或servlet的一些信息)

   ```java
   servletConfig.getServletContext();
   ```

#### 2.ServletContext(servlet的上下文)

ServletContext的四个作用：

```java
ServletContext servletContext = getServletContext();
```

1. 获取web.xml中配置的上下文参数	context-param

   ```java
   servletContext.getInitParameter("users");
   ```

2. 获取当前的工作路径

   ```java
   servletContext.getContextPath();
   ```

3. 获取工程部署后在服务器硬盘上的绝对路径

   ```java
   servletContext.getRealPath("/");
   ```

4. 可以像Map集合一样存储数据

   ```java
   servletContext.setAttribute("user","zs");
   ```

   

### 三、url到servlet程序的访问

---

#### 1.URL：统一资源定位	包含了三部分：协议	服务器IP	端口号	资源

```http
http://localhost:8080/maven_servlet/servlet1
```

http	表示HTTP协议

localhost	表示服务器IP（真实IP在实际中使用域名显示）

8080	表示服务器端口号

maven_servlet	表示工程路径

servlet1	表示工程中资源的路径

#### 2.访问流程

```markdown
- 根据服务器IP和端口号找到需要访问的tomcat服务器
- 根据工程路径找到部署在服务器上的项目
- 根据工程中资源的路径寻找当前项目上哪个servlet配置了@WebServlet("servlet1")注解的类并进行匹配
- 在匹配到的类里，tomcat会为其创建一个对象，并调用service()方法
```

service()中的两个参数

```markdown
- ServletRequest	封装请求时的数据
- ServletResponse	封装响应时的数据--后期方便实现前后端交互
```



### 四、生命周期

---

指的是一个组件从创建到销毁的过程

Servlet运行在web容器 (Tomcat服务器 ）中，它的生命周期由服务器来进行管理

#### 1.servlet的加载和创建对象

默认情况下，当我们第一次访问servlet时，服务器会创建servlet对象，如果此时创建时间较长的话，会造成访问该Servlet的用户体验度比较差，由此我们会在服务器启动时就把 servlet准备就绪

我们可以改变servlet启动的时机，通过loadOnStartup来设置：

```java
@WebServlet(urlPatterns = "/servlet2", loadOnStartup = 1)
```

- 负整数：当第一次启动servlet时才创建Servlet对象

- 整数或0：服务器启动时就创建servlet对象

- @WebServlet注解的相关参数

  ![image-20230219091006132](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230219114000057-1933163917.png)

#### 2.生命周期流程

```markdown
- 执行servlet的构造方法--—|
-					   --在第一次访问的时候创建servlet程序并初始化时会调用
- 执行init()方法--初始化--|
- 执行service()方法--服务--每次访问都会调用
- 执行destroy()方法--销毁--当web工程停止时调用
```



### 五、GET/POST的分发

---

service()用于处理请求和响应

但是请求的方式有多种，常用的有get和post，需要对get和post请求的不同，使用不同方式获取请求参数，需要对service()进行请求分发

```java
/**
 * servlet中执行功能的方法
 *
 * @param servletRequest
 * @param servletResponse
 * @throws ServletException
 * @throws IOException
 */
@Override
public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
    //根据请求的不同，获取请求参数会有不同
    HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
    //获取当前请求的请求方式
    String method = httpServletRequest.getMethod();
    if ("GET".equals(method)) {
        doGet(servletRequest, servletResponse);
    } else if ("POST".equals(method)) {
        doPost(servletRequest, servletResponse);
    }
}
```

最终我们要得到的结果就是get请求执行doGET()方法post请求执行doPost()方法，其实在 ServletAPl中已经为我们提供了实现分发的类HttpServlet，我们只需要继承自HttpServlet，重写doGet()和doPost()方法即可

补充 ： 

除了表单的method=post 提交是执行doPost()方法以外，其他清求（ 直接访问、跳转等 ）基本都是执行doGet()方法
方法



### 六、访问路径与配置

---

sevlet程序写好后我们可以通过urlPatterns配置的路径访问对应的servlet

#### 1.访问路径

如果有多个请求都需要经过一个servlet处理，我们可以在@WebServlet注解里配置多个路径

1. 普通路径匹配：

   ```java
   @WebServlet(urlPatterns = {"/TestServlet","TestServlet1"})
   ```

2. 精确路径匹配（多级路径）：

   ```java
   @WebServlet(urlPatterns = "/TestServlet/select")
   ```

3. 路径目录匹配：

   ```java
   @WebServlet(urlPatterns = "/TestServlet/*")
   ```

4. 扩展名路径匹配（匹配后面的扩展名）

   ```java
   @WebServlet(urlPatterns = "*.do")
   ```

5. 任意路径匹配：<font color='red'>尽量避免</font>

   ```java
   @WebServlet(urlPatterns = "/*")或@WebServlet(urlPatterns = "/")
   ```

   注意：配置/会覆盖原来tomcat中DefaultServlet里专门用来处理静态资源的规则，如果配置/*或/还是会覆盖tomcat中的DefaultServlet规则，导致运行的是当前匹配的Servlet，此时静态资源就不会被处理，再次访问资源就会出现问题

#### 2.Xml配置servlet

```xml
<web-app>
    <display-name>Archetype Created Web Application</display-name>
    <!--    配置上下文参数-->
    <context-param>
        <param-name>users</param-name>
        <param-value>root</param-value>
    </context-param>
    <!--    给tomcat配置一个servlet-->
    <servlet>
        <!--        为servlet程序取一个别名-->
        <servlet-name>XmlServlet</servlet-name>
        <!--        servlet程序所在的包和类名-->
        <servlet-class>com.controller.XmlServlet</servlet-class>
        <!--        servlet的初始化参数-->
        <init-param>
            <!--            参数名-->
            <param-name>user</param-name>
            <!--            参数值-->
            <param-value>root</param-value>
        </init-param>
    </servlet>
    <!--    配置servlet访问的地址-->
    <servlet-mapping>
        <!--        告诉服务器当前配置的使用对象-->
        <servlet-name>XmlServlet</servlet-name>
        <!--        配置访问servlet的路径-->
        <url-pattern>xml</url-pattern>
    </servlet-mapping>
</web-app>
```



### 七、HttpServletRequest接口

---

#### 1.HttpServletRequest的作用

每次只要有请求进入到tomcat服务器，tomcat服务器就会把请求过来的http协议信息封装在 Request对象中，然后传递到service()方法 （判断执行doGet或doPost)，此时就可以在doGet或doPost中通过HttpServletRequest获取所有的请求信息

#### 2.HttpServletRequest和ServletRequest的关系

HttpServletRequest子接口继承于ServletRequest

#### 3.Request对象是由tomcat创建的一个具体对象

```
Request对象的继承关系：
	ServletRequest -> HttpServletRequest -> RequestFacade
```

#### 4.获取Request对象请求的数据

1. 获取请求行
2. 获取请求头
3. 获取请求体







# 未完待续。。。

