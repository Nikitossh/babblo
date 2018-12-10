<template>
    <div v-if="this.cost">
        <h4>Cost</h4>
        <div>
            <label>Category: </label> {{this.cost.category.category}}
        </div>
        <div>
            <label>Value: </label> {{this.cost.value}}
        </div>
        <div>
            <label>Comment: </label> {{this.cost.comment}}
        </div>

        <span v-if="this.cost.id>1"
            v-on:click=""
            class="button is-small btn-primary">Inactive</span>
        <span v-else
            v-on:click=""
        class="button is-small btn-primary">Active</span>

        <span class="button is-small btn-danger" v-on:click="deleteCost()">Delete</span>
    </div>
    <div v-else>
        <br/>
        <p>Please click on a Cost...</p>
    </div>
</template>

<script>
    import http from "../http-common";

    export default {
        name: "cost",
        props: ["cost"],
        methods: {
            addCost() {
                http
                    .put()
            },
            deleteCost() {
                http
                    .delete("/cost/" + this.cost.id, data)
                    .then(response => {
                        console.log(response.data);
                        this.$emit("refreshData");
                        this.$router.push('/');
                    })
                    .catch(e => {
                        console.log(e);
                    })
            }
        }
    }
</script>
