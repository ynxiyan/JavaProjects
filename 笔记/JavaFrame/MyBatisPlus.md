# [MyBatisPlus](https://www.cnblogs.com/ynxiyan/p/17239386.html)

### 一、MyBatisPlus入门

---

1. 在创建SpringBoot项目时勾选需要的技术集

   ![image-20230321102056130](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321113007290-1348502694.png)

2. 导入相应坐标

   ```xml
   <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-boot-starter</artifactId>
       <version>3.4.1</version>
   </dependency>
   <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>druid</artifactId>
       <version>1.1.10</version>
   </dependency>
   ```

   注：由于MyBatisPlus并未被收录到idea的系统内置配置，无法直接选择加入，需要手动在pom.xml中配置添加

3. 配置数据源

   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       type: com.alibaba.druid.pool.DruidDataSource
       url: jdbc:mysql://localhost:3306/mybatisplus_db?serverTimezone=UTC
       username: root
       password: 123456
   ```

4. 使用@Mapper注解，标注mapper接口并继承BaseMapper<>

   ```java
   @Mapper
   public interface UserDao extends BaseMapper<User> {
   }
   ```

5. 测试

   ```java
   @Autowired
   private UserDao userDao;
   
   @Test
   void selectAll() {
       System.out.println(userDao.selectList(null));
   }
   ```



### 二、MyBatisPlus的简介

---

[MyBatis-Plus ](https://github.com/baomidou/mybatis-plus)（简称 MP）是一个 [MyBatis](https://www.mybatis.org/mybatis-3/)的增强工具，在 MyBatis 的基础上只做增强不做改变，为简化开发、提高效率而生

![image-20230321102952070](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321113006723-750234432.png)

图片来源于：[简介 | MyBatis-Plus (baomidou.com)](https://baomidou.com/pages/24112f/#特性)



### 三、标准数据层开发

---

#### 1. 标准数据层CRUD功能

![image-20230321103445562](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321113005896-1020275003.png)

```java
@Mapper
public interface UserDao extends BaseMapper<User> {
}
------------------------
@Autowired
private UserDao userDao;
```

##### 1-1. 新增

```java
@Test
void testInsert() {
    User user = new User(null, "test", "1234", 12, "1564456776");
    System.out.println(userDao.insert(user));
}
```

##### 1-2. 删除

```java
@Test
void testDeleteById() {
    User user = new User();
    System.out.println(userDao.deleteById(1638010091989630977l));
}
```

##### 1-3. 修改

```java
@Test
void testUpadteById() {
    User user = new User();
    user.setId(1638011119938093058l);
    user.setAge(33);
    System.out.println(userDao.updateById(user));
}
```

##### 1-4. 根据Id查询

```java
@Test
void testSelectById() {
    User user = new User();
    System.out.println(userDao.selectById(1638011119938093058l));
}
```

##### 1-5. 查询全部

```java
@Test
void testSelectAll() {
    System.out.println(userDao.selectList(null));
}
```

#### 2. LomBok

Lombok，是一个Java类库，提供了一组注解，简化POJO实体类开发

[Lombok - IntelliJ IDEs Plugin | Marketplace (jetbrains.com)](https://plugins.jetbrains.com/plugin/6317-lombok)

使用步骤：

1. 导入相应坐标

   ```xml
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
   </dependency>
   ```

   注：新版本IDEA已经内置了该插件，如果删除setter和getter方法程序有报红，则需要安装插件

2. 使用注解

   - @Setter:为模型类的属性提供setter方法
   - @Getter:为模型类的属性提供getter方法
   - @ToString:为模型类的属性提供toString方法
   - @EqualsAndHashCode:为模型类的属性提供equals和hashcode方法
   - <a>@Data</a>:是个组合注解，包含上面的注解的功能
   - @NoArgsConstructor:提供一个无参构造函数
   - @AllArgsConstructor:提供一个包含所有参数的构造函数

**说明：**Lombok只是简化模型类的编写，之前的方法也能继续使用，如：

```java
@Data 
@AllArgsConstructor 
@NoArgsConstructor 
public class User { 
    private Long id; 
    private String name; 
    private String password; 
    private Integer age; 
    private String tel;
    public User(String name, String password) { 
        this.name = name; 
        this.password = password;
    } 
}
```

#### 3. 分页插件

##### 3-1. Page

Page继承了 IPage 类，实现了 简单分页模型 如果你要实现自己的分页模型可以继承 Page类或者实现 IPage类

**Page的属性：**

![image-20230321145404138](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165318744-1406262292.png)

图片来源于：[分页插件 | MyBatis-Plus (baomidou.com)](https://baomidou.com/pages/97710a/#page)

##### 3-2. 分页插件的使用

1. 配置MyBatisPlus的分页拦截器

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/21 14:23
    * @注释:MyBatisPlus配置
    */
   @Configuration
   public class MyBaitsPlusConfig {
       /**
        * MyBatisPlus拦截器
        *
        * @return
        */
       @Bean
       public MybatisPlusInterceptor mybatisPlusInterceptor() {
           //创建拦截器对象
           MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
           //添加分页拦截器
           mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
           return mybatisPlusInterceptor;
       }
   }
   ```

