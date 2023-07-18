import { createApp } from 'vue';

import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap';

import App from './App.vue';
import router from './router/router';

createApp(App)
  .component('VueDatePicker', VueDatePicker)
  .use(router)
  .mount('#app');
