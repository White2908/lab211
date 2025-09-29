package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Mountains;
import model.Mountain;

public class Students {
    private final List<Student> list = new ArrayList<>();


    public void add(Student student) {
        list.add(student);
    }

    public void remove(Student student) {
        list.remove(student);
    }

    public List<Student> getList() {
        return list;
    }

    public Student contains(String studentID) {
        for(Student s : list) {
            if(s.getStudentID().equals(studentID)) {
                return s;
            }
        }
        return null;
    }

    public void searchByName(String name){
        for(Student s : list) {
            String compareName = "";
            compareName = s.getName().toLowerCase();
            if(compareName.contains(name.toLowerCase()) ) {
                System.out.println(s);
            }
        }
    }

    public void filterByCampus(String campus){
        for(Student s : list) {
            String fillID = s.getStudentID().toLowerCase();
            if(fillID.startsWith(campus.toLowerCase()) ) {
                System.out.println(s);
            }

        }
    }

    public void statisticsByLocation(Mountains mlist){
        for(Mountain m : mlist.getList()) {
            int participant =0;
            double totalcost = 0;
            for(Student s : list) {
                if(s.getMountainCode().equals(m.getCode())) {
                    participant++;
                    totalcost += s.getTuitionFee();
                }
            }
            if(participant > 0) {
                System.out.println(m.getCode() + " | " + participant + " | " + totalcost);
            }
        }
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

    public void saveStudentList(String fileName){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for(Student s : list) {
                bw.write(s.getStudentID() + "," + s.getName() + "," + s.getNumber() + "," + s.getEmail() + "," + s.getMountainCode() + "," + s.getTuitionFee());
                bw.newLine();
            }
        }catch (IOException e) {
            System.out.println("Error writing file\n" + fileName);
            return;
        }
    }

}
