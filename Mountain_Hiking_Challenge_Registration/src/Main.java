import controller.Controller;
import model.Mountains;
import model.Student;
import model.Students;
import view.MenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Students sl = new Students();
        sl.loadStudentList("data/StudentList.txt");
        Mountains ml = new Mountains();
        ml.loadMountainList("data/MountainList.txt");
        Controller controller = new Controller(ml,sl);
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
                    controller.addStudent();
                    break;
                case 2: // Update student
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
                    System.out.print("Enter Student ID to remove: ");
                    String removeId = sc.nextLine();
                    Student removest = sl.contains(removeId);
                    sl.remove(removest);
                    break;
                case 5: // Search by name
                    System.out.print("Enter name keyword: ");
                    String keyword = sc.nextLine().toLowerCase();
                    sl.getList().stream()
                            .filter(s -> s.getName().toLowerCase().contains(keyword))
                            .forEach(System.out::println);
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
                    System.out.println("Feature SAVE DATA not implemented yet!");
                    break;
                case 9: // Exit
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please enter 1-9.");
            }
            System.out.println("Enter any key to continue...");
            sc.nextLine();
        }
    }
}
