package com.alston.controller;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import com.alston.service.MemberService;
import com.alston.service.MemberServiceCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberServiceCriteria memberServiceCriteria;

    @GetMapping("/all-member")
    public List<Member> getAllMember() {
        return memberServiceCriteria.getAllMember();
    }

    @GetMapping("/all-teacher")
    public List<Member> getAllTeacher() {
        return memberServiceCriteria.getAllTeacher();
    }

    @GetMapping("/all-student")
    public List<Member> getAllStudent() {
        return memberServiceCriteria.getAllStudent();
    }

    @GetMapping("/teacher")
    public Member getTeacher(@RequestParam String teacherId) {
        return memberServiceCriteria.getTeacher(teacherId);
    }

    @GetMapping("/student")
    public Member getStudent(@RequestParam String studentId) {
        return memberServiceCriteria.getStudent(studentId);
    }

    @PostMapping("/teacher")
    public Boolean addTeacher(@RequestBody Teacher teacherInfo) {
        return memberService.addTeacher(teacherInfo);
    }

    @PostMapping("/student")
    public Boolean addStudent(@RequestBody Student studentInfo) {
        return memberService.addStudent(studentInfo);
    }

    @PutMapping("/teacher")
    public Integer updateTeacher(@RequestBody Teacher teacherInfo) {
        return memberServiceCriteria.updateTeacher(teacherInfo);
    }

    @PutMapping("/student")
    public Integer updateStudent(@RequestBody Student studentInfo) {
        return memberServiceCriteria.updateStudent(studentInfo);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public Integer deleteTeacher(@PathVariable String teacherId) {
        return memberServiceCriteria.deleteTeacher(teacherId);
    }

    @DeleteMapping("/student/{studentId}")
    public Integer deleteStudent(@PathVariable String studentId) {
        return memberServiceCriteria.deleteStudent(studentId);
    }

}