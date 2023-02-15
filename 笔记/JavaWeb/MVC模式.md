# [MVC模式](https://www.cnblogs.com/ynxiyan/p/17120539.html)

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



### 二、使用MVC模式开发

#### 1.分包管理

**Controller层**

servlet就是controller----第四层

```
xxx.xxx.controller/servlet
```

**Model层**

- 数据对象----第一层

``` 
xxx.xxx.bean/pojo/entity/domain		//存储数据类的包
```

**Dao层**：专门设计和实现对数据库的操作的包

1. 数据层和持久层----第二层

   ```
   xxx.xxx.dao(接口)与xxx.xxx.dao.Impl(实现)
   ```

2. 逻辑处理层将Dao层换上一种操作方式----第三层

   ```
   xxx.xxx.service(接口)与xxx.xxx.service.Impl(实现)
   ```

**View层**：动态项目中的web目录下





# 未完待续。。。

