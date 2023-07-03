<template>
  <div class="container-lg w-50 p-3">
    <header
      class="bg-white shadow-lg w-full z-30 fixed"
      style="margin-bottom: 65px; text-align: center"
    >
      <div
        class="h-16 flex justify-center items-center"
        style="padding: 16px 0"
      >
        <h1 v-if="isEdit">修改</h1>
        <h1 v-else>新增</h1>
      </div>
    </header>

    <form class="row g-3" style="margin-top: 50px">
      <div class="col-md-6">
        <label class="form-label" for="form2Example1">姓名</label>
        <input
          type="text"
          id="form2Example1"
          class="form-control"
          v-model="member.name"
        />
      </div>
      <div class="col-md-6">
        <label class="form-label" for="form2Example2">性別</label>
        <select
          id="form2Example2"
          class="form-select"
          aria-label="select"
          v-model="member.gender"
        >
          <option value="male" selected>男</option>
          <option value="female">女</option>
        </select>
      </div>
      <div
        class="form-outline mb-4"
        v-if="isEdit === true && member.subject != undefined"
      >
        <label class="form-label" for="form2Example3">科目</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.subject"
        />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">科目</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.subject"
        />
      </div>
      <div
        class="form-outline mb-4"
        v-if="isEdit === true && member.jobTitle != undefined"
      >
        <label class="form-label" for="form2Example4"> 職位 </label>
        <select
          id="form2Example4"
          class="form-select"
          aria-label="select"
          v-model="member.jobTitle"
        >
          <option value="" selected>無</option>
          <option value="teacher">老師</option>
          <option value="director">主任</option>
          <option value="president">校長</option>
        </select>
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example4"> 職位 </label>
        <select
          id="form2Example4"
          class="form-select"
          aria-label="select"
          v-model="member.jobTitle"
        >
          <option value="" selected>無</option>
          <option value="teacher">老師</option>
          <option value="director">主任</option>
          <option value="president">校長</option>
        </select>
      </div>
      <div
        class="form-outline mb-4"
        v-if="isEdit === true && member.studentClass != undefined"
      >
        <label class="form-label" for="form2Example3">班級</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.studentClass"
        />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">班級</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.studentClass"
        />
      </div>
      <div
        class="form-outline mb-4"
        v-if="isEdit === true && member.admissionYearMonth != undefined"
      >
        <label class="form-label" for="form2Example3">入學年度</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.admissionYearMonth"
        />
      </div>
      <div class="form-outline mb-4" v-else-if="isEdit === false">
        <label class="form-label" for="form2Example3">入學年度</label>
        <input
          type="text"
          id="form2Example3"
          class="form-control"
          v-model="member.admissionYearMonth"
        />
      </div>
      <div style="margin-top: 30px" class="row justify-content-end">
        <div class="col-2">
          <button
            type="button"
            class="btn btn-outline-primary"
            v-if="isEdit"
            @keyup.enter="addMember(member)"
            @click="addMember(member)"
          >
            儲存
          </button>
          <button
            type="button"
            class="btn btn-outline-primary"
            v-else
            @keyup.enter="addMember(member)"
            @click="addMember(member)"
          >
            新增
          </button>
        </div>
        <div class="col-2">
          <button
            type="button"
            class="btn btn-outline-danger"
            @click="router.go(-1)"
          >
            取消
          </button>
        </div>
      </div>
    </form>
  </div>
</template>

<script setup>
import { reactive, ref } from "vue";
import { useRoute, useRouter } from "vue-router";
import axios from "axios";

const router = useRouter();
const route = useRoute();

let member = reactive({
  id: "",
  name: "",
  gender: "",
  subject: "",
  jobTitle: "",
  studentClass: "",
  admissionYearMonth: "",
});

const isEdit = ref(false);

if (route.query.isEdit === "true") {
  isEdit.value = true;
  queryMember(route.query.id, route.query.subject);
}

const addMember = (member) => {
  if (member.id != "") {
    updateMember(member);
    return;
  }
  let url = "teacher";

  if (member.subject == "") {
    url = "student";
  }
  axios
    .post("http://localhost:8080/rest/" + url, member)
    .then((response) => {
      if (response.status === 200) {
        console.log("新增成功");
        router.push("/");
      }
    })
    .catch((e) => {
      console.log(e);
    });
};

function queryMember(id, subject) {
  let url = "teacher?teacherId=";

  if (subject === undefined) {
    url = "student?studentId=";
  }
  axios
    .get("http://localhost:8080/rest/" + url + id)
    .then((response) => {
      if (response.status === 200) {
        let resp = response.data;
        member.id = resp.id;
        member.name = resp.name;
        member.gender = resp.gender;
        member.subject = resp.subject;
        member.jobTitle = resp.jobTitle;
        member.studentClass = resp.studentClass;
        member.admissionYearMonth = resp.admissionYearMonth;
      } else {
        console.log("error");
      }
    })
    .catch(function (error) {
      console.log(error);
    });
}

const updateMember = (member) => {
  let url = "teacher";
  if (member.subject === undefined) {
    url = "student";
  }
  axios
    .put("http://localhost:8080/rest/" + url, member)
    .then((response) => {
      if (response.status === 200) {
        console.log("修改成功");
        router.push("/");
      }
    })
    .catch((e) => {
      console.log(e);
    });
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
