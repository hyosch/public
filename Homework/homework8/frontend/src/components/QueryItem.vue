<template>
  <div class="container-fluid">
    <form>
      <div class="row justify-content-center mb-1">
        <div class="col-8 col-md-5 mb-3">
          申請日期起訖
          <Datepicker v-model="searchParams.date" format="yyyy-MM-dd" range />
        </div>
        <div class="col-8 col-md-5 mb-2">
          <label for="validationDefault02" class="w-100"
            >統一編號
            <input
              type="text"
              class="form-control"
              id="validationDefault02"
              required
              v-model="searchParams.ban"
            />
          </label>
        </div>
      </div>
      <div class="offset-2 offset-md-1 mb-2">
        <div class="form-row d-inline-flex pe-3" v-for="(box, index) in checkbox" :key="index">
          <div class="form-check mb-3 col">
            <label class="form-check-label" :for="`checkBoxLabel${index}`">
              <input
                class="form-check-input"
                type="checkbox"
                :value="box.char"
                :id="`checkBoxLabel${index}`"
                required
                v-model="searchParams.status"
                @click="changeStatus(box.char)"
              />
              {{ box.desc }}
            </label>
          </div>
        </div>
      </div>
      <div class="justify-content-center d-flex">
        <button class="btn btn-primary" style="margin-right: 20px" type="button" @click="clear"
          >清除</button
        >
        <button class="btn btn-primary" type="button" @click="queryApplies">查詢</button>
      </div>
    </form>
    <div class="row justify-content-center">
      <table class="table table-striped w-75 m-2 m-md-5">
        <thead>
          <tr>
            <th scope="col" class="mx-3 mb-2">選擇</th>
            <th scope="col" class="mx-3 mb-2">案件編號</th>
            <th scope="col" class="mx-3 mb-2">服務名稱</th>
            <th scope="col" class="mx-3 mb-2">統一編號</th>
            <th scope="col" class="mx-3 mb-2">狀態</th>
            <th scope="col" class="mx-3 mb-2">申請日期</th>
            <th scope="col" class="mx-3 mb-2">備註</th>
            <th scope="col" class="mx-3 mb-2">動作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(apply, index) in applyList" :key="index">
            <th scope="col">
              <label :for="`invalidCheck${apply.no}`">
                <input
                  class="form-check-input"
                  type="checkbox"
                  :value="`${apply.no}`"
                  :id="`invalidCheck${apply.no}`"
                  required
                  v-model="selected.array"
                  @click="checkIfAlbeUpdate(apply.status)"
                />
              </label>
            </th>
            <td>
              {{ apply.serviceCaseNo }}
            </td>
            <td>
              {{ apply.serviceName }}
            </td>
            <td>
              {{ apply.ban }}
            </td>
            <td>
              {{ apply.status }}
            </td>
            <td>
              {{ dayjs(apply.applyDate).format('YYYY-MM-DD') }}
            </td>
            <td>
              {{ apply.remark }}
            </td>
            <td>
              <router-link
                :to="{
                  path: '/about',
                  query: {
                    no: apply.no,
                    serviceName: apply.serviceName,
                    serviceCaseNo: apply.serviceCaseNo,
                  },
                }"
              >
                <button class="btn btn-primary"> 放大鏡 </button>
              </router-link>
            </td>
          </tr>
          <div class="w-100 mt-5">
            <button class="btn btn-primary" :disabled="isDisabled === false" @click="checkUpdate">
              核准
            </button>
          </div>
        </tbody>
      </table>
    </div>
    <AlertItem v-if="isAlertVisible" @onAlertClose="onAlertClose" />
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue';
import axios from 'axios';
import router from '@/router/router';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';
import AlertItem from '@/components/AlertItem.vue';
import dayjs from 'dayjs';

const isAlertVisible = ref(false);
const showAlert = () => {
  console.log('show');
  isAlertVisible.value = true;
};
const onAlertClose = () => {
  console.log('close');
  isAlertVisible.value = false;
};

const applyList = ref([]);

const searchParams = ref({
  date: [],
  ban: null,
  status: ['0'],
});

const queryApplies = () => {
  console.log(searchParams);
  if (searchParams.value.date === null) {
    searchParams.value.date = [];
  }

  axios
    .get('http://localhost:8080/api/v1/search', {
      params: {
        applyDate: searchParams.value.date[0],
        toDate: searchParams.value.date[1],
        ban: searchParams.value.ban,
        status: searchParams.value.status.at(0),
      },
    })
    .then((response) => {
      if (response.status === 202) {
        applyList.value = response.data.content;
      }
    })
    .catch((e) => {
      console.log(e);
    });
};
queryApplies();

const selected = reactive({
  array: [],
});
let isDisabled = false;

const checkIfAlbeUpdate = (status) => {
  if (status === 'N' || status === 'Y') {
    isDisabled = false;
    showAlert();
    selected.array = [];
    return;
  }
  if (status === '0') {
    isDisabled = true;
  }
};

const checkUpdate = () => {
  console.log(selected.array);
  if (selected.array.length === 0) {
    return;
  }
  axios
    .post('http://localhost:8080/api/v1/update', {
      noArray: selected.array,
      status: 'Y',
      account: 'account',
      ip: 'ip',
    })
    .then((response) => {
      if (response.status === 200) {
        console.log(response.data);
      } else {
        router.go(0);
      }
    })
    .catch((e) => {
      console.log(e);
    });
};

const checkbox = [
  { char: '0', desc: '處理中' },
  { char: 'Y', desc: '已完成' },
  { char: 'N', desc: '已退回' },
];

const changeStatus = (ch) => {
  searchParams.value.status = [];
  searchParams.value.status.push(ch);
};

const clear = () => {
  searchParams.value.date = [];
  searchParams.value.ban = null;
  searchParams.value.status = ['0'];
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
