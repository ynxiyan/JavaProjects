# [JDBC和数据库连接池](https://www.cnblogs.com/ynxiyan/p/17106242.html)

## JDBC

### 一、概述

---

JDBC（ 为访问不同的数据库提供了统一的接口 ， 为使用者屏蔽了细节问题 。
Java 程序员使用 JDBC, 可以连接任何提供了JDBC（ 驱动程序的数据库系统 ， 从而完成对数据库的各种操作 。

#### 1.JDBC的基本原理图 [重要]

![image-20230209092327351](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165736115-85445696.png)

JDBC接口：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 9:27
 * @注释:规定的jdbc接口[模拟]
 */
public interface JdbcInterface {
    /**
     * 连接
     *
     * @return
     */
    Object getConnection();

    /**
     * 数据的增删改查
     */
    void crud();

    /**
     * 关闭连接
     */
    void close();
}
```

实现类：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 9:32
 * @注释:Mysql实现jdbc接口
 */
public class MysqlJdbcImpl implements JdbcInterface {
    /**
     * 连接
     *
     * @return
     */
    @Override
    public Object getConnection() {
        return "得到Mysql连接";
    }

    /**
     * 数据的增删改查
     */
    @Override
    public void crud() {
        System.out.println("实现数据的增删改查");
    }

    /**
     * 关闭连接
     */
    @Override
    public void close() {
        System.out.println("关闭连接");
    }
}
```

测试：

```java
public class Test {
    public static void main(String[] args) {
        //创建jdbc对象(通过接口调用实现类，动态绑定[多态])
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();
        //创建Mysql连接
        jdbcInterface.getConnection();
        //对数据进行操作
        jdbcInterface.crud();
        //关闭Mysql连接
        jdbcInterface.close();
    }
}
```

#### 2.JDBC带来的好处

JDBC是Java提供一套用于数据库操作的接口 API,**Java程序员只需要面向这套接口编程即可**。 不同的数据库厂商 ， 需要针对这套接口 ， 提供不同实现 。

#### 3.JDBC API

![image-20230209113339548](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165734230-187910294.png)

![image-20230211094323974](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230211150925556-284269119.png)



### 二、JDBC快速入门

---

#### 1.使用步骤

```markdown
# 注册驱动 - 加载Driver 类
# 获取连接 - 得到 Connection
# 执行增删改查 - 发送SQL给mysql 执行
# 释放资源 - 关闭相关连接
```

#### 2.模拟 JDBC

![image-20230209104938970](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165732320-2140465523.png)

完整代码：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 10:10
 * @注释:第一个Jdbc程序，完成简单的操作
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        /*
        前置操作：
        创建一个文件夹（名字随意）
        将jar包拷贝到该目录下，右键添加到库
         */
        //1.注册驱动(创建Driver对象）
        Driver driver = new Driver();
        //2.得到连接（本质：socket连接）
        //"jdbc连接协议://主机或IP地址:端口号/数据库名"
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        //3.将用户名和密码放入Properties对象中
        Properties properties = new Properties();
        /*
        说明：
        user和password是规定好的不能修改
         */
        //设置用户
        properties.setProperty("user", "root");
        //设置密码
        properties.setProperty("password", "123456");
        //4.连接数据库
        Connection connection = driver.connect(url, properties);
        //5.操作数据库
        //创建sql语句
        String sql = "insert into actor values(null,'张三','男','2000-09-07','110')";
        //执行sql语句并返回结果对象
        Statement statement = connection.createStatement();
        //返回受影响的行数(返回大于0的数字即执行成功，返回0则执行失败)
        int rows = statement.executeUpdate(sql);
        System.out.println(rows > 0 ? "sql执行成功" : "sql执行失败");
        //6.关闭连接
        statement.close();
        connection.close();
    }
}
```

#### 3.获取数据库连接的 5 种方式

##### 3-1.方式一，使用Driver对象

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:43
 * @注释:方式一
 */
public class Manner1 {
    public static void main(String[] args) throws SQLException {
        //获取Driver实现类对象
        Driver driver = new Driver();
        //定义jdbc连接地址
        String url="jdbc:mysql://localhost:3306/hsp_jdbc";
        //创建Properties对象
        Properties properties = new Properties();
        //设置用户名
        properties.setProperty("user","root");
        //设置密码
        properties.setProperty("password","123456");
        //连接数据库
        Connection connect = driver.connect(url, properties);
    }
}
```

