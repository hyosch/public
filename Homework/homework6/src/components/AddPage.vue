<template>
  <div class="container-lg w-50 p-3" style="margin: 100px auto;">
    <h1>新增功能</h1>
    <form style="margin-top: 50px;">
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example1">姓名</label>
        <input type="text" id="form2Example1" class="form-control" v-model="member.name" />
      </div>
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example2">性別</label>
        <select id="form2Example2" class="form-select" aria-label="select" v-model="member.gender">
          <option value="male" selected>
            男
          </option>
          <option value="female">
            女
          </option>
        </select>
      </div>
      <div class="form-outline mb-4" v-if="isEdit === true && member.subject != undefined">
        <label class="form-label" for="form2Example3">科目</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.subject" />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">科目</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.subject" />
      </div>
      <div class="form-outline mb-4" v-if="isEdit === true && member.jobTitle != undefined">
        <label class="form-label" for="form2Example4">
          職位
        </label>
        <select id="form2Example4" class="form-select" aria-label="select" v-model="member.jobTitle">
          <option value="" selected>
            無
          </option>
          <option value="teacher">
            老師
          </option>
          <option value="director">
            主任
          </option>
          <option value="president">
            校長
          </option>
        </select>
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example4">
          職位
        </label>
        <select id="form2Example4" class="form-select" aria-label="select" v-model="member.jobTitle">
          <option value="" selected>
            無
          </option>
          <option value="teacher">
            老師
          </option>
          <option value="director">
            主任
          </option>
          <option value="president">
            校長
          </option>
        </select>
      </div>
      <div class="form-outline mb-4" v-if="isEdit === true && member.studentClass != undefined">
        <label class="form-label" for="form2Example3">班級</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.studentClass" />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">班級</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.studentClass" />
      </div>
      <div class="form-outline mb-4" v-if="isEdit === true && member.admissionYearMonth != undefined">
        <label class="form-label" for="form2Example3">入學年度</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.admissionYearMonth" />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">入學年度</label>
        <input type="text" id="form2Example3" class="form-control" v-model="member.admissionYearMonth" />
      </div>


      <button type="button" class="btn btn-primary btn-block" @click="addMember(member)">新增</button>
      <button type="button" class="btn btn-primary btn-danger" @click="clearAdd()">
        <font-awesome-icon icon="trash-can" />
      </button>
    </form>


  </div>
</template>

<script setup>

import { reactive } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import axios from 'axios'

/* <!--  ================= 新增功能 =================  --> */

const router = useRouter()
const route = useRoute()

let member = reactive({
  id: '',
  name: '',
  gender: '',
  subject: '',
  jobTitle: '',
  studentClass: '',
  admissionYearMonth: ''
})

let isEdit = false

if (route.query.isEdit === 'true') {
  isEdit = true
  queryMember(route.query.id, route.query.subject)
}

function addMember(member) {
  if (member.id != '') {
    updateMember(member)
    return
  }
  let url = 'teacher'

  if (member.subject == '') {
    url = 'student'
  }
  axios.post('http://localhost:8080/rest/' + url, member)
    .then(response => {
      if (response.status === 200) {
        console.log('新增成功')
        router.push('/')
      }
    })
    .catch(function (error) { console.log(error) })
}

function queryMember(id, subject) {
  let url = 'teacher?teacherId='

  if (subject === undefined) {
    url = 'student?studentId='
  }
  axios.get('http://localhost:8080/rest/' + url + id)
    .then(response => {
      if (response.status === 200) {
        let resp = response.data
        member.id = resp.id
        member.name = resp.name
        member.gender = resp.gender
        member.subject = resp.subject
        member.jobTitle = resp.jobTitle
        member.studentClass = resp.studentClass
        member.admissionYearMonth = resp.admissionYearMonth
      } else {
        console.log('error')
      }
    })
    .catch(function (error) { console.log(error) })
}

function updateMember(member) {
  let url = 'teacher'
  if (member.subject === undefined) {
    url = 'student'
  }
  axios.put('http://localhost:8080/rest/' + url, member)
    .then(response => {
      if (response.status === 200) {
        console.log('修改成功')
        router.push('/')
      }
    })
    .catch(function (error) { console.log(error) })
}

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
