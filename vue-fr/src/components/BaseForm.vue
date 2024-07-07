<template>
  <div class="form-overlay" @click="$emit('close')">
    <div class="form-container" @click.stop>
      <button type="button" @click="$emit('close')" class="close-button">×</button>
      <h2 class="form-title">{{ title }}</h2>
      <form @submit.prevent="handleSubmit" class="form-content space-y-4">
        <slot name="form-fields"></slot>
        <div class="button-container">
          <slot name="form-buttons"></slot>
        </div>
      </form>
    </div>
  </div>
</template>

<script  lang="ts">
import {defineComponent} from 'vue';
export default defineComponent({
  props: {
    title:{
      type: String,
      required: true,
    }
  },

  methods: {
    handleSubmit(){
      this.$emit('submit');
    },
    closeForm(){
      this.$emit('close');
    },
    handleOverLayClick(event:any){
      if(event.target.classList.contains('form-overlay')){
        this.closeForm();
      }
    }
  }
})
</script>

<style scoped>
.form-overlay {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 0, 0, 0.5);
}

.form-container {
  position: relative;
  background: white;
  padding: 20px;
  border-radius: 8px;
  z-index: 10;
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 300px;
}

.close-button {
  position: absolute;
  top: 10px;
  right: 10px;
  background: none;
  border: none;
  font-size: 24px;
  cursor: pointer;
}

.form-title {
  text-align: center;
  font-size: 1.5rem;
  font-weight: bold;
  margin-bottom: 1rem;
}

.button-container {
  display: flex;
  flex-direction: column;
  align-items: center;
}
</style>
