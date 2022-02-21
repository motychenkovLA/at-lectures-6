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

    public boolean repositoryIsEmpty() {
        return (countDefects <= 0);
    }

    public Defect findDefectById(long idDefect) {
        for (Defect defect : defectsList) // todo 5 - выходит за границы не пустых элементов
            if (defect.getId() == idDefect) {
                return defect;
            } else {
                return null; // todo 5 - не найдет дефект если он не первый в массиве
            }
        return null;
    }
}