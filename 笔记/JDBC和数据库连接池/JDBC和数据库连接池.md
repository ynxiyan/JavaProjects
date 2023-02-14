# [JDBC和数据库连接池](https://www.cnblogs.com/ynxiyan/p/17106242.html)

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



### 七、数据库连接池

---

#### 1.传统获取Connection 问题分析

传统的JDBC数据库连接使用 DriverManager 来获取 ，每次向数据库建立连接的时候都要将 Connection 加载到内存中， 再验证IP地址、用户名和密码。需要数据库连接的时候，就向数据库要求一个 ，频繁的进行数据库连接操作将占用很多的系统资源 ，容易造成服务器崩溃 。
每一次数据库连接 ，使用完后都得断开 ，如果程序出现异常而未能关闭 ，将导致数据库内存泄漏 ，最终将导致重启数据库 。
传统获取连接的方式 ，不能控制创建的连接数量 ，如连接过多 ，也可能导致内存泄漏 ，MySQL崩溃 。
解决传统开发中的数据库连接问题 ，可以采用数据库连接池技术(connection pool)

**数据库连接池种类**

```markdown
- 1.JDBC 的数据库连接池使用 javax.sqI.DataSource 来表示 ，DataSource只是一个接口 ，该接口通常由第三方提供实现[提供.jar]
- 2.C3P0数据库连接池速度相对较慢稳定性不错 (hibernate, spring)
- 3.DBCP数据库连接池，速度相对C3P0较快 ，但不稳定
- 4.Proxool数据库连接池 ，有监控连接池状态的功能 ，稳定性较C3P0差一点
- 5.BoneCP 数据库连接池速度快
- 6.Druid( 德鲁伊 ）是阿里提供的数据库连接池 ，集 DBCP 、C3P0 、Proxool优点于一身的库连接池
```

![image-20230213183909411](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230213202909398-791560500.png)

#### 2.C3P0应用实例

##### 2-1.相关参数，在程序中指定 user, url , password 等

```java
public void testC3P0_One() throws IOException, PropertyVetoException, SQLException {
        //1.创建一个数据源对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        //2.通过配置文件获取连接信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/com/hspedu/resource/jdbc.properties"));
        //3.设置配置文件参数
        String url = properties.getProperty("url");
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        //4.给数据源comboPooledDataSource设置相关参数
        //注意连接管理是由comboPooledDataSource来管理
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //设置初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //设置最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        //得到连接（getConnection()就是从DataSource实现）
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
}
```

##### 2-2.使用配置文件模板来完成

前置操作
    1.将C3P0的配置文件放到src目录下
    2.设置配置文件的相关信息

c3p0-config.xml：

```xml
<c3p0-config>

  <named-config name="hsp_jdbc">
<!-- 驱动类 -->
  <property name="driverClass">com.mysql.jdbc.Driver</property>
  <!-- url-->
  	<property name="jdbcUrl">jdbc:mysql://127.0.0.1:3306/hsp_jdbc</property>
  <!-- 用户名 -->
  		<property name="user">root</property>
  		<!-- 密码 -->
  	<property name="password">123456</property>
  	<!-- 每次增长的连接数-->
    <property name="acquireIncrement">5</property>
    <!-- 初始的连接数 -->
    <property name="initialPoolSize">10</property>
    <!-- 最小连接数 -->
    <property name="minPoolSize">5</property>
   <!-- 最大连接数 -->
    <property name="maxPoolSize">10</property>

	<!-- 可连接的最多的命令对象数 -->
    <property name="maxStatements">5</property> 
    
    <!-- 每个连接对象可连接的最多的命令对象数 -->
    <property name="maxStatementsPerConnection">2</property>
  </named-config>
</c3p0-config>
```

```java
public void testC3P0_Two() throws SQLException {
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource("hsp_jdbc");
    Connection connection = comboPooledDataSource.getConnection();
    connection.close();
}
```

#### 3.Druid(德鲁伊)应用实例

前置操作
1.导入Druid.jar
2.将配置文件导入到src目录下


druid.properties:

