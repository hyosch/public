<template>
  <div>
    <router-view @reload="updateComponent" :key="renderKey" />
  </div>
</template>

<script setup>
import { ref } from "vue";

const renderKey = ref(0);

const updateComponent = () => {
  renderKey.value += 1;
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
