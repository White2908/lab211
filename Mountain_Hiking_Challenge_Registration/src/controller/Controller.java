package controller;

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
}
