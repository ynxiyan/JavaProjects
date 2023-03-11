# [Spring](https://www.cnblogs.com/ynxiyan/p/17204045.html)

### 一、为什么学习Spring

---

**概述：**

从配置到安全性，从 Web 应用程序到大数据——无论您的应用程序的基础架构需求是什么，都有一个 Spring 项目可以帮助您构建它。从小处着手，只使用您需要的东西 - Spring 在设计上是模块化的

**特点：**

- 简化开发：降低企业开发的复杂性

  - IoC
  - AOP
    - 事务处理

- 框架整合：高效整合其他技术，提高企业级应用开发于运行效率

  - MyBatis

  - MyBatisPlus

    ...



### 二、Spring Framework系统架构

---

Spring Framework 是 Spring 生态圈中最基础的项目 ， 是其他项目的根基

![image-20230310105332318](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165737003-110355567.png)

- Core Container: 核心容器
- AOP: 面向切面编程
- Aspects: AOP 思想实现
- Data Access: 数据访问
- Data lntegration ： 数据集成
- Web: Web 开发
- Test ： 单元测试与集成测试



### 三、Spring的核心概念

---

**目标：充分解耦**

1. IoC（控制反转）

   使用对象时，由主动new产生对象转换为由外部提供对象，此过程中对象创建控制权由程序转移到外部，此思想称为控制反转

   Spring技术对IoC思想进行了实现

   - spring提供； 一个容器，称为IoC容器（Spring容器），用来充当IoC思想的“外部”
   - IoC容器负责对象的创建、初始化等一系列工作，被创建或被管理的对象在IoC容器中统称为Bean

2. DI（依赖注入）

   在容器中建立bean与bean之间的依赖关系的整个过程称为依赖注入

最终效果：

​			使用对象时不仅可以直接从IoC容器中获取，并且获取到的bean已经绑定了所有的依赖关系

#### 1. IoC入门

1. 导入spring坐标

   ```xml
   <!--        spring-->
   <dependency>
       <groupId>org.springframework</groupId>
       <artifactId>spring-context</artifactId>
       <version>5.2.10.RELEASE</version>
   </dependency>
   ```

2. 配置bean

   ```xml
   <?xml version="1.0" encoding="UTF-8"?>
   <beans xmlns="http://www.springframework.org/schema/beans"
          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">
       <!--    配置bean
       id属性表示给bean起别名
       class属性表示给bean定义类型-->
       <bean id="userDao" class="com.spring_ioc.dao.impl.UserDaoImpl"/>
       <bean id="userService" class="com.spring_ioc.service.impl.UserServiceImpl"/>
   </beans>
   ```

   注意：在定义bean时id属性不能重复

3. 创建IoC容器并获取bean

   ```java
   //创建IoC容器并获取配置信息
   ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
   //获取bean
   UserDao userDao = (UserDao) applicationContext.getBean("userDao");
   UserService userService = (UserService)applicationContext.getBean("userService");
   ```

#### 2. DI入门

1. 删除业务层中使用new的方式创建的dao对象

   ```java
   private UserDao userDao;
   ```

2. 提供对应的set方法

   ```java
   public void setUserDao(UserDao userDao) {
       this.userDao = userDao;
   }
   ```

3. 配置service与dao的关系

   ```xml
   <bean id="userService" class="com.spring_ioc.service.impl.UserServiceImpl">
       <!--        配置service与dao的关系
           name属性表示配置哪一个具体的属性
           ref属性表示参照哪一个bean-->
       <property name="userDao" ref="userDao"/>
   </bean>
   ```



### 四、核心容器

---

#### 1. bean（配置文件开发）

![image-20230311112915734](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170636506-875297257.png)

##### 1. bean的配置

1. 基础配置

   ![image-20230310145439688](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165736488-1372987661.png)

2. 别名配置

   ![image-20230310145905558](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165736010-1614830287.png)

   注意事项：

   获取bean无论是通过id还是name获取如果无法获取到将抛出异NoSuchBeanDefinitionException

   ```bash
   NoSuchBeanDefinitionException ：NO bean named 'bookServiceImp1 ' available
   ```

3. 作用范围配置

   ![image-20230310150319980](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165735588-2011555010.png)

   - 适合交给容器进行管理的bean
     - 表现层对象
     - 业务层对象
     - 数据层对象
     - 工具对象

   - 不适合交给容器进行管理的bean
     - 封装实体的域对象

