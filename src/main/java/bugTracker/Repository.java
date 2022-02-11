package bugTracker;

import java.util.Arrays;

public class Repository {
    private int countOfDefects;
    private int numOfBug = 0;
    private Defect[] defects = new Defect[2];

    public int getNumOfBug() {return numOfBug;}

    void add (Defect defect){
        if (numOfBug == defects.length) {
            defects = Arrays.copyOf(defects, defects.length * 2);
        }
        defects[numOfBug] = defect;
        numOfBug++;
    }

    Defect[] getAll(){
        return defects;
    }
}
