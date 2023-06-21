package com.alston.controller;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import com.alston.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/teacher")
    public Member addTeacher(@RequestBody Teacher teacherInfo) {
        String teacherId = memberService.addTeacher(teacherInfo);
        return memberService.getTeacher(teacherId);
    }

    @PostMapping("/student")
    public Member addStudent(@RequestBody Student studentInfo) {
        String studentId = memberService.addStudent(studentInfo);
        return memberService.getStudent(studentId);
    }

    @PutMapping("/teacher")
    public Member updateTeacher(@RequestBody Teacher teacherInfo) {
        return memberService.updateTeacher(teacherInfo);
    }

    @PutMapping("/student")
    public Member updateStudent(@RequestBody Student studentInfo) {
        return memberService.updateStudent(studentInfo);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public String deleteTeacher(@PathVariable String teacherId) {
        return memberService.deleteTeacher(teacherId);
    }

    @DeleteMapping("/student/{studentId}")
    public String deleteStudent(@PathVariable String studentId) {
        return memberService.deleteStudent(studentId);
    }

}