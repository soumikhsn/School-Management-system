package projectJava;

public interface Grade{
    public String showGrade();
}

interface Functions{
    public void setMidTermMarks(double midTermMarks);
    public double getMidTermMarks();

    public void setFinalTermMarks(double finalTermMarks);
    public double getFinalTermMarks();
}

class Classification{
    public static String showGradeClassification(double i){
        if(i >= 90){
            return "(A)";
        }
        else if(i >= 80){
            return "(B)";
        }
        else if(i >= 70){
            return "(C)";
        }
        else if(i >= 60){
            return "(D)";
        }
        else if(i >= 50){
            return "(E)";
        }
        else {
            return "(F)";
        }
    }
}

class Term{
    protected double midTermMarks;
    protected double finalTermMarks;
}
