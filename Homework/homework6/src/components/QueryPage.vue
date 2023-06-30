<template>
  <div class="container-lg w-75 p-3">
    <div class="">
      <h1>查詢功能</h1>
      <form class="form-outline mb-4" style="margin-top: 50px;">
        <div>
          <div class="form-outline mb-4">
            <label class="form-label" for="form1Example1">編號</label>
            <input type="text" id="form1Example1" class="form-control" v-model="input.id" />
          </div>

          <div class="form-outline mb-4">
            <label class="form-label" for="input01">
              職位
            </label>
            <select id="form1Example2" class="form-select" aria-label="select" v-model="input.jobTitle">
              <option value="" selected>
                無
              </option>
              <option value="student">
                學生
              </option>
              <option value="teacher">
                老師
              </option>
            </select>
          </div>

          <div style="margin-bottom: 50px;">
            <router-link :to="{ path: '/add' }">
              <button class="btn btn-primary btn-block">新增</button>
            </router-link>
            <button type="button" class="btn btn-primary btn-block" @click="query()">查詢</button>
            <button type="button" class="btn btn-primary btn-danger" @click="clear()">
              <font-awesome-icon :icon="['fas', 'camera-retro']" />
            </button>
          </div>
        </div>
      </form>

      <table style="margin: 0 auto; border: 1px solid;" class="form-outline mb-4">
        <thead>
          <tr>
            <th class="white-space-nowrap">
              學號
            </th>
            <th class="white-space-nowrap">
              姓名
            </th>
            <th class="white-space-nowrap">
              性別
            </th>
            <th class="white-space-nowrap">
              科目
            </th>
            <th class="white-space-nowrap">
              職位
            </th>
            <th class="white-space-nowrap">
              班級
            </th>
            <th class="white-space-nowrap">
              入學年度
            </th>
            <th class="white-space-nowrap">
              編輯
            </th>
            <th class="white-space-nowrap">
              刪除
            </th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="(member) in data.members.resultList" :key="member.id">
            <td>
              {{ member.id }}
            </td>
            <td>
              {{ member.name }}
            </td>
            <td>
              {{ member.gender }}
            </td>
            <td v-if="member.subject != null">
              {{ member.subject }}
            </td>
            <td v-else> </td>
            <td v-if="member.jobTitle != null">
              {{ member.jobTitle }}
            </td>
            <td v-else> </td>
            <td v-if="member.studentClass != null">
              {{ member.studentClass }}
            </td>
            <td v-else> </td>
            <td v-if="member.admissionYearMonth != null">
              {{ member.admissionYearMonth }}
            </td>
            <td v-else> </td>
            <td v-if="member != null">
              <router-link :to="{ path: '/add', query: { id: member.id, subject: member.subject, isEdit: 'true' } }">
                <button class="btn btn-primary btn-block">編輯</button>
              </router-link>
            </td>
            <td v-else> </td>
            <td v-if="member != null">
              <button type="button" class="btn btn-primary btn-danger" @click="del(member.id, member.subject)">刪除</button>
            </td>
            <td v-else> </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script setup>

import { useRouter } from 'vue-router'
import { reactive } from 'vue'
import axios from 'axios'

/* <!--  ================= 查詢功能 =================  --> */

let member = reactive({
  name: '',
  gender: '',
  subject: '',
  jobTitle: '',
  studentClass: '',
  admissionYearMonth: ''
})
console.log(member)

const router = useRouter()

const data = reactive({
  members: {
    memberList: [],
    getMembers: axios.get('http://localhost:8080/rest/all-member')
      .then(response => {
        data.members.memberList = response.data
      })
      .catch(function (error) { console.log(error) }),

    teacherList: [],
    getTeachers: axios.get('http://localhost:8080/rest/all-teacher')
      .then(response => {
        data.members.teacherList = response.data
      })
      .catch(function (error) { console.log(error) }),

    studentList: [],
    getStudents: axios.get('http://localhost:8080/rest/all-student')
      .then(response => {
        data.members.studentList = response.data
      })
      .catch(function (error) { console.log(error) }),
    resultList: []
  }
})

const input = reactive({
  id: '',
  jobTitle: ''
})

function del(memberId, subject) {
  let url = 'teacher/'

  if (subject === undefined) {
    url = 'student/'
  }
  axios.delete('http://localhost:8080/rest/' + url + memberId)
    .then(response => {
      console.log(response)
      router.go(0)
    })
    .catch(function (error) { console.log(error) })
}

/*
function add() {
  router.push('/add')
     let url = 'teacher?teacherId='
  
    if (subject === undefined) {
      url = 'student?studentId='
    }
    axios.get('http://localhost:8080/rest/' + url + memberId)
      .then(response => {
        member = response.data
        console.log(member)
        router.push('/add')
      })
      .catch(function (error) { console.log(error) }) 
}*/

function query() {
  let inputId = input.id
  let inputJobTitle = input.jobTitle
  data.members.resultList = []

  if (inputId === '' && inputJobTitle === '') {

    for (let i = 0; i < data.members.memberList.length; i++) {
      data.members.resultList.push(data.members.memberList[i])
    }
  } else if (inputId === '' && inputJobTitle === 'teacher') {

    for (let i = 0; i < data.members.teacherList.length; i++) {
      data.members.resultList.push(data.members.teacherList[i])
    }
  } else if (inputId === '' && inputJobTitle === 'student') {

    for (let i = 0; i < data.members.studentList.length; i++) {
      data.members.resultList.push(data.members.studentList[i])
    }
  } else if (inputId != null) {
    input.jobTitle = ''
    for (let i = 0; i < data.members.memberList.length; i++) {
      if (inputId === data.members.memberList[i].id) {
        data.members.resultList.push(data.members.memberList[i])
      }
    }
  } else {
    console.log('查無資料')
  }
}

function clear() {
  input.id = ''
  input.jobTitle = ''
  data.members.resultList = []
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