package projectJava;

import java.io.Serializable;

public class Student1 implements Serializable {
    private String name;
    private String id;
    private Maths m1;
    private English e1;
    private Bangla b1;

    public Student1(){}

    public Student1(String name, String id){
        this.name = name;
        this.id = id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setE1(English e1) {
        this.e1 = e1;
    }

    public English getE1() {
        return e1;
    }

    public void setM1(Maths m1) {
        this.m1 = m1;
    }

    public Maths getM1() {
        return m1;
    }

    public Bangla getB1() {
        return b1;
    }

    public void setB1(Bangla b1) {
        this.b1 = b1;
    }

    public String mathGrade(){
        return m1.showGrade();
    }

    public String englishGrade(){
        return e1.showGrade();
    }

    public String banglaGrade(){
        return b1.showGrade();
    }

    @Override
    public String toString() {
        return "Student1{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", maths Mid=" + m1.getMidTermMarks() +
                ", maths Final=" + m1.getFinalTermMarks() +
                ", eng Mid=" + e1.getMidTermMarks() +
                ", eng Final=" + e1.getFinalTermMarks() +
                ", bangla Mid=" + b1.getMidTermMarks() +
                ", bangla Final=" + b1.getFinalTermMarks() +
                '}';
    }
}
