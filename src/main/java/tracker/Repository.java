package tracker;


public class Repository {
    private int size = 0;
    private Defect[] defectList; // todo 0 - можно зафиналить

    public Repository(int maxDefects) {
        defectList = new Defect[maxDefects];
    }

    public void add(Defect defect) {
        // todo 1 - сначала увеличивается на один, потом уменьшается на один, почему сразу не взять готовое значение?
        size++;
        defectList[size - 1] = defect;
    }

    public Defect[] getAll() {
        Defect[] defectListWithoutNull = new Defect[size];
        System.arraycopy(defectList, 0, defectListWithoutNull, 0, size);
        return defectListWithoutNull;
    }


    public boolean isFull() {
        // todo 1 - есть размер массива и счетчик текущего числа, нуллы в ячейках вторичны
        return defectList[defectList.length - 1] != null;

    }
}
