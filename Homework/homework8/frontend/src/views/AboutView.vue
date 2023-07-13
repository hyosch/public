<template>
  <div class="about">
    <AboutItem msg="This is an about page" />
  </div>
</template>

<script>
// @ is an alias to /src
import AboutItem from '@/components/AboutItem.vue';

export default {
  name: 'AboutView',
  components: {
    AboutItem,
  },
};
</script>
