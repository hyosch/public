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
    MemberService memberService;

    @GetMapping("/all-member")
    public List<Member> members() {
        return memberService.getAllMember();
    }

    @GetMapping("/all-teacher")
    public List<Member> teachers() {
        return memberService.getAllTeacher();
    }

    @GetMapping("/all-student")
    public List<Member> students() {
        return memberService.getAllStudent();
    }

    @GetMapping("/teacher")
    public List<Member> teacher(@RequestParam String teacherId) {
        return memberService.getTeacher(teacherId);
    }

    @GetMapping("/student")
    public List<Member> student(@RequestParam String studentId) {
        return memberService.getStudent(studentId);
    }

}