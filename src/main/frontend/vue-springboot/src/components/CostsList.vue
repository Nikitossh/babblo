<template>
    <div class="list">
        <div class="col-md-6">
            <h4>Costs List</h4>
            <ul>
                <li v-for="cost in costs" :key="cost.id">
                    <router-link :to="{
                            name: 'cost-details',
                            params: {cost: cost, id: cost.id}
                         }">
                            {{cost.id}} {{cost.value}} {{cost.category.category}} {{cost.date.date}}

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
</style>
