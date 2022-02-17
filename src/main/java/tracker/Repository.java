package tracker;


public class Repository {
    private int size = 0;
    private final Defect[] defectList;

    public Repository(int maxDefects) {
        defectList = new Defect[maxDefects];
    }

    public void add(Defect defect) {
        defectList[size] = defect;
        size++;
    }

    public Defect[] getAll() {
        Defect[] defectListWithoutNull = new Defect[size];
        System.arraycopy(defectList, 0, defectListWithoutNull, 0, size);
        return defectListWithoutNull;
    }

    public Defect getDefect(long id) {
        for (int i = 0; i < size; i++) {
            if (defectList[i].getId() == id) {
                return defectList[i];
            }
        }
        return null;
    }

    public boolean isFull() {
        return defectList.length == size;
    }

}