##### 2. bean的实例化

1. 构造方法

   bean本质上就是对象，创建bean对象使用构造方法

   **注意：**如果无参构造方法不存在将抛出异常BeanCreationException

2. 静态工厂

   - 通过工厂创建对象

     ```java
     public class UserDaoFactory {
         public static UserDao getUserDao(){
             return new UserDaoImpl();
         }
     }
     ```

   - 配置bean

     ```xml
     <bean id="userDao" class="com.spring_ioc.factory.UserDaoFactory" factory-method="getUserDao"/>
     ```

3. 实例工厂

   - 配置工厂bean

     ```xml
     <bean id="UserDaoFactory" class="com.spring_ioc.factory.UserDaoFactory"/>
     ```

   - 通过工厂创建对象

     ```java
     public class UserDaoFactory {
         public UserDao getUserDao(){
             return new UserDaoImpl();
         }
     }
     ```

   - 配置bean

     ```xml
     <bean id="userDao" factory-bean="UserDaoFactory" factory-method="getUserDao"/>
     ```

4. FactoryBean

   - 通过FactoryBean创建对象

     ```java
     public class UserDaoFactoryBean implements FactoryBean<UserDao> {
         //代替原始实例工厂创建对象的方法
         @Override
         public UserDao getObject() throws Exception {
             return new UserDaoImpl();
         }
     
         //获取bean的实例对象类型
         @Override
         public Class<?> getObjectType() {
             return UserDao.class;
         }
     
         //设置bean实例的是否为非单例
         @Override
         public boolean isSingleton() {
             //false:表示单例
             //true：表示非单例
             return false;
         }
     }
     
     ```

   - 配置bean

     ```xml
     <bean id="UserDao" class="com.spring_ioc.factory.UserDaoFactoryBean"/>
     ```

##### 3. bean的生命周期

- 初始化容器

  - 创建对象 （ 内存分配 ）

  - 执行构造方法

  - 执行属性注入（set 操作）

  - 执行bean初始化方法

    - xml配置

      ![image-20230310160847579](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165735130-793178739.png)

    - 接口配置

      ![image-20230310160943425](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165734511-2002783677.png)

- 使用 bean

  - 执行业务操作

- 关闭/销毁容器

  ![image-20230310161551238](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165733973-152369421.png)

  - 执行bean销毁方法



#### 2.容器

![image-20230311112755257](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170635676-1826288538.png)

1. 创建容器

   ![image-20230311111625077](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170635236-1502903166.png)

2. 获取bean

   ![image-20230311111716974](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170634785-874155276.png)



#### 3.依赖注入

##### 1.普通方法（setter注入）

1. 引用类型

   ![image-20230310162533314](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165733335-861372363.png)

2. 简单类型

   ![image-20230310163447372](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165732853-2075772346.png)

##### 2.构造方法（构造器注入）

1. 引用类型

   ![image-20230310164533281](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165732342-499636106.png)

2. 简单类型

   ![image-20230310164615094](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165731753-1128542775.png)

3. 参数适配

   ![image-20230310164717598](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165731126-1898811270.png)

##### 3.依赖方式的选择

```markdown
- 强制依赖使用构造器进行，使用setter注入有概率不进行注入导致null对象出现
- 可选依赖使用setter注入进行，灵活性强
- Spring框架倡导使用构造器，第三方框架内部大多数采用构造器注入的形式进行数据初始化，相对严谨
- 如果有必要可以两者同时使用，使用构造器注入完成强制依赖的注入，使用setter注入完成可选依赖的注入
- 实际开发过程中还要根据实际情况分析，如果受控对象没有提供setter方法就必须使用构造器注入
- 自己开发的模块推荐使用setter注入
```

##### 4.自动装配

IoC容器根据bean所依赖的资源在容器中自动查找并注入到bean中的过程称为自动装配

1. 按类型装配

   ![image-20230311094356028](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170634385-1769797152.png)

2. 按名称装配
3. 按构造器装配
4. 不使用自动装配

自动装配特征：

```markdown
- 1.自动装配用于引用类型依赖注入，不能对简单类型进行操作
- 2. 使用按类型装配时（byType）必须保障容器中相同类型的bean唯一，推荐使用
- 3. 使用按名称装配时（byName）必须保障容器中具有指定名称的bean，因变量名与配置耦合，不推荐使用
- 4. 自动装配优先级低于setter注入与构造器注入，同时出现时自动装配配置失效
```



