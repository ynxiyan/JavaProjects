import Vue from 'vue'
import layout from "../views/layout.vue";
import index from "..views/home/indecx.vue"
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'layout',
      component:layout,
      children:[
        {
          path:'index',
          name:'index',
          components:index,
        },
        {

        }
      ]
    }
  ]
})
