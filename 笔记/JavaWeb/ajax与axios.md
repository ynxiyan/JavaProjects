# [ajax与axios](https://www.cnblogs.com/ynxiyan/p/17148758.html)

### Ajax

#### 一、什么是ajax请求

---

AJAX是异步JavaScript和XML的缩写，它不是一种编程语言，而是一种使用现有标准的新方法，可以在**不重新加载整个页面**的情况下，**与服务器交换数据并更新部分网页内容**；可以使用AJAX请求从服务器获取数据，或者向服务器发送数据，AJAX请求可以使用GET或POST方法，可以是**同步或异步**的

理解异步：浏览器发送请求给服务器，在服务器处理请求的过程中，浏览器某个部分还可以发起请求
或其他操作

```markdown
- 通过浏览器调用js异步发起请求，浏览器地址不会发生变化，实现局部更新而不舍弃原来页面的内容
```



#### 二、ajax的使用

---

1. 创建对象

   ```javascript
   var xmlhttp;
   if (window.XMLHttpRequest)
   {// code for IE7+, Firefox, Chrome, Opera, Safari
       xmlhttp=new XMLHttpRequest();
   }
   else
   {// code for IE6, IE5
       xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
   }
   ```

2. 发起请求

   - method：请求的类型；GET 或 POST
   - url：文件在服务器上的位置
   - async：true（异步）或 false（同步）

   ```javascript
   xmlhttp.open("GET","http://localhost:8080/maven_ajax/ajax",true);
   // 发起ajax请求
   xmlhttp.send();
   ```

3. 获取响应

   服务器给ajax请求响应以后监听的事件

   - OK	4或200
   - responseText	获得字符串形式的响应数据
   - responseXML	获得 XML 形式的响应数据

   ```javascript
   xmlhttp.onreadystatechange=function()
   {
       if (xmlhttp.readyState==4 && xmlhttp.status==200)
       {
           document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
       }
   }
   ```



### Axios

#### 一、axios 是什么?

---

Axios 是一个基于 *[promise](https://javascript.info/promise-basics)* 网络请求库，作用于[`node.js`](https://nodejs.org/) 和浏览器中。 它是 *[isomorphic](https://www.lullabot.com/articles/what-is-an-isomorphic-application)* 的(即同一套代码可以运行在浏览器和node.js中)；在服务端它使用原生 node.js `http` 模块, 而在客户端 (浏览端) 则使用 XMLHttpRequests



#### 二、axios的使用

---

1. 安装

   使用 npm:

   ```bash
   $ npm install axios
   ```

   使用 jsDelivr CDN:

   ```html
   <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
   ```

2. GET请求

   ```javascript
   axios({
       //指定请求方式
       method: "get",
       //请求地址及参数
       url: "http://localhost:8080/maven_ajax/ajax?username=" + uservalue,
       //响应后的处理
   }).then(function (response) {
       //处理结果
       }
   });
   ```

3. POST请求

   ```javascript
   axios({
       //指定请求方式
       method: "post",
       //请求地址
       url: "http://localhost:8080/maven_ajax/ajax",
       //数据
       data: "username=" + uservalue,
       //响应后的处理
   }).then(function (response) {
       //处理结果
   });
   ```

   



