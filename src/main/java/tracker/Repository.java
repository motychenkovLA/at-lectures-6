package tracker;

import java.util.Arrays;

public class Repository {
    private final Defect[] defectsList;
    private final int maxBugs;
    private int countDefects = 0;

    public Repository(int maxBugs) {
        this.maxBugs = maxBugs;
        defectsList = new Defect[maxBugs];
    }

    public void addDefect(Defect defect) {
        defectsList[countDefects] = defect;
        countDefects++;
    }

    public Defect[] getAllDefects() {
        return Arrays.copyOf(defectsList, countDefects);
    }

    public boolean repositoryIsFull() {
        return (countDefects >= maxBugs);
    }

}
