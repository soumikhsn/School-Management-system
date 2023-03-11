package projectJava;

import java.io.Serializable;

public class Bangla extends Term implements Grade, Functions, Serializable {

    @Override
    public void setFinalTermMarks(double finalTermMarks) {
        this.finalTermMarks = finalTermMarks;
    }

    @Override
    public double getFinalTermMarks() {
        return finalTermMarks;
    }

    @Override
    public void setMidTermMarks(double midTermMarks) {
        this.midTermMarks = midTermMarks;
    }

    public double getMidTermMarks() {
        return midTermMarks;
    }
    @Override
    public String showGrade() {
        double i = (this.getMidTermMarks() + this.getFinalTermMarks()) / 2;
        String j = Classification.showGradeClassification(i);
        System.out.println("Grade Bangla: " + i);
        return j;
    }
}