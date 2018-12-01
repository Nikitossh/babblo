import Vue from "vue";
import Router from "vue-router";
import CostsList from "./components/CostsList.vue";
import AddCost from "./components/AddCost.vue";
import SearchCosts from "./components/SearchCosts.vue";
import Cost from "./components/Cost.vue";

Vue.use(Router);

export default new Router({
   mode: "history",
   routes: [
       {
           path: "/",
           name: "costs",
           alias: "/cost",
           component: CostsList,
           children: [
               {
                   path: "/cost/:id",
                   name: "cost-details",
                   component: Cost,
                   props: true
               }
           ]
       }, {
           path: "/add",
           name: "add",
           component: AddCost
       },
       {
           path: "/search",
           name: "search",
           component: SearchCosts
       }
   ]
});
