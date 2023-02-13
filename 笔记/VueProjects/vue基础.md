# [Vue项目创建](https://www.cnblogs.com/ynxiyan/p/17026455.html)

#### 一、创建项目

1.安装淘宝镜像

```bash
npm i -g cnpm --registry=https://registry.npm.taobao.org
```

2.安装vue的脚手架工具

```bash
npm i -g vue-cli
```

3.测试

```bash
vue -V
```

4.初始化包结构

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

5.启动项目/停止项目(Ctrl + C)

```bash
npm run dev
```

#### 二、导入ElementUI

1.安装ElementUI

```bash
npm i element-ui -S
```

2.在main.js中添加

```js
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';

Vue.use(ElementUI);
```

#### 三、导入路由

**? Install vue-router? No时才需要安装**

1.安装路由

```bash
npm install vue-router -S
```

2.在src内新建router目录 添加index.js作为总路由

```js
// 引入依赖
import Vue from 'vue'
import VueRouter from 'vue-router'
 
// 使用路由中间件
Vue.use(VueRouter)
 
// 懒加载引入组件
const index = () => import('../page/index.vue')
 
// 路由表
const routes = [{
    path: '/',
    component: index,
    meta: {
        title: '首页'
    }
}, ]
 
 
// 修改路由模式
const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})
 
//暴露
export default router
```

3.在mian.js中引入刚刚改好的index.js文件 并添加到vue实例中

```js
···
import router from './router'
 
 
···
 
 
new Vue({
  router:router,
  ···
}
```

4.在app.vue中添加路由出口 <router-view></router-view> 这是一个会变的组件 url不同 他就变成不同的组件 变化的规则就是路由表的内容

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

5.router和route的区别：

router是全局路由对象，负责全局事务，可以用来跳转等，除了routes还有其他的属性和方法

route是局部路由对象，当前页面或组件的路由，用来获取信息
