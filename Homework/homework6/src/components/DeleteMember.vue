<template>
  <div class="container-lg w-50 p-3">
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

          <div style="margin-bottom: 50px;">
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
              <button type="button" class="btn btn-primary btn-block"
                @click="edit(member.id, member.subject)">edit</button>
            </td>
            <td v-else> </td>
            <td v-if="member != null">
              <button type="button" class="btn btn-primary btn-danger"
                @click="del(member.id, member.subject)">del</button>
            </td>
            <td v-else> </td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>

  <div class="container-lg w-50 p-3" style="margin: 100px auto;">
    <h1>新增功能</h1>
    <form style="margin-top: 50px;">
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example1">姓名</label>
        <input type="text" id="form2Example1" class="form-control" v-model="returnValue.member.name" />
      </div>
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example2">性別</label>
        <select id="form2Example2" class="form-select" aria-label="select" v-model="returnValue.member.gender">
          <option value="male" selected>
            男
          </option>
          <option value="female">
            女
          </option>
        </select>
      </div>
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example3">科目</label>
        <input type="text" id="form2Example3" class="form-control" v-model="returnValue.member.subject" />
      </div>

      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example4">
          職位
        </label>
        <select id="form2Example4" class="form-select" aria-label="select" v-model="returnValue.member.jobTitle">
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

      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example3">班級</label>
        <input type="text" id="form2Example3" class="form-control" v-model="returnValue.member.studentClass" />
      </div>
      <div class="form-outline mb-4">
        <label class="form-label" for="form2Example3">入學年度</label>
        <input type="text" id="form2Example3" class="form-control" v-model="returnValue.member.admissionYearMonth" />
      </div>


      <button type="button" class="btn btn-primary btn-block" @click="addTeacher()">新增</button>
      <button type="button" class="btn btn-primary btn-danger" @click="clearAdd()">
        <font-awesome-icon icon="trash-can" />
      </button>
    </form>


  </div>
</template>

<script setup>

/* import getDataFn from '../library/getData.js' */
import { reactive } from 'vue'
import { useRouter } from 'vue-router'
import axios from 'axios'

/* <!--  ================= 新增功能 =================  --> */

const returnValue = reactive({
  member: {
    name: '',
    gender: '',
    subject: '',
    jobTitle: '',
    studentClass: '',
    admissionYearMonth: ''
  }
})

function addTeacher() {
  axios.post('http://localhost:8080/rest/teacher', returnValue.member)
    .then(response => {
      console.log(response)
      query()
      router.push('/AddMember')
    })
    .catch(function (error) { console.log(error) })

}

/* <!--  ================= 查詢功能 =================  --> */

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

const router = useRouter()

function clearAdd() {
  returnValue.member = ''
}

function del(memberId, subject) {
  let url = 'teacher/'

  if (subject === undefined) {
    url = 'student/'
  }
  axios.delete('http://localhost:8080/rest/' + url + memberId)
    .then(response => {
      console.log(response)
    })
    .catch(function (error) { console.log(error) })
}

function edit(memberId, subject) {
  queryById(memberId, subject)
}

function queryById(memberId, subject) {
  let url = 'teacher?teacherId='

  if (subject === undefined) {
    url = 'student?studentId='
  }
  axios.get('http://localhost:8080/rest/' + url + memberId)
    .then(response => {
      returnValue.member = response.data
    })
    .catch(function (error) { console.log(error) })
}

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

/* const {members, getData} = getDataFn()
getData() */




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
