package com.alston.service;

import com.alston.dao.MemberRepository;
import com.alston.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    List<Member> memberList;

    public List<Member> getAllMember() {
        return memberRepository.findAll();
    }

    public List<Member> getAllTeacher() {
        memberList = new ArrayList<>();
        for (Member m : memberRepository.findAll()) {
            if (!m.getJobTitle().isEmpty()) {
                memberList.add(m);
            }
        }

        return memberList;
    }

    public List<Member> getAllStudent() {
        memberList = new ArrayList<>();
        for (Member m : memberRepository.findAll()) {
            if (!m.getStudentClass().isEmpty()) {
                memberList.add(m);
            }
        }

        return memberList;
    }

    public List<Member> getTeacher(String teacherId) {
        List<Member> list = new ArrayList<>();
        for (Member m : getAllTeacher()) {
            if ((m.getId()).equals(teacherId)) {
                list.add(m);
                return list;
            }
        }

        return new ArrayList<>();
    }

    public List<Member> getStudent(String studentId) {
        List<Member> list = new ArrayList<>();
        for (Member m : getAllStudent()) {
            if ((m.getId()).equals(studentId)) {
                list.add(m);
                return list;
            }
        }

        return new ArrayList<>();
    }

}