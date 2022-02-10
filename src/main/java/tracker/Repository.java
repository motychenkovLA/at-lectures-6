package tracker;

import java.util.Arrays;

public class Repository {
    private Defect[] defectsList; // todo 1 - не изменяется, можно зафиналить
    private int maxBugs;// todo 1 - не изменяется, можно зафиналить
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
        // todo 0 - можно сделать в одну строчку, идея наверняка предлагает
        Defect copyOfDefectList[] = Arrays.copyOf(defectsList, countDefects);
        return copyOfDefectList;
    }

    public boolean repositoryIsFull() {
        // todo 0 - можно сделать в одну строчку, идея наверняка предлагает + что-то с отступами
          boolean answer = (countDefects >= maxBugs);
                return answer;
    }

}
