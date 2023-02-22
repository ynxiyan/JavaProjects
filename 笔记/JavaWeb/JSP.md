# [JSP](https://www.cnblogs.com/ynxiyan/p/17138173.html)

### 一、jsp是什么，它有什么作用

---

JSP（全称Java Server Pages）JSP 技术是以 Java 语言作为脚本语言的，Java的服务器页面

JSP开发的WEB应用可以跨平台使用，既可以运行在 Linux 上也能运行在 Windows 上

主要作用：代替servlet程序回传html页面数据

因为servlet程序向浏览器回传html页面数据是一件非常繁琐的事情，开发成本和维护成本都
极高 
Servlet 回传 html 数据的格式 ：

```java
public final class index_jsp extends HttpJspBase implements JspSourceDependent {
	...
  public void _jspService(final HttpServletRequest request, final HttpServletResponse response) throws IOException, ServletException {
	...
      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Hello World!</h2>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    ...
  }
}

```



### 二、jsp的访问

---

jsp页面和html页面一样，都是存放在web或webapp下，访问也一样，直接使用xx.jsp即可



### 三、jsp的本质

---

jsp页面本质是一个Servelet程序，当我们第一次去访问jsp页面的时候，tomcat服务器会帮我们
将jsp页面翻译为一个java的源文件，并且对它进行编译成.class文件

```java
public final class index_jsp extends HttpJspBase implements JspSourceDependent
```

HttpJspBase是tomcat源码中的部分，导入源码可以看到继承了HttpServlet，翻译出来就是Servlet



### 四、jsp的语法

---

#### 1.jsp头部的page命令

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
language属性：表示的是jsp翻译后是什么语言的文件，暂时只支持java
contentType属性：表示当前jsp返回给页面的时候是什么类型的文档，也就是源码中的response.setContentType("text/html;charset=utf-8");
pageEncoding属性：表示的是当前源码的字符集编码
import属性：用于导包和java源文件一样
errorPage属性：表示当前jsp页面运行出错时，自动跳转到的页面
--%>
```

##### 2.jsp常用的脚本

1. 声明脚本

   ```jsp
   <%!
       //    声明脚本
       private Integer id;
       private String name;
       private static Map<String, String> map;
   
       //    声明静态代码块
       static {
           map = new HashMap<String, String>();
           map.put("", "");
       }
   
       //    声明方法
       public void test() {
       }
   
       //    内部类
       public class test {
   
       }
   %>
   ```

   作用：可以给jsp翻译出来的java类定义属性和方法，甚至静态代码块、内部类等；写在声明脚本里的内容会被放在翻译后的.class文件中，作为类的成员

2. 表达式脚本

   ```jsp
   <%--输出整数--%>
   <%=12%>
   <%--输出浮点数--%>
   <%=12.1%>
   <%--输出字符--%>
   <%="String"%>
   <%--输出集合--%>
   <%=map%>
   <%--输出请求参数--%>
   <%=request.getParameter("username")%>
   ```

   作用：用于翻译输出内容（整数、字符、对象等）；写在表达式脚本的内容会被放在翻译后的.class文件里的_jspService()方法中并输出到页面上（out.write()）

   **表达式脚本不能以分号结束**

3. 代码脚本（写法与PHP一致）

   ```jsp
   <%
       List<Student> list = new ArrayList<Student>();
       list.add(new Student(1, "zs", 23, "男", 0));
       list.add(new Student(2, "ls", 21, "女", 1));
       list.add(new Student(3, "rg", 8, "女", 1));
       list.add(new Student(4, "zx", 12, "男", 0));
   %>
   <table border="1px">
       <tr>
           <th>序号</th>
           <th>姓名</th>
           <th>年龄</th>
           <th>性别</th>
           <th>状态</th>
           <th>操作</th>
       </tr>
       <%
           for (int i = 0; i < list.size(); i++) {
               Student student = list.get(i);
       %>
       <tr>
           <td><%=student.getId()%>
           </td>
           <td><%=student.getName()%>
           </td>
           <td><%=student.getAge()%>
           </td>
           <td><%=student.getSex()%>
           </td>
           <td><%=student.getState() == 1 ? "已报道" : "未报道"%>
           </td>
           <td><a href="#">更新</a><a href="#">删除</a>
           </td>
       </tr>
       <%
           }
       %>
   </table>
   ```

   作用：可以在jsp页面写我们需要的java功能代码，写在代码脚本里的内容会被放在编译后的.class文件里的_jspService()方法中；代码脚本可以有多个代码块组成一个完整的java语句
   代码脚本还可以和html、表单等一起使用用来输出数据；代码脚本可以直接使用 _jspService() 方法中的所有的对象



### 五、jsp的缺点

---

```markdown
- jsp书写麻烦，既要写html还要写java甚至js也要写在里面
- 阅读麻烦
- 不利于开发（如前端不懂java，后端不懂html时）
```



### 六、EL表达式

---

EL表达式是JSP表达式语言的简称，它可以让你在JSP中方便地访问JavaBean中的数据，或者创建算术和逻辑表达式

EL表达式的语法：${EL表达式}，其中EL表达式可以是数值、字符串、布尔值、null或者变量

```jsp
<%--list表示request对象里存储的数据（集合、字符、数组）--%>
${list}
```

EL表达式的作用：让JSP书写起来更加方便，简化在JSP中获取作用域或者请求数据的写法，以及进行各种运算

使用EL表达式有以下好处：

- 代码量小，并且不需要使用尖括号
- 支持从pageContext,request,session,application中取值，它会自动检查四个作用域，不需要特别指定
- 如果变量不存在，会输出空字符串""，而不是null,省去了手工判断的工作



### 七、JSTL标签

---

JSTL标签是JSP标准标签库的一部分，它提供了一些常用的功能，比如迭代，条件判断，格式化输出等，JSTL有四大标签库：core，fmt，sql和xml

JSTL语法：如<c:out value="${name}" />

```jsp
<%--判断a是否等于1，等于则输出<h4>a=1</h4>到jsp页面--%>
<c:if test="${a == 1}"><h4>a=1</h4></c:if>
```

JSTL标签的作用：封装了JSP应用的通用核心功能，比如迭代，条件判断，xml文档操作，国际化标签，sql标签等；JSTL标签可以让Web程序员不需要在页面上嵌入Java程序，提高了程序的阅读性，维护性和方便性（代替代码脚本）



### 八、EL表达式、JSTL标签的用前提示

---

maven项目创建后web.xml的版本为2.3版本，该版本不支持EL表达式和JSTL标签需要在头部的page命令里添加isELIgnored属性

```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
----------------------------
<%--在使用jstl标签前需要导入标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

JSTL标签简写：

![image-20230221141750541](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230221150229310-1880827777.png)

例子：(优化代码脚本里的学生列表)

```jsp
<table border="1px">
    <tr>
        <th>序号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%--itens表示获取的数据集合、数组  var表示遍历时里面的每个对象并存储为变量--%>
    <c:forEach items="${list}" var="student">
        <tr>
            <td>${student.id}
            </td>
            <td>${student.name}
            </td>
            <td>${student.age}
            </td>
            <td>${student.sex}
            </td>
            <td>${student.state == 1?"已报道":"未报道"}
            </td>
            <td><a href="#">更新</a><a href="#">删除</a>
            </td>
        </tr>
    </c:forEach>
</table>
```



