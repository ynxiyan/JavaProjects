# [Filter过滤器与监听器](https://www.cnblogs.com/ynxiyan/p/17147527.html)

### Filter过滤器

#### 一、什么是过滤器

---

Filter过滤器是JavaWeb中三大组件之一（三大组件：Servlet程序、Filter过滤器、Listener监听器）
Filter是javaEE的规范，也就是接口



#### 二、过滤器的作用

---

拦截请求，过滤响应： 

解释：过滤器可以把请求的资源拦截下来，在拦截过程中加上一些代码、功能实现一些特殊的功能

说明：过滤器在访问每一个资源的时候都会被执行，我们可以在过滤器中加上一些拦截性的操作

过滤器拦截请求常见的应用场景：

```markdown
- 权限检查
- 日志操作
- 事务处理
- 统一编码处理
- 敏感数据拦截
```



#### 三、Filter过滤器的使用

---

##### 1.Filter的访问

1. xml配置

   ```xml
   <web-app>
       ...
       <filter>
           <!--    为filter起别名-->
           <filter-name>FilterTest</filter-name>
           <!--    具体过滤器的全类名-->
           <filter-class>com.filter.FilterTest</filter-class>
       </filter>
       <filter-mapping>
           <!--    访问某个路径时调用哪个filter-->
           <filter-name>FilterTest</filter-name>
           <!--    什么路径可以访问到filter-->
           <url-pattern>/*</url-pattern>
       </filter-mapping>
   </web-app>
   ```

2. 注解

   ```java
   //什么路径可以访问该filter
   @WebFilter("/*")
   ```

##### 2.Filter的使用步骤

1. 新建类实现Filter接口
2. 根据需要重写Filter接口的方法（必须重写doFilter，也就是过滤器功能的方法）
3. 在doFilter方法中定义相关的逻辑（记得判断并放行）

```java
//执行方法
@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    //放行
    chain.doFilter(request, response);
}
```

##### 3. 生命周期

```markdown
- 构造方法			     -|
						   基本一起，在web工程启动后创建对象，然后初始化
- init()------初始化	  -|
- doFilter()--执行		  每次只要有请求都会拦截并执行
- destory()---销毁		  停止web工程时自动销毁
```

##### 4.Filter的拦截路径

拦截路径表示filter对哪些请求进行拦截（访问所有资源，都会被拦截）

1. 拦截jsp

   ```java
   @WebFilter("*.jsp")
   ```

2. 拦截某一个目录下

   ```java
   @WebFilter("/a/*")
   ```

3. 拦截某一个路径

   ```java
   @WebFilter("/index.jsp")
   ```

4. 放行资源、路径与设置编码

   ```java
   //将ServletRequest转换成HttpServletRequest子对象
   HttpServletRequest httpServletRequest = (HttpServletRequest) request;
   //设置网页请求编码
   httpServletRequest.setCharacterEncoding("utf-8");
   //设置服务器响应编码
   response.setContentType("text/html;charset=utf-8");
   //放行资源\路径
   String[] paths = {"/imgs/", "/css/", "/js/", "/login.jsp", "/loginServlet", "/register.jsp", "/enrollServlet"};
   //获取当前路径
   String url = httpServletRequest.getRequestURL().toString();
   //比对路径
   for (String str : paths) {
       //判断路径中是否存在放行的资源\路径
       if (url.contains(str)) {
           //放行
           chain.doFilter(request, response);
           return;
       }
   }
   ```

   

#### 四、过滤器链

---

Filter过滤器链是指在 Web 应用中，部署了多个 Filter 来拦截同一目标资源的情况；Filter 链中的 Filter 的执行顺序由 \<filter-mapping> 标签的配置顺序决定（A-Z）

Filter 链中的任何一个 Filter 没有调用 FilterChain.doFilter() 方法，请求都不会到达目标资源



#### 五、FilterConfig

---

FilterConfig就是filter过滤器的配置文件类，tomcat每次在创建filter的时候就会同时创建一个FilterConfig类

包含的配置信息：

```java
//获取过滤器的FilterName
System.out.println(config.getFilterName());
//获取初始化参数中的参数
System.out.println(config.getInitParameter(""));
//application
ServletContext servletContext = config.getServletContext();
```



### Listener监听器

---

监听器是监听域对象（application session request）创建、销毁或者添加、修改、删除属性发生改变时自动执行的一些代码的操作

说明：request和session指的就是我们学习过的请求对象、会话对象、application指的是ServletContext对象

ServletContext代表的是当前的整个web项目，在服务启动时tomcat也会自动创建该对象，关
闭服务器就自动销毁

监听器的分类：

![image-20230223143027169](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230223144751484-1369130448.png)