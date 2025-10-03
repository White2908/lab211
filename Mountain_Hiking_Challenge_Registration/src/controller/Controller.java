package controller;

import model.Mountain;
import model.Mountains;
import model.Student;
import model.Students;
import view.MenuView;
import java.util.Scanner;
import ultils.InputValidator;

public class Controller {
    InputValidator iv = new InputValidator();
    Mountains ml = new Mountains();
    Students sl = new Students();

    public Controller(Mountains ml, Students sl) {
        this.ml = ml;
        this.sl = sl;
    }

    //Feature_1
    public void addStudent() {
        Scanner sc = new Scanner(System.in);
        String studentID = "";
        String name = "";
        String number = "";
        String email = "";
        String mountainCode = "";
        double tuitionFee = 6000000;
        boolean status = false;

        //add id
        while (!status){
            System.out.println(MenuView.ADD_ID);
            studentID = sc.nextLine();
            status = iv.inputValid(studentID,InputValidator.ID_VALIDATE);
            if(!status){
                System.out.println("Invalid ID!!!");
            }
            if(sl.contains(studentID) != null){
                status = false;
            }
            sc = new Scanner(System.in);
        }
        status = false;

        //add name
        while (!status){
            System.out.println(MenuView.ADD_NAME);
            name = sc.nextLine();
            status = iv.inputValid(name,InputValidator.NAME_VALIDATE);
            if(!status){
                System.out.println("Invalid NAME!!!");
            }
            sc = new Scanner(System.in);
        }
        status = false;

        //add number
        while (!status){
            System.out.println(MenuView.ADD_NUMBER);
            number = sc.nextLine();
            status = iv.inputValid(number,InputValidator.NUMBER_VALIDATE);
            if(!status){
                System.out.println("Invalid NUMBER!!!");
            }
        }
        status = false;

        //add email
        while (!status){
            System.out.println(MenuView.ADD_EMAIL);
            email = sc.nextLine();
            status = iv.inputValid(email,InputValidator.EMAIL_VALIDATE);
            if(!status){
                System.out.println("Invalid EMAIL!!!");
            }
        }
        status = false;

        //add mountaincode
        while (!status){
            System.out.println(MenuView.ADD_MOUNTAIN_CODE);
            mountainCode = sc.nextLine();
            status = ml.contains(mountainCode);
            if(!status){
                System.out.println("Invalid MOUNTAIN CODE!!!");
            }
            sc = new Scanner(System.in);
        }
        status = false;

        //caculate fee
        tuitionFee = iv.TUITION_FEE_VALIDATE(number,tuitionFee);

        //add student
        Student s = new Student(studentID, name, number, email, mountainCode, tuitionFee);
        sl.add(s);
        System.out.println(MenuView.ADD_SUCCESS);
    }

    //FEATURE_2
    public void updateStudent(Student s) {
        Scanner sc = new Scanner(System.in);
        String studentID = "";
        String name = "";
        String number = "";
        String email = "";
        String mountainCode = "";
        double tuitionFee = 6000000;
        boolean status = false;

        //add name
        while (!status) {
            System.out.println(MenuView.ADD_NAME + "(" + s.getName() + ")");
            name = sc.nextLine();
            if (name.equals("")) name = s.getName();
            status = iv.inputValid(name, InputValidator.NAME_VALIDATE);
            if (!status) {
                System.out.println("Invalid NAME!!!");
            }
            sc = new Scanner(System.in);
        }
        status = false;

        //update number
        while (!status) {
            System.out.println(MenuView.ADD_NUMBER + "(" + s.getNumber() + ")");
            number = sc.nextLine();
            if (number.equals("")) number = s.getNumber();
            status = iv.inputValid(number, InputValidator.NUMBER_VALIDATE);
            if (!status) {
                System.out.println("Invalid NUMBER!!!");
            }
        }
        status = false;

        //update email
        while (!status) {
            System.out.println(MenuView.ADD_EMAIL + "(" + s.getEmail() + ")");
            email = sc.nextLine();
            if (email.equals("")) email = s.getEmail();
            status = iv.inputValid(email, InputValidator.EMAIL_VALIDATE);
            if (!status) {
                System.out.println("Invalid EMAIL!!!");
            }
        }
        status = false;

        //update mountain code
        while (!status) {
            System.out.println(MenuView.ADD_MOUNTAIN_CODE + "(" + s.getMountainCode() + ")");
            mountainCode = sc.nextLine();
            if (mountainCode.equals("")) mountainCode = s.getMountainCode();
            status = ml.contains(mountainCode);
            if (!status) {
                System.out.println("Invalid MOUNTAIN CODE!!!");
            }
        }

        //update fee
        tuitionFee = iv.TUITION_FEE_VALIDATE(number, tuitionFee);

        s.setName(name);
        s.setNumber(number);
        s.setEmail(email);
        s.setMountainCode(mountainCode);
        s.setTuitionFee(tuitionFee);
        System.out.println(MenuView.UPDATE_SUCCESS);
    }

    //FEATURE_3
    public void showStudentList() {
        System.out.println(MenuView.STUDENT_LIST);
        for (Student s : sl.getList()) {
            System.out.println(String.format("%-10s | %-20s | %-13s | %-10s| %.0f",
                    s.getStudentID(),
                    s.getName(),
                    s.getNumber(),
                    s.getMountainCode(),
                    s.getTuitionFee()));
        }
        System.out.println(MenuView.MENU_END);
    }

    public void showMountainList() {
        for (Mountain m : ml.getList()) {
            System.out.println(m);
        }
    }
}
