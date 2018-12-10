<template>
  <div id="app" class="container-fluid">
    <div class="site-info">
      <h1>Babblo</h1>
    </div>
    <nav>
      <router-link class="btn btn-primary" to="/">Costs</router-link>
      <router-link class="btn btn-primary" to="/add">AddCost</router-link>
      <router-link class="btn btn-primary" to="/search">Search costs</router-link>
    </nav>
    <br/>
    <router-view/>
  </div>
</template>

<script>
    export default {
        name: "app"
    };
</script>

<style>
  .site-info {
    color: blue;
    margin-bottom: 20px;
  }

  .btn-primary {
    margin-right: 50px;
  }

  .container-fluid {
    text-align: center;
  }
</style>
