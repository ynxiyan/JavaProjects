# [Vue2](https://www.cnblogs.com/ynxiyan/p/17252877.html)

### 一、前端MVVM模式及Axios异步通信

---

#### 1. 什么是MVVM

![image-20230324142553899](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230324173657317-1902717791.png)

MVVM（Model-View-ViewModel）是一种软件架构设计模式，由微软 WPF（用于替代WinForm，以前就是用这个技术开发桌面应用程序的）和Silverlight（类似于JavaApplet，简单点说就是在浏览器上运行的 WPF）的架构师Ken Cooper和Ted Peters开发，是一种简化用户界面的事件驱动编程方式；由 John Gossman（同样也是WPF和Silverlight的架构师）于2005年在他的博客上发表

MVVM源自于经典的MVC（Model-View-Controller）模式（期间还演化出了MVP（Model-ViewPresenter）模式）

MVVM的核心是ViewModel层，负责转换Model中的数据对象来让数据变得更容易管理和使用，其作用如下：

- 该层向上与视图层进行双向数据绑定
- 向下与 Model 层通过接口请求进行数据交互

#### 2. 为什么使用MVVM

MVVM模式和MVC模式一样，主要目的是分离视图（View）和模型（Model），有几大好处：

- 低耦合： 视图（View）可以独立于Model变化和修改，一个ViewModel可以绑定到不同的View上，当View变化的时候Model可以不变，当Model变化的时候View也可以不变
- 可复用： 你可以把一些视图逻辑放在一个ViewModel里面，让很多View重用这段视图逻辑
- 独立开发： 开发人员可以专注于业务逻辑和数据的开发（ViewModel），设计人员可以专注于页面设计
- 可测试： 界面素来是比较难于测试的，而现在测试可以针对 ViewModel 来写

#### 3. 为什么要使用 Axios

由于Vue.js是一个视图层框架并且作者（尤雨溪）严格遵守SoC （关注度分离原则），所以Vue.js并不包含AJAX的通信功能，为了解决通信问题，作者单独开发了一个名为vue-resource的插件，不过在进入2.0 版本以后停止了对该插件的维护并推荐了Axios框架

1. npm安装

   ```bash
   npm install axios
   ```

2. 在mian.js里使用axios

   ```bash
   Vue.prototype.axios = axios;
   ```



### 二、MVVM模式的实现者

---

Vue.js就是MVVM中的ViewModel层的实现者，在MVVM架构中，是不允许数据和视图直接通信的，只能通过ViewModel来通信，而ViewModel就是定义了一个Observer观察者：

- ViewModel能够观察到数据的变化，并对视图对应的内容进行更新
- ViewModel能够监听到视图的变化，并能够通知数据发生改变

![image-20230324143341538](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230324173656934-306966638.png)



### 三、核心要素

---

1. 数据驱动

   ![image-20230324143922767](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230324173656477-1748954817.png)

   当你把一个普通的JavaScript对象传给Vue实例的data选项，Vue将遍历此对象所有的属性，并使用 Object.defineProperty把这些属性全部转为getter/setter

   **注：**这些getter/setter对用户来说是不可见的

   每个组件实例都有相应的watcher实例对象，它会在组件渲染的过程中把属性记录为依赖，之后当依 赖项的setter被调用时，会通知watcher重新计算，从而致使它关联的组件得以更新

2. 组件化

- 页面上每个独立的可交互的区域视为一个组件
- 每个组件对应一个工程目录，组件所需的各种资源在这个目录下就近维护 页面不过是组件的容器，
- 组件可以嵌套自由组合（复用）形成完整的页面



### 四、组件基础

---

#### 1. 什么是组件

组件是可复用的Vue实例，说白了就是一组可以重复使用的模板，跟JSTL的自定义标签、 Thymeleaf的 th:fragment以及Sitemesh3框架有着异曲同工之妙；通常一个应用会以一棵嵌套的 组件树的形式来组织：

![image-20230324145349648](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230324173656016-645677978.png)

#### 2. 组件入门

