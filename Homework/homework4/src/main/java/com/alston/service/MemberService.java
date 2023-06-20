package com.alston.service;

import com.alston.dao.MemberRepository;
import com.alston.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public List<Member> getAllTeacher() {
        return memberRepository.findAllTeacher();
    }

    public List<Member> getAllStudent() {
        return memberRepository.findAllStudent();
    }

    public Member getTeacher(String teacherId) {
        for (Member m : getAllTeacher()) {
            if ((m.getId()).equals(teacherId)) {
                return m;
            }
        }

        return new Member();
    }

    public Member getStudent(String studentId) {
        for (Member m : getAllStudent()) {
            if ((m.getId()).equals(studentId)) {
                return m;
            }
        }

        return new Member();
    }

}