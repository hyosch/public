package com.alston.model.controller;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MemberController {

    public static List<Member> memberList() {
        List<Member> memberList = new ArrayList<>();
        memberList.add(new Teacher("1", "Billy", "male", "數學", "教務主任"));
        memberList.add(new Teacher("2", "Heidi", "female", "英文", "教師"));
        memberList.add(new Student("3", "Jacky", "male", "301", "201910"));
        memberList.add(new Student("4", "Lawrence", "male", "801", "201812"));

        return memberList;
    }

    @GetMapping("/all-teacher")
    public List<Member> teachers() {
        List<Member> list = new ArrayList<>();
        for (Member m : memberList()) {
            if (m instanceof Teacher) {
                list.add(m);
            }
        }

        return list;
    }

    @GetMapping("/all-student")
    public List<Member> students() {
        List<Member> list = new ArrayList<>();
        for (Member m : memberList()) {
            if (m instanceof Student) {
                list.add(m);
            }
        }

        return list;
    }

    @GetMapping("/student")
    public Member student(@RequestParam String id) {
        for (Member m : memberList()) {
            if (m.getId().equals(id)) {
                return m;
            }
        }

        return new Member();
    }

}