#### 4.集合注入

1. 定义集合

   ```java
   private int[] array;
   private List<String> list;
   private Set<String> set;
   private Map<String, String> map;
   private Properties properties;
   ```

2. 设置setter

   ```java
   public void setArray(int[] array) {
       this.array = array;
   }
   
   public void setList(List<String> list) {
       this.list = list;
   }
   
   public void setSet(Set<String> set) {
       this.set = set;
   }
   
   public void setMap(Map<String, String> map) {
       this.map = map;
   }
   
   public void setProperties(Properties properties) {
       this.properties = properties;
   }
   ```

3. 配置集合

   ```xml
   <bean id="bookDao" class="com.spring_auto.dao.impl.BookDaoImpl">
       <!--        数组注入-->
       <property name="array">
           <array>
               <value>1</value>
               <value>2</value>
           </array>
       </property>
       <!--        list集合注入-->
       <property name="list">
           <list>
               <value>list1</value>
               <value>list2</value>
           </list>
       </property>
       <!--        set集合注入-->
       <property name="set">
           <set>
               <value>set1</value>
               <value>set2</value>
               <value>set1</value>
           </set>
       </property>
       <!--        map集合注入-->
       <property name="map">
           <map>
               <entry key="key1" value="map1"/>
               <entry key="key2" value="map2"/>
           </map>
       </property>
       <!--        properties注入-->
       <property name="properties">
           <props>
               <prop key="key1">pro1</prop>
               <prop key="key2">pro2</prop>
           </props>
       </property>
   </bean>
   ```

   

#### 5.加载properties文件

