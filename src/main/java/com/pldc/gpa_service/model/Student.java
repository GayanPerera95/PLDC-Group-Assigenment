package com.pldc.gpa_service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @Column(name = "student_id")
    int studentId;

    @Column(name = "name")
    String name;

    @Column(name = "batch")
    String batch;

    @Column(name = "password")
    String password;

    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
    private Degree degree;

    @OneToMany(mappedBy = "student")
    private List<Result> results;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

}
