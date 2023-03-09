# [MyBatis](https://www.cnblogs.com/ynxiyan/p/17201088.html)

### 一、什么是MyBatis

---

MyBatis 是一款优秀的持久层框架 ， 用于简化 JDBC 开发
MyBatis 本是 Apache 的一个开源项目 iBatis, 2010 年这个项目由 apache software foundation 迁移到了 google code, 并且改名为 MyBatis 。 2013 年 1 1 月迁移到 Github
官网 ： [mybatis – MyBatis 3 | 简介](https://mybatis.org/mybatis-3/zh/index.html)

```markdown
**持久层**
- 负责将数据到保存到数据库的那一层代码
- JavaEE 三层架构表现层业务层 、 持久层

**框架**
- 框架就是一个半成品软件 ， 是一套可重用的 、 通用的 、 软件基础代码模型
- 在框架的基础之上构建软件编写更加高效 、 规范 、 通用 、 可扩展
```

**MyBatis的作用**

简化硬编码，自动完成繁琐操作



### 二、MyBatis入门

---

1. 导入坐标

   ```xml
   <!--    mybatis-->
   <dependency>
       <groupId>org.mybatis</groupId>
       <artifactId>mybatis</artifactId>
       <version>3.5.5</version>
   </dependency>
   <!--        slf4j日志api-->
   <dependency>
       <groupId>org.slf4j</groupId>
       <artifactId>slf4j-simple</artifactId>
       <version>1.7.25</version>
   </dependency>
   ```

2. 编写mybatis-config.xml配置文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE configuration
           PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
           "https://mybatis.org/dtd/mybatis-3-config.dtd">
   <configuration>
       <environments default="development">
           <environment id="development">
               <transactionManager type="JDBC"/>
               <dataSource type="POOLED">
                   <!--                数据库的连接信息-->
                   <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                   <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false"/>
                   <property name="username" value="root"/>
                   <property name="password" value="123456"/>
               </dataSource>
           </environment>
       </environments>
       <mappers>
           <!--        加载sql的映射文件-->
           <mapper resource="usermapper.xml"/>
       </mappers>
   </configuration>
   ```

3. 编写表映射文件

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--        namespace:名称空间-->
   <mapper namespace="usermapper">
       <select id="selectAll" resultType="com.model.User">
           select * from user
       </select>
   </mapper>
   ```

4. 构建SqlSessionFactory

   ```java
   //加载mybatis的核心配置文件，获取SqlSessionFactory
   String resource = "mybatis-config.xml";
   InputStream inputStream = Resources.getResourceAsStream(resource);
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   //获取sqlSession对象，用于执行sql
   SqlSession sqlSession = sqlSessionFactory.openSession();
   //执行sql
   List<User> users = sqlSession.selectList("usermapper.selectAll");
   System.out.println(users);
   //释放资源
   sqlSession.close();
   ```



### 三、Mapper代理开发

---

**目的：**

```markdown
- 解决原生方式的硬编码
- 简化后期执行sql
```

**使用步骤：**

1. 定义与SQL映射文件同名的Mapper接口，并且将Mapper接口和SQL映射文件放置在同一目录（创建mapper包，并在resource下创建com/mapper/目录）

2. 设置SQL映射文件的namespace属性为Mapper接口全限定名

   ```xml
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE mapper
           PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
           "https://mybatis.org/dtd/mybatis-3-mapper.dtd">
   <!--        namespace:名称空间-->
   <mapper namespace="com.mapper.UserMapper">
       <select id="selectAll" resultType="com.model.User">
           select * from user
       </select>
   </mapper>
   ```

3. 在mybatis-config.xml配置文件里加载sql映射文件

   ```xml
   <mappers>
       <!--        加载sql的映射文件-->
       <!--        <mapper resource="usermapper.xml"/>-->
       <package name="com.mapper"/>
   </mappers>
   ```

   

4. 在Mapper接口中定义方法，方法名就是SQL映射文件中sql语句的id，并保持参数类型和返回值类型一致

   ```java
   /**
    * 查询用户列表
    *
    * @return 返回用户列表
    */
   List<User> selectAll();
   ```

5. 编码

   ```java
   //加载mybatis的核心配置文件，获取SqlSessionFactory
   String resource = "mybatis-config.xml";
   InputStream inputStream = Resources.getResourceAsStream(resource);
   SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
   //获取sqlSession对象，用于执行sql
   SqlSession sqlSession = sqlSessionFactory.openSession();
   //获取UserMapper接口的单例对象
   UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
   List<User> userList = userMapper.selectAll();
   System.out.println(userList);
   //释放资源
   sqlSession.close();
   ```



### 四、MyBatis核心配置文件

---

MyBatis的配置文件包含了会深深影响MyBatis行为的设置和属性信息，配置文档的顶层结构如下：

- configuration（配置）

  - properties（属性）
  - settings（设置）
  - typeAliases（类型别名）
  - typeHandlers（类型处理器）
  - objectFactory（对象工厂）
  - plugins（插件）
  - environments（环境配置）
    - environment（环境变量）
    - transactionManager（事务管理器）
    - dataSource（数据源）

  - databaseIdProvider（数据库厂商标识）
  - mappers（映射器）

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "https://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--    给实体类起别名并使用包扫描-->
    <typeAliases>
        <package name="com.model"/>
    </typeAliases>
    <!--    环境配置
            environments：配置数据库连接信息，可以配置多个环境，通过default属性切换成不同的数据源-->
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <!--                数据库的连接信息-->
                <property name="driver" value="com.mysql.cj.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
        <!--        加载sql的映射文件-->
        <!--        <mapper resource="usermapper.xml"/>-->
        <package name="com.mapper"/>
    </mappers>
</configuration>
```



### 五、处理字段不一致

---

#### 1. 对表字段起别名

1. 直接在sql上写

   ```xml
   <select id="selectAll" resultType="Brand">
       select id, brand_name as brandName, company_name as companyName, ordered, description, status
       from tb_brand;
   </select>
   ```

   缺点：每次查询都需要定义别名

2. 使用sql片段

   ```xml
   <!--    sql片段-->
   <sql id="brand_select">
       id, brand_name as brandName, company_name as companyName, ordered, description, status
   </sql>
   <select id="selectAll" resultType="Brand">
       select
       # 通过id引入sql片段
       <include refid="brand_select"></include>
       from tb_brand;
   </select>
   ```

   缺点：不灵活

#### 2. 使用resultMap

```xml
<!--    id:唯一标识
        type：映射的类型，支持别名-->
<resultMap id="brandResultMap" type="Brand">
    <!--        id:完成主键字段的映射
            result:完成一般字段的映射
                column:表的列名
                property:实体类的属性-->
    <result column="brand_name" property="brandName"/>
    <result column="company_name" property="companyName"/>
</resultMap>
<select id="selectAll" resultMap="brandResultMap">
    select *
    from tb_brand;
</select>
```



### 六、参数占位符

---

1. \#{}

   ```markdown
   # 会将其替换为?，可以防止sql注入
   ```

2. ${}

   ```markdown
   # 直接拼接sql，存在sql注入问题
   ```

使用时机：

- 参数传递时使用#{}
- 表名列名不固定时使用${}



### 七、特殊字符处理

---

1. 转义字符

   ```xml
   <!--小于-->
   &lt;
   ```

2. CDATA区

   ```xml
   <![CDATA[
   
   ]]>
   ```



### 八、参数的设置

---

Mapper:

```xml
<select id="selectByCondition" resultMap="brandResultMap">
    select *
    from tb_brand
    where status = #{status}
    and company_name like #{companyName}
    and brand_name like #{brandName}
</select>
```

参数：

```java
int status = 1;
String companyName = "华为";
String brandName = "华为";
companyName = "%" + companyName + "%";
brandName = "%" + brandName + "%";
```

#### 1. 散装参数

如果方法中有多个参数，需要使用@Param注解

```java
/**
 * 条件查询（散装参数）
 *
 * @param status      传入状态
 * @param companyName 传入企业名称
 * @param brandName   传入产品名称
 * @return 返回商品列表
 */
List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
-----------------------------------------------
System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(status, companyName, brandName));
```

#### 2. 对象参数

对象的属性名称要和参数占位符名称一致

```java
/**
 * 条件查询（对象参数）
 *
 * @param brand 传入品牌对象
 * @return 返回商品列表
 */
