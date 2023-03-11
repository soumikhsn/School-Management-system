package projectJava;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class ProjectReportCard extends JFrame {

    static JTable table;
    static DefaultTableModel model;

    static JScrollPane scroll;
    String[] columns = {"First Name", "Student Id", "Mid Maths", "Final Maths", "Maths Grade", "Mid English", "Final English", "English Grade",
            "Mid Bangla", "Final Bangla", "Bangla Grade"};
    static String[] rows = new String[11];

    JButton add, update, delete, save, show;
    JLabel headline, areaHeadline;
    JTextField StudNameText;
    JTextField studentIDText;
    JLabel studentName, studentID, mathMid, mathFinal, englishMid, englishFinal, banglaMid, banlgaFinal;
    TextField mathFinalText, mathMidText, englishMidText, englishFinalText, banglaMidText, banglaFinalText;
    JFrame jFrame;
    static Container container, container1;
    JOptionPane jOptionPane;

    Student1 st1;
    English e1;
    Maths m1;
    Bangla b1;
    double d2, d3;
    String s, s1, s2;

    String file = "Report Test.txt";
    static int tableRow = -1;
    static int height = 220;

    ProjectReportCard() {
        container = getContentPane();
        container.setLayout(null);
        setBounds(300, 90, 1200, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("Student Result Card");

        studentName = new JLabel("Student Name");
        studentName.setSize(120, 20);
        studentName.setLocation(50, 80);//50 80
        container.add(studentName);

        StudNameText = new JTextField();
        StudNameText.setSize(220, 20);
        StudNameText.setLocation(180, 80);
        StudNameText.setEditable(true);
        container.add(StudNameText);

        studentID = new JLabel("Student ID");
        studentID.setSize(120, 20);
        studentID.setLocation(50, 110);
        container.add(studentID);

        studentIDText = new JTextField();
        studentIDText.setSize(220, 20);
        studentIDText.setLocation(180, 110);
        studentIDText.setEditable(true);
        container.add(studentIDText);

        mathMid = new JLabel("Maths Mid");
        mathMid.setSize(100, 20);
        mathMid.setLocation(50, 140);
        container.add(mathMid);

        mathMidText = new TextField(10);
        mathMidText.setSize(220, 20);
        mathMidText.setLocation(180, 140);
        mathMidText.setEditable(true);
        container.add(mathMidText);

        mathFinal = new JLabel("Maths Final");
        mathFinal.setSize(100, 20);
        mathFinal.setLocation(50, 170);
        container.add(mathFinal);

        mathFinalText = new TextField(10);
        mathFinalText.setSize(220, 20);
        mathFinalText.setLocation(180, 170);
        mathFinalText.setEditable(true);
        container.add(mathFinalText);

        englishMid = new JLabel("English Mid");
        englishMid.setSize(100, 20);
        englishMid.setLocation(50, 200);
        container.add(englishMid);

        englishMidText = new TextField(10);
        englishMidText.setSize(220, 20);
        englishMidText.setLocation(180, 200);
        container.add(englishMidText);

        englishFinal = new JLabel("English Final");
        englishFinal.setSize(100, 20);
        englishFinal.setLocation(50, 230);
        container.add(englishFinal);

        englishFinalText = new TextField(10);
        englishFinalText.setSize(220, 20);
        englishFinalText.setLocation(180, 230);
        container.add(englishFinalText);

        banglaMid = new JLabel("Bangla Mid");
        banglaMid.setSize(100, 20);
        banglaMid.setLocation(50, 260);
        container.add(banglaMid);

        banglaMidText = new TextField(10);
        banglaMidText.setSize(220, 20);
        banglaMidText.setLocation(180, 260);
        container.add(banglaMidText);

        banlgaFinal = new JLabel("Bangla Final");
        banlgaFinal.setSize(100, 20);
        banlgaFinal.setLocation(50, 290);
        container.add(banlgaFinal);

        banglaFinalText = new TextField(10);
        banglaFinalText.setSize(220, 20);
        banglaFinalText.setLocation(180, 290);
        container.add(banglaFinalText);

        add = new JButton("Add");
        add.setSize(100, 20);
        add.setLocation(500, 80);
        container.add(add);

        update = new JButton("Update");
        update.setSize(100, 20);
        update.setLocation(500, 110);
        container.add(update);

        delete = new JButton("Delete");
        delete.setSize(100, 20);
        delete.setLocation(500, 140);
        container.add(delete);

        save = new JButton("Save");
        save.setSize(100, 20);
        save.setLocation(500, 170);
        container.add(save);

        model = new DefaultTableModel(rows, 0) {
            public boolean isCellEditable(int i, int i1) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
        };

        table = new JTable(model);
        model.setColumnIdentifiers(columns);

        table.setModel(model);
        table.setRowHeight(30);
        //table.setPreferredSize(new Dimension(1000, height));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(300);
        columnModel.getColumn(1).setPreferredWidth(10);
        columnModel.getColumn(2).setPreferredWidth(10);
        columnModel.getColumn(3).setPreferredWidth(10);
        columnModel.getColumn(4).setPreferredWidth(10);
        columnModel.getColumn(5).setPreferredWidth(10);
        columnModel.getColumn(6).setPreferredWidth(10);
        columnModel.getColumn(7).setPreferredWidth(10);
        columnModel.getColumn(8).setPreferredWidth(10);
        columnModel.getColumn(9).setPreferredWidth(10);
        columnModel.getColumn(10).setPreferredWidth(10);

        scroll = new JScrollPane(table);
        scroll.setSize(1100, 260);//600 250 // 1200 220
        scroll.setLocation(20, 330);//200
        container.add(scroll);

        List<Student1> list = new ArrayList<Student1>();

        //List<Student1> list1 = new ArrayList<Student1>();

        /*st1 = new Student1();
        m1 = new Maths();
        e1 = new English();
        b1 = new Bangla();*/

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                st1 = new Student1();
                m1 = new Maths();
                e1 = new English();
                b1 = new Bangla();

                st1.setName(StudNameText.getText());
                String name = st1.getName();
                rows[0] = name;

                st1.setId(studentIDText.getText());
                String id = st1.getId();
                rows[1] = id;

                try {
                    s = mathMidText.getText();
                    if (!s.equals("")) {
                        d2 = Double.parseDouble(s);
                        m1.setMidTermMarks(d2);
                        st1.setM1(m1);

                        d3 = st1.getM1().getMidTermMarks();
                        s2 = String.valueOf(d3);
                        rows[2] = s2;
                    } else {
                        rows[2] = mathMidText.getText();
                        m1.setMidTermMarks(Double.NaN);
                        st1.setM1(m1);
                        System.out.println("Math Mid: " +st1.getM1().getMidTermMarks());
                    }
                } catch (Exception e2) {
                    System.out.println("here i am..");
                    rows[2] = "";
                    m1.setMidTermMarks(Double.NaN);
                    st1.setM1(m1);
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    e2.printStackTrace();
                }

                try {
                    s1 = mathFinalText.getText();
                    if (!s1.equals("")) {
                        System.out.println("trying");
                        d2 = Double.parseDouble(s1);
                        m1.setFinalTermMarks(d2);
                        st1.setM1(m1);

                        d3 = st1.getM1().getFinalTermMarks();
                        s2 = String.valueOf(d3);
                        rows[3] = s2;
                    } else {
                        rows[3] = mathFinalText.getText();
                        m1.setFinalTermMarks(Double.NaN);
                        st1.setM1(m1);
                    }
                } catch (Exception e2) {
                    rows[3] = "";
                    m1.setFinalTermMarks(Double.NaN);
                    st1.setM1(m1);
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    e2.printStackTrace();
                }

                if (!mathMidText.getText().equals("") && !mathFinalText.getText().equals("")) {
                    try {
                        System.out.println("Maths... " + st1.getM1().getMidTermMarks() + " " + st1.getM1().getFinalTermMarks());
                        String s2 = st1.mathGrade();
                        //String s3 = String.valueOf(d3);
                        rows[4] = s2;

                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(jFrame, "Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }
                    System.out.println(st1.mathGrade() + "from table...");
                } else {
                    rows[4] = "";
                }

                try {
                    s = englishMidText.getText();
                    if (!s.equals("")) {
                        System.out.println("hello try");
                        d2 = Double.parseDouble(s);
                        e1.setMidTermMarks(d2);
                        st1.setE1(e1);

                        d3 = st1.getE1().getMidTermMarks();
                        s2 = String.valueOf(d3);
                        rows[5] = s2;
                    } else {
                        rows[5] = englishMidText.getText();
                        //rows[5] = null;
                        e1.setMidTermMarks(Double.NaN);
                        st1.setE1(e1);
                    }
                } catch (Exception e2) {
                    rows[5] = "";
                    e1.setMidTermMarks(Double.NaN);
                    st1.setE1(e1);
                    System.out.println("Error!!!");
                    JOptionPane.showMessageDialog(jFrame, "Error");
                }

                try {
                    s = englishFinalText.getText();
                    if (!s.equals("")) {
                        d2 = Double.parseDouble(s);
                        e1.setFinalTermMarks(d2);
                        st1.setE1(e1);

                        d3 = st1.getE1().finalTermMarks;
                        s2 = String.valueOf(d3);
                        rows[6] = s2;
                    } else {
                        rows[6] = englishFinalText.getText();
                        //rows[6] = null;
                        e1.setFinalTermMarks(Double.NaN);
                        st1.setE1(e1);
                    }
                } catch (Exception e2) {
                    rows[6] = "";
                    e1.setFinalTermMarks(Double.NaN);
                    st1.setE1(e1);
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    System.out.println("Error!!!");
                }

                if (!englishMidText.getText().equals("") && !englishFinalText.getText().equals("")) {
                    try {
                        String s2 = st1.englishGrade();
                        //String s3 = String.valueOf(d3);
                        rows[7] = s2;
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(jFrame, "Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }
                    System.out.println(st1.mathGrade() + "from table...");
                } else {
                    rows[7] = "";
                }

                try {
                    s = banglaMidText.getText();
                    if (!s.equals("")) {
                        System.out.println("hello try");
                        d2 = Double.parseDouble(s);
                        b1.setMidTermMarks(d2);
                        st1.setB1(b1);

                        d3 = st1.getB1().getMidTermMarks();
                        s2 = String.valueOf(d3);
                        rows[8] = s2;
                    } else {
                        rows[8] = banglaMidText.getText();
                        //rows[8] = null;
                        b1.setMidTermMarks(Double.NaN);
                        st1.setB1(b1);
                    }
                } catch (Exception e2) {
                    rows[8] = "";
                    b1.setMidTermMarks(Double.NaN);
                    st1.setB1(b1);
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    System.out.println("Error!!!");
                    e2.printStackTrace();
                }

                try {
                    s = banglaFinalText.getText();
                    if (!s.equals("")) {
                        d2 = Double.parseDouble(s);
                        b1.setFinalTermMarks(d2);
                        st1.setB1(b1);

                        d3 = st1.getB1().finalTermMarks;
                        s2 = String.valueOf(d3);
                        rows[9] = s2;
                    } else {
                        rows[9] = banglaFinalText.getText();
                        //rows[9] = null;
                        b1.setFinalTermMarks(Double.NaN);
                        st1.setB1(b1);
                    }
                } catch (Exception e2) {
                    rows[9] = "";
                    b1.setFinalTermMarks(Double.NaN);
                    st1.setB1(b1);
                    JOptionPane.showMessageDialog(jFrame, "Error");
                    System.out.println("Error!!!");
                }

                if (!banglaMidText.getText().equals("") && !banglaFinalText.getText().equals("")) {
                    try {
                        String s2 = st1.banglaGrade();
                        rows[10] = s2;
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(jFrame, "Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }
                    System.out.println(st1.banglaGrade() + "from table...");
                } else {
                    rows[10] = "";
                }
                list.add(st1);

                System.out.println(list.size() + "is the list size");

                for (Student1 student1 : list){
                    System.out.println(student1.toString());
                }
                model.addRow(rows);
                tableRow++;
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                st1 = new Student1();
                m1 = new Maths();
                e1 = new English();
                b1 = new Bangla();

                int rowNumber = table.getSelectedRow();
                if (rowNumber >= 0) {
                    model.removeRow(rowNumber);
                    tableRow--;
                    list.remove(rowNumber);
                    System.out.println(list.size() + "is the list size");
                }
                for (Student1 student1 : list){
                    System.out.println(student1.toString());
                }
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int rowNumber = table.getSelectedRow();
                System.out.println(rowNumber + "row number");
                try {
                    if (table.getSelectedRow() >= 0) {
                        String studName = model.getValueAt(rowNumber, 0).toString();
                        String studID = model.getValueAt(rowNumber, 1).toString();
                        String mathMid = model.getValueAt(rowNumber, 2).toString();
                        String mathFinal = model.getValueAt(rowNumber, 3).toString();
                        String englishMid = model.getValueAt(rowNumber, 5).toString();
                        String englishFinal = model.getValueAt(rowNumber, 6).toString();
                        String banglaMid = model.getValueAt(rowNumber, 8).toString();
                        String banglaFinal = model.getValueAt(rowNumber, 9).toString();

                        StudNameText.setText(studName);
                        studentIDText.setText(studID);
                        mathMidText.setText(mathMid);
                        mathFinalText.setText(mathFinal);
                        englishMidText.setText(englishMid);
                        englishFinalText.setText(englishFinal);
                        banglaMidText.setText(banglaMid);
                        banglaFinalText.setText(banglaFinal);
                    }
                } catch (Exception e2){
                    System.out.println("problem occurs");
                    //e2.printStackTrace();
                }
            }
        });

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int rowNumber = table.getSelectedRow();
                System.out.println("Update row Number: " + rowNumber);
                if (rowNumber >= 0) {
                    st1 = new Student1();
                    m1 = new Maths();
                    e1 = new English();
                    b1 = new Bangla();

                    String studName = StudNameText.getText();
                    String studID = studentIDText.getText();
                    String mathMidMarks = mathMidText.getText();
                    String mathFinalMarks = mathFinalText.getText();
                    String englishMidMarks = englishMidText.getText();
                    String englishFinalMarks = englishFinalText.getText();
                    String banglaMidMarks = banglaMidText.getText();
                    String banglaFinalMarks = banglaFinalText.getText();

                    int mm = -1, ee = -1, bb = -1;

                    try {
                        st1.setName(StudNameText.getText());
                        String name = st1.getName();
                        System.out.println("Name: " + name);
                        rows[0] = name;
                        model.setValueAt(name, rowNumber, 0);

                        st1.setId(studentIDText.getText());
                        String id = st1.getId();
                        rows[1] = id;
                        model.setValueAt(id, rowNumber, 1);
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(jFrame, "Name Error");
                        e2.printStackTrace();
                    }

                    try {
                        s = mathMidText.getText();
                        if (!s.equals("")) {
                            d2 = Double.parseDouble(s);
                            m1.setMidTermMarks(d2);
                            st1.setM1(m1);

                            d3 = st1.getM1().getMidTermMarks();
                            s2 = String.valueOf(d3);
                            rows[2] = s2;
                            model.setValueAt(s2, rowNumber, 2);
                        } else {
                            m1.setMidTermMarks(Double.NaN);
                            st1.setM1(m1);
                            rows[2] = mathMidText.getText();
                            model.setValueAt(s, rowNumber, 2);
                        }
                    } catch (Exception e2) {
                        mm = 0;
                        JOptionPane.showMessageDialog(jFrame, "Maths Mid Error");
                        System.out.println("Mid Maths Error!!!");
                        e2.printStackTrace();
                    }

                    try {
                        s1 = mathFinalText.getText();
                        if (!s1.equals("")) {
                            System.out.println("trying to update");
                            d2 = Double.parseDouble(s1);
                            m1.setFinalTermMarks(d2);
                            st1.setM1(m1);

                            d3 = st1.getM1().getFinalTermMarks();
                            s2 = String.valueOf(d3);
                            rows[3] = s2;
                            model.setValueAt(s2, rowNumber, 3);
                        } else {
                            m1.setFinalTermMarks(Double.NaN);
                            st1.setM1(m1);
                            rows[3] = mathFinalText.getText();
                            model.setValueAt(s1, rowNumber, 3);
                        }
                    } catch (Exception e2) {
                        mm = 0;
                        JOptionPane.showMessageDialog(jFrame, "Final Maths Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }

                    if (!mathMidText.getText().equals("") && !mathFinalText.getText().equals("") && mm == -1) {
                        try {
                            String s3 = st1.mathGrade();
                            //String s3 = String.valueOf(d3);
                            rows[4] = s3;
                            model.setValueAt(s3, rowNumber, 4);
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(jFrame, "Maths Grade Error");
                            System.out.println("Maths Grade Error!!!");
                            e2.printStackTrace();
                        }
                        System.out.println(st1.mathGrade() + "from table...");
                    } else {
                        s = "";
                        rows[4] = s;
                        model.setValueAt(s, rowNumber, 4);
                    }

                    try {
                        s = englishMidText.getText();
                        if (!s.equals("")) {
                            System.out.println("hello try");
                            d2 = Double.parseDouble(s);
                            e1.setMidTermMarks(d2);
                            st1.setE1(e1);

                            d3 = st1.getE1().getMidTermMarks();
                            s2 = String.valueOf(d3);
                            rows[5] = s2;
                            model.setValueAt(s2, rowNumber, 5);
                        } else {
                            rows[5] = englishMidText.getText();
                            model.setValueAt(s, rowNumber, 5);
                        }
                    } catch (Exception e2) {
                        ee = 0;
                        e1.setMidTermMarks(Double.NaN);
                        st1.setE1(e1);
                        JOptionPane.showMessageDialog(jFrame, "English Mid Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }

                    try {
                        s = englishFinalText.getText();
                        if (!s.equals("")) {
                            d2 = Double.parseDouble(s);
                            e1.setFinalTermMarks(d2);
                            st1.setE1(e1);

                            d3 = st1.getE1().finalTermMarks;
                            s2 = String.valueOf(d3);
                            rows[6] = s2;
                            model.setValueAt(s2, rowNumber, 6);
                        } else {
                            e1.setFinalTermMarks(Double.NaN);
                            st1.setE1(e1);
                            rows[6] = englishFinalText.getText();
                            model.setValueAt(s, rowNumber, 6);
                        }
                    } catch (Exception e2) {
                        ee = 0;
                        JOptionPane.showMessageDialog(jFrame, "English Final Error");
                        System.out.println("Error!!!");
                    }

                    if (!englishMidText.getText().equals("") && !englishFinalText.getText().equals("") && ee == -1) {
                        try {
                            String s3 = st1.englishGrade();
                            //String s3 = String.valueOf(d3);
                            rows[7] = s3;
                            model.setValueAt(s3, rowNumber, 7);
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(jFrame, "English Grade Error");
                            System.out.println("Error!!!");
                            e2.printStackTrace();
                        }
                        System.out.println(st1.englishGrade() + "from table...");
                    } else {
                        s = "";
                        rows[7] = s;
                        model.setValueAt(s, rowNumber, 7);
                    }

                    try {
                        s = banglaMidText.getText();
                        if (!s.equals("")) {
                            System.out.println("hello try");
                            d2 = Double.parseDouble(s);
                            b1.setMidTermMarks(d2);
                            st1.setB1(b1);

                            d3 = st1.getB1().getMidTermMarks();
                            s2 = String.valueOf(d3);
                            rows[8] = s2;
                            model.setValueAt(s2, rowNumber, 8);
                        } else {
                            b1.setMidTermMarks(Double.NaN);
                            st1.setB1(b1);
                            rows[8] = banglaMidText.getText();
                            model.setValueAt(s, rowNumber, 8);
                        }
                    } catch (Exception e2) {
                        bb = 0;
                        JOptionPane.showMessageDialog(jFrame, "Bangla Mid Error");
                        System.out.println("Error!!!");
                        e2.printStackTrace();
                    }

                    try {
                        s = banglaFinalText.getText();
                        if (!s.equals("")) {
                            d2 = Double.parseDouble(s);
                            b1.setFinalTermMarks(d2);
                            st1.setB1(b1);

                            d3 = st1.getB1().finalTermMarks;
                            s2 = String.valueOf(d3);
                            rows[9] = s2;
                            model.setValueAt(s2, rowNumber, 9);
                        } else {
                            b1.setFinalTermMarks(Double.NaN);
                            st1.setB1(b1);
                            rows[9] = banglaFinalText.getText();
                            model.setValueAt(s, rowNumber, 9);
                        }
                    } catch (Exception e2) {
                        bb = 0;
                        JOptionPane.showMessageDialog(jFrame, "Bangla Final Error");
                        System.out.println("ERROR!!!");
                    }

                    if (!banglaMidText.getText().equals("") && !banglaFinalText.getText().equals("") && bb == -1) {
                        try {
                            String s3 = st1.banglaGrade();
                            rows[10] = s3;
                            model.setValueAt(s3, rowNumber, 10);
                        } catch (Exception e2) {
                            JOptionPane.showMessageDialog(jFrame, "Bangla Grade Error");
                            System.out.println("Bangla Grade Error!!!");
                            e2.printStackTrace();
                        }
                        System.out.println(st1.banglaGrade() + "from table...");
                    } else {
                        s = "";
                        rows[10] = s;
                        model.setValueAt(s, rowNumber, 10);
                    }

                    try {
                        list.set(table.getSelectedRow(), st1);

                        for (Student1 student1 : list) {
                            System.out.println(student1.toString());
                        }
                    } catch (Exception e2){
                        e2.printStackTrace();
                    }
                }
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i, j;
                try {
                    System.out.println("save row: " +tableRow);
                    PrintWriter printWriter = new PrintWriter(file);
                    for (i = 0; i <= tableRow; i++) {
                        for (j = 0; j < table.getColumnCount(); j++) {
                            try {
                                String check = model.getValueAt(i, j).toString();
                                if (check.equals("")) {
                                    System.out.println("save Exception");
                                    printWriter.write("---");
                                } else {
                                    printWriter.write(model.getValueAt(i, j).toString());
                                }
                                printWriter.write("\n");
                            } catch (Exception e2) {
                                continue;
                            }
                        }
                        printWriter.write("\n");
                    }

                    printWriter.flush();
                    printWriter.close();

                } catch (Exception e2) {
                    e2.printStackTrace();
                    System.out.println(e2.toString() + "error");
                }
                //show.setVisible(true);
                System.out.println("Table row..: " +tableRow);

                st1 = new Student1();
                m1 = new Maths();
                e1 = new English();
                b1 = new Bangla();

                try {
                    FileOutputStream writeData = new FileOutputStream("student_data.txt");
                    ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

                    writeStream.writeObject(list);
                    writeStream.flush();
                    writeStream.close();

                } catch (IOException e2) {
                    e2.printStackTrace();
                }

                try {
                    FileInputStream readData = new FileInputStream("student_data.txt");
                    ObjectInputStream readStream = new ObjectInputStream(readData);

                    List<Student1> list1 = (ArrayList<Student1>) readStream.readObject();
                    readStream.close();
                } catch (Exception e2){

                }
            }
        });

        //show.addActionListener(new ActionListener() {
        //  @Override
        //public void actionPerformed(ActionEvent e) {
        try {
            int i = 0;
            System.out.println();
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] tableLines = br.lines().toArray();
            Scanner myReader = new Scanner(br);
            String string;
            System.out.println("Show... row: " +tableRow + " lines: " +tableLines.length);
            for (int k = 0; k < tableLines.length; k++) {
                string = Files.readAllLines(Paths.get("Report Test.txt")).get(k);
                if (!string.equals("")) {
                    rows[i] = string;
                    if (string.equals("---")) {
                        rows[i] = "";
                    }
                    i++;
                } else {
                    model.addRow(rows);
                    i = 0;
                    tableRow++;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }

        try{
            for(int u = 0; u <= tableRow; u++) {
                System.out.println("here i am");
                st1 = new Student1();
                m1 = new Maths();
                e1 = new English();
                b1 = new Bangla();

                double p;
                String studName = model.getValueAt(u, 0).toString();
                String studID = model.getValueAt(u, 1).toString();
                String mathMid = model.getValueAt(u, 2).toString();
                String mathFinal = model.getValueAt(u, 3).toString();
                String englishMid = model.getValueAt(u, 5).toString();
                String englishFinal = model.getValueAt(u, 6).toString();
                String banglaMid = model.getValueAt(u, 8).toString();
                String banglaFinal = model.getValueAt(u, 9).toString();

                if(studName != ""){
                    st1.setName(studName);
                    st1.getName();
                }
                if(studID != ""){
                    st1.setId(studID);
                    st1.getId();
                }
                if(mathMid != ""){
                    p = Double.parseDouble(mathMid);
                    m1.setMidTermMarks(p);
                    st1.setM1(m1);
                    st1.getM1().getMidTermMarks();
                }
                else {
                    //rows[3] = mathFinalText.getText();
                    m1.setMidTermMarks(Double.NaN);
                    st1.setM1(m1);
                }
                System.out.println("no aim");
                if(mathFinal != ""){
                    p = Double.parseDouble(mathFinal);
                    m1.setFinalTermMarks(p);
                    st1.setM1(m1);
                    st1.getM1().getFinalTermMarks();
                }
                else {
                    //rows[3] = mathFinalText.getText();
                    m1.setFinalTermMarks(Double.NaN);
                    st1.setM1(m1);
                }
                if(englishMid != ""){
                    p = Double.parseDouble(englishMid);
                    e1.setMidTermMarks(p);
                    st1.setE1(e1);
                    st1.getE1().getMidTermMarks();
                }
                else {
                    e1.setMidTermMarks(Double.NaN);
                    st1.setE1(e1);
                }
                if(englishFinal != ""){
                    p = Double.parseDouble(englishFinal);
                    e1.setFinalTermMarks(p);
                    st1.setE1(e1);
                    st1.getE1().getFinalTermMarks();
                }
                else {
                    //rows[5] = englishMidText.getText();
                    //rows[5] = null;
                    e1.setFinalTermMarks(Double.NaN);
                    st1.setE1(e1);
                }
                if(banglaMid != ""){
                    p = Double.parseDouble(banglaMid);
                    b1.setMidTermMarks(p);
                    st1.setB1(b1);
                    st1.getB1().getMidTermMarks();
                }
                else {
                    //rows[8] = banglaMidText.getText();
                    //rows[8] = null;
                    b1.setMidTermMarks(Double.NaN);
                    st1.setB1(b1);
                }
                if(banglaFinal != ""){
                    p = Double.parseDouble(banglaFinal);
                    b1.setFinalTermMarks(p);
                    st1.setB1(b1);
                    st1.getB1().getFinalTermMarks();
                }
                else {
                    //rows[8] = banglaMidText.getText();
                    //rows[8] = null;
                    b1.setFinalTermMarks(Double.NaN);
                    st1.setB1(b1);
                }

                list.add(st1);
            }
            for(Student1 student1 : list){
                System.out.println(student1.toString());
            }
        } catch (Exception e2){
            e2.printStackTrace();
        }
        //});
        setVisible(true);
    }
}
