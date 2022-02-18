package Tracker;

//увеличил начальный размер массива до 10
public class Repository {
    private int counter = 0;                          //счётчик
    private int size = 10;                            //размер массива
    private Defect[] defects = new Defect[size];

//увеличить шаг расширения массива
    void add(Defect defect) {     //костыль безразмерного массива
        if (counter == defects.length) {
            Defect[] array;
            array = defects;
            size = size * 2;
            defects = new Defect[size];
            System.arraycopy(array, 0, defects, 0, array.length);
        }
        defects[counter] = defect;
        counter++;
    }

    Defect[] getAll() {
        Defect[] filledDefects = new Defect[counter];
        System.arraycopy(defects,0, filledDefects, 0, filledDefects.length);  //беру только заполненные дефекты
        return filledDefects;
    }
}
