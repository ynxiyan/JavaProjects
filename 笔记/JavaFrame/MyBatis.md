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

### 六、使用配置文件开发

----

#### 1. 参数占位符

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

#### 2. 特殊字符处理

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

#### 3. 参数的设置

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

##### 3-1. 散装参数

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

##### 3-2. 对象参数

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

##### 3-3. Map集合参数

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

#### 4.动态SQL

动态 SQL 是 MyBatis 的强大特性之一。如果你使用过 JDBC 或其它类似的框架，你应该能理解根据不同条件拼接 SQL 语句有多痛苦，例如拼接时要确保不能忘记添加必要的空格，还要注意去掉列表最后一个列名的逗号。利用动态 SQL，可以彻底摆脱这种痛苦。

##### 4-1. 多条件查询

###### 4-1-1. \<if>

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

###### 4-1-2. \<where>

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

##### 4-2. 单条件查询

###### 4-2-1. \<choose>

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

#### 5. 添加、修改

##### 5-1. 添加

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

###### 5-1-1. 主键返回

使用主键返回

1. 设置useGeneratedKeys的属性值为true
2. Property的属性值为主键对应的实体属性名称

```xml
<insert id="add" useGeneratedKeys="true" keyProperty="id">
    insert into tb_brand (brand_name, company_name, ordered, description, status)
    values (#{brandName},#{companyName},#{ordered},#{description},#{status});
</insert>
```

##### 5-2.修改

###### 5-2-1. 修改全部字段

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

###### 5-2-2. 修改指定字段

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

#### 6.删除

##### 6-1. 批量删除

使用\<foreach>标签遍历需要删除的id，即遍历id数组

```java
/**
 * 批量删除
 *
 * @param id 传入id数组
 */
void deleteByIds(@Param("ids") int[] id);
```

```xml
<delete id="deleteByIds">
    delete
    from tb_brand
    where id in
    # collection：需要遍历的数组名称
    # item：需要遍历的键
    # separator：分隔符
    # open：开始
    # close：结束
    <foreach collection="ids" item="id" separator="," open="(" close=")">
        #{id}
    </foreach>
</delete>
```

**注意：**

- mybatis会将数组参数，封装为一个Map集合

- 默认为：array = 数组

- 可以使用@Param注解改变Map集合的默认key的名称

##### 6-2. 删除指定

```xml
<delete id="deleteById">
    delete
    from tb_brand
    where id = #{id};
</delete>
```

#### 7.参数传递

在进行参数传递时，mybatis会使用ParamNameResolver类将参数封装

注意：**使用@Param注解，替换Map集合默认的arg键名**

MyBatis 参数封装 ：

1. 单个参数 ：

   - Model类型 ：

     直接使用属性名（要保证属性名和参数占位符名称一致）

   - Map集合 ：

     直接使用键名（要保证键名和参数占位符名称一致）

   - CotIection ：封装为Map集合

     ```java
     map.put("arg0",CotIection集合);
     map.put("cotIection",CotIection集合);
     ```

   - List ：封装为Map集合

     ```java
     map.put("arg0",List集合);
     map.put("cotIection",CotIection集合);
     map.put("list",List集合);
     ```

   - Array ：封装为Map集合

     ```java
     map.put("arg0",数组);
     map.put("array",数组);
     ```

   - 其他类型 ：直接使用

2. 多个参数 ： 封装为Map集合

   ```java
   map.put("arg0"，参数1);		|		map.put("param1"，参数1);	
   map.put("arg1", 参数2);		 |		 map.put("param2"， 参数2);
   ```



### 七、使用注解开发

---

使用注解来映射简单语句会使代码显得更加简洁，但对于稍微复杂一点的语句，Java注解不仅力不从心，还会让你本就复杂的SQL语句更加混乱不堪。因此，如果你需要做一些很复杂的操作最好
用XML来映射语句
选择何种方式来配置映射，以及认为是否应该要统一映射语句定义的形式，完全取决于你和你的团队。换句话说，永远不要拘泥于一种方式，你可以很轻松在基于汪解和XML的语句映射方式间自由自移植和切换

