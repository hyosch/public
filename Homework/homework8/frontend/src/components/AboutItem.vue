<template>
  <div class="container-lg w-90 p-3">
    <header class="bg-white shadow-lg w-full fixed" style="margin-bottom: 65px; text-align: center">
    </header>
    <div class="container">
      <div>
        <router-link
          :to="{
            path: '/',
          }"
        >
          <button class="btn btn-primary"> 查詢 </button>
        </router-link>

        <button class="btn btn-primary"> 檢視明細 </button>
      </div>
      <table class="table table-bordered">
        <tbody>
          <tr>
            <th class="table-active col-2">申請人員</th>
            <td class="table-borderless">system</td>
          </tr>
          <tr>
            <th class="table-active">案件編號</th>
            <td class="col-5">{{ ip.caseNo }}</td>
            <th class="table-active col-2">服務名稱</th>
            <td>{{ ip.serviceName }}</td>
          </tr>
          <tr>
            <th class="table-active">申請日期</th>
            <td>{{ ip.applyDate }}</td>
            <th class="table-active">狀態</th>
            <td>{{ ip.status }}</td>
          </tr>
          <tr>
            <th class="table-active">統一編號</th>
            <td>{{ ip.ban }}</td>
            <th class="table-active">核定日期</th>
            <td>{{ ip.approvedDate }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="container" style="margin: 35px auto">
      <div>固定IP列表</div>
      <table class="table table-hover">
        <thead>
          <tr class="table-active">
            <th scope="col">項次</th>
            <th scope="col">動作</th>
            <th scope="col">服務名稱</th>
            <th scope="col">固定IP</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(statement, index) in ipStatementList" :key="index">
            <td>
              {{ index + 1 }}
            </td>
            <td> 新增 </td>
            <td>
              {{ statement.service }}
            </td>
            <td>
              {{ statement.routId }}
            </td>
          </tr>
        </tbody>
      </table>
    </div>
    <div class="form-row d-inline-flex justify-content-around">
      <div class="form-check mb-3 col">
        <label class="form-check-label" for="invalidCheck7">
          備註<input type="text" id="invalidCheck7" required v-model="remark" />
        </label>
      </div>
      <div class="">
        <button class="btn btn-primary" @click="returnUpdate"> 退回 </button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute } from 'vue-router';
import axios from 'axios';

const route = useRoute();

const queryParams = {
  no: route.query.no,
  serviceCaseNo: route.query.serviceCaseNo,
};

const ip = ref({
  caseNo: '',
  serviceName: '',
  applyDate: '',
  status: '',
  ban: '',
  remark: '',
  approvedDate: '',
  action: '新增',
  service: '服務環境',
  routId: '',
});

const getIp = () => {
  axios
    .get(`http://localhost:8080/api/v1/search/002/${queryParams.serviceCaseNo}`)
    .then((response) => {
      if (response.status === 202 && response.data !== '') {
        console.log('getIp', response.data);
        ip.value = response.data;
        console.log('ip.value', ip.value);
      } else {
        console.log(123);
      }
    })
    .catch((e) => {
      console.log(e);
    });
};
getIp();

const ipStatementList = ref([]);

const getIpStatement = () => {
  axios
    .get(`http://localhost:8080/api/v1/search/${queryParams.serviceCaseNo}`)
    .then((response) => {
      if (response.status === 202) {
        ipStatementList.value = response.data;
        console.log('ipStatementList', ipStatementList);
      }
    })
    .catch((e) => {
      console.log(e);
    });
};
getIpStatement();

const remark = ref('');

const returnUpdate = () => {
  axios
    .post(`http://localhost:8080/api/v1/update/${queryParams.no}`, {
      status: 'N',
      remark: remark.value,
      account: 'account',
      ip: 'ip',
    })
    .then((response) => {
      if (response.status === 20) {
        console.log('response.data', response.data);
      }
    })
    .catch((e) => {
      console.log(e);
    });
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