List<Brand> selectByCondition(Brand brand);
----------------------------------
Brand brand = new Brand();
brand.setStatus(status);
brand.setCompanyName(companyName);
brand.setBrandName(brandName);
System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(brand));
```

#### 3. Map集合参数

Map集合的键要和参数占位符名称保持一致

```java
/**
 * 条件查询（Map集合）
 *
 * @param map 传入Map的键
 * @return 返回商品列表
 */
List<Brand> selectByCondition(Map map);
------------------------------------
Map<String, Object> map = new HashMap<>();
map.put("status", status);
map.put("companyName", companyName);
map.put("brandName", brandName);
System.out.println(sqlSession.getMapper(BrandMapper.class).selectByCondition(map));
```



### 九、动态SQL

---

动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

#### 1. 多条件查询

##### 1-1. \<if>

条件判断	test属性：写逻辑表达式

```xml
<select id="selectByCondition" resultMap="brandResultMap">
    select *
    from tb_brand
    where
    <if test="status != null">
        status = #{status}
    </if>
    <if test="companyName != null and companyName != ''">
        and company_name like #{companyName}
    </if>
    <if test="brandName != null and brandName != ''">
        and brand_name like #{brandName}
    </if>
</select>
```

问题：直接使用上面的方法可能造成sql语法错误，解决方法：

1. 恒等式	1=1
2. \<where>

##### 1-2. \<where>

解决\<if>标签可能造成的sql语法错误

```xml
<select id="selectByCondition" resultMap="brandResultMap">
    select *
    from tb_brand
    <where>
        <if test="status != null">
            status = #{status}
        </if>
        <if test="companyName != null and companyName != ''">
            and company_name like #{companyName}
        </if>
        <if test="brandName != null and brandName != ''">
            and brand_name like #{brandName}
        </if>
    </where>
