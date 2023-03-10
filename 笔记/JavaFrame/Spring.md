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



### 四、bean

---

#### 1. bean的配置

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

#### 2. bean的实例化

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

#### 3. bean的生命周期

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



### 五、依赖注入

---

#### 1.普通方法（setter注入）

1. 引用类型

   ![image-20230310162533314](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165733335-861372363.png)

2. 简单类型

   ![image-20230310163447372](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165732853-2075772346.png)

#### 2.构造方法（构造器注入）

1. 引用类型

   ![image-20230310164533281](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165732342-499636106.png)

2. 简单类型

   ![image-20230310164615094](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165731753-1128542775.png)

3. 参数适配

   ![image-20230310164717598](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310165731126-1898811270.png)

#### 3.依赖方式的选择

```markdown
- 强制依赖使用构造器进行，使用setter注入有概率不进行注入导致null对象出现
- 可选依赖使用setter注入进行，灵活性强
- Spring框架倡导使用构造器，第三方框架内部大多数采用构造器注入的形式进行数据初始化，相对严谨
- 如果有必要可以两者同时使用，使用构造器注入完成强制依赖的注入，使用setter注入完成可选依赖的注入
- 实际开发过程中还要根据实际情况分析，如果受控对象没有提供setter方法就必须使用构造器注入
- 自己开发的模块推荐使用setter注入
```





所有的笔记来源于：[Spring-13-自动装配_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1Fi4y1S7ix/?p=15&spm_id_from=pageDriver&vd_source=866d188814ba5db60ad050687381e713)



