<template>
  <div class="d-flex justify-content-end">
    <div class="alert alert-warning alert-dismissible fade show w-25">
      <button
        type="button"
        class="btn-close"
        data-bs-dismiss="alert"
        aria-label="Close"
        @click="onClose"
      >
      </button>
      <strong>警告!</strong> 勾選資料含已處理或已退回資料
    </div>
  </div>
</template>

<script setup>
const emits = defineEmits(['onAlertClose']);

const onClose = () => {
  emits('onAlertClose');
};
</script>

<style>
.alert {
  color: rgb(43, 28, 28);
  padding: 16px;
  margin-top: 180px;
  margin-bottom: 16px;
  margin-right: 50px;
  position: absolute;
  top: 0;
  right: 0;
}
.alert h2 {
  margin-top: 0;
}
.alert button {
  background-color: white;
  color: #f44336;
  border: none;
  padding: 4px 8px;
  border-radius: 4px;
  cursor: pointer;
}
</style>
