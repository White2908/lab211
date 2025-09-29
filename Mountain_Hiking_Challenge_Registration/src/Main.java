import controller.Controller;
import model.Mountains;
import model.Student;
import model.Students;
import ultils.MenuHandler;
import view.MenuView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Students sl = new Students();
        sl.loadStudentList("data/StudentList.txt");
        Mountains ml = new Mountains();
        ml.loadMountainList("data/MountainList.txt");
        MenuHandler menuHandler = new MenuHandler(ml, sl);
        menuHandler.showMenu();
    }
}