```properties
#key=value
driverClassName=com.mysql.jdbc.Driver
url=jdbc:mysql://localhost:3306/hsp_jdbc?rewriteBatchedStatements=true
#url=jdbc:mysql://localhost:3306/girls
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

```java
public void test() throws Exception {
        //创建Properties对象
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));
        //创建一个指定对象的数据库连接池(Druid连接池)
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        connection.close();
}
```



### 八、将 JDBCUtils 工具类改成Druid(德鲁伊)实现

---

通过德鲁伊数据库连接池获取连接对象

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/13 19:41
 * @注释:基于Druid数据库连接池的工具类
 */
public class JdbcUtilsByDruid {
    //创建连接池对象
    private static DataSource dataSource;

    //在静态代码块初始化代码
    static {
        //创建Properties对象
        Properties properties = new Properties();
        //读取配置文件信息
        try {
            properties.load(new FileInputStream("src/druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //编写getConnection方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //编写colose方法
    /*
    注：
    在数据库连接池技术中并不是真正的关闭连接而是把使用的Connection对象放回连接池
     */
    public static void close(ResultSet resultSet, Statement statement, Connection connection) {
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

#### 1.实际使用使用工具类 JDBCUtilsByDruid

##### 1-1.更新记录

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
        connection = JdbcUtilsByDruid.getConnection();
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

##### 1-2.插入记录

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
        connection = JdbcUtilsByDruid.getConnection();
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

##### 1-3.删除记录

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
        connection = JdbcUtilsByDruid.getConnection();
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

##### 1-4.查询记录

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
        connection = JdbcUtilsByDruid.getConnection();
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



### 九、Apache—DBUtils

---

#### 1.分析问题

关闭 Connection 后 ，ResuItSet 结果集无法使用
ResuItSet 不利于数据的管理

![image-20230213175214567](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230213180938627-1989399548.png)

#### 2.基本介绍

commons-dbutils 是 Apache 组织提供的一个开源 JDBC（ 工具类库 ， 它是对 JDBC 的封装，使用 dbutils 能极大简化jdbc编码的工作量 。
DbUtiIs 类：

```markdown
* QueryRunner 类 ： 该类封装了 SQL 的执行 ， 是线程安全的 。 可以实现增 、 删 、 改 、 查 、 批处理
* 使用 QueryRunner 类实现查询
* ResultSetHandIer 接口：该接口用于处理 java.sqI.ResultSet, 将数据按要求转换为另一种形式
```

方法：

```markdown
 - update--插入、修改、删除，返回受影响的行数
 - insert--支持插入操作，获取自增列作为返回值
 - query--查询操作，自动处理ResultSet需要Handler的配合