<a style="color:red">缺点：</a>

- 会直接使用com.mysql.jdbc.Driver()，属于静态加载，灵活性差，依赖强

##### 3-2.方式二，减少依赖增强灵活性

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式二
 */
public class Manner2 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类(动态加载，更加的灵活，减少依赖性)
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //定义jdbc连接地址
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        //创建Properties对象
        Properties properties = new Properties();
        //设置用户名
        properties.setProperty("user", "root");
        //设置密码
        properties.setProperty("password", "123456");
        //连接数据库
        Connection connect = driver.connect(url, properties);
    }
}
```

##### 3-3.方式三，使用DriverManager替代Driver进行统一管理

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式三
 */
public class Manner3 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类(动态加载，更加的灵活，减少依赖性)
        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) aClass.newInstance();
        //定义jdbc连接地址、用户名和密码
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        String user = "root";
        String password = "123456";
        //注册Driver驱动
        DriverManager.registerDriver(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
```

<a style="color:red">缺点：</a>

- 需手动注册Driver驱动

##### 3-4.使用Class.forName自动完成注册驱动，简化代码（<a style="color:grren">推荐使用</a>）

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 11:51
 * @注释:方式四
 */
public class Manner4 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        //使用反射加载Driver类并在加载时自动完成Driver驱动的注册
        Class.forName("com.mysql.jdbc.Driver");
        //定义jdbc连接地址、用户名和密码
        String url = "jdbc:mysql://localhost:3306/hsp_jdbc";
        String user = "root";
        String password = "123456";
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
```

补充：

```markdown
- mysqL 驱动5.1.6以后可以无需 CLass.forName("com.mysql.jdbc.Driver");
- 从 jdk1.5以后使用了 jdbc4,不再需要显示调用 class.forName() 注册驱动而是自动调用驱动jar包下 META-INF\services\java.sql.Driver 文本中的类名称去注册
```

<a style="color:grren"># 建议还是写上 CLass.forName("com.mysql.jdbc.Driver"), 更加明确</a>

##### 3-5.使用配置文件，连接数据库更灵活

jdbc.properties:

```properties
url=jdbc:mysql://localhost:3306/hsp_jdbc
user=root
password=123456
driver=com.mysql.jdbc.Driver
```
Manner5:
```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 14:53
 * @注释:方式五
 */
public class Manner5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //注册驱动（可省略）
        Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
    }
}
```



#### 4.创建、插入、修改、删除（练习）

题目：

![image-20230209153723801](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165729562-792841262.png)

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 14:53
 * @注释:使用方式五完成数据表的创建、插入、修改、删除
 */
public class Manner5 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        //通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //注册驱动（可省略）
        Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //操作数据库
        //创建news表
        String createSql = "create table news (id int not null primary key auto_increment," +
                "content varchar(100)" +
                ")";
        //向news表插入数据
        String insertSql = "insert into news values(null,'dyt')," +
                "(null,'det')," +
                "(null,'dst')," +
                "(null,'dsit')," +
                "(null,'dwt')";
        //更新news表里id为1的信息内容
        String updateSql = "update news set content='news' where id=1";
        //删除news表里id为3的记录
        String deleteSql = "delete from news where id=3";
        //创建Statement对象
        Statement statement = connection.createStatement();
        //执行sql语句
        statement.executeUpdate(createSql);
        int insert = statement.executeUpdate(insertSql);
        System.out.println(insert > 0 ? "sql执行成功" : "sql执行失败");
        int update = statement.executeUpdate(updateSql);
        System.out.println(update > 0 ? "sql执行成功" : "sql执行失败");
        int delete = statement.executeUpdate(deleteSql);
        System.out.println(delete > 0 ? "sql执行成功" : "sql执行失败");
        //关闭连接
        statement.close();
        connection.close();
    }
}
```



### 三、ResultSet[结果集]

---

#### 1.基本介绍

表示数据库结果集的数据表，通常通过执行查询数据库的语句生成
ResultSet 对象保持一个光标指向其当前的数据行 。 最初，光标位于第一行之前
next() 方法将光标移动到下一行 ， 并且由于在 ResultSet 对象中没有更多行时返回false ，因此可以在 while 循环中使用循环来遍历结果集

