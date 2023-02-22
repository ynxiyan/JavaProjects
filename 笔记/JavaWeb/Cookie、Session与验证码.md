# [Cookie、Session与验证码](https://www.cnblogs.com/ynxiyan/p/17144089.html)

### Cookie

#### 一、什么是Cookie

---

 cookie翻译过来就是饼干的意思，是服务器通知客户端（浏览器）保存数据的一种技术；客户端有了cookie以后，每次请求都会带着cookie发送给服务器

注意：每个cookie不能超过4kb



#### 二、如何创建、修改和获取Cookie

---

创建：

1. 使用Cookie对象的构造方法

   ```java
   Cookie userCookie = new Cookie("username","zs");
   ```

2. 发送Cookie到客户端（response）

   ```java
   response.addCookie(userCookie);
   ```

修改：

1. 创建同名的Cookie对象，直接重新赋值

   ```java
   Cookie newCookie = new Cookie("username","ls");
   response.addCookie(newCookie);
   ```

获取：

只要浏览器存在cookie所有的请求都会携带，获取时得到的cookie是一个数组

```java
//获取cookie(数组)
Cookie[] cookies = request.getCookies();
//遍历cookie
for (Cookie cookie : cookies) {
    //判断cookie的key
    if("username".equals(cookie.getName())){
        String value = cookie.getValue();
        break;
    }
}
```



#### 三、Cookie的其他细节

---

##### 1.Cookie的存活时间

默认的情况下，cookie是保存一次会话的时间（浏览器和服务器连接），当你关闭浏览器后cookie 就消失了；为此我们可以通过手动设置cookie存活时间使其存活更长时间

```java
//存活7天
cookie.setMaxAge(7 * 24 * 60 * 60);
```

##### 2.Cookie存储中文

新版浏览器正常情况下cookie可以存储中文，如果出现乱码需要设置url的编码和解码

```java
String username = "张三";
//设置url编码和解码处理
URLEncoder.encode("utf-8");
//设置cooike
Cookie cookie = new Cookie("username", username);
//设置存活时间
cookie.setMaxAge(7 * 24 * 60 * 60);
//通知客户端保存cooike
response.addCookie(cookie);
--------------------------------------------------
//获取cookie(数组)
Cookie[] cookies = request.getCookies();
//遍历cookie
for (Cookie cookie : cookies) {
    //判断cookie的key
    if("username".equals(cookie.getName())){
        String value = cookie.getValue();
        //设置url解码
        URLEncoder.encode(value,"utf-8");
        break;
    }
}
```

##### 3.Cookie的有效路径

可以有效的过滤哪些cookie需要发送给服务器

如：将cooike发送到当前项目下的get路径

```java
cookie.setPath(request.getContextPath()+"get");
```



### Session

#### 1.什么是Session会话

---

Session就是一个接口(HttpSession) 他是用来维护一个客户端和服务器之前关联的一种技术，每个客户端都有自己的一个session会话，在session对话中我们经常用来保存用户登录以后的信息



#### 2.如何创建、获取Session

---

创建：

```java
//创建Session
HttpSession session = request.getSession();
//存储Session
session.setAttribute("username","zs");
```

获取：

1. 通过页面获取

   ```jsp
   <%--        Session名称--%>
   ${{username}
   ```

2. 通过Servlet获取

   ```java
   Object username = request.getSession().getAttribute("username");
   ```



#### 3.Session的生命周期

---

1. 设置session的超时时间（以秒位单位，超时自动销毁）

   默认为30分钟；值可以为负数表示永不超时

   ```java
   session.setMaxInactiveInterval();
   ```

2. web.xml里配置

   ```xml
   <web-app>
     ...
     <session-config>
       <session-timeout>30</session-timeout>
     </session-config>
   </web-app>
   ```

3. 销毁session

   ```java
   session.invalidate();
   ```

   

### Cookie与Session的区别

---

注意：Session本质上也是Cookie，只要浏览器不关闭就能共享数据

