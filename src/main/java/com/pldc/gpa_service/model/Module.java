package com.pldc.gpa_service.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "module")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "module_id")
    private int moduleId;

    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "degree_id")
    private Degree degree;

    @Column(name = "module_name")
    private String moduleName;

    @Column(name = "year")
    private int year;

    @Column(name = "credit")
    private int credit;

    @OneToMany(mappedBy = "module")
    private List<Result> results;

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
}