1. 使用Vue.component()方法注册组件：

   ```html
   <div id="app"> 
       <ul>
           <component-li v-for="item in items" v-bind:item="item"></component-li> 
       </ul> 
   </div>
   ```

   ```javascript
   // 定义一个名为component-li的组件
   // 别名,{模板}
   Vue.component('component-li',{ 
       template:'<li>Hello li</li>'
   }) 
   var app = new Vue({ 
       el:'#app',
   }) 
   ```

   **注意：**在实际开发中，我们并不会用以下方式开发组件，而是采用vue-cli创建.vue模板文件的方式开发

2. 使用props属性传递参数：

   **注意：**默认规则下 props 属性里的值不能为大写

   ```javascript
   // 定义一个名为component-li的组件 
   Vue.component('component-li',{ 
       props:['item'], 
       template:'<li>Hello {{item}}</li>'
   }) 
   var app = new Vue({ 
       el:'#app', 
       data:{ items:['古力娜扎','迪丽热巴','玛尔扎哈']
            }
   })
   ```



### 五、插槽

---

Vue实现了一套内容分发的API，这套API的设计灵感源自Web Components规范草案，将\<slot>元素作为承载分发内容的出口

**\<slot>元素是一个插槽出口 (slot outlet)，标示了父元素提供的插槽内容 (slot content) 将在哪里被渲染**

插槽入门：

```html
<div id="app">
    <todo>
        <todo-title slot='todo-title' v-bind:title="title"></todo-title> 
        <todo-items slot='todo-items' v-for="item in items" v-bind:item="item">
        </todo-items> 
    </todo>
</div>
```



### 六、vue-cli

---

#### 1. 什么是 vue-cli

vue-cli官方提供的一个脚手架（预先定义好的目录结构及基础代码，咱们在创建Maven项目时可以选择创建一个骨架项目，这个骨架项目就是脚手架），用于快速生成一个vue的项目模板

主要功能：

- 统一的目录结构
- 本地调试
- 热部署
- 单元测试
- 集成打包上线

#### 2. 安装 vue-cli

**前置操作，安装安装 Node.js**

```http
http://nodejs.cn/download
```

1. 安装淘宝镜像

   ```bash
   npm i -g cnpm --registry=https://registry.npm.taobao.org
   ```

2. 安装vue的脚手架工具

   ```bash
   npm i -g vue-cli
   ```

3. 测试

   ```bash
   vue list
   ```

4. 创建一个基于 webpack 模板的 vue 应用程序

   ```bash
   vue init webpack 项目名
   //示例
   ? Project name vuetest
   ? Project description A Vue.js project
   ? Author LayGranger <yn.xiyan@.qq.com>
   ? Vue build standalone
   ? Install vue-router? Yes
   ? Use ESLint to lint your code? No
   ? Set up unit tests No
   ? Setup e2e tests with Nightwatch? No
   ? Should we run `npm install` for you after the project has been created? (recommended) npm
   ```

   **说明：**

   - Project name：项目名称，默认回车即可 
   - Project description：项目描述，默认回车即可 
   - Author：项目作者，默认回车即可 
   - Install vue-router：是否安装vue-router
   - Use ESLint to lint your code：是否使用ESLint做代码检查，选择n不安装（后期需要再手动添加） 
   - Set up unit tests：单元测试相关，选择n不安装（后期需要再手动添加） 
   - Setup e2e tests with Nightwatch：单元测试相关，选择n不安装（后期需要再手动添加） 
   - Should we run npm install for you after the project has been created：创建完成后直接初始化

#### 3. Vue-cli目录结构

| 目录            | 描述                                                         |
| --------------- | ------------------------------------------------------------ |
| build 和 config | WebPack 配置文件                                             |
| node_modules    | 用于存放 npm install 安装的依赖文件                          |
| src             | 项目源码目录                                                 |
| static          | 静态资源文件                                                 |
| .babelrc        | Babel 配置文件，主要作用是将 ES6 转换为 ES5                  |
| .editorconfig   | 编辑器配置                                                   |
| eslintignore    | 需要忽略的语法检查配置文件                                   |
| .gitignore      | git 忽略的配置文件                                           |
| .postcssrc.js   | css 相关配置文件，其中内部的module.exports是NodeJS模块化语法 |
| index.html      | 首页，仅作为模板页，实际开发时不使用                         |
| package.json    | 项目的配置文件                                               |

**package.json：项目的配置文件**

- name：项目名称
- version：项目版本
- description：项目描述
- author：项目作者
- scripts：封装常用命令
- dependencies：生产环境依赖
- devDependencies：开发环境依赖

