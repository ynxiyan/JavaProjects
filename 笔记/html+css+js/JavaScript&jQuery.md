# [JavaScript&jQuery](https://www.cnblogs.com/ynxiyan/p/17157072.html)

### JavaScript

#### 一、什么是JavaScript

---

JavaScript是一种动态的编程语言。是基于对象和事件驱动的脚本语言，具有安全性可以用来在网页中添加交互功能和动态效果。

JavaScript的特点：

- 语法与java类似
- 边执行边解释

javas的组成：

- ECMAScript	js的核心语法	简称es
- DOM               文档对象模型
- BOM               浏览器对象模型



#### 二、JavaScript的使用

---

1. 在标签中使用

   ```html
   <input type="button" onclick="alert('按钮')" />
   ```

2. 引入JavaScript

   ```html
   <script src=""></script>
   ```

3. 内嵌式

   ```html
   <script type="text/javascript">
   
   </script>
   ```

##### 1.变量

```java
var--全局变量
let--局部变量
const--常量
```

##### 2.数据类型

```markdown
- number	数字（整数、小数）
- undefined	未定义类型（变量声明未赋值）
- String	字符串（不区分单个多个）
- Object	null表示对象为空
- boolean
```

##### 3.运算符

```markdown
* 算术运算符：+、-、*、/
* 一元运算符：++、--
* 赋值运算符：=、+=、-=、*=、/=
* 关系运算符:>、<、>=、<=、!=、==、===
* 三元运算符：条件表达式?true:false
* 逻辑运算符：&&、||、!
* +号转换
```

##### 4. 系统函数

```markdown
- parseInt()	转成数字
- parseFloat()	转成小数
- isNaN()	是否是非数字

- 匿名函数	对象.监听=function(){
  }
```

##### 5.常见对象

1. 基本对象

   ```javascript
   //Array--数组
   var arr1 = new Array("", "");
   var arr2 = ["", ""];
   //添加元素
   arr1.push(元素);
   //删除元素
   arr2.splice(开始位置，结束位置);
   ```

2. DOM对象

   ```javascript
   //获取当前资源地址
   document.URL;
   //判断非法访问
   document.referrer;
   //获取元素
   document.getElementById(唯一);
   document.getElementsByClassName(数组);
   document.getElementsByTagName(数组);
   //获取满足条件的元素
   document.querySelector(第一个元素);
   document.querySelectorAll(全部元素);
   ```

3. BOM对象

   JavaScript将浏览器的各个组成部分封装为一个个对象，这些对象具有一定的属性和函数，能够对各部分进行操作

   1. window	浏览器窗口对象
   
      不需要常见，调函数名直接使用
   
      ```javascript
      //对话框
      alert(标题);
      confirm(标题);
      prompt(标题，值);
      
      //定时函数
      setTimeout(操作,时间);   延迟执行
      setInterval(操作，时间);  间隔执行
      
      //打开窗口
      open();
      
      //关闭窗口
      colse();
      ```
   
   2. history	历史记录对象
   
      ```javascript
      //后退
      history.back();
      //前进
      history.forward();
      //跳转
      history.go();
      ```
   
   3. location	地址栏对象
   
   4. screen	屏幕对象
   
   5. navigator	浏览器

##### 6.常见事件（监听）

| 事件         | 说明         |
| ------------ | ------------ |
| onload       | 文档加载完成 |
| onclick      | 单击         |
| onmouseenter | 鼠标移入     |
| onmouseout   | 鼠标移出     |
| onfocus      | 获取光标     |
| onblur       | 失去光标     |

##### 7.属性操作

1. 获取属性

   ```javascript
   style.width
   ```

2. 获取属性值

   ```javascript
   getAttribute("需要获取的属性");
   ```

3. 设置属性值

   ```javascript
   setAttribute({"需要设置的属性":"需要设置的属性的值",});
   ```

4. 获取元素

   ```javascript
   //获取父元素
   parentNode
   //获取子元素
   childNodes
   //获取最后一个元素
   lastElementChild
   //获取第一个元素
   firstElementChild
   //获取下一个元素
   nextElementSibling
   //获取上一个元素
   previousElementSibling
   ```

##### 8.节点操作

