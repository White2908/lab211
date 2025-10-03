package ultils;

import controller.Controller;
import model.Mountains;
import model.Student;
import model.Students;
import view.MenuView;

import java.util.Scanner;

public class MenuHandler {
    Scanner sc = new Scanner(System.in);
    Mountains ml = new Mountains();
    Students sl = new Students();
    Controller controller;

    public MenuHandler(Mountains ml, Students sl) {
        this.ml = ml;
        this.sl = sl;
        this.controller = new Controller(this.ml,this.sl);
    }

    public void showMenu() {
        boolean saveflag = true;
        int choice = 0;

        while (true) {
            MenuView.showMenu();
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number 1-9.");
                continue;
            }

            switch (choice) {
                case 1: // Add student
                    saveflag = false;
                    controller.addStudent();
                    break;
                case 2: // Update student
                    saveflag = false;
                    System.out.print("Enter Student ID to update: ");
                    String id = sc.nextLine();
                    Student found =sl.contains(id);
                    if (found != null) {
                        controller.updateStudent(found);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 3: // Show list
                    controller.showStudentList();
                    break;
                case 4: // Remove student
                    saveflag = false;
                    System.out.print("Enter Student ID to remove: ");
                    String removeId = sc.nextLine();
                    Student removest = sl.containsID(removeId);
                    System.out.println("Are you sure you want to delete this registration?(Y/N):");
                    String confirm = sc.nextLine();
                    if(confirm.matches("^[Yy]")){
                        sl.remove(removest);
                        System.out.println(MenuView.REMOVE_SUCCESS);
                    }
                    else if(confirm.matches("^[Nn]")){
                        System.out.println(MenuView.STUDENT_REMOVE_FAIL);
                    }
                    break;
                case 5: // Search by name
                    System.out.print("Enter name keyword: ");
                    String keyword = sc.nextLine().toLowerCase();
                    sl.searchByName(keyword);
                    break;
                case 6: // Filter by campus (mountainCode)
                    System.out.print("Enter Campus: ");
                    String CCode = sc.nextLine();
                    sl.filterByCampus(CCode);
                    break;
                case 7: // Statistics by location
                    sl.statisticsByLocation(ml);
                    break;
                case 8: // Save data
                    saveflag = true;
                    sl.saveStudentList("data/StudentList.txt");
                    break;
                case 9: // Exit
                    if(!saveflag) {
                        System.out.println("\"Do you want to save the changes before exiting? (Y/N)\"");
                        String flag = sc.nextLine();
                        if(flag.matches("^[Yy]")){
                            sl.saveStudentList("data/StudentList.txt");
                        }
                        else if(flag.matches("^[Nn]")){
                            return;
                        }
                        else {
                            System.out.println("Invalid input! Please enter Y or N.");
                            break;
                        }
                    }
                    System.out.println("Exiting...");
                    return;
                case 10:
                    System.out.println("Enter String S:");
                    String sp = sc.nextLine();
                    System.out.println(MenuView.STUDENT_LIST);
                    sl.searchByPhone(sp);
                    break;
                default:
                    System.out.println("This function is not available.");
            }
            System.out.println("Enter any key to continue...");
            sc.nextLine();
        }
    }
}