#### 4. vue-cli src目录

1. main.js

   项目的入口文件，我们知道所有的程序都会有一个入口

   ```js
   // The Vue build version to load with the `import` command // (runtime-only or standalone) has been set in webpack.base.conf with an alias. 
   import Vue from 'vue' 
   import App from './App'
   Vue.config.productionTip = false
   /* eslint-disable no-new */ 
   new Vue({ 
       el: '#app', 
       components: { App }, 
       template: '<App/>'
   })
   ```

   | 语句                             | 描述                                                         |
   | -------------------------------- | ------------------------------------------------------------ |
   | import Vue from 'vue'            | ES6 写法，会被转换成 require("vue"); （require 是 NodeJS 提供 的模块加载器） |
   | import App from './App'          | 意思同上，但是指定了查找路径，./ 为当前目录                  |
   | Vue.config.productionTip = false | 关闭浏览器控制台关于环境的相关提示                           |

   **new Vue({...})：**实例化 Vue

   - el: '#app'：查找 index.html 中 id 为 app 的元素
   - template: '\<App/>'：模板，会将 index.html 中\<div id="app">\<div> 替换为\<App/>
   - components: { App }：引入组件，使用的是 import App from './App' 定义的 App 组 件

2. App.vue

   ```vue
   <template> 
   <div id="app"> 
       <img src="./assets/logo.png"> 
       <HelloWorld/>
       </div> 
   </template>
   <script> 
       import HelloWorld from './components/HelloWorld'
       export default { 
           name: 'App', 
           components: { 
               HelloWorld
           }
       } 
   </script>
   <style> 
       #app { 
           font-family: 'Avenir', 
               Helvetica, Arial, sans-serif; 
           -webkit-font-smoothing: antialiased; 
           -moz-osx-font-smoothing: grayscale; 
           text-align: center; 
           color: #2c3e50; 
           margin-top: 60px;
       } 
   </style>
   ```

   | 标签                                             | 描述                                                        |
   | ------------------------------------------------ | ----------------------------------------------------------- |
   | template                                         | HTML 代码模板，会替换 \<App /> 中的内容                     |
   | import HelloWorld from './components/HelloWorld' | 引入 HelloWorld 组件，用于替换 template 中的 \<HelloWorld/> |

   **export default{...}：**导出 NodeJS 对象，作用是可以通过import关键字导入 

   - name: 'App'：定义组件的名称
   - components: { HelloWorld }：定义子组件



### 七、Webpack

---

本质上，webpack是一个现代JavaScript应用程序静态模块打包器(module bundler)；当webpack处理应用程序时，它会递归地构建一个依赖关系图(dependency graph)，其中包含应用程序需要的每个模 块，然后将所有这些模块打包成一个或多个bundle

1. 安装webpack

   ```bash
   npm install webpack -g
   npm install webpack-cli -g
   ```

2. 配置

   创建webpack.config.js

   ```js
   module.exports = { 
       entry: "", 
       output: { 
           path: "", 
           filename: ""
       }, 
       module: { 
           loaders: [ {
               test: /\.js$/, loader: ""
           }
                    ]
       }, 
       plugins: {}, 
       resolve: {}, 
       watch: true
   }
   ```

   | 属性    | 描述                                              |
   | ------- | ------------------------------------------------- |
   | entry   | 入口文件，指定 WebPack 用哪个文件作为项目的入口   |
   | output  | 输出，指定 WebPack 把处理完成的文件放置到指定路径 |
   | module  | 模块，用于处理各种类型的文件                      |
   | plugins | 插件，如：热更新、代码重用等                      |
   | resolve | 设置路径指向                                      |
   | watch   | 监听，用于设置文件改动后直接打包                  |

3. 执行

   ```bash
   # 直接打包
   webpack
   # 用于监听变化 
   webpack --watch
   ```



### 八、vue-router

---

#### 1. 什么是vue-router

Vue Router 是 Vue.js 官方的路由管理器；它和 Vue.js 的核心深度集成，让构建单页面应用变得易如反 掌。包含的功能有：

- 嵌套的路由/视图表
- 模块化的、基于组件的路由配置
- 路由参数、查询、通配符
- 基于Vue.js过渡系统的视图过渡效果
- 细粒度的导航控制
- 带有自动激活的CSSclass的链接
- HTML5历史模式或hash模式，在IE9中自动降级
- 自定义的滚动条行为

