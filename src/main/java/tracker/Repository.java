package tracker;

public class Repository {
    private Defect[] defectsList;
    public int maxBugs;

    public Repository(int maxBugs) {
        this.maxBugs = maxBugs;
        defectsList = new Defect[maxBugs];
    }

    public void addDefect(int id, Defect defect) {
        defectsList[Defect.getCountDefects()] = defect;
    }

    public Defect[] getAllDefects() {
        return defectsList;
    }
}
