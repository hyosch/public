package com.alston.controller;

import com.alston.model.Member;
import com.alston.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/all-member")
    public List<Member> getAllMember() {
        return memberService.getAllMember();
    }

    @GetMapping("/all-teacher")
    public List<Member> getAllTeacher() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/all-student")
    public List<Member> getAllStudent() {
        return memberService.getAllStudent();
    }

    @GetMapping("/teacher")
    public Member getTeacher(@RequestParam String teacherId) {
        return memberService.getTeacher(teacherId);
    }

    @GetMapping("/student")
    public Member getStudent(@RequestParam String studentId) {
        return memberService.getStudent(studentId);
    }

}