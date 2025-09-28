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
        sl.loadStudentList("data/student.txt");
        Mountains ml = new Mountains();
        ml.loadMountainList("data/mountain.txt");
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
                    Student found = sl.getList().stream()
                            .filter(s -> s.getStudentID().equals(id))
                            .findFirst()
                            .orElse(null);
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
                    boolean removed = sl.getList().removeIf(s -> s.getStudentID().equals(removeId));
                    if (removed) {
                        System.out.println(MenuView.REMOVE_SUCCESS);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;
                case 5: // Search by name
                    System.out.print("Enter name keyword: ");
                    String keyword = sc.nextLine().toLowerCase();
                    sl.getList().stream()
                            .filter(s -> s.getName().toLowerCase().contains(keyword))
                            .forEach(System.out::println);
                    break;
                case 6: // Filter by campus (mountainCode)
                    System.out.print("Enter mountain code: ");
                    String mCode = sc.nextLine();
                    sl.getList().stream()
                            .filter(s -> s.getMountainCode().equalsIgnoreCase(mCode))
                            .forEach(System.out::println);
                    break;
                case 7: // Statistics by location
                    sl.getList().stream()
                            .map(Student::getMountainCode)
                            .distinct()
                            .forEach(code -> {
                                long count = sl.getList().stream()
                                        .filter(s -> s.getMountainCode().equals(code))
                                        .count();
                                System.out.println(code + ": " + count + " students");
                            });
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
        }
    }
}
