package com.alston.service;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void getAllMember() {
        List<Member> memberList = memberService.getAllMember();
        assertEquals("1", memberList.get(0).getId());
        assertEquals("Billy", memberList.get(0).getName());
        assertEquals("3", memberList.get(2).getId());
        assertEquals("male", memberList.get(2).getGender());
    }

    @Test
    void getAllTeacher() {
        List<Teacher> teacherList = new ArrayList<>();
        List<Member> memberList = memberService.getAllMember();
        for (Member m : memberList) {
            if (m instanceof Teacher) {
                teacherList.add((Teacher) m);
            }
        }
        assertEquals("1", teacherList.get(0).getId());
        assertEquals("數學", teacherList.get(0).getSubject());
        assertEquals("2", teacherList.get(1).getId());
        assertEquals("教師", teacherList.get(1).getJobTitle());
    }

    @Test
    void getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        List<Member> memberList = memberService.getAllMember();
        for (Member m : memberList) {
            if (m instanceof Student) {
                studentList.add((Student) m);
            }
        }
        assertEquals("3", studentList.get(0).getId());
        assertEquals("201910", studentList.get(0).getAdmissionYearMonth());
        assertEquals("Lawrence", studentList.get(1).getName());
        assertEquals("801", studentList.get(1).getStudentClass());
    }

    @Test
    void getTeacher() {
        Member member = memberService.getTeacher("1");
        assertEquals("1", member.getId());
        assertEquals("Billy", member.getName());
    }

    @Test
    void getStudent() {
        Member member = memberService.getStudent("4");
        assertNotNull(member);
    }

}