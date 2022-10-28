package com.pldc.gpa_service.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "degree")
public class Degree {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "degree_id")
    int degreeId;

    @Column(name = "degree_name", updatable = false)
    String degreeName;

    @OneToMany(mappedBy = "degree")
    private List<Module> modules;

    @OneToMany(mappedBy = "degree")
    private List<Student> students;

    public Degree(int degreeId) {
    }

    public Degree() {
    }

    public int getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(int degreeId) {
        this.degreeId = degreeId;
    }

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "degreeId=" + degreeId +
                ", degreeName='" + degreeName + '\'' +
                ", modules=" + modules +
                ", students=" + students +
                '}';
    }
}
