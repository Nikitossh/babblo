<template>
    <div class="searchform">
        <h4>Find by value</h4>
        <div class="form-group">
            <input type="number" class="form-control" id="value" required v-model="value" name="value">
        </div>

        <div class="btn-group">
            <button v-on:click="searchCosts" class="btn btn-success">Search costs</button>
        </div>

        <ul class="search-result">
            <li v-for="(cost, index) in costs" :key="index">
                <h6>{{cost.category}} {{cost.value}}</h6>
            </li>
        </ul>

    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "search-cost",
        data() {
            return {
                value: 0,
                costs: []
            };
        },
        methods: {
            searchCosts() {
                http.get("/costs/value" + this.value)
                    .then(response => {
                        this.cost = response.data; //JSON are parsed automatically.
                        console.log(response.data);
                    })
                    .catch(e => {
                        console.log(e);
                    })
            }
        }
    }
</script>

<style>
    .searchform {
        max-width: 300px;
        margin: auto;
    }
    .search-result {
        margin-top: 20px;
        text-align: left;
    }

</style>
