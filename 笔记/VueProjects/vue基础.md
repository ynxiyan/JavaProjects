# [Vue基础](https://www.cnblogs.com/ynxiyan/p/17165201.html)

### 一、Vue的介绍与描述

---

Vue (读音 /vjuː/，类似于 **view**) 是一套用于构建用户界面的**渐进式框架**；与其它大型框架不同的是，Vue 被设计为可以自底向上逐层应用；Vue 的核心库只关注视图层，不仅易于上手，还便于与第三方库或既有项目整合（作者：尤雨溪）

```markdown
- 构建用户界面：把数据通过某种办法变成用户的界面
- 渐进式：Vue可以从底层向上逐层应用（简单应用只需要一个核心库，复杂应用引入各种各样的插件）
```



### 二、Vue的特点

---

```markdown
* 遵循MVVM模式
* 编码简洁体积小
* 运行效率高，适合移动/PC端开发
* 它本身只关注UI，可以引入第三方开发项目
* 采用组件化编程模式，提高代码复用率且代码更好维护
* 声明式编码，让编码人员无需操作DOM，提高开发效率
* 使用虚拟DOM和Diff算法，尽量的复用DOM节点
```

![image-20230228143719528](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230228170932315-819140020.png)



### 三、Vue的使用

---

#### 1.在HTML中使用

**this是Vue的实例**

1. 引入Vue

   ```javascript
   <!--引入vue-->
   <script src="https://cdn.jsdelivr.net/npm/vue@2/dist/vue.js"></script>
   ```

2. 创建容器

   ```html
   <!--准备vue容器-->
   <!--root容器中的代码我们称为Vue-->
   <div id="app">
   </div>
   ```

3. 创建Vue对象实例

   ```javascript
   // 创建vue实例
   new Vue({
       // 用于指定当前vue对象为哪个容器服务，值为id，我们称为root它依然遵循html规范只不过添加了一些vue语法
       el:'#app',
       // 用于存储数据，数据是提供给el指定的容器使用
       // data一旦更新，页面也会更新
       data:{
           name:'张三',
           address:'昆明',
       }
   });
   ```

4. 使用插值表达式渲染页面

   ```html
   <!--    插值表达式-->
   <!--    {{}}可以读取data里的数据-->
   <h4>姓名：{{name}}</h4>
   <h4>地址：{{address}}</h4>
   ```

#### 2.数据绑定（指令语法）

1. 单向数据绑定

   仅需要显示在页面上时使用

   ```html
   <!--    单向数据绑定v-bind 缩写:-->
   <a v-bind:href="list.url">{{list.name}}</a>
   ```

2. 双向数据绑定

   需要提交到服务器时使用（一般使用在表单上）

   - v-model默认绑定value属性

   ```html
   <!--    双向数据绑定v-model 缩写v-model=""-->
   <h4>姓名：<input v-model:value="name"/></h4>
   ```

#### 3.el和data的两种写法

1. 对象式

   ```java
   new Vue({
       el: '#app',
       data: {}
   });
   ```

2. 通过Vue对象挂载容器

   ```javascript
   const vue = new Vue({
       data: {}
   });
   vue.$mount('#app');
   ```

3. 函数式

   ```javascript
   new Vue({
       el: '#app',
       data: function () {
           return{};
       }
   });
   -----------------------------
   // 简写
   new Vue({
       el: '#app',
       data() {
           return{};
       }
   });
   ```

   

### 四、插值表达式与指令语法的使用环境

---

插值表达式：

- 插值表达式通常使用在标签中的文本上

指令语法：

- 指令语法退出使用在标签的属性上



### 五、MVVM的解析

---

```markdown
- M (Model):模型，data中的数据
- V (View):视图，id为app的容器中的所有东西
- VM (ViewModel):视图模型，Vue实例
```

data中所有的属性都会出现在VM上（Vue实例对象）；VM以及原型上的属性都可以在模板中使用



### 六、Vue的生命周期

---

生命周期：也叫钩子	生命周期钩子

![20200815191941397](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230228170931755-509607344.png)

图片来源于：[vue生命周期中文图_小妖王木木的博客-CSDN博客_vue生命周期图中文](https://blog.csdn.net/qq_44752978/article/details/108027024)

![image-20230228164030466](https://img2023.cnblogs.com/blog/2854528/202302/2854528-20230228170931268-1078130810.png)

#### 1.常用的生命周期钩子

```markdown
# mounted：发送ajax请求，启动定时器	绑定自定义事件等初始化操作
# beforeDestroy：清除定时器，取消一些占用资源等收尾工作
```

销毁以后页面的DOM和相关的事件依然有效