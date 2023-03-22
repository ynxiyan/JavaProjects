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

   ```java
   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   //实体类映射的表
   @TableName("user")
   public class User {
       ...
       //不查询的字段
       @TableField(select = false)
       private String password;
       private Integer age;
       private String tel;
       //不存在的字段
       @TableField(exist = false)
       private Integer online;
   ...
   }
   ```

2. 表名映射

   ![image-20230321162619081](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321165317375-2031343849.png)
   
   ```java
   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   //实体类映射的表
   @TableName("user")
   public class User {
   ...
   }
   ```

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

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
//实体类映射的表
@TableName("user")
public class User {
    //使用数据库自增策略
    @TableId(type = IdType.AUTO)
    private Long id;
...
}
```

type属性可选值：

- NONE：不设置id生成策略
- AUTO：使用数据库ID自增，在使用该策略的时候一定要确保对应的 数据库表设置了ID主键自增，否则无效
- INPUT：用户手工输入id，在使用该策略的时候需要将表的自增策略删除掉
- ASSIGN_ID：雪花算法生成id(可兼容数值型与字符串型)，在使用该策略的时候不需要手动设置ID，如果手动设置ID，则会使用自己设置的值
- ASSIGN_UUID：以UUID生成算法作为id生成策略，在使用该策略的时候需要注意的是，主键的类型不能是Long，而应该改成String类型（表字段的主键类型需要设置为varchar，长度要大于32，因为UUID生成的主键为32位，如果长度小的话就会导致插入失败）

**id生成策略全局配置：**

```yaml
mybatis-plus: 
  global-config: 
    db-config: 
      id-type: assign_id
```

**分布式ID是什么?**

- 当数据量足够大的时候，一台数据库服务器存储不下，这个时候就需要多台数据库服务器进行存储 比如订单表就有可能被存储在不同的服务器上
- 如果用数据库表的自增主键，因为在两台服务器上所以会出现冲突这个时候就需要一个全局唯一ID,这个ID就是分布式ID。

**雪花算法：**

雪花算法(SnowFlake)，是Twitter官方给出的算法实现是用Scala写的；其生成的结果是一个64bit大小的整数，它的结构如下图：

![image-20230322095738527](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322110344954-1256809403.png)

- 1bit,不用,因为二进制中最高位是符号位，1表示负数，0表示正数

  生成的id一般都是用整数， 所以最高位固定为0

- 41bit-时间戳，用来记录时间戳，毫秒级 3. 10bit-工作机器id，用来记录工作机器id,其中高位5bit是数据中心ID其取值范围0-31，低位 5bit是工作节点ID其取值范围0-31，两个组合起来最多可以容纳1024个节点

- 序列号占用12bit，每个节点每毫秒0开始不断累加，最多可以累加到4095，一共可以产生4096 个ID

Id生成策略对比：

| 策略名称    | 具体描述                                                     |
| ----------- | ------------------------------------------------------------ |
| NONE        | 不设置id生成策略，MP不自动生成，约等于INPUT,所以这两种方式都需要用户手动设 置，但是手动设置第一个问题是容易出现相同的ID造成主键冲突，为了保证主键不冲突就需要做很 多判定，实现起来比较复杂 |
| AUTO        | 数据库ID自增,这种策略适合在数据库服务器只有1台的情况下使用,不可作为分布式ID使用 |
| ASSIGN_UUID | 可以在分布式的情况下使用，而且能够保证唯一，但是生成的主键是32位的字符 串，长度过长占用空间而且还不能排序，查询性能也慢 |
| ASSIGN_ID   | 可以在分布式的情况下使用，生成的是Long类型的数字，可以排序性能也高，但是 生成的策略和服务器时间有关，如果修改了系统时间就有可能导致出现重复主键 |

#### 2. 多记录操作

实际业务中数据删除带来的问题：统计报表

![image-20230322102143715](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322110344432-763276593.png)

#### 3. 逻辑删除

1. 修改数据库表添加deleted列

   ![image-20230322104806984](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322110344018-882261336.png)

2. 实体类添加属性

   ```java
   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   //实体类映射的表
   @TableName("user")
   public class User {
       //使用数据库自增策略
       @TableId(type = IdType.AUTO)
       private Long id;
       private String name;
       //不查询的字段
       @TableField(select = false)
       private String password;
       private Integer age;
       private String tel;
       //不存在的字段
       @TableField(exist = false)
       private Integer online;
       @TableLogic(value = "0", delval = "1")
       private Integer deleted;
   }
   ```

   ![image-20230322104551273](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322110343552-1948967517.png)

   **注：**逻辑删除的本质其实是修改操作；如果加了逻辑删除字段，查询数据时也会自动带上逻辑删除字段

**逻辑删除全局配置：**

```yaml
mybatis-plus: 
  global-config: 
    db-config: 
      # 逻辑删除字段名 
      logic-delete-field: deleted 
      # 逻辑删除字面值：未删除为0 
      logic-not-delete-value: 0 
      # 逻辑删除字面值：删除为1 
      logic-delete-value: 1
