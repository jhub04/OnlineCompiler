<script setup>

import { ref } from "vue";

const fileName = ref("main.cpp");
const code = ref("public static void main(String[] args) {System.out.println(\"Hello World!\")}")
const output = ref("");

</script>

<template>
  <header><h1>Java Compiler</h1></header>
  <main>
    <div class="input-container">
      <p>{{ fileName }}</p>
      <textarea>{{ code }}</textarea>
    </div>
  </main>
</template>

<style scoped>
textarea {
  width: 750px;
  height: 300px;
  resize: none;
}
</style>