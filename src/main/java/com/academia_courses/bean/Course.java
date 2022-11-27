package com.academia_courses.bean;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;

    @Column(nullable = false, unique = true)
    private String courseCode;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Column
    private String discription;

    @Column(nullable = false)
    private Integer year;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Integer credits;

    @Column(nullable = false)
    private Integer capacity;

    @Column(nullable = false)
    private String faculty;

    public Course() {
    }
    public Course(String courseCode, String courseName, String discription, Integer year, Integer term, Integer credits, Integer capacity, String faculty) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.discription = discription;
        this.year = year;
        this.term = term;
        this.credits = credits;
        this.capacity = capacity;
        this.faculty = faculty;

    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}