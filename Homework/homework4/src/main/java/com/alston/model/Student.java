package com.alston.model;

public class Student extends Member {

    String studentClass;
    String admissionYearMonth;

    public Student() {
    }

    public Student(String id, String name, String gender, String studentClass, String admissionYearMonth) {
        super(id, name, gender);
        this.studentClass = studentClass;
        this.admissionYearMonth = admissionYearMonth;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public String getAdmissionYearMonth() {
        return admissionYearMonth;
    }

    public void setAdmissionYearMonth(String admissionYearMonth) {
        this.admissionYearMonth = admissionYearMonth;
    }

}