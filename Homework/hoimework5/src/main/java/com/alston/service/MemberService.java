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

    public Boolean getTeacher(String teacherId) {
        Teacher teacher = memberRepository.findTeacherById(teacherId);
        if (teacher != null) {
            return true;
        }
        return false;
    }

    public Boolean getStudent(String studentId) {
        Student student = memberRepository.findStudentById(studentId);
        if (student != null) {
            return true;
        }
        return false;
    }

    public Boolean addTeacher(Teacher teacherInfo) {
        Object teacher = memberRepository.save(teacherInfo);
        if (teacher != null) {
            return true;
        }
        return false;
    }

    public Boolean addStudent(Student studentInfo) {
        Object student = memberRepository.save(studentInfo);
        if (student != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateTeacher(Teacher teacherInfo) {
        Teacher teacher = memberRepository.findTeacherById(teacherInfo.getId());

        if (teacher != null) {
            teacher.setName(teacherInfo.getName());
            teacher.setGender(teacherInfo.getGender());
            teacher.setSubject(teacherInfo.getSubject());
            teacher.setJobTitle(teacherInfo.getJobTitle());
            memberRepository.save(teacher);

            return true;
        }
        return false;
    }

    @Transactional
    public Boolean updateStudent(Student studentInfo) {
        Student student = memberRepository.findStudentById(studentInfo.getId());

        if (student != null) {
            student.setName(studentInfo.getName());
            student.setGender(studentInfo.getGender());
            student.setAdmissionYearMonth(studentInfo.getAdmissionYearMonth());
            student.setStudentClass(studentInfo.getStudentClass());
            memberRepository.save(student);

            return true;
        }

        return false;
    }

    public String deleteTeacher(String teacherId) {
        Teacher teacher = memberRepository.findTeacherById(teacherId);
        if (teacher != null) {
            return "id: " + teacherId + " not found";
        }
        memberRepository.deleteById(teacherId);

        return "id: " + teacherId + "has been deleted";
    }

    public String deleteStudent(String studentId) {
        Student student = memberRepository.findStudentById(studentId);
        if (student != null) {
            return "id: " + studentId + " not found";
        }
        memberRepository.deleteById(studentId);

        return "id: " + studentId + "has been deleted";
    }

}