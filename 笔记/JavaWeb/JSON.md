### 一、什么是JSON

---

JSON（JavaScript Object Notation）即js对象表示法，是一种数据交换格式，它使用 JavaScript 语法来描述数据对象，但是不依赖于任何编程语言或平台；JSON 是轻量级的、基于文本的、开放的，非常适合在网络中进行传输（ 数据交换指的是客户端和服务器之间的数据传递格式 ）

且它容易阅读和编写，同时计算机解析和编译时也是非常的简便，JSON采用完全独立于语言的文本格式，很多编程语言都支持（java、C、python等）

JSON是由键值对组成，并且由大括号包围，每个键由引号引起来，键和值之间使用**:**进行分割，多组值对之间使用**,**分隔

```
//js对象：			| 	//json对象：			|	//xml对象
var js_obj = {		  var json_obj = {			<user>
    name:"ss",			   "name":"ss",			 <name>ss</name>
}					  }							</user>
```

**开发模式：**`servlet + jsp + 域对象 ==> servlet+ajax+JSON`



### 二、JSON的使用

---

JSON本身是一个对象

#### 1.JSON的存在形式

1. 对象形式（JSON对象）

   ```javascript
   var json_obj = {
       "name":"ss",
   }
   ```

2. 字符串形式（JSON字符串）

   通常是一个数组

   ```javas
   var str='{"name":"ss"}';
   ```

#### 2.JSON的访问

```javascript
//对象.属性
json_obj.name;
```

#### 3.JSON对象与字符串的转换

parse()：字符串转JSON对象

stringify()：JSON对象转字符串

```javascript
// 字符串==>对象
var str_obj = JSON.parse(str);
// 对象==>字符串
var obj_str = JSON.stringify(json_obj);
```

注：访问时通常使用js的对象访问的方法，不建议对字符串进行访问，字符串需要转为对象



### 三、java对象与JSON字符串的转换

---

请求数据：后端处理需要java对象（JSON字符串 ==> java对象）

响应数据：前端处理需要JSON对象（java对象 ==> JSON字符串 ==> JSON对象）

API：GSON、fastJSON（推荐）等

#### 1.对象 <==> JSON

```java
Student student = new Student(1, "zs", "km");
//Java对象 ==> JSON字符串
String jsonString = JSON.toJSONString(student);
//JSON字符串 ==> java对象
Student parseObject = JSON.parseObject(jsonString, Student.class);
```

#### 2.Map <==> JSON

```java
HashMap<String, Object> map = new HashMap<String,Object>();
map.put("key1","zs");
map.put("key2","zz");
map.put("key3","zq");
map.put("key4","za");
//Map集合 ==> JSON字符串
String string = JSON.toJSONString(map);
//JSON字符串 ==> java对象
JSONObject jsonObject = JSONObject.parseObject(string);
//JSON字符串 ==> Map集合
Map parse = (Map) JSON.parse(string);
```