#### 2.vue-router的使用

**? Install vue-router? No时才需要安装**

1. 安装路由

   ```bash
   npm install vue-router -S
   ```

2. 在src内新建router目录添加index.js作为总路由

   ```js
   // 引入依赖
   import Vue from 'vue'
   import VueRouter from 'vue-router'
   import HelloWorld from '@/components/HelloWorld'
   
   // 使用路由中间件
   Vue.use(VueRouter)
   
   //暴露
   export default new Router({
       routes: [
           {
               path: '/',
               name: 'HelloWorld',
               component: HelloWorld
           }
       ]
   })
   ```

3. 在mian.js中引入刚刚改好的index.js文件并添加到vue实例中

   ```js
   ···
   import router from './router'
   
   ···
   
   new Vue({
       ...
       router,
       ···
   }
   ```

4. 在app.vue中添加路由出口\<router-view>\</router-view> 这是一个会变的组件 url不同 他就变成不同的组件变化的规则就是路由表的内容

   ```vue
   <template>
   <div id="app">
       <!-- <img alt="Vue logo" src="./assets/logo.png">
   <HelloWorld msg="Welcome to Your Vue.js App"/> -->
   
       <!-- 路由视图图 -->
       <router-view></router-view>
       </div>
   </template>
   ```

5. router-link：默认会被渲染成一个\<a>标签，to属性为指定链接
6. router-view：用于渲染路由匹配到的组件
7. router和route的区别：
   - router是全局路由对象，负责全局事务，可以用来跳转等，除了routes还有其他的属性和方法
   - route是局部路由对象，当前页面或组件的路由，用来获取信息

#### 3.嵌套路由

嵌套路由又称子路由，在实际应用中，通常由多层嵌套的组件组合而成；同样地，URL 中各段动态路径 也按某种结构对应嵌套的各层组件，例如：

