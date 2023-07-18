<template>
  <div class="container-fluid w-90">
    <header class="bg-white"> </header>
    <div class="container">
      <div>
        <router-link :to="{ path: '/' }">
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
            <td class="col-5">{{ queryParams.serviceCaseNo }}</td>
            <th class="table-active col-2">服務名稱</th>
            <td>{{ queryParams.serviceName }}</td>
          </tr>
          <tr>
            <th class="table-active">申請日期</th>
            <td>{{ dayjs(ip.applyDate).format('YYYY-MM-DD') }}</td>
            <th class="table-active">狀態</th>
            <td>{{ ip.status }}</td>
          </tr>
          <tr>
            <th class="table-active">統一編號</th>
            <td>{{ ip.ban }}</td>
            <th class="table-active">核定日期</th>
            <td>{{ dayjs(ip.approvedDate).format('YYYY-MM-DD') }}</td>
          </tr>
        </tbody>
      </table>
    </div>

    <div class="container my-5">
      <div>固定IP列表</div>
      <table class="table table-hover table-bordered">
        <thead>
          <tr class="table-active">
            <th scope="col" class="">項次</th>
            <th scope="col" class="">動作</th>
            <th scope="col" class="">服務名稱</th>
            <th scope="col" class="">固定IP</th>
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
    <div class="container">
      <div class="row d-flex">
        <div class="d-flex justify-content-end">
          <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#staticBackdrop">
            退回
          </button>
        </div>
      </div>
    </div>
  </div>

  <BootstrapModal>
    <template v-slot:header>
      <h5 class="modal-title" id="staticBackdropLabel">退回訊息</h5>
      <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
    </template>
    <template v-slot:body>
      <div class="row">
        <label class="form-check-label" for="input7">
          <input
            type="text"
            id="input7"
            class="p-1 w-100"
            placeholder="請輸入備註"
            v-model="remark"
          />
        </label>
      </div>
    </template>
    <template v-slot:footer>
      <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
      <button type="button" class="btn btn-primary" data-bs-dismiss="modal" @click="returnUpdate()"
        >發送</button
      >
    </template>
  </BootstrapModal>
</template>

<script setup>
import { ref } from 'vue';
import { useRoute, useRouter } from 'vue-router';
import axios from 'axios';
import BootstrapModal from '@/components/BootstrapModal.vue';
import dayjs from 'dayjs';

const showModal = ref(false);
const route = useRoute();
const router = useRouter();

const queryParams = {
  no: route.query.no,
  serviceName: route.query.serviceName,
  serviceCaseNo: route.query.serviceCaseNo,
};

const ip = ref({
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
    .get(`http://localhost:8080/api/v1/searchIp/${queryParams.serviceCaseNo}`)
    .then((response) => {
      if (response.status === 202 && response.data !== '') {
        ip.value = response.data;
        console.log('ip.value', ip.value);
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
  console.log(remark);
  axios
    .post(`http://localhost:8080/api/v1/update/${queryParams.no}`, {
      status: 'N',
      remark: remark.value,
      account: 'account',
      ip: 'ip',
    })
    .then((response) => {
      if (response.status === 200) {
        console.log('response.data', response.data);
        router.push('/');
      }
      showModal.value = false;
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
