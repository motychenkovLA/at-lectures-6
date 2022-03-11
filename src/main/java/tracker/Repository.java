package tracker;

import java.util.Arrays;

public class Repository  {
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

    public boolean repositoryIsEmpty() {
        return (countDefects <= 0);
    }

    public Defect findDefectById(long idDefect) {
        for (int i = 0; i < countDefects; i++) {
            if (defectsList[i].getId() == idDefect) {
                return defectsList[i];
            }
        }
        return null;
    }

}