```javascript
//创建节点
createElement(标签名);
//复制节点(true：复制属性与值；false：只复制标签)
cloneNode();
//插入节点(新节点，老节点)
insertBefore();
//删除节点(只有父元素才能删除)
removeChild();
//替换节点(新节点，老节点)
replaceChild();
//在末尾追加节点
appendChild();
```



#### 三、JavaScript正则表达式

---

正则表达式（英语：Regular Expression，在代码中常简写为regex、regexp或RE）使用单个字符串来

描述、匹配一系列符合某个句法规则的字符串搜索模式。

搜索模式可用于文本搜索和文本替换。

语法：

```javascript
var patt = /runoob/i
```

**/runoob/i** 是一个正则表达式。**runoob** 是一个**正则表达式主体** (用于检索)。**i** 是一个**修饰符** (搜索不区分大小写)



### jQuery

#### 一、什么是jQuery

---

jQuery 是一个 JavaScript 库，极大地简化了 JavaScript 编程

工厂函数：

$()作用：获取元素	创建元素	转换对象

js的优先级：

|          | window.onload    | $(document).ready() |
| -------- | ---------------- | ------------------- |
| 执行时机 | 整个网页加载完成 | 网页的结构加载完成  |
| 书写个数 | 有且仅有一个     | N个                 |
| 简写     | 无               | $(function(){})     |



#### 二、jQuery的使用

---

##### 1.常用函数

1. 获取元素

   ```javascript
   $("选择器名");
   ```

2. 添加样式

   ```javascript
   $("").css({"属性":"值",});
   ```

3. 添加类样式到元素

   ```javascript
   $().addClass("类名");
   ```

4. 移除样式

   ```\
   $().removeClass();
   ```

5. 隐藏元素

   ```javascript
   $().hide();
   ```

6. 显示元素

   ```javascript
   $().show();
   ```

7. 隐式迭代

   无需遍历直接赋值

8. 获取父元素

   能够获取到根元素

   ```javascript
   $().parents("需要获取的父元素");
   ```

9. 获取子元素

   ```javascript
   $().children("需要获取的子元素");
   ```

10. 获取后代元素

    ```javascript
    $().find("需要获取的后代元素");
    ```

11. 获取同级元素

    ```javascript
    //所有同级元素
    $().siblings("需要获取的同级元素");
    //下一个同级元素
    $().next();
    //后面的同级元素
    $().nextAll();
    //上一个同级元素
    $().prev();
    //前面的同级元素
    $().prevAll();
    ```

12. 过滤元素

    在一组元素中选出需要的元素

    ```javascript
    //首个元素
    $().first();
    //最后一个元素
    $().last();
    //选择某一个元素
    $().eq(元素位置);
    //获取满足的过滤元素
    $().filter("需要获取的元素");
    //需要排除元素
    $().not("需要排除的元素");
    ```

##### 2.选择器

1. 元素选择器

   ```javascript
   $("标签名");
   ```

2. id选择器

   ```java
   $("#id名");
   ```

3. 类选择器

   ```javascript
   $(".类名");
   ```

4. 属性选择器

   ```javascript
   $("p[name=名称]");
   ```

5. 偶数索引

   ```javascript
   $("p:even");
   ```

6. 奇数索引

   ```javascript
   $("p:odd");
   ```

##### 3.常见事件（监听）

| 事件                                   | 说明             |
| -------------------------------------- | ---------------- |
| ready(function(){}) 或 $(function(){}) | 文档加载完成     |
| click()                                | 单击             |
| show()                                 | 显示             |
| hide()                                 | 隐藏             |
| dblclick()                             | 双击             |
| mouseenter()[仅自身] 或 mouseover()    | 鼠标移入         |
| mouseleave()[仅自身] 或 mouseout()     | 鼠标移出         |
| mousedown()                            | 鼠标按下         |
| mouseup()                              | 鼠标弹起         |
| focus()                                | 获取光标         |
| blur()                                 | 失去光标         |
| keydown()                              | 键盘按下         |
| keyup()                                | 键盘弹起         |
| keypress()                             | 键盘按下产生字符 |

键盘提交：

```javascript
//event称为事件对象：表示当前触发事件的源对象
//keyCode=13:表示键盘的回车
if(event.keyCode == 13){
    alert("提交");
}
```

