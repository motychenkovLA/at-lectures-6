package Tracker;


public class Repository {
    private int counter = 0;                        //счётчик
    private int size = 0;                           //размер массива
    private Defect[] defects = new Defect[size];


    void add(Defect defect) {                       //костыль безразмерного массива
        Defect[] array;
        array = defects;
        size++;
        defects = new Defect[size];
        System.arraycopy(array, 0, defects, 0, array.length);
        defects[counter] = defect;
        counter++;
    }

    Defect[] getAll() {
        return defects;
    }
}
