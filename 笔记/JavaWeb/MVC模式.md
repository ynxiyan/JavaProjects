### 一、什么是MVC

MVC是一种软件架构的思想 ，将软件按照	模型	视图	控制器	来划分 。

```markdown
# M:Model, 模型层，指的是工程里的JavaBean，作用就是用来处理数据 。
    JavaBean 分为两类 :
    - 实体类Bean：专门存储数据的，如：Student	User	Brand等
    - 业务处理Bean：指Service或Dao，专门用来处理业务逻辑和数据访问的
# V:View，视图层指的是工程当中用于显示信息的内容，HTML或JSP，作用是与用户交互，展示数据
# C:Controller, 控制层，指的是工程中的Servlet，作用是接收请求和响应浏览器
```