2. 测试

   ```java
   @Test
   void testSelectAllPage() {
       IPage page = new Page(1,4);
       userDao.selectPage(page, null);
       System.out.println("当前页码为：" + page.getCurrent() + "，每页显示：" + page.getSize() + "条，共：" + page.getPages() + "页");
       System.out.println("总计：" + page.getTotal() + "条");
       page.getRecords().forEach(System.out::println);
   }
   ```

**附：**开启日志

```yaml
#  配置MyBatisPlus
mybatis-plus:
  configuration:
    #      输出日志到控制台
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
```

#### 4. DQL编程控制

##### 4-1. 条件查询方式

- 方式一：字符串

  ```java
  //字符串
  QueryWrapper queryWrapper = new QueryWrapper();
  //条件：年龄小于13
  queryWrapper.lt("age", 13);
  System.out.println(userDao.selectList(queryWrapper));
  ```

- 方式二：lambda

  ```java
  //lambda
  QueryWrapper<User> queryWrapper = new QueryWrapper();
  //条件：年龄小于13
  queryWrapper.lambda().lt(User::getAge,13);
  System.out.println(userDao.selectList(queryWrapper));
  ```

- 方式三：lambda(LambdaQueryWrapper)

  ```java
  //lambda(LambdaQueryWrapper)
  LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
  //条件：年龄小于13
  lambdaQueryWrapper.lt(User::getAge,13);
  System.out.println(userDao.selectList(lambdaQueryWrapper));
  ```

**注：**or()相当于sql语句的or关键字,默认为and

##### 4-2. 条件NULL值处理

在条件查询中如若出现某一条件为空可使用以下方法解决：

1. 创建Query实体类，继承于model实体

   ```java
   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   public class UserQuery extends User {
       private Integer qAge;
   }
   ```

2. 使用表达式判断当前条件是否为空

   ```java
   //模拟页面传递过来的查询数据 
   UserQuery uq = new UserQuery(); 
   uq.setAge(10); 
   uq.setQAge(30); 
   LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>(); lqw.lt(uq.getQAge() != null,User::getAge, uq.getQAge()); lqw.gt(uq.getAge() != null,User::getAge, uq.getAge()); 
   System.out.println(userDao.selectList(lqw));
   ```

##### 4-2. 查询投影

![image-20230321155659917](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165318296-1366948745.png)

##### 4-3. 查询条件设定

1. 等值匹配

   eq()： 相当于 =,对应的sql语句为：

   ```mysql
   SELECT id,name,password,age,tel FROM user WHERE (name = ? AND password = ?)
   ```

   - selectList：查询结果为多个或者单个

   - selectOne:查询结果为单个

2. 范围匹配（>、>=、<、<=、between）

   - gt():大于(>)
   - ge():大于等于(>=) 
   - lt():小于(<) 
   - lte():小于等于(<=)
   - between():between ? and ?

3. 模糊匹配（like）

   - like():前后加百分号,如 %J% 
   - likeLeft():前面加百分号,如 %J 
   - likeRight():后面加百分号,如 J%

4. 排序（order）

   - orderBy排序 
     - condition:条件，true则添加排序，false则不添加排序 
     - isAsc:是否为升序，true升序，false降序 
     - columns:排序字段，可以有多个 

   - orderByAsc/Desc(单个column):按照指定字段进行升序/降序 
   - orderByAsc/Desc(多个column):按照多个字段进行升序/降序 
   - orderByAsc/Desc 
     - condition:条件，true添加排序，false不添加排序 
     - 多个columns：按照多个字段进行排序

5. 具体条件请参考官方文档的条件构造器

   ```http
   https://baomidou.com/pages/10c804/#abstractwrapper
   ```

##### 4-4. 字段映射与表名映射

1. 字段映射

   ![image-20230321162600944](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165317825-1622747605.png)

2. 表名映射

   ![image-20230321162619081](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165317375-2031343849.png)

**表名映射（前缀）全局配置：**

```yaml
mybatis-plus: 
  global-config: 
    db-config: 
      table-prefix: tbl_
```



### 三、DML编程控制

---

#### 1. Id生成策略

![image-20230321163649037](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165316804-1506172698.png)

type属性可选值：

- NONE：不设置id生成策略
- AUTO：使用数据库ID自增，在使用该策略的时候一定要确保对应的 数据库表设置了ID主键自增，否则无效
- INPUT：用户手工输入id
- ASSIGN_ID：雪花算法生成id(可兼容数值型与字符串型)
- ASSIGN_UUID：以UUID生成算法作为id生成策略

**id生成策略全局配置：**

```yaml
mybatis-plus: 
  global-config: 
    db-config: 
      id-type: assign_id
```







所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)

