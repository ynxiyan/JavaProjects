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

##### 1-6. 分页查询



##### 1-7. 按条件查询



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

#### 3. 分页功能

