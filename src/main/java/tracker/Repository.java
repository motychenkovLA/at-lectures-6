package tracker;

import java.util.Scanner;

public class Repository {
    int numberOfDefects = 0;
    final int MAX_DEFECTS;
    Defect[] defectList;
    Repository(int maxDefects) {
        MAX_DEFECTS = maxDefects;
    defectList = new Defect[MAX_DEFECTS];
    }
    void add(Defect defect) {
        this.numberOfDefects = (int) defect.getId();
        defectList[numberOfDefects-1] = defect;

    }
    Defect[] getAll() {
            return defectList;
    }
    int getNumberOfDefects() {return numberOfDefects;}
}