| Cookie       | Session      |
| ------------ | ------------ |
| 存储在浏览器 | 存储在服务器 |
| 不安全       | 相对安全     |



### 图形验证码

---

使用前提：已导入Google图形验证码maven依赖

#### 1.配置类

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/22 14:13
 * @注释:图形验证码的配置
 */
public class GetCodeCongfig {
    public static DefaultKaptcha getDefaultKaptcha() {
        //验证码生成器
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //配置
        Properties properties = new Properties();
        //是否有边框
        properties.setProperty("kaptcha.border", "yes");
        //设置边框颜色
        properties.setProperty("kaptcha.border.color", "105,179,90");
        //边框粗细度，默认为1
        // properties.setProperty("kaptcha.border.thickness","1");
        //验证码
        properties.setProperty("kaptcha.session.key", "code");
        //验证码文本字符颜色 默认为黑色
        properties.setProperty("kaptcha.textproducer.font.color", "blue");
        //设置字体样式
        properties.setProperty("kaptcha.textproducer.font.names", "宋体,楷体,微软雅黑");
        //字体大小，默认40
        properties.setProperty("kaptcha.textproducer.font.size", "30");
        //验证码文本字符内容范围 默认为abced2345678gfynmnpwx
        // properties.setProperty("kaptcha.textproducer.char.string", "");
        //字符长度，默认为5
        properties.setProperty("kaptcha.textproducer.char.length", "4");
        //字符间距 默认为2
        properties.setProperty("kaptcha.textproducer.char.space", "4");
        //验证码图片宽度 默认为200
        properties.setProperty("kaptcha.image.width", "100");
        //验证码图片高度 默认为40
        properties.setProperty("kaptcha.image.height", "40");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
```

#### 2.servlet

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/22 14:24
 * @注释:生成图形验证码
 */
@WebServlet(urlPatterns = "/getCode")
public class GetCodeServlet extends HttpServlet {
    //得到配置类中设置参数返回的图形验证码对象
    private DefaultKaptcha defaultKaptcha= GetCodeCongfig.getDefaultKaptcha();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 定义response输出类型为image/jpeg类型
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        //-------------------生成验证码 begin --------------------------
        //获取验证码文本内容
        String text = defaultKaptcha.createText();
        //System.out.println("验证码内容:"+text);
        //将验证码内容放入session中
        request.getSession().setAttribute("captcha",text);
        //根据文本验证码内容创建图形验证码，
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream = null;

        try {
            outputStream =  response.getOutputStream();
            //输出流输出图片，格式为jpg
            ImageIO.write(image,"jpg",outputStream);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
```

#### 3.验证

```java
//获取服务器验证码
String captcha = (String) request.getSession().getAttribute("captcha");
//获取用户验证码
String code = request.getParameter("code");
//判断验证码是否一致（忽略大小写）
if(code.equalsIgnoreCase(captcha)){
    ...
}
```

配置信息来源于：[谷歌验证码实现_haoStar_T1的博客-CSDN博客_谷歌验证码实现](https://blog.csdn.net/weixin_41925461/article/details/120077911)



### CodeUtils

---

1. 导入CodeUtils.java

2. 创建GetCodeServlet

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/2/22 17:18
    * @注释:获取验证码
    */
   @WebServlet(urlPatterns = "/getcode")
   public class GetCodeServlet extends HttpServlet {
       @Override
       protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           doPost(request, response);
       }
   
       @Override
       protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           ServletOutputStream outputStream = response.getOutputStream();
           //生成验证码
           String code = CodeUtils.outputVerifyImage(150, 50, outputStream, 4);
           request.getSession().setAttribute("code", code);
       }
   }
   ```

3. 验证

   ```java
   //获取用户验证码
   String checkCode = request.getParameter("checkCode");
   //获取服务器验证码
   String code = (String) request.getSession().getAttribute("code");
   //判断验证码是否一致（忽略大小写）
   if (code.equalsIgnoreCase(checkCode)) {
       ...
   }
   ```

   
