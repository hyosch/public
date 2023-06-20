package com.alston.dao;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository<T extends Member> extends JpaRepository<T, String> {

    @Query("from Teacher")
    List<Teacher> findAllTeacher();

    @Query("from Student")
    List<Student> findAllStudent();

}