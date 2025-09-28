package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Mountains {
    private List<Mountain> list = new ArrayList<>();

    public void add(Mountain mountain) {
        list.add(mountain);
    }

    public boolean contains(String code) {
        for(Mountain m : list) {
            if(m.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public void loadMountainList(String fileName){
        list.clear();
        int lineNumber = 0;
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            br.readLine(); //skip header

            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length < 3 || data.length > 4){
                    System.out.println("Something is missing in line " + lineNumber + "\n");
                }
                else {
                    Mountain m = new Mountain(data[0], data[1], data[2], data[3]);
                    list.add(m);
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