</select>
```

#### 2. 单条件查询

##### 2-1. \<choose>

选择分支，类似于java的switch语句

\<choose>相当于switch	\<when>相当于case	\<otherwise>相当于default

```xml
<select id="selectByConditionSingle" resultMap="brandResultMap">
    select *
    from tb_brand
    <where>
        <choose>
            <when test="status != null">
                status = #{status}
            </when>
            <when test="companyName != null and companyName != ''">
                and company_name like #{companyName}
            </when>
            <when test="brandName != null and brandName != ''">
                and brand_name like #{brandName}
            </when>
        </choose>
    </where>
</select>
```



### 十、添加、修改

---

#### 1. 添加

```xml
<insert id="add">
    insert into tb_brand (brand_name, company_name, ordered, description, status)
    values (#{brandName},#{companyName},#{ordered},#{description},#{status});
</insert>
```

**注意点：**

MyBatis默认关闭了自动提交，需要自己手动提交或在获取sqlSession对象时开启

```java
//获取sqlSession对象
//true:开启自动提交，false:关闭自动提交；默认为false
SqlSession sqlSession = sqlSessionFactory.openSession(true);
---------------------------------
//手动提交
sqlSession.commit();
```

##### 1-1. 主键返回

使用主键返回

1. 设置useGeneratedKeys的属性值为true
2. Property的属性值为主键对应的实体属性名称

```xml
<insert id="add" useGeneratedKeys="true" keyProperty="id">
    insert into tb_brand (brand_name, company_name, ordered, description, status)
    values (#{brandName},#{companyName},#{ordered},#{description},#{status});
</insert>
```

#### 2.修改

##### 2-1. 修改全部字段

```xml
<update id="update">
    update tb_brand
    set brand_name   = #{brandName},
    company_name = #{companyName},
    ordered      = #{ordered},
    description  = #{description},
    status       = #{status}
    where id = #{id};
</update>
```

##### 2-2. 修改指定字段

使用**\<set>**和**\<if>**标签判断哪些值不为空

```xml
<update id="update">
    update tb_brand
    <set>
        <if test="brandName != null and brandName != ''">
            brand_name = #{brandName},
        </if>
        <if test="companyName != null and companyName != ''">
            company_name = #{companyName},
        </if>
        <if test="ordered != null">
            ordered = #{ordered},
        </if>
        <if test="description != null and description != ''">
            description = #{description},
        </if>
        <if test="status != null">
            status = #{status}
        </if>
    </set>
    where id = #{id};
</update>
```







