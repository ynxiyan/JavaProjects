# [Vue项目创建](https://www.cnblogs.com/ynxiyan/p/17026455.html)

### 一、创建项目

---

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

5.使用图形化界面创建项目

```bash
vue ui
```

6.启动项目/停止项目(Ctrl + C)

```bash
npm run dev
```



### 二、导入ElementUI

----

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



### 三、导入路由

---

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

3.在mian.js中引入刚刚改好的index.js文件 并添加到vue实例中

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



### 四、导入Axios

---

##### 1. npm安装

```bash
npm install axios
```

##### 2. 解决跨域问题

1. Vue：

   - 在config目录下的index.js找到proxyTable字段并加上以下语句即可

     ```js
     proxyTable: {
         //解决跨域
         '/api': {
             target: 'http://localhost:8080', // 你请求的第三方接口
                 changeOrigin: true, // 在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
                     pathRewrite: {  // 路径重写，
                         '^/api': ''  // 替换target中的请求地址，也就是说以后你在请求http://localhost:8080这个地址的时候直接写成/api即可。
                     }
         }
     },
     ```

   - 定义axios的请求前缀（在src目录下的min.js里加入以下语句即可）

     ```js
     axios.defaults.baseURL = '/api'
     ```

2. java：

   ```java
   /**
    * @Author: XIYAN
    * @Date: 2023/3/24 13:21
    * @注释:跨域处理
    */
   @Configuration
   public class WebConfig implements WebMvcConfigurer {
       /**
        * 跨域处理配置
        *
        * @param registry
        */
       @Override
       public void addCorsMappings(CorsRegistry registry) {
           // 跨域路径
           CorsRegistration cors = registry.addMapping("/**");
   
           // 可访问的外部域
           cors.allowedOrigins("*");
           // 支持跨域用户凭证
           //cors.allowCredentials(true);
           //cors.allowedOriginPatterns("*");
           // 设置 header 能携带的信息
           cors.allowedHeaders("*");
           // 支持跨域的请求方法
           cors.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
           // 设置跨域过期时间，单位为秒
           cors.maxAge(3600);
       }
   }
   ```

   

### 五、解决node版本过高问题

---

<a style="color:red">临时</a>

```bash
$env:NODE_OPTIONS="--openssl-legacy-provider"
```

