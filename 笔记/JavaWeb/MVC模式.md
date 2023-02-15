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
xxx.xxx.bean/pojo/entity/domain(存储数据类的包)
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

#### 2.MVC案例

##### 2-1.Model:

```java
/**
 * @Author: XIYAN
 * @Date: 2023/2/14 16:53
 * @注释:用于存储数据的类，new该类的对象即可存储一个对应数据库的一条记录
 */
@Data
public class Dogs {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
}
```

##### 2-2.Dao:

1. dao

- 接口

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/2/14 17:12
   * @注释:设计操作entity中对象应该有的功能
   */
  public interface DogsDao {
      /**
       * 新增
       *
       * @param dogs 传入新增的信息
       * @return 返回受影响的行数
       */
      int insertDogs(Dogs dogs);
  
      /**
       * 删除
       *
       * @param dogs 传入需要删除的Id
       * @return 返回受影响的行数
       */
      int deleteDogs(Dogs dogs);
  
      /**
       * 修改
       *
       * @param dogs 传入需要修改的信息
       * @param name 传入需要修改的名称
       * @return 返回受影响的行数
       */
      int updateDogs(Dogs dogs, String name);
  
      /**
       * 通过Id查询
       *
       * @param dogs 传入需要查询的Id
       * @return 返回查询的结果信息
       */
      Dogs selectDogsById(Dogs dogs);
  
      /**
       * 查询所有
       *
       * @return 返回查询的结果集信息
       */
      List<Dogs> selectDogsAll();
  
      /**
       * 模糊查询
       *
       * @param like 传入需要模糊查询的名称
       * @return 返回查询的结果集信息
       */
      List<Dogs> selectDogLike(String like);
  }
  ```

- 实现

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/2/14 17:24
   * @注释:DogsDao的实现类需要实现所有的抽象方法
   */
  public class DogsDaoImpl extends BasicDao implements DogsDao {
      @Override
      public int insertDogs(Dogs dogs) {
          String sql = "insert into dogs(name,sex,age) values(?,?,?)";
          return update(sql, dogs.getName(), dogs.getSex(), dogs.getAge());
      }
  
      @Override
      public int deleteDogs(Dogs dogs) {
          String sql = "delete from dogs where id=?";
          return update(sql, dogs.getId());
      }
  
      @Override
      public int updateDogs(Dogs dogs, String name) {
          String sql = "update dogs set name=?,sex=?,age=? where name=?";
          return update(sql, dogs.getName(), dogs.getSex(), dogs.getAge(), name);
      }
  
      @Override
      public Dogs selectDogsById(Dogs dogs) {
          String sql = "select id,name,sex,age from dogs where id=?";
          return selectOne(Dogs.class, sql, dogs.getId());
      }
  
      @Override
      public List<Dogs> selectDogsAll() {
          String sql = "select id,name,sex,age from dogs";
          return selectList(Dogs.class, sql);
      }
  
      @Override
      public List<Dogs> selectDogLike(String like) {
          String sql = "select id,name,sex,age from dogs where name like?";
          return selectList(Dogs.class, sql, like);
      }
  }
  ```

2. service

- 接口

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/2/15 11:20
   * @注释:逻辑层，只是调用了Dao，使其可以进行简单判断，但是一般换了一种叫法
   */
  public interface DogsService {
      boolean addDogs(Dogs dogs);
  
      boolean removeDogs(Dogs dogs);
  
      boolean modifyDogs(Dogs dogs, String name);
  
      Dogs getDogsById(Dogs dogs);
  
      List<Dogs> getDogsAll();
  
      List<Dogs> getDogLike(String like);
  }
  ```

- 实现

  ```java
  /**
   * @Author: XIYAN
   * @Date: 2023/2/15 11:26
   * @注释:DogsService实现类需要实现DogsService的所有抽象方法
   */
  public class DogsServiceImpl implements DogsService {
      private final DogsDao dogsDao = new DogsDaoImpl();
  
      @Override
      public boolean addDogs(Dogs dogs) {
          return dogsDao.insertDogs(dogs) > 0;
      }
  
      @Override
      public boolean removeDogs(Dogs dogs) {
          return dogsDao.deleteDogs(dogs) > 0;
      }
  
      @Override
      public boolean modifyDogs(Dogs dogs, String name) {
          return dogsDao.updateDogs(dogs, name) > 0;
      }
  
      @Override
      public Dogs getDogsById(Dogs dogs) {
          return dogsDao.selectDogsById(dogs);
      }
  
      @Override
      public List<Dogs> getDogsAll() {
          return dogsDao.selectDogsAll();
      }
  
      @Override
      public List<Dogs> getDogLike(String like) {
          return dogsDao.selectDogLike(like);
      }
  }
  ```

##### 2-3.controller:

后面补充。。。

##### 2-4.view：

后面补充。。。

# 未完待续。。。

