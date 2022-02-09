package tracker;


public class Repository {
    private int size = 0;
    private Defect[] defectList;

    public Repository(int maxDefects) {
        defectList = new Defect[maxDefects];
    }

    public void add(Defect defect) {
        size++;
        defectList[size - 1] = defect;
    }

    public Defect[] getAll() {
        Defect[] defectListWithoutNull = new Defect[size];
        System.arraycopy(defectList, 0, defectListWithoutNull, 0, size);
        return defectListWithoutNull;
    }


    public boolean isFull() {
        return defectList[defectList.length - 1] != null;

    }
}
