package model;

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
}