![image-20230311110847553](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170633952-1459694039.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<!--       开启context命名空间-->
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="
                           http://www.springframework.org/schema/beans
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context
                           http://www.springframework.org/schema/context/spring-context.xsd
                           ">
    <!--使用context空间加载properties-->
    <context:property-placeholder location="classpath*:*.properties" system-properties-mode="NEVER"/>
    <bean id="druidDataSource" class="com.alibaba.druid.pool.DruidDataSource">
        <!--        使用属性占位符读取properties文件中的属性-->
        <property name="driverClassName" value="${driverClassName}"/>
        <property name="url" value="${url}"/>
        <property name="username" value="${username}"/>
        <property name="password" value="${password}"/>
        <property name="initialSize" value="${initialSize}"/>
        <property name="minIdle" value="${minIdle}"/>
        <property name="maxActive" value="${maxActive}"/>
        <property name="maxWait" value="${maxWait}"/>
    </bean>
</beans>
```



#### 6.注解开发

##### 1. bean

![image-20230311115151342](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170633435-1753308651.png)

<a style="color:red">注意：</a>spring提供@Component注解的三个衍生注解

```markdown
	@Controller：用于表现层bean定义
	@Service：用于业务层bean定义
	@Repository：用于数据层bean的定义
```

##### 2. bean的管理

1. bean的作用范围

   默认值singleton（单例），可选值prototype（非单例）

   ![image-20230311140229846](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170633046-189396566.png)

2. bean的生命周期

   ![image-20230311140249899](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170632640-781003601.png)

##### 3. 配置类

![image-20230311135335217](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170632182-78103052.png)

```java
//创建容器，并读取配置类
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
```

##### 4. 依赖注入（自动装配）

1. 引用类型

   ![image-20230311141033548](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170631591-703095665.png)

   注意：如果想加载指定的bean，可以使用以下方法

   ![image-20230311141121711](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170631117-98822364.png)

2. 简单类型

   ![image-20230311141540612](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170630684-614913259.png)

##### 5.加载properties文件

![image-20230311142041611](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170630228-1514863070.png)



#### 7.配置文件开发与注解开发的对比

![image-20230311144449139](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230311170629657-1161826626.png)



### 五、Spring整合

---

#### 1. 整合MyBatis

1. 引入相应坐标

   ```xml
   <dependencies>
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-context</artifactId>
           <version>5.2.10.RELEASE</version>
       </dependency>
       <dependency>
           <groupId>mysql</groupId>
           <artifactId>mysql-connector-java</artifactId>
           <version>8.0.32</version>
       </dependency>
       <dependency>
           <groupId>com.alibaba</groupId>
           <artifactId>druid</artifactId>
           <version>1.1.10</version>
       </dependency>
       <dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis</artifactId>
           <version>3.5.5</version>
       </dependency>
       <!--    spring操作jdbc-->
       <dependency>
           <groupId>org.springframework</groupId>
           <artifactId>spring-jdbc</artifactId>
           <version>5.2.10.RELEASE</version>
       </dependency>
       <!--    spring整合mybatis-->
       <dependency>
           <groupId>org.mybatis</groupId>
           <artifactId>mybatis-spring</artifactId>
           <version>1.3.0</version>
       </dependency>
   </dependencies>
   ```

2. 配置Druid.properties

   ```properties
   #key=value
   driverClassName=com.mysql.jdbc.Driver
   url=jdbc:mysql://root@localhost:3306/spring_db?rewriteBatchedStatements=true
   username=root
   password=123456
   #initial connection Size
   initialSize=10
   #min idle connecton size
   minIdle=5
   #max active connection size
   maxActive=20
   #max wait time (5000 mil seconds)
   maxWait=5000
   ```

3. 配置JdbcByDruidConfig

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:25
    * @注释:Spring整合JdbcByDruid
    */
   public class JdbcByDruidConfig {
       //注册驱动
       @Value("${driverClassName}")
       private String driver;
       //数据库连接源
       @Value("${url}")
       private String url;
       //用户名
       @Value("${username}")
       private String username;
       //密码
       @Value("${password}")
       private String password;
       //初始连接大小
       @Value("${initialSize}")
       private int initialSize;
       //最小空闲连接大小
       @Value("${minIdle}")
       private int minIdle;
       //最大活动连接大小
       @Value("${maxActive}")
       private int maxActive;
       //最长等待时间
       @Value("${maxWait}")
       private int maxWait;
   
       /**
        * 初始化jdbcByDruid数据源连接池
        *
        * @return 返回初始化后的DruidDataSource对象
        */
       @Bean
       public DataSource druidDataSource() {
           DruidDataSource druidDataSource = new DruidDataSource();
           druidDataSource.setDriverClassName(driver);
           druidDataSource.setUrl(url);
           druidDataSource.setUsername(username);
           druidDataSource.setPassword(password);
           druidDataSource.setInitialSize(initialSize);
           druidDataSource.setMinIdle(minIdle);
           druidDataSource.setMaxActive(maxActive);
           druidDataSource.setMaxWait(maxWait);
           return druidDataSource;
       }
   }
   ```

4. 配置MyBatisConfig

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:28
    * @注释:Spring整合MyBatis
    */
   public class MyBatisConfig {
       /**
        * 初始化SqlSessionFactory并设置相关参数
        *
        * @param jdbcByDruidConfig 传入jdbcByDruid的数据库连接池对象
        * @return 返回初始化后的SqlSession对象
        */
       @Bean
       public SqlSessionFactoryBean sqlSessionFactory(JdbcByDruidConfig jdbcByDruidConfig) {
           //创建SqlSessionFactoryBean对象
           SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
           //设置类型别名的包路径
           sqlSessionFactoryBean.setTypeAliasesPackage("com.spring_mybatis.model");
           //设置数据源
           sqlSessionFactoryBean.setDataSource(jdbcByDruidConfig.druidDataSource());
           return sqlSessionFactoryBean;
       }
   
       /**
        * 设置Mapper自动代理的映射文件
        *
        * @return 返回初始化后的Mapper自动代理映射对象
        */
       @Bean
       public MapperScannerConfigurer mapperScannerConfigurer() {
           //创建mapper自动代理对象
           MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
           //设置包扫描路径
           mapperScannerConfigurer.setBasePackage("com.spring_mybatis.dao");
           return mapperScannerConfigurer;
       }
   }
   ```

5. 配置SpringConfig

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/11 16:12
    * @注释:Spring配置
    */
   @Configuration
   @ComponentScan("com.spring_mybatis")
   @PropertySource("druid.properties")
   @Import({JdbcByDruidConfig.class, MyBatisConfig.class})
   public class SpringConfig {
   
   }
   ```

6. 测试

   ```java
   //获取Spring配置信息
   ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
   //获取bean
   AccountService accountService = applicationContext.getBean(AccountService.class);
   System.out.println(accountService.findAll());
   ```

   



所有的笔记来源于：[黑马程序员的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/37974444)



