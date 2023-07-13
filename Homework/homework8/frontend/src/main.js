import { createApp } from 'vue';

import VueDatePicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

import App from './App.vue';
import router from './router/router';

import 'bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';

createApp(App).component('VueDatePicker', VueDatePicker).use(router).mount('#app');
