package tracker;

import java.util.Arrays;

public class Repository {

    private Defect[] defects;
    private int currentDefectCount;


    public Repository() {
        defects = new Defect[2];
        currentDefectCount = 0;
    }

    public void add(Defect defect) {
        if (currentDefectCount >= defects.length) {
            defects = Arrays.copyOf(defects, defects.length * 2);
        }
        defects[currentDefectCount] = defect;
        currentDefectCount++;
    }

    public Defect[] getAll() {
        return Arrays.copyOf(defects, currentDefectCount);
    }

    public Defect getById(long id) {
        for (int j=0; j<currentDefectCount; j++) {
            Defect bug = defects[j];
            if (id == bug.getId()) {
                return bug;
            }
        }
        return null;
    }
}