```markdown
# 查询 ： @Select 	# 添加 ： @lnsert	 # 修改 ： @Update	 # 删除 ： @Delete
```

**提示：**

- 注解完成简单功能
- 配置文件完成复杂功能



### 八、MyBatis的缓存机制

---

#### 1. 概述

![image-20230310102638024](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230310113029073-1057627226.png)

图片来自：[mic老师面试资料_哔哩哔哩_bilibili](https://www.bilibili.com/video/BV1YR4y127Yt/?p=2&spm_id_from=333.1007.top_right_bar_window_history.content.click)

Mybatis缓存机制是指Mybatis框架提供的一种提高查询效率的功能，它可以将经常查询的数据存储在内存中，减少和数据库的交互次数；Mybatis缓存机制分为一级缓存和二级缓存

**一级缓存：**

一级缓存是SqlSession级别的缓存，也称为本地缓存；它默认开启，只对当前SqlSession有效；当SqlSession执行增删改操作或者关闭时，一级缓存会失效

<a style="color:red">注意：</a>执行**insert**、**update**、**delete**操作会刷新缓存

**二级缓存：**

二级缓存是mapper级别的缓存，它是基于namespace的缓存，一个命名空间（namespace）对应一个二级缓存，也称为全局缓存。它需要手动开启和配置，可以跨SqlSession共享数据。二级缓存可以自定义实现Cache接口来扩展

#### 2. 如何开启和配置二级缓存

要开启和配置二级缓存，需要做以下几个步骤：

- 1.在全局配置文件mybatis-config.xml中设置cacheEnabled为true，这是开启二级缓存的前提。

  ```xml
  <!--显式的开启二级缓存-->
  <settings>
      <setting name="cacheEnabled" value="true"/>
  </settings>
  ```

- 2.在mapper.xml或mapper.java的命名空间中添加\<cache/>标签，这是开启二级缓存的必要条件。

  ```xml
  <!--    开启二级缓存
    readOnly：表示缓存以只读的形式保存，当有新的缓存进入的时候，会直接删除旧的缓存，如果不配置这个属性，会导致一个报错。
    flushInterval：刷新间隔，以毫秒为单位。即缓存的刷新间隔，默认不刷新
    size：引用数目，默认为1024
    eviction：回收策略，有四个值，分别对应四种不同的缓存回收策略，
     默认是LRU，即移除最长时间不使用的缓存。
     其次是FIFO，按照缓存进入的时间移除最早进入的缓存。-->
  <cache readOnly="true"/>
  ```

- 3.让返回的Model(POJO)实现Serializable接口（序列化），这是使用二级缓存的要求。

如果需要自定义缓存实现，可以在\<cache/>标签中指定type属性为自定义的Cache接口实现类。



### 九、分页插件

---

#### 1. MyBatis内置

Mybatis内置了一个专门处理分页的类——RowBounds，我们使用它可以轻松完成分页

1. mapper

   ```java
   @Mapper
   public interface UserMapper {
       /**
        * 查询所有用户信息
        *
        * @param rowBounds 传入当前页码和每页显示数
        * @return 返回筛选后的用户列表
        */
       List<User> selectUserAll(RowBounds rowBounds);
   }
   ```

2. 测试

   ```java
   @Autowired
   private UserMapper userMapper;
   
   @Test
   void getUserAll() {
       //当前页码
       int currPage = 1;
       //当前页显示记录数量
       int pageSize = 1;
       //注意：currPage和start别搞错了，一个表示当前页码，一个是从第几行读取记录
       //计算从第几行读取记录
       int start = (currPage - 1) * pageSize;
       RowBounds rowBounds = new RowBounds(start, pageSize);
       List<User> userList = userMapper.selectUserAll(rowBounds);
       System.out.println(userList);
   }
   ```