##### 4.文档或窗口事件：

| 事件     | 说明                         |
| -------- | ---------------------------- |
| load()   | 文档加载完成                 |
| scroll() | 用户滚动（滚动某元素时触发） |
| resize() | 调整窗口                     |
| unload   | 用户离开窗口                 |

事件绑定：

| 事件     | 写法                                                         | 说明         |
| -------- | ------------------------------------------------------------ | ------------ |
| bind()   | $().bind({<br/>			click: function() {},<br/>			mouseover:function(){},<br/>		}); | 绑定多个事件 |
| on()     | $().on(<br/>			"click", function() {},<br/>			"mouseover",function(){},<br/>		); | 绑定多个事件 |
| unbind() | $().unbind("click");                                         | 解绑多个事件 |

##### 5.复合事件

| 事件          | 语法                                                         | 说明               |
| ------------- | ------------------------------------------------------------ | ------------------ |
| toggle()      | $().toggle(时间, "缓动函数", "回调函数");                    | 显示或隐藏         |
| toggleClass() | $().toggleClass("类名");                                     | 添加样式或移除样式 |
| fadeToggle()  | $().fadeToggle(时间, "缓动函数", "回调函数");                | 淡入或淡出         |
| slideToggle() | $().slideToggle(时间, "缓动函数", "回调函数");               | 滑入或滑出         |
| animate()     | $().animate({<br/>			"需要改变的属性": "需要改变的值",<br/>		}, 时间); | 动画               |
| stop()        | $().stop(状态(true / false), 最终位置(true / false));        | 停止               |
| hover()       | $().hover();                                                 | 移入或移出         |

##### 6.内容操作

1. 双标签获取、设置值

   ```javascript
   $().html("值");	包含原格式
   $().text("值");	仅文本
   ```

2. 表单获取、设置值

   ```javascript
   $().val();
   ```

##### 6.节点操作

1. 创建节点

   注意：创建完成后还需实现插入操作

   ```javascript
   var $newNode = $("<li>需要插入的内容</li>");
   ```

2. 插入节点

   - 内部插入：

     append()追加到末尾

     appendTo()通过索引追加到末尾

     ```javascript
     $().append($newNode);
     ---------------------------
     $newNode.appendTo($());
     ```

     prepend()追加到首部

     prependTo()通过索引追加到首部

     ```javascript
     $().prepend($newNode);
     ---------------------------
     $newNode.prependTo($());
     ```
   
   - 外部插入
   
     after()、insertAfter()追加到元素外面（后面）
   
     ```javascript
     $().after($newNode);
     -----------------------
     $newNode.insertAfter($());
     ```
     
     before()、insertBefore()追加到元素外面（前面）
     
     ```javascript
     $().before($newNode);
     -------------------------
     $newNode.insertBefore($());
     ```

3. 复制节点

   true：仅复制标签

   false：包含属性、事件

   ```javascript
   $().clone(true);
   ```

4. 删除、清空节点

   删除：

   ```javascript
   $().remove();
   ```

   清空：

   ```javascript
   $().empty();
   ```

5. 替换节点

   ```javascript
   $().replaceWith($newNode);
   -----------------------------
   $newNode.replaceAll($());
   ```

##### 7.属性操作

1. 获取属性

   ```javascript
   $().attr("需要获取的属性");
   ```

2. 设置属性

   ```javascript
   $().attr({"需要设置的属性": "需要设置的属性的值"});
   ```

3. 移除属性

   ```javascript
   $().removeAttr("需要移除的属性");
   ```

4. 获取索引

   ```javascript
   $().index(元素索引);
   ```

   

### JavaScript对象与jQuery对象的转换

---

jQuery本质上也是JavaScript但是jQuery是JavaScript的封装框架，很多原生的方法没有JavaScript多，有的时候我们需要将jQuery转为JavaScript或者是将JavaScript转为jQuery对象来完成方法的调用

JavaScript => jQuery

```javascript
var $div = document.getElementsByTagName("div");
$($div);
```

jQuery => JavaScript

```javascript
var $divEle = $("#div");
$divEle.get(元素索引); 或 var a = $divEle[元素索引];
```
