package tracker;

import java.util.Arrays;

public class Repository {

    private Defect[] defects;
    private int currentDefectCount;


    public Repository() {
        defects=new Defect[2];
        currentDefectCount = 0;
    }

    public void add(Defect defect) {
        if (currentDefectCount >= defects.length) {
            defects = Arrays.copyOf(defects, defects.length*2);
        }
        defects[currentDefectCount] = defect;
        currentDefectCount++;
    }

    public Defect[] getAll() {
        return Arrays.copyOf(defects, currentDefectCount);
    }
}
