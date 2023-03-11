package projectJava;

public class ReportCard {
    public static void main(String[] args){
        Student1 s1 = new Student1("rim", "223");
        English english = new English();
        Maths maths = new Maths();

        maths.setMidTermMarks(70);
        s1.setM1(maths);
        //s1.show();

        maths.setFinalTermMarks(90);
        s1.setM1(maths);

        english.setMidTermMarks(31);
        s1.setE1(english);
        System.out.println("E!.. get");
        System.out.println(s1.getE1().getMidTermMarks()+ "got E1...");
        System.out.println(s1.getM1().getMidTermMarks()+" got Math Mid");
        System.out.println(s1.getM1().getFinalTermMarks()+ " got Math Final");
        System.out.println(s1.mathGrade() + " Showing Math Grade");

        String string = null;
        System.out.println("Main String: " +string);
        new ProjectReportCard();
    }
}
