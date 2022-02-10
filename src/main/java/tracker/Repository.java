package tracker;

import java.util.Arrays;

public class Repository {
    private Defect[] defectsList;
    private int maxBugs;
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
        Defect copyOfDefectList[] = Arrays.copyOf(defectsList, countDefects);
        return copyOfDefectList;
    }

    public boolean repositoryIsFull() {
          boolean answer = (countDefects >= maxBugs);
                return answer;
    }

}