```

![image-20230213202632803](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230213202909023-865548319.png)

#### 3.实际使用DBUtils

##### 3-1.插入记录

```java
public void testInsert() throws SQLException {
        //简化sql操作，结合Handler来处理常见的查询减少代码量
        QueryRunner queryRunner = new QueryRunner();
        //获取连接
        Connection connection = JdbcUtils.getConnection();
        String sql="insert into dogs values(null,?,?,?)";
        int update = queryRunner.update(connection, sql, "a", "公", 12);
        System.out.println(update);
        DbUtils.closeQuietly(connection);
}
```

##### 3-2.删除记录

```java
public void testDelete() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        String sql="delete from dogs where age>?";
        Connection connection = JdbcUtils.getConnection();
        int update = queryRunner.update(connection, sql, 10);
        System.out.println(update);
        DbUtils.closeQuietly(connection);
}
```

##### 3-3.查询记录（单条）

```java
public void testSelect() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="select id,name,sex,age from dogs where id=?";
        //执行sql的时候需要Handler对象，参数为查询到对象的class
        BeanHandler<Dogs> dogsBeanHandler = new BeanHandler<>(Dogs.class);
        Dogs dogs = queryRunner.query(connection, sql, dogsBeanHandler, 4);
        System.out.println(dogs);
        DbUtils.closeQuietly(connection);
}
```

##### 3-4.查询记录（多条）

```java
public void testSelectAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="select id,name,sex,age from dogs where id<?";
        BeanListHandler<Dogs> dogsBeanHandler = new BeanListHandler<>(Dogs.class);
        List<Dogs> dogsList = queryRunner.query(connection, sql, dogsBeanHandler, 10);
        dogsList.forEach(System.out::println);
        DbUtils.closeQuietly(connection);
}
```

##### 3-5.修改记录

```java
public void testupDate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        String sql="update dogs set age=? where name=?";
        int update = queryRunner.update(connection, sql, 19, "f");
        System.out.println(update);
        DbUtils.closeQuietly(connection);
}
```

##### 3-6.查询记录（聚合函数）

```java
public void testAggregate() throws SQLException {
        QueryRunner queryRunner = new QueryRunner();
        Connection connection = JdbcUtils.getConnection();
        //最大值
        String maxSql="select max(age) from dogs";
        ScalarHandler<Object> handler = new ScalarHandler<>();
        int max = (Integer) queryRunner.query(connection, maxSql, handler);
        System.out.println(max);
        DbUtils.closeQuietly(connection);
}
```

#### 4.再次分析问题（解决：抽象CRUD方法）

通过编写上述代码后相对于直接使用JdbcUtils简化了不少代码，但是我们发现代码重复量太高



### 十、抽象CRUD（BasicDao）

---

#### 1.分析问题

apache-dbutils+Druid 简化了JDBC开发 ，但还有不足 ：

```markdown
* SQL 语句是固定 ，不能通过参数传入 ，通用性不好 ，需要进行改进 ，更方便执行增删改查
* 对于 select 操作 ，如果有返回值 ，返回类型不能固定 ，需要使用泛型
* 将来的表很多 ，业务需求复杂 ，不可能只靠一个 Java 类完成
```

![image-20230213202821986](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230213202908116-300204625.png)

#### 2.基本说明

DAO ：data access object 数据访问对象这样的通用类 ，称为 BasicDao ，是专门和数据库交互的 ，即完成对数据库 （ 表 ） 的 crud 操作 。
在 BaiscDao 的基础上 ，实现一张表对应一个 Dao，更好的完成功能。

#### 3.BasicDAO 应用实例

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/13 15:28
 * @注释:BaseDao是所有针对数据库操作的基本类
 *  需要在里面设置一些通用方法来解决增删查改代码重复的问题
 */
public class BasicDao {
    //定义QueryRunner类型的属性，值为对象
    QueryRunner queryRunner = new QueryRunner();
    /**
     * 该方法是进行增删改的通用方法
     * @param sql     传入需要操作的sql
     * @param params  传入需要使用的值
     * @return        返回受影响的行数
     */
    public int update(String sql, Object... params) {
        //打开链接
        Connection connection = JdbcUtils.getConnection();
        try {
            //执行成功返回受影响的行数
            return queryRunner.update(connection, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭连接
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 根据传入的sql查询单个对象的方法
     * @param clazz    查询后要返回的对象
     * @param sql      查询单个对象的sql
     * @param params   sql参数
     * @return         查询到的对象
     * @param <T>      根据calzz得到一个泛型将这个泛型作为对象返回（属性与表字段相同）
     */
    public <T>T selectOne(Class<T> clazz,String sql,Object ... params){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     *
     * @param clazz     查询后要返回的对象
     * @param sql       查询的sql
     * @param params    sql参数
     * @return          查询到的对象
     * @param <T>       根据calzz得到一个泛型将这个泛型作为对象返回（属性与表字段相同）
     */
    public <T>List<T> selectList(Class<T> clazz,String sql,Object ... params){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }

    /**
     * 通用的聚合函数查询方法
     * @param sql       传入的sql
     * @param params    sql参数
     * @return          返回查询到的值
     */
    public Object selectAggregate(String sql,Object ... params){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection,sql,new ScalarHandler<>(),params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DbUtils.closeQuietly(connection);
        }
    }
}
```



所有的笔记来源于：[韩顺平 (bilibili.com)](https://space.bilibili.com/651245581)
