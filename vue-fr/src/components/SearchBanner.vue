
<script setup lang="ts">
import {FwbJumbotron} from 'flowbite-vue'
import Searchbar from './Searchbar.vue'
</script>
<template>
  <div
  >
    <fwb-jumbotron
      header-text="Search for you next read."
      sub-text="1000's of books from different genres."
    >
      <div class="flex flex-col space-y-4 sm:flex-row sm:justify-center sm:space-y-0">
        <Searchbar/>
      </div>
    </fwb-jumbotron>
  </div>
</template>
