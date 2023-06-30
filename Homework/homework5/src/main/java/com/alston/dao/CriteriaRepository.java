package com.alston.dao;

import com.alston.model.Member;
import com.alston.model.Student;
import com.alston.model.Teacher;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CriteriaRepository {

    @PersistenceContext
    EntityManager em;

    public List<Member> getAllMember() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Member> cq = cb.createQuery(Member.class);
        cq.from(Member.class);

        return em.createQuery(cq).getResultList();
    }

    public List<Member> getAllTeacher() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);
        cq.from(Teacher.class);

        List<Teacher> resultList = em.createQuery(cq).getResultList();
        List<Member> memberList = new ArrayList<>();
        for (Teacher t : resultList) {
            memberList.add(t);
        }

        return memberList;
    }

    public List<Member> getAllStudent() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);
        cq.from(Student.class);

        List<Student> resultList = em.createQuery(cq).getResultList();
        List<Member> memberList = new ArrayList<>();
        for (Student t : resultList) {
            memberList.add(t);
        }

        return memberList;
    }

    public Teacher getTeacherById(String teacherId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Teacher> cq = cb.createQuery(Teacher.class);

        Root<Teacher> root = cq.from(Teacher.class);
        cq.select(root)
                .where(cb.equal(root.get("id"), teacherId));
        List<Teacher> resultList = em.createQuery(cq).getResultList();

        return resultList.get(0);
    }

    public Student getStudentById(String studentId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> root = cq.from(Student.class);
        cq.select(root)
                .where(cb.equal(root.get("id"), studentId));
        List<Student> resultList = em.createQuery(cq).getResultList();

        return resultList.get(0);
    }

    @Transactional
    public Integer updateTeacher(Teacher teacher) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Teacher> cu = cb.createCriteriaUpdate(Teacher.class);

        Root<Teacher> root = cu.from(Teacher.class);
        cu.set("name", teacher.getName());
        cu.set("gender", teacher.getGender());
        cu.set("subject", teacher.getSubject());
        cu.set("jobTitle", teacher.getJobTitle());
        cu.where(cb.equal(root.get("id"), teacher.getId()));

        return em.createQuery(cu).executeUpdate();
    }

    @Transactional
    public Integer updateStudent(Student student) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaUpdate<Student> cu = cb.createCriteriaUpdate(Student.class);

        Root<Student> root = cu.from(Student.class);
        cu.set("name", student.getName());
        cu.set("gender", student.getGender());
        cu.set("studentClass", student.getStudentClass());
        cu.set("admissionYearMonth", student.getAdmissionYearMonth());
        cu.where(cb.equal(root.get("id"), student.getId()));

        return em.createQuery(cu).executeUpdate();
    }

    @Transactional
    public Integer deleteTeacherById(String teacherId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Teacher> cd = cb.createCriteriaDelete(Teacher.class);

        Root<Teacher> root = cd.from(Teacher.class);
        cd.where(cb.equal(root.get("id"), teacherId));

        return em.createQuery(cd).executeUpdate();
    }

    @Transactional
    public Integer deleteStudentById(String studentId) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);

        Root<Student> root = cd.from(Student.class);
        cd.where(cb.equal(root.get("id"), studentId));

        return em.createQuery(cd).executeUpdate();
    }

}