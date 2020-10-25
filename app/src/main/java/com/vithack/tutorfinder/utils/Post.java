package com.vithack.tutorfinder.utils;

public class Post {

    private String postby_id,subject,medium,salary,location,p_university,deadline,classes;

    public Post() {
    }

    public Post(String postby_id, String subject, String medium, String salary, String location, String p_university, String deadline, String classes) {
        this.postby_id = postby_id;
        this.subject = subject;
        this.medium = medium;
        this.salary = salary;
        this.location = location;
        this.p_university = p_university;
        this.deadline = deadline;
        this.classes = classes;
    }

    public String getPostby_id() {
        return postby_id;
    }

    public void setPostby_id(String postby_id) {
        this.postby_id = postby_id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getP_university() {
        return p_university;
    }

    public void setP_university(String p_university) {
        this.p_university = p_university;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
