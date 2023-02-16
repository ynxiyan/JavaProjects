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



### 三、url到servlet程序的访问

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

- 复整数：当第一次启动servlet时才创建Servlet对象
- 整数或0：服务器启动时就创建servlet对象

#### 2.生命周期流程

```markdown
- 执行servlet的构造方法--—|
-					   --在第一次访问的时候创建servlet程序并初始化时会调用
- 执行init()方法--初始化--|
- 执行service()方法--服务--每次访问都会调用
- 执行destroy()方法--销毁--当web工程停止时调用
```





# 未完待续。。。

