<template>
    <div class="submitform">
        <!--<div v-if="!submitted">-->
            <div class="form-group">
                <label for="category">Category</label>
                <input type="text" class="form-control" id="category" required v-model="cost.category" name="category">
            </div>

            <div class="form-group">
                <label for="value">Value</label>
                <input type="text" class="form-control" id="value" required v-model="cost.value" name="value">
            </div>

            <div class="form-group">
                <label for="comment">Comment</label>
                <input type="text" class="form-control" id="comment" required v-model="cost.comment" name="comment">
            </div>

            <div class="form-group">
                <label for="date">Date</label>
                <input type="date" class="form-control" id="date" required v-model="cost.date" name="date">
            </div>

        <button v-on:click="saveCost" class="btn btn-success">Submit cost</button>
        <!--</div>-->
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "add-cost",
        data() {
            return {
                cost: {
                    id: 0,
                    value: 0,
                    category: "category",
                    comment: "noComment",
                    date: ""
                },
                submitted: false
            };
        },
    methods: {
            /* eslint-disable no-console */
        saveCost() {
            var data = {
                value: this.cost.value,
                category: this.cost.category.category,
                comment: this.cost.comment,
                date: this.cost.date.date
            };
            http
                .post("/cost", data)
                .then(response => {
                    this.cost.id = response.data.id;
                    console.log(response.data);
                })
                .catch(e => {
                    console.log(e);
                });

            this.submitted = true;
        },

        newCost() {
            this.submitted = false;
            this.cost = {};
        }
        /* eslint-enable no-console */
    }
    };
</script>

<style>
    .submitform {
        max-width: 300px;
        margin: auto;
    }
</style>
