package com.alston.service;

import com.alston.dao.MemberRepository;
import com.alston.model.Member;

import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

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
        Teacher teacher;
        if ((teacher = memberRepository.findTeacherById(teacherId)) != null) {
            return teacher;
        }
        return new Member();
    }

    public Member getStudent(String studentId) {
        return memberRepository.findStudentById(studentId);
    }

    public String addTeacher(Teacher teacherInfo) {
        Teacher teacher = (Teacher) memberRepository.save(teacherInfo);
        return teacher.getId();
    }

    public String addStudent(Student studentInfo) {
        Student student = (Student) memberRepository.save(studentInfo);
        return student.getId();
    }

    @Transactional
    public Teacher updateTeacher(Teacher teacherInfo) {
        Teacher teacher;

        if ((teacher = memberRepository.findTeacherById(teacherInfo.getId())) != null) {
            teacher.setName(teacherInfo.getName());
            teacher.setGender(teacherInfo.getGender());
            teacher.setSubject(teacherInfo.getSubject());
            teacher.setJobTitle(teacherInfo.getJobTitle());

            return (Teacher) memberRepository.save(teacher);
        }

        return new Teacher();
    }

    @Transactional
    public Student updateStudent(Student studentInfo) {
        Student student;

        if ((student = memberRepository.findStudentById(studentInfo.getId())) != null) {
            student.setName(studentInfo.getName());
            student.setGender(studentInfo.getGender());
            student.setAdmissionYearMonth(studentInfo.getAdmissionYearMonth());
            student.setStudentClass(studentInfo.getStudentClass());

            return (Student) memberRepository.save(student);
        }

        return new Student();
    }

    public String deleteTeacher(String teacherId) {
        if (memberRepository.findTeacherById(teacherId) == null) {
            return "id: " + teacherId + " not found";
        }
        memberRepository.deleteById(teacherId);

        return "id: " + teacherId + "has been deleted";
    }

    public String deleteStudent(String studentId) {
        if (memberRepository.findStudentById(studentId) == null) {
            return "id: " + studentId + " not found";
        }
        memberRepository.deleteById(studentId);

        return "id: " + studentId + "has been deleted";
    }

}