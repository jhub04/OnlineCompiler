<script setup>
import { ref } from "vue";
import axios from "axios";

const fileName = ref("main.cpp");
const code = ref(
  'class HelloWorld {public static void main(String[] args) {System.out.println("Hello World!");}}'
);
const output = ref("");

const run = async () => {
  try {
    const response = await axios.post("http://localhost:8080/api/run", code.value, { headers: {"Content-Type": "application/json"} });
    console.log(code.value);
    output.value = response.data;
  } catch (error) {
    output.value = "Error running code";
  }
};
</script>

<template>
  <header><h1>Java Compiler</h1></header>
  <main>
    <div class="input-container">
      <p>{{ fileName }}</p>
      <textarea>{{ code }}</textarea>
    </div>

    <div class="submit-container">
      <button @click="run">Run</button>
    </div>

    <div class="output-container">
      <textarea>{{ output }}</textarea>
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