![image-20230327092021606](https://img2023.cnblogs.com/blog/2854528/202303/2854528-20230327113452377-815580533.png)

子路由配置：

```js
{
    // 首页 
    path:'/main', 
    name:'Main', 
    component:Main, 
    // 嵌套路由 
    children:[{
        // 会员等级 
        path:'/members/level', 
        name:'MemberLevel', 
        component:MemberLevel
    }, {
        // 会员列表 
        path:'/members/list',
        name:'MemberList',
        component:MemberList 
    }] 
}
```

**说明：**主要在路由配置中增加了 children 数组配置，用于在该组件下设置嵌套路由

View：

```vue
<template>
  <div id="app">
    <router-link to="test">test</router-link>
    <router-view/>
  </div>
</template>
```

**说明：**

- 在元素中配置了\<router-view />用于展示嵌套路由
- 使用\<router-link to="/members/list">会员列表\</router-link>跳转需要显示的嵌套路由内容

#### 4.参数传递

我们经常需要把某种模式匹配到的所有路由，全都映射到同个组件，例如，我们有一个 User 组件，对 于所有 ID 各不相同的用户，都要使用这个组件来渲染；此时我们就需要传递参数

1. 使用路径匹配的方式

   - 配置路由

     ```js
     {
         // 会员等级 
         path:'/members/level/:id', 
         name:'MemberLevel', 
         component:MemberLevel
     }
     ```

     **说明：**主要是在path属性中增加了:id占位符

   - 传递参数

     - router-link

       ```vue
       <router-link :to="{name:'MemberLevel',params:{id:2}}">会员等级</router-link>
       ```

     **说明：**此时将 to改为 :to，是为了将这一属性当成对象使用，注意router-link中的name属性名称一定要和路由中的name属性名称匹配，因为这样Vue才能找到对应的路由路径

     - 代码方式

       ```javascript
       this.$router.push({ name: 'MemberLevel', params: {id: 2}});
       ```

   - 接收参数

     ```vue
     {{ $route.params.id }}
     ```

2. 使用props的方式

   - 配置路由

     ```js
     {
         path: '/member/level/:id', 
         name:'MemberLevel', 
         component: UserProfile, 
         props: true
     }
     ```

     **说明：**主要增加了 props: true 属性

   - 传递参数

     **与第一种方法一致**

   - 接收参数

     ```vue
     <template>
     <div id="app">
         {{ id }}
         </div>
     </template>
     <script>
         export default { 
             props: ['id'], 
             name: "MemberLevel"
         }
     </script>
     ```

#### 5. 路由重定向

Vue中的重定向是作用在路径不同但组件相同的情况下

1. 普通重定向

   - 配置路由

     ```js
     {
         path: '/main', 
         name: 'Main', 
         component: Main
     }, 
     {
         path: '/goMain', 
         redirect: '/main'
     }
     ```

   - 定义重定向

     ```vue
     <router-link to="/goMain">回到首页</router-link>
     ```

   **说明：**这里定义了两个路径，一个是 /main ，一个是 /goMain，其中 /goMain 重定向到了 /main 路径，由此可以看出重定向不需要定义组件

2. 带参数重定向

   - 配置路由

     ```js
     {
         // 首页 
         path: '/main/:name', 
         name: 'Main', 
         component: Main
     }, 
     {
         path: '/goMain/:name', 
         redirect: '/main/:name'
     }
     ```

   - 定义重定向

     ```vue
     <router-link to="/goMain/admin123">回到首页</router-link>
     ```

#### 6. 路由模式与404处理

1. 路由模式

   路由模式有两种：

   - hash：路径带 # 符号，如 http://localhost/#/login
   - history：路径不带 # 符号，如 http://localhost/login

   ```js
   export default new Router({ 
       mode: 'history', 
       routes: [ ]
   });
   ```

2. 404处理

   ```js
   {
       path: '*', 
       component: NotFound
   }
   ```

#### 7. 路由钩子

- beforeRouteEnter：在进入路由前执行
- beforeRouteLeave：在离开路由前执行

```javascript
export default{ 
    props:['id'], 
    name:'MemberLevel', 
    beforeRouteEnter: (to,from,next) => { 
        console.log("进入会员等级页面"); 
        next(vm=>{});
    }, 
    beforeRouteLeave:(to,from,next)=>{ 
        console.log("离开会员等级页面"); 
        next(vm=>{});
    } 
}
```

**注意：**在该方法调用时Vue实例还没有创建，此时无法获取到this对象，需要使用官方提供的回调函数（vm）拿到当前实例

**参数说明：** 

- to：路由将要跳转的路径信息
- from：路径跳转前的路径信息
- next：路由的控制参数
  - next() 跳入下一个页面
  - next('/path') 改变路由的跳转方向，使其跳到另一个路由
  - next(false) 返回原来的页面
  - next((vm)=>{}) 仅在 beforeRouteEnter 中可用，vm 是组件实例



### 九、vuex

---

Vuex 是一个专为 Vue.js 应用程序开发的 状态管理模式。它采用集中式存储管理应用的所有组件的状 态，并以相应的规则保证状态以一种可预测的方式发生变化

1. npm安装

   ```bash
   npm install vuex -S
   ```

2. 在mian.js里使用Vuex

   ```js
   import Vuex from 'vuex'
   Vue.use(Vuex);
   ```

#### 1. Vuex入门（使用钩子）

main.js：

```javascript
// 路由跳转前执行 
router.beforeEach((to,from,next)=>{ 
    // 获取用户登录状态 
    let isLogin = sessionStorage.getItem('isLogin');
    // 注销 
    if(to.path=='/logout'){ 
        // 清空 
        sessionStorage.clear();
        // 跳转到登录页面 
        next({path:'/login'});
    }
    else if(to.path=='/login'){ 
        if(isLogin != null){ 
            next({path:'/main'});
        }
    }
    else if(isLogin == null){ 
        next({path:'/login'});
    } 
    // 下一个路由 
    next();
})
```

#### 2. Vuex的使用

1. 创建Vuex配置文件

   ```js
   import Vue from 'vue' 
   import Vuex from 'vuex'
   Vue.use(Vuex);
   // 全局state对象,用于保存所有组件的公共数据 
   const state={ 
       user:{ 
           name:''
       } 
   };
   // 监听state值的最新状态（计算属性） 
   const getters={ 
       getUser(state){ 
           return state.user;
       } 
   };
   // 唯一可以改变state值的方法(同步执行) 
   const mutations={ 
       updateUser(state,user){ 
           state.user=user;
       } 
   }
   // 异步执行mutations方法 
   const actions={ 
       asyncUpdateUser(context,user){ 
           context.commit('updateUser',user);
       } 
   }
   export default new Vuex.Store({ 
       state, 
       getters, 
       mutations, 
       actions
   })
   ```

2. 在mian.js里配置store/index.js

   ```js
   import store from './store'
   ```

3. Login.vue

   ```javascript
   methods: { 
       submitForm(formName) { 
           this.$refs[formName].validate((valid) => { if (valid) {
               sessionStorage.setItem('isLogin','true');
               this.$store.dispatch('asyncUpdateUser',{name:this.form.name});
               this.$router.push("/main");
           } else { 
               this.$message.error('请输入用户名或密码！'); 
               return false;
           }); 
        }, 
   }
   ```

4. Main.vue

   ```vue
   <span>{{$store.getters.getUser.name}}</span>
   ```

#### 3. 解决浏览器刷新后Vuex数据消失问题

**解决方案：**

监听页面是否刷新，如果页面刷新了，将 state对象存入到 sessionStorage中；页面打开之后，判断sessionStorage中是否存在 state对象，如果存在，则说明页面是被刷新过的，将sessionStorage中存的数据取出来给vuex中的state赋值；如果不存在，说明是第一次打开，则取 vuex 中定义的 state初始值

1. 增加监听刷新事件

   ```javascript
   export default { 
       name: 'App', 
       mounted() { 
           window.addEventListener('unload', this.saveState);
       }, 
       methods: { 
           saveState() { 
               sessionStorage.setItem('state',JSON.stringify(this.$store.state));
           } 
       } 
   }
   ```

2. 修改store/index.js中的state方法

   ```js
   const state = sessionStorage.getItem('state') ? JSON.parse(sessionStorage.getItem('state')) : { 
       user: { 
           username: ''
       } 
   };
   ```

#### 4. 模块化

由于使用单一状态树，应用的所有状态会集中到一个比较大的对象；当应用变得非常复杂时，store对象就有可能变得相当臃肿

为了解决以上问题，Vuex允许我们将store分割成模块（module）。每个模块拥有自己的state、mutation、action、getter、甚至是嵌套子模块——从上至下进行同样方式的分割

1. 在store目录下创建一个名为modules的目录并创建一个名为xxx.js的文件

   **将原先Vuex配置文件里关于xxx业务的方法剪切过来**

2. 修改store/index.js

   ```js
   import Vue from 'vue' 
   import Vuex from 'vuex' 
   import user from './modules/user'
   Vue.use(Vuex);
   export default new Vuex.Store({ 
       modules:{ 
           user
       } 
   })
   ```

3. 修改 App.vue

   ```javascript
   export default { 
       name: 'App', 
       mounted() { 
           window.addEventListener('unload',this.saveState);
       }, 
       methods:{ 
           saveState(){ sessionStorage.setItem('userState',JSON.stringify(this.$store.state.user)); 
           }
       }
   }
   ```

   

### 十、整合ElementUI

----

1. 安装ElementUI

   ```bash
   npm i element-ui -S
   ```

2. 安装SASS加载器

   ```bash
   npm install sass-loader@7.3.1
   npm install node-sass --save-dev
   ```

   **说明：**sass-loader默认不指定版本是最新的8.0.x，运行可能会出现问题,所以指定版本安装

3. 在main.js中添加

   ```js
   import ElementUI from 'element-ui';
   import 'element-ui/lib/theme-chalk/index.css';
   
   Vue.use(ElementUI);
   ```



### 附：NPM 相关命令说明

---

| 命令                             | 说明                                                         |
| -------------------------------- | ------------------------------------------------------------ |
| npm install moduleName           | 安装模块到项目目录下                                         |
| npm install -g moduleName        | -g的意思是将模块安装到全局，具体安装到磁盘哪个位置，要看npm config prefix 的位置 |
| npm install -save moduleName     | -save 的意思是将模块安装到项目目录下，并在 package 文 件的 dependencies 节点写入依赖， -S 为该命令的缩写 |
| npm install -save-dev moduleName | -save-dev 的意思是将模块安装到项目目录下，并在 package 文件的 devDependencies 节点写入依赖， -D 为该命令的缩写 |



所有的笔记来源于：[乐字节小涵的个人空间_哔哩哔哩_bilibili](https://space.bilibili.com/1360529881)