package com.alston.dao;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository<T extends Member> extends JpaRepository<T, String> {

    @Query("from Teacher")
    List<Teacher> findAllTeacher();

    @Query("SELECT t from Teacher t WHERE t.id = :teacherId")
    Teacher findTeacherById(@Param("teacherId") String teacherId);

    @Query("from Student")
    List<Student> findAllStudent();

    @Query("SELECT s from Student s WHERE s.id = :studentId")
    Student findStudentById(@Param("studentId") String studentId);

}