![image-20230211094907675](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230211150923657-610392516.png)

![image-20230209163845428](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165728813-567969601.png)

#### 2.应用实例：

![image-20230209165220391](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230209165727636-115490164.png)

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/9 16:06
 * @注释:eclect语句返回ResultSet并取出结果集
 */
public class Result {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        //1.通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //2.注册驱动（可省略）
        Class.forName(driver);
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //4.创建Statement对象
        Statement statement = connection.createStatement();
        //5.操作数据库
        //查询actor表
        String selectSql = "select id,name,sex,borndate from actor";
        //6.执行sql语句并返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(selectSql);
        //7.使用while循环取出数据   next--让光标下移，当没有数据行时返回false
        while (resultSet.next()) {
            //获取该行的第一列数据~~~
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String sex = resultSet.getString(3);
            Date borndate = resultSet.getDate(4);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + borndate);
        }
        //8.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```



### 四、Statement

----

#### 1.基本介绍

Statement 对象用于执行静态 SQL 语句并返回其生成的结果的对象
在连接建立后 ， 需要对数据库进行访问 ， 执行 命名或是 SQL 语句，可以通过

```markdown
- Statement [ 存在 SQL 注入 ]
- PreparedStatement [ 预处理 ]
- CaIIabIeStatement [ 存储过程 ]
```

Statement 对象执行 SQL 语句 ，存在 SQL 注入风险

![image-20230210101759654](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230210170139232-1344386694.png)

例：

```mysql
select * from admin where `name`='1' or 'and pwd=' or '1'='1';
```

SQL 注入是利用某些系统没有对用户输入的数据进行充分的检查 ， 而在用户输
入数据中注入非法的 SQL 语句段或命令 ， 恶意攻击数据库 。
要防范 SQL 注入 ， 只要用 PreparedStatement( 从 Statement 扩展而来 ） 取
代 Statement 就可以了 

#### 2.java程序模拟SQL注入：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/10 9:20
 * @注释:java演示SQL注入
 */
public class Statement {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        //使用next()时当收到空格或者'时自动结束
        //如果希望看到SQL注入，这里需要使用nextLine()
        String name = input.nextLine();
        System.out.print("请输入密码：");
        String pwd = input.nextLine();
        //1.通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //2.注册驱动（可省略）
        Class.forName(driver);
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //4.创建Statement对象
        java.sql.Statement statement = connection.createStatement();
        //5.操作数据库
        //查询actor表
        String selectSql = "select name,pwd from admin where name='" + name + "'and pwd='" + pwd + "'";
        //6.执行sql语句并返回单个ResultSet对象
        ResultSet resultSet = statement.executeQuery(selectSql);
        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
        //8.关闭连接
        resultSet.close();
        statement.close();
        connection.close();
    }
}
```

终端：

```bash
请输入用户名：1' or
请输入密码： or '1'='1
```



### 五、PreparedStatement

----

#### 1.基本介绍

PreparedStatement 执行的 SQL 语句中的参数用问号 （?）来表示 ，调用PreparedStatement 对象的 setXxx()方法来设置这些参数.setXxx()方法有两个参数 ，第一个参数是要设置的 SQL 语句中的参数的索引（ 从 1 开始 ), 第二个是设置的 SQL 语句中的参数的值
调用 executeQuery() ， 返回 ResuItSet 对象
调用 executeUpdate() ：执行更新 ，包括增 、删 、修改

#### 2.预处理的好处

```markdown
* 不再使用 + 拼接 sql 语句 ， 减少语法错误
* 有效的解决了 sql 注入问题 ！
* 大大减少了编译次数 ， 效率较高
```

#### 3.应用实例：

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/10 9:20
 * @注释:java演示SQL注入
 */
public class PerparStatement {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入用户名：");
        //使用next()时当收到空格或者'时自动结束
        //如果希望看到SQL注入，这里需要使用nextLine()
        String name = input.nextLine();
        System.out.print("请输入密码：");
        String pwd = input.nextLine();
        //1.通过Properties对象获取配置文件信息
        Properties properties = new Properties();
        //读取文件
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        //获取用户名
        String user = properties.getProperty("user");
        //获取密码
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        //2.注册驱动（可省略）
        Class.forName(driver);
        //3.连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //4.操作数据库
        //查询actor表(sql语句里的？相当于占位符)
        String selectSql = "select name,pwd from admin where name=? and pwd=?";
        //5.创建PerparedStatement对象(PerparedStatement对象实现了PerparedStatement接口的实现类的对象)
        PreparedStatement preparedStatement = connection.prepareStatement(selectSql);
        //6.设置占位符（？）的位置及获取的字段名
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, pwd);
        //6.执行sql语句并返回单个ResultSet对象
        /*
        执行select语句使用executeQuery()
        执行update、insert、delete语句使用executeUpdate()
         */
        //executeQuery()里的参数无需再处理
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            System.out.println("登录成功！");
        } else {
            System.out.println("登录失败！");
        }
        //8.关闭连接
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
```

#### 4.使用PerparedStatement创建、插入、修改、删除、查询（练习）

题目：

![image-20230210150524400](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230210170138775-2073636866.png)

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/10 15:08
 * @注释:使用PerparedStatement创建、插入、修改、删除、查询
 */
public class PerparedStatementDml {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
        Scanner scanner = new Scanner(System.in);
        //创建Properties对象并获取配置文件信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/myjdbc/demo3/resource/jdbc.properties"));
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //注册Driver驱动
        Class.forName(driver);
        //连接数据库
        Connection connection = DriverManager.getConnection(url, user, password);
        //操作数据库
        //创建admin表
        String createSql = "create table admin (id int not null primary key auto_increment,username varchar(10),pwd varchar(10))";
        int createTable = connection.prepareStatement(createSql).executeUpdate();
        //向admin表插入数据
        String insertSql = "insert into admin values(null,?,?)";
        System.out.print("请输入用户名：");
        String username = scanner.nextLine();
        System.out.print("请输入密码：");
        String pwd = scanner.nextLine();
        PreparedStatement insPs = connection.prepareStatement(insertSql);
        insPs.setString(1, username);
        insPs.setString(2, pwd);
        int insertData = insPs.executeUpdate();
        System.out.println(insertData > 0 ? "插入数据成功" : "执行失败！");
        //修改admin表中username为tom的记录
        String updateSql = "update admin set username=? where username=?";
        System.out.print("请输入需要修改的用户名：");
        String oldname = scanner.nextLine();
        System.out.print("请输入新的用户名：");
        String newname = scanner.nextLine();
        PreparedStatement updPs = connection.prepareStatement(updateSql);
        updPs.setString(1, newname);
        updPs.setString(2, oldname);
        int updateData = updPs.executeUpdate();
        System.out.println(updateData > 0 ? "更新数据成功" : "执行失败！");
        //删除admin中的一条记录
        String deleteSql = "delete from admin where id=?";
        System.out.print("请输入需要删除的id：");
        int id = scanner.nextInt();
        PreparedStatement delPs = connection.prepareStatement(deleteSql);
        delPs.setInt(1, id);
        int deleteData = delPs.executeUpdate();
        System.out.println(deleteData > 0 ? "删除记录成功" : "执行失败！");
        //查询admin表中的所有记录
        String selectSql = "select id,username,pwd from admin";
        ResultSet resultSet = connection.prepareStatement(selectSql).executeQuery();
        while (resultSet.next()) {
            int ids = resultSet.getInt(1);
            String usernames = resultSet.getString(2);
            String pwds = resultSet.getString(3);
            System.out.println(ids + "\t" + usernames + "\t" + pwds);
        }
    }
}
```



### 六、封装 JDBCUtils

---

#### 1.说明

在jdbc操作中 ，获取连接和释放资源是经常使用到 ，可以将其封装成JDBC连接数据库的工具类 （JdbcUtiIs）

![image-20230211104002602](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230211150922609-11108462.png)

#### 2.实际使用使用工具类 JDBCUtils

##### 2-1.JdbcUtils

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/11 10:07
 * @注释:完成mysql数据库的连接与关闭
 */
public class JdbcUtils {
    //1.定义属性（需定义成static静态属性）
    //用户名
    private static String user;
    //密码
    private static String password;
    //数据库连接点
    private static String url;
    //驱动
    private static String driver;

    //2.初始化（static）
    static {
        //创建Properties对象
        Properties properties = new Properties();
        try {
            //读取配置文件信息
            properties.load(new FileInputStream("src/com/hspedu/resource/jdbc.properties"));
            //获取用户名
            user = properties.getProperty("user");
            //获取密码
            password = properties.getProperty("password");
            //获取数据库连接点
            url = properties.getProperty("url");
            //获取驱动
            driver = properties.getProperty("driver");
        } catch (IOException e) {
            /*
            注意：在实际开发中，需要这样处理
            1.将编译异常转成远行时异常
            2.这样调用者可以选择捕获该异常，也可以选择默认处理该异常，比较方便
             */
            throw new RuntimeException(e);
        }
    }

    //3.连接数据库，返回一个Connection连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //4.关闭连接（如果需要关闭连接，就传入需要关闭的对象，否则传入null）
    /*
    可能需要关闭的对象：
    1.关闭ResultSet结果集
    2.关闭Sataement或PreparedStatement
    3.关闭Connection
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
        //判断需要关闭的对象是否为空
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
```

