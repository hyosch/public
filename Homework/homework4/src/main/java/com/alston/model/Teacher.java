package com.alston.model;

public class Teacher extends Member {

    String subject;
    String jobTitle;

    public Teacher() {
    }

    public Teacher(String id, String name, String gender, String subject, String jobTitle) {
        super(id, name, gender);
        this.subject = subject;
        this.jobTitle = jobTitle;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

}