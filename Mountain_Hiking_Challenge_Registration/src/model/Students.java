package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Students {
    private final List<Student> list = new ArrayList<>();

    public void add(Student student) {
        list.add(student);
    }

    public List<Student> getList() {
        return list;
    }

    public void loadStudentList(String fileName){
        list.clear();
        int lineNumber = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            br.readLine(); //skip header

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length != 6){
                    System.out.println("Something is missing in line " + lineNumber + "\n");
                }
                else {
                    Student s = new Student(data[0], data[1], data[2], data[3], data[4], Double.parseDouble(data[5]));
                    list.add(s);
                }
                lineNumber++;
            }
        }catch (Exception e) {
            System.out.println("Error reading file\n" + fileName);
            return;
        }
        System.out.println("Loaded " + lineNumber + " students\n");
    }

}