##### 2-2.更新记录

```java
/**
 * 更新记录
 */
public static void upDate() {
    //1.创建Connection对象
    Connection connection = null;
    //2.创建PeoparedStatement对象
    PreparedStatement preparedStatement = null;
    //3.数据库操作
    String updateSql = "update actor set name=? where id=?";
    try {
        //4.得到连接
        connection = JdbcUtils.getConnection();
        //5.预处理SQL语句
        preparedStatement = connection.prepareStatement(updateSql);
        //6.处理占位符
        preparedStatement.setString(1, "志昂");
        preparedStatement.setInt(2, 2);
        //执行SQL语句并返回影响行数
        int update = preparedStatement.executeUpdate();
        System.out.println(update > 0 ? "更新记录成功" : "执行失败");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        //7.关闭连接
        JdbcUtils.close(null, preparedStatement, connection);
    }
}
```

##### 2-3.插入记录

```java
/**
 * 插入记录
 */
public static void inSert() {
    Scanner scanner = new Scanner(System.in);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String insertSql = "insert into admin values(null,?,?)";
    try {
        connection = JdbcUtils.getConnection();
        preparedStatement = connection.prepareStatement(insertSql);
        boolean flag = true;
        while (flag) {
            System.out.print("请输入用户名：");
            String user = scanner.nextLine();
            preparedStatement.setString(1, user);
            System.out.print("请输入密码");
            String pwd = scanner.nextLine();
            preparedStatement.setString(2, pwd);
            int insert = preparedStatement.executeUpdate();
            System.out.println(insert > 0 ? "插入记录成功" : "执行失败");
            System.out.print("是否继续添加记录(y/n)：");
            String w = scanner.next();
            if (!"y".equals(w)) {
                flag = false;
            }
            String dubug = scanner.nextLine();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        JdbcUtils.close(null, preparedStatement, connection);
    }
}
```

##### 2-4.删除记录

```java
/**
 * 删除记录
 */
public static void delEte() {
    Scanner scanner = new Scanner(System.in);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    String deleteSql = "delete from admin where username=?";
    try {
        connection = JdbcUtils.getConnection();
        preparedStatement = connection.prepareStatement(deleteSql);
        System.out.print("请输入需要删除的用户名：");
        String user = scanner.nextLine();
        preparedStatement.setString(1, user);
        int delete = preparedStatement.executeUpdate();
        System.out.println(delete > 0 ? "删除记录成功" : "执行失败");
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        JdbcUtils.close(null, preparedStatement, connection);
    }
}
```

##### 2-5.查询记录

```java
/**
 * 查询记录
 */
public static void selEct() {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String selectSql = "select id,username,pwd from admin";
    try {
        connection = JdbcUtils.getConnection();
        preparedStatement = connection.prepareStatement(selectSql);
        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String username = resultSet.getString(2);
            String pwd = resultSet.getString(3);
            System.out.println(id + "\t" + username + "\t" + pwd);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    } finally {
        JdbcUtils.close(resultSet, preparedStatement, connection);
    }
}
```



# 未完待续。。。。。。。

所有的笔记来源于：[韩顺平 (bilibili.com)](https://space.bilibili.com/651245581)
