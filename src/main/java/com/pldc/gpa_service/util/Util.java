package com.pldc.gpa_service.util;

import com.pldc.gpa_service.model.Result;

import java.util.ArrayList;
import java.util.List;

public class Util {

    public static double calculateGpa(List<Result> results) {

//        List<Result> nonEmptyResults = new ArrayList<>();
        double calGP = 0;
        double gpa;

        for (Result result : results) {

            calGP = calGP + (getGP(result.getGrade()) * 3);
        }

        gpa = calGP/(results.size()*3);

        return gpa;
    }

    public static double getGP(String grade) {

        double gp = 0.0;

        if (grade.equals("A+")) {
            gp = 4.0;
        }else if (grade.equals("A")) {
            gp = 4.0;
        }else if (grade.equals("A-")) {
            gp = 3.7;
        }else if (grade.equals("B+")) {
            gp = 3.3;
        }else if (grade.equals("B")) {
            gp = 3.0;
        }else if (grade.equals("B-")) {
            gp = 2.7;
        }else if (grade.equals("C+")) {
            gp = 2.3;
        }else if (grade.equals("C")) {
            gp = 2.0;
        }else if (grade.equals("C-")) {
            gp = 1.7;
        }else if (grade.equals("D+")) {
            gp = 1.3;
        }else if (grade.equals("D")) {
            gp = 1.0;
        }else if (grade.equals("F")) {
            gp = 0.0;
        }

        return gp;
    }
}
