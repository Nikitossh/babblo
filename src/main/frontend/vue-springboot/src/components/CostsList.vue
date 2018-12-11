<template>
    <div class="list">
        <div class="col-md-6">
            <h4>Costs List</h4>
            <ul class="category-list">
                <li v-for="cost in costs" :key="cost.id">
                    <router-link :to="{
                            name: 'cost-details',
                            params: {cost: cost, id: cost.id}
                         }">
                            {{cost.id}} {{cost.value}} {{cost.category.category}} {{cost.date}}

                    </router-link>
                </li>
            </ul>
        </div>
        <div class="col-md-6">
            <router-view @refreshData="refreshList"></router-view>
        </div>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "costs-list",
        data() {
            return {
                costs: []
            };
        },
        methods: {
            retrieveCosts() {
                http
                    .get("/costs")
                    .then(response => {
                        this.costs = response.data; // JSON are parsed automatically
                        console.log(response.data());
                    })
                    .catch(e => {
                        console.log(e);
                    });
            },
            refreshList() {
                this.retrieveCosts();
            }
        },
        mounted() {
            this.retrieveCosts();
        }
    };
</script>

<style>
    .list {
        text-align: left;
        margin-left: 200px;
        /*max-width: 450px;*/
        /*margin: auto;*/
    }

    .category-list * {transition: .4s linear;}
    .category-list {
        background: white;
        list-style-type: circle;
        list-style-position: inside;
        padding: 0 10px;
        margin: 0;
    }
    .category-list li {
        font-family: "Trebuchet MS", "Lucida Sans";
        border-bottom: 1px solid #efefef;
        padding: 10px 0;
    }
    .category-list a {
        text-decoration: none;
        color: #555;
    }
    .category-list li span {
        float: right;
        display: inline-block;
        border: 1px solid #efefef;
        padding: 0 5px;
        font-size: 13px;
        color: #999;
    }
    .category-list li:hover a {color: #c93961;}
    .category-list li:hover span {
        color: #c93961;
        border: 1px solid #c93961;
    }
</style>