```

#### 4. 乐观锁

实现业务并发现象带来的问题：秒杀

1. 数据库表添加version列

   ![image-20230322113245285](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322114535545-1955865488.png)

2. 在实体类中添加属性

   ```java
   @Data
   @NoArgsConstructor
   @AllArgsConstructor
   //实体类映射的表
   @TableName("user")
   public class User {
   ...
       @Version
       private Integer version;
   }
   ```

3. 添加乐观锁的拦截器

   ```java
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
   ...
           //添加乐观锁拦截器
           mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
           return mybatisPlusInterceptor;
       }
   }
   ```

4. 测试

   ```java
   @Test 
   void testUpdate(){ 
       //1.先通过要修改的数据id将当前数据查询出来 
       User user = userDao.selectById(3L); 	//version=3
       User user2 = userDao.selectById(3L);	//version=3
       user2.setName("Jock aaa"); userDao.updateById(user2);	//verion=3条件成立，执行成功=>version=4
       user.setName("Jock bbb"); userDao.updateById(user);		//verion=3条件不成立，执行失败
   }
   ```

   ![image-20230322113655968](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230322114534750-1951824045.png)

具体实现可参看官方文档：

```http
https://baomidou.com/pages/0d93c0/#optimisticlockerinnerinterceptor
```



### 四、快速开发（代码生成器）

---

代码生成器包含以下内容：

- 模板: MyBatisPlus提供，可以自己提供，但是麻烦，不建议
- 数据库相关配置:读取数据库获取表和字段信息
- 开发者自定义配置:手工配置，比如ID生成策略

使用步骤：

1. 在创建SpringBoot项目时勾选需要的技术集

   ![image-20230321102056130](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230321113007290-1348502694.png)

2. 导入相应坐标

   ```xml
   <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-boot-starter</artifactId>
       <version>3.4.1</version>
   </dependency>
   <!--        MyBatisPlus代码生成器-->
   <dependency>
       <groupId>com.baomidou</groupId>
       <artifactId>mybatis-plus-generator</artifactId>
       <version>3.4.1</version>
   </dependency>
   <!--        velocity模板引擎-->
   <dependency>
       <groupId>org.apache.velocity</groupId>
       <artifactId>velocity-engine-core</artifactId>
       <version>2.3</version>
   </dependency>
   <dependency>
       <groupId>com.alibaba</groupId>
       <artifactId>druid</artifactId>
       <version>1.1.10</version>
   </dependency>
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
   </dependency>
   <dependency>
       <groupId>com.springmvc_restful</groupId>
       <artifactId>springmvc_restful</artifactId>
       <version>1.0-SNAPSHOT</version>
   </dependency>
   ```

3. 配置代码生成器

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/22 14:50
    * @注释:MyBatisPlus代码生成器
    */
   public class CodeGenerator {
       public static void main(String[] args) {
           //1.创建代码生成器对象AutoGenerator
           AutoGenerator autoGenerator = new AutoGenerator();
   
           //================================================
   
           //2.设置数据库相关配置
           //创建yamlBean实例工厂对象
           YamlPropertiesFactoryBean ymlBean = new YamlPropertiesFactoryBean();
           //读取配置文件类路径
           ymlBean.setResources(new ClassPathResource("application.yml"));
           //读取配置文件
           Properties properties = ymlBean.getObject();
           //创建数据库连接源对象
           DataSourceConfig dataSourceConfig = new DataSourceConfig();
           //设置MySQL驱动
           dataSourceConfig.setDriverName(properties.getProperty("spring.datasource.driver-class-name"));
           //设置数据库链接
           dataSourceConfig.setUrl(properties.getProperty("spring.datasource.url"));
           //设置用户名
           dataSourceConfig.setUsername(properties.getProperty("spring.datasource.username"));
           //设置密码
           dataSourceConfig.setPassword(properties.getProperty("spring.datasource.password"));
           autoGenerator.setDataSource(dataSourceConfig);
   
           //================================================
   
           //3.设置全局配置
           //创建全局配置对象
           GlobalConfig globalConfig = new GlobalConfig();
           //设置代码生成位置
           globalConfig.setOutputDir(System.getProperty("user.dir") + "\\springboot_generator\\src\\main\\java");
           //设置生成完毕后是否打开生成代码所在的目录
           globalConfig.setOpen(false);
           //设置作者
           globalConfig.setAuthor("XIYAN");
           //设置是否覆盖原始生成的文件
           globalConfig.setFileOverride(true);
           //设置数据层接口名，%s为占位符，指代模块名称
           globalConfig.setMapperName("%sDao");
           //设置Id生成策略
           globalConfig.setIdType(IdType.AUTO);
           autoGenerator.setGlobalConfig(globalConfig);
   
           //================================================
   
           //4.设置包名相关配置
           //创建包名配置对象
           PackageConfig packageConfig = new PackageConfig();
           //设置生成的包名，与代码所在位置不冲突，二者叠加组成完整路径
           packageConfig.setParent("com.springboot_generator");
           //设置实体类包名
           packageConfig.setEntity("model");
           //设置数据层包名
           packageConfig.setMapper("dao");
           autoGenerator.setPackageInfo(packageConfig);
   
           //================================================
   
           //5.设置策略相关配置
           //创建策略配置对象
           StrategyConfig strategyConfig = new StrategyConfig();
           //设置当前参与生成的表名，参数为可变参数，不写默认为当前数据库连接对象的所以表
           //strategyConfig.setInclude("tbl_user");
           //设置数据库表的前缀名称，模块名 =数据库表名 - 前缀名 例如： User = tbl_user - tbl_
           //strategyConfig.setTablePrefix("tbl_");
           //设置是否启用Rest风格
           strategyConfig.setRestControllerStyle(true);
           //设置乐观锁字段名
           strategyConfig.setVersionFieldName("version");
           //设置逻辑删除字段名
           strategyConfig.setLogicDeleteFieldName("deleted");
           //设置是否启用lombok
           strategyConfig.setEntityLombokModel(true);
           autoGenerator.setStrategy(strategyConfig);
   
           //================================================
   
           //6.执行代码生成器
           autoGenerator.execute();
       }
   }
   ```

**注意：**代码生成器生成的Mapper.xml中对于MyBatis的环境是没有进行配置的，如果想要运行， 需要将配置文件中的内容进行完善后在运行，即配置MyBatis：[MyBatis](https://www.cnblogs.com/ynxiyan/p/17201088.html)



**附：**对于Service层里MyBatisPlus封装的方法有哪些方法可用，可参看官方文档：

```http
https://baomidou.com/pages/49cc81/#service-crud-%E6%8E%A5%E5%8F%A3
```





所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)

