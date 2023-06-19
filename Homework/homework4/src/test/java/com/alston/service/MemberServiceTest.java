package com.alston.service;

import com.alston.dao.MemberRepository;
import com.alston.model.Member;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Test
    void getAllMember() {

        List<Member> memberList = memberService.getAllMember();
        assertEquals("1", memberList.get(0).getId());
        assertEquals("Billy",memberList.get(0).getName());
        assertEquals("3", memberList.get(2).getId());
        assertEquals("male",memberList.get(2).getGender());
    }

    @Test
    void getAllTeacher() {
        List<Member> memberList = memberService.getAllTeacher();
        assertEquals("1", memberList.get(0).getId());
        assertEquals("數學",memberList.get(0).getSubject());
        assertEquals("2", memberList.get(1).getId());
        assertEquals("教師",memberList.get(1).getJobTitle());
    }

    @Test
    void getAllStudent() {
        List<Member> memberList = memberService.getAllStudent();
        assertEquals("3", memberList.get(0).getId());
        assertEquals("201910",memberList.get(0).getAdmissionYearMonth());
        assertEquals("Lawrence", memberList.get(1).getName());
        assertEquals("801",memberList.get(1).getStudentClass());
    }

    @Test
    void getTeacher() {
        Member member = memberService.getTeacher("1").get(0);
        assertEquals("1", member.getId());
        assertEquals("Billy",member.getName());
    }

    @Test
    void getStudent() {
        Member member = memberService.getStudent("4").get(0);
        assertNotNull(member);

    }
}