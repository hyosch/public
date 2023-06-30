package com.alston.service;

import com.alston.dao.CriteriaRepository;
import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberServiceCriteria {

    @Autowired
    private CriteriaRepository criteriaRepository;

    public List<Member> getAllMember() {
        return criteriaRepository.getAllMember();
    }

    public List<Member> getAllTeacher() {
        return criteriaRepository.getAllTeacher();
    }

    public List<Member> getAllStudent() {
        return criteriaRepository.getAllStudent();
    }

    public Member getTeacher(String teacherId) {
        Teacher teacher = criteriaRepository.getTeacherById(teacherId);
        if (teacher != null) {
            return teacher;
        }
        return null;
    }

    public Member getStudent(String studentId) {
        Student student = criteriaRepository.getStudentById(studentId);
        if (student != null) {
            return student;
        }
        return null;
    }

    @Transactional
    public Integer updateTeacher(Teacher teacherInfo) {
        Teacher teacher = criteriaRepository.getTeacherById(teacherInfo.getId());

        if (teacher != null) {
            teacher.setName(teacherInfo.getName());
            teacher.setGender(teacherInfo.getGender());
            teacher.setSubject(teacherInfo.getSubject());
            teacher.setJobTitle(teacherInfo.getJobTitle());

            return criteriaRepository.updateTeacher(teacher);
        }

        return 0;
    }

    @Transactional
    public Integer updateStudent(Student studentInfo) {
        Student student = criteriaRepository.getStudentById(studentInfo.getId());

        if (student != null) {
            student.setName(studentInfo.getName());
            student.setGender(studentInfo.getGender());
            student.setAdmissionYearMonth(studentInfo.getAdmissionYearMonth());
            student.setStudentClass(studentInfo.getStudentClass());

            return criteriaRepository.updateStudent(student);
        }

        return 0;
    }

    public Integer deleteTeacher(String teacherId) {
        if (criteriaRepository.getTeacherById(teacherId) == null) {
            return 0;
        }
        return criteriaRepository.deleteTeacherById(teacherId);
    }

    public Integer deleteStudent(String studentId) {
        if (criteriaRepository.getStudentById(studentId) == null) {
            return 0;
        }
        return criteriaRepository.deleteStudentById(studentId);
    }

}