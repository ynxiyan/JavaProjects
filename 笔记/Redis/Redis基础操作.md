### 一、什么是Redis

---

一个开源的远程字典服务器，Remote dictionary server它是基于内存的数据库，常用作键值存储、缓存和消息队列等

Redis通常将全部数据存储在内存中，也可以不时的将数据写入硬盘实现持久化，但仅用于重新启动后将数据加载回内存

### 二、安装Redis

---

1. 下载redis

   ```http
   https://redis.io/download/
   ```

2. 解压文件

   ![image-20230327153205890](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327153205890.png)

3. 配置环境变量

   ![image-20230327153117351](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327153117351.png)

   ![image-20230327153143822](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327153143822.png)

4. 运行redis-server

   ![image-20230327153404131](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327153404131.png)

5. 运行redis-cli

   ![image-20230327153440542](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327153440542.png)

### 二、基本操作

---

#### 1. 数据库操作

redis默认有16个数据库，编号为0~15，且默认访问0号数据库

| 指令              | 说明                                                   |
| :---------------- | ------------------------------------------------------ |
| select 数据库编号 | 选择指定数据库                                         |
| dbsize            | 获取当前数据库键值对数量                               |
| flushdb           | 清空当前数据库                                         |
| flushall          | 清空所有数据库                                         |
| save              | 将数据保存至磁盘                                       |
| bgsave            | 将数据异步保存至磁盘 （ 后台 ： Background)            |
| lastsave          | 默认每两秒自动执行一次（获取最后一次成功保存的unix秒） |

#### 2. 通用数据操作

操作范围为当前数据库

| 指令                  | 说明                                              |
| --------------------- | ------------------------------------------------- |
| keys 格式             | 查看符合指定格式的 key ， * 为通配符              |
| exists key1  key2 ... | 查看是否存在一至多个指定的 key                    |
| type key              | 按 key 查看 value 的数据类型                      |
| del key1 key2 ...     | 按 key 删除一至多个键值对                         |
| rename key1 key2      | 重命名 key1 ， 如果 key2 已经存在 ， 其值会被覆盖 |
| renamenx key1 key2    | key2 不存在时重命名 key1                          |
| move key 数据库编号   | 按 key 将一个键值对移动到指定数据库               |
| copy key1 key2        | 将 key1 的值拷贝给 key2                           |

#### 3. 字符串操作

key-value，键-值

![image-20230327152809646](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327152809646.png)

| 指令                               | 说明                                                         |
| ---------------------------------- | ------------------------------------------------------------ |
| set key value                      | 添加 / 修改一个键值对<br/>EX(expire) ： 设置过期秒数<br/>PX ： 设置过期毫秒数<br/>EXAT ： 设置过期的unix秒<br/>PXAT ： 设置过期的unix毫秒<br/>NX ： 仅当成员不存在时添加成员<br/>KEEPTTL ： set时不重置<br/>XX：仅当成员存在时修改成员<br/>GET：修改一个键值对并返回原值，原值不存在则返回nil |
| get key                            | 按key获取value                                               |
| mset key1 value1  key2 value2 ...  | 添加 / 修改一至多个键值对                                    |
| mget key1 key2 ...                 | 按key获取一至多个value                                       |
| append key value                   | 在原有value后追加内容                                        |
| strlen key                         | 查看字符串长度                                               |
| getrange key 开始位置 结束位置     | 获取范围时 [startindex ， endindex] 的子串<br/>（index从0开始，-n表示倒数第n个字符） |
| msetnx key1 value1 key2 value2 ... | 批量版setnx                                                  |

如果字符串的内容是数值：

| 指令                   | 说明                                            |
| ---------------------- | ----------------------------------------------- |
| incr key               | 按key创建值为1的value，或使value增长(increase)1 |
| incrby key 整数值      | 按key使value增长(increase)给定数值              |
| incrbyfioat key 小数值 | 按key使value增长(increase)给定数值              |
| decr key               | 按key使value减小(decrease)1                     |
| decrby key 数值        | 按key使value减小(decrease)给定数值              |

临时键值对：

生存时间time to live，缩写为ttl，指键值对距离被删除的剩余秒数

如果重新set，生存时间(time to live，ttl)将被重置

| 指令               | 说明                                                         |
| ------------------ | ------------------------------------------------------------ |
| expire key 秒数    | 设定一个生存时间                                             |
| ttl key            | 查看生存时间的剩余秒数<br/>（key 不存在则返回-2 ， 永久键值对则返回-1） |
| pexpire key 毫秒数 | 毫秒版expire                                                 |
| pttl key           | 毫秒版ttl                                                    |
| persist key        | 持久化 （取消生存时间）                                      |

#### 4. 散列表Hash

key-field-value，键-字段-值

![image-20230327152750752](C:/Users/XIYAN/AppData/Roaming/Typora/typora-user-images/image-20230327152750752.png)

| 指令                                                         | 说明                                |
| ------------------------------------------------------------ | ----------------------------------- |
| hset key field1 value1 field2 vaIue2 ...<br/>（在老版本中hset设置单个字段和值 ，hmset设置多个字段合值） | 添加 / 修改一个键与一至多对字段和值 |
| hget key field                                               | 按key和field获取一对value           |
| hmget key field1 field2 ...                                  | 按key和field获取一至多对value       |
| hgetall key                                                  | 按key获取field获取全部的field-value |
| hdel key field1 field2 ...                                   | 删除一至多对field-value             |
| hsetnx key field value                                       | 仅在field不存在时添加一对field      |
| hkeys key                                                    | 查看一个散列表中所有的field         |
| hvals key                                                    | 查看一个散列表中所有的value         |
| hlen key                                                     | 统计一个散列表中有多少对field-value |
| hexists key field                                            | 查看一个field是否存在               |
| hstrlen key field                                            | 按key和field查看value的长度         |

如果value字符串的内容是数值：

| 指令                    | 说明                               |
| ----------------------- | ---------------------------------- |
| hincrby key 整数值      | 按key使value增长(increase)给定数值 |
| hincrbyfioat key 小数值 | 按key使value增长(increase)给定数值 |





















