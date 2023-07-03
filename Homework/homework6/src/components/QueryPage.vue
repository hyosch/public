<template>
  <div class="container-lg w-75 p-3">
    <header
      class="bg-white shadow-lg w-full z-30 fixed"
      style="margin-bottom: 65px; text-align: center"
    >
      <div
        class="h-16 flex justify-center items-center"
        style="padding: 16px 0"
      >
        <h1>查詢</h1>
      </div>
    </header>
    <form class="row g-3" style="margin-top: 50px">
      <div class="col-md-4">
        <label class="form-label" for="form1Example1">學號</label>
        <input
          type="text"
          id="form1Example1"
          class="form-control"
          v-model="input.id"
        />
      </div>
      <div class="col-md-4">
        <label class="form-label" for="input01"> 職位 </label>
        <select
          id="form1Example2"
          class="form-select"
          aria-label="select"
          v-model="input.jobTitle"
        >
          <option value="" selected>無</option>
          <option value="student">學生</option>
          <option value="teacher">老師</option>
        </select>
      </div>
      <div style="margin-bottom: 50px" class="row justify-content-end">
        <div class="col-1">
          <router-link :to="{ path: '/add' }">
            <button class="btn btn-outline-secondary">
              <font-awesome-icon :icon="['fa', 'plus']" />
            </button>
          </router-link>
        </div>
        <div class="col-1">
          <button
            type="button"
            class="btn btn-outline-primary"
            @click="query()"
          >
            <font-awesome-icon :icon="['fa', 'magnifying-glass']" />
          </button>
        </div>
        <div class="col-1">
          <button type="button" class="btn btn-outline-danger" @click="clear()">
            <font-awesome-icon :icon="['fas', 'trash-can']" />
          </button>
        </div>
      </div>
    </form>

    <table style="margin: 0 auto" class="table table-striped">
      <thead>
        <tr>
          <th scope="col">學號</th>
          <th scope="col">姓名</th>
          <th scope="col">性別</th>
          <th scope="col">科目</th>
          <th scope="col">職位</th>
          <th scope="col">班級</th>
          <th scope="col">入學年度</th>
          <th scope="col">編輯</th>
          <th scope="col">刪除</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(member, index) in resultList" :key="index">
          <th scope="row">
            {{ member.id }}
          </th>
          <td>
            {{ member.name }}
          </td>
          <td>
            {{ member.gender }}
          </td>
          <td v-if="member.subject != null">
            {{ member.subject }}
          </td>
          <td v-else></td>
          <td v-if="member.jobTitle != null">
            {{ member.jobTitle }}
          </td>
          <td v-else></td>
          <td v-if="member.studentClass != null">
            {{ member.studentClass }}
          </td>
          <td v-else></td>
          <td v-if="member.admissionYearMonth != null">
            {{ member.admissionYearMonth }}
          </td>
          <td v-else></td>
          <td v-if="member != null">
            <router-link
              :to="{
                path: '/add',
                query: {
                  id: member.id,
                  subject: member.subject,
                  isEdit: 'true',
                },
              }"
            >
              <button class="btn btn-outline-primary">
                <font-awesome-icon :icon="['fa', 'pen-to-square']" />
              </button>
            </router-link>
          </td>
          <td v-else></td>
          <td v-if="member != null">
            <button
              type="button"
              class="btn btn-outline-danger"
              @click="deleteMember(member.id, member.subject)"
            >
              <font-awesome-icon :icon="['fas', 'trash-can']" />
            </button>
          </td>
          <td v-else></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { reactive, ref, defineEmits } from 'vue';
import axios from 'axios';

const member = reactive({
  name: '',
  gender: '',
  subject: '',
  jobTitle: '',
  studentClass: '',
  admissionYearMonth: '',
});
member;

const emit = defineEmits(['reload']);
const reload = () => {
  emit('reload');
};

const memberList = ref([]);
const teacherList = ref([]);
const studentList = ref([]);
const resultList = ref([]);

const input = ref({
  id: '',
  jobTitle: '',
});

const getMembers = () => {
  axios
    .get('http://localhost:8080/rest/all-member')
    .then((response) => {
      memberList.value = response.data;
      query();
    })
    .catch((e) => {
      console.log(e);
    });
};
getMembers();

const getTeachers = () => {
  axios
    .get('http://localhost:8080/rest/all-teacher')
    .then((response) => {
      teacherList.value = response.data;
    })
    .catch((e) => {
      console.log(e);
    });
};
getTeachers();

const getStudents = () => {
  axios
    .get('http://localhost:8080/rest/all-student')
    .then((response) => {
      studentList.value = response.data;
    })
    .catch((e) => {
      console.log(e);
    });
};
getStudents();

const deleteMember = (memberId, subject) => {
  let url = 'teacher/';
  if (subject === undefined) {
    url = 'student/';
  }
  axios
    .delete('http://localhost:8080/rest/' + url + memberId)
    .then(() => {
      reload();
    })
    .catch((e) => {
      console.log(e);
    });
};

const query = () => {
  const inputId = input.value.id;
  const inputJobTitle = input.value.jobTitle;
  resultList.value = [];

  if (inputId === '' && inputJobTitle === '') {
    resultList.value = memberList.value;
  } else if (inputId === '' && inputJobTitle === 'teacher') {
    resultList.value = teacherList.value;
  } else if (inputId === '' && inputJobTitle === 'student') {
    resultList.value = studentList.value;
  } else if (inputId != null) {
    input.value.jobTitle = '';
    for (let i = 0; i < memberList.value.length; i++) {
      if (inputId === memberList.value[i].id) {
        resultList.value.push(memberList.value[i]);
        return;
      }
    }
    console.log('查無資料');
  } else {
    console.log('怪怪的...');
  }
};

const clear = () => {
  input.value.id = '';
  input.value.jobTitle = '';
  resultList.value = [];
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
