package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class GradeList {
    private final ArrayList<Double> grades;

    public GradeList() {
        this.grades = new ArrayList<Double>();
    };

    public void addNew(Double grade) {
        this.grades.add(grade);
    }

    public void addNew(Double[] newGrades) {
        this.grades.addAll(Arrays.asList(newGrades));
    }

    public void addNew(int grade) {
        this.grades.add((double) grade);
    }

    public double avg() {
        if (this.grades.isEmpty()) {
            return -1.0;
        }
        double sum = 0.0;
        for (Double grade : this.grades) {
            sum += grade;
        }
        return sum / this.grades.size();
    }

    public double min() {
        if (this.grades.isEmpty()) {
            return -1.0;
        }
        double min = this.grades.get(0);
        for (Double grade : this.grades) {
            if (grade < min) {
                min = grade;
            }
        }
        return min;
    }

    public double max() {
        if (this.grades.isEmpty()) {
            return -1.0;
        }
        double max = this.grades.get(0);
        for (Double grade : this.grades) {
            if (grade > max) {
                max = grade;
            }
        }
        return max;
    }
}
