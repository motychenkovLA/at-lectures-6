package tracker;

import java.util.Arrays;

public class Repository {

    private Defect[] defects;
    private static int currentDefectCount;

    public Repository(int MaxBug) {
        defects=new Defect[MaxBug];
        currentDefectCount = 0;
    }

    public void add(Defect defect) {
        if (currentDefectCount > defects.length-1) {
            defects = Arrays.copyOf(defects, defects.length+10);
        }
        defects[currentDefectCount] = defect;
        currentDefectCount++;
    }

    public Defect[] getAll() {
        return defects;
    }
}
