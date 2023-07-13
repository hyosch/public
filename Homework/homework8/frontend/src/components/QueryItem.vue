<template>
  <div class="container-lg w-75 p-3">
    <header
      class="bg-white shadow-lg w-full z-30 fixed"
      style="margin-bottom: 65px; text-align: center"
    >
      <div class="h-16 flex justify-center items-center" style="padding: 16px 0">
        <h1>查詢</h1>
      </div>
    </header>
    <div>
      <form>
        <div class="row">
          <div class="col mb-3">
            申請日期起訖
            <Datepicker v-model="searchParams.date" format="yyyy-MM-dd" range />
          </div>
          <div class="col mb-3">
            <label for="validationDefault02"
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
        <div class="form-row d-inline-flex" v-for="(box, index) in checkbox" :key="index">
          <div class="form-row d-inline-flex">
            <div class="form-check mb-3 col">
              <label class="form-check-label" :for="`checkBoxLabel${index}`">
                <input
                  class="form-check-input"
                  type="checkbox"
                  :value="box.char"
                  :id="`checkBoxId${index}`"
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
          <button class="btn btn-primary" style="margin-right: 20px" type="button">清除</button>
          <button class="btn btn-primary" type="button" @click="queryApplies">查詢</button>
        </div>
      </form>
    </div>
    <div class="mt-50 mb-50" style="margin: 50px">
      <table style="margin: 0 auto" class="table table-striped">
        <thead>
          <tr>
            <th scope="col">選擇</th>
            <th scope="col">案件編號</th>
            <th scope="col">服務名稱</th>
            <th scope="col">統一編號</th>
            <th scope="col">狀態</th>
            <th scope="col">申請日期</th>
            <th scope="col">備註</th>
            <th scope="col">動作</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(apply, index) in applyList" :key="index">
            <td>
              <label :for="`invalidCheck${apply.no}`">
                <input
                  class="form-check-input"
                  type="checkbox"
                  :value="`${apply.no}${apply.status}`"
                  :id="`invalidCheck${apply.no}`"
                  required
                  v-model="selected.array"
                  @click="checkIfAlbeUpdate(apply.status)"
                />
              </label>
            </td>
            <td>
              {{ apply.caseNo }}
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
              {{ apply.applyDate }}
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
                    serviceCaseNo: apply.serviceCaseNo,
                  },
                }"
              >
                <button class="btn btn-primary"> 放大鏡 </button>
              </router-link>
            </td>
          </tr>
          <div class="d-flex">
            <button class="btn btn-primary" :disabled="isDisabled" @click="checkUpdate"
              >核准</button
            >
          </div>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive } from 'vue';
import axios from 'axios';
import Datepicker from '@vuepic/vue-datepicker';
import '@vuepic/vue-datepicker/dist/main.css';

const apply = ref({
  ban: '',
  caseNo: '',
  serviceCaseNo: '',
  applyDate: '',
  no: '',
  remark: '',
  serviceName: '',
  status: '',
  approved: '',
  lastModifiedBy: '',
  lastModifiedIp: '',
});
console.log('apply', apply);

const applyList = ref([]);

const searchParams = ref({
  date: [],
  ban: '',
  status: ['0'],
});

const queryApplies = () => {
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
let isDisabled = ref(true);

const noArray = [];

const checkIfAlbeUpdate = (status) => {
  console.log(status);
  if (status === 'N' || status === 'Y') {
    isDisabled = true;
    alert('勾選資料含已處理或已退回資料');
    return;
  }
  if (status === '0') {
    isDisabled = false;
    return;
  }
  isDisabled = false;
};

const checkUpdate = () => {
  console.log(selected.array);
  if (selected.array.length === 0) {
    alert('未勾選核准資料');
    return;
  }
  axios
    .post('http://localhost:8080/api/v1/update', {
      noArray,
      status: 'Y',
      account: 'account',
      ip: 'ip',
    })
    .then((response) => {
      if (response.status === 200) {
        console.log(response.data);
        queryApplies();
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
