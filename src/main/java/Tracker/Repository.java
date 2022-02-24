package Tracker;

import java.lang.annotation.Target;

public class Repository {
    private int counter = 0;                          //счётчик
    private int size = 10;                            //размер массива
    private Defect[] defects = new Defect[size];

    void add(Defect defect) {                         //костыль безразмерного массива
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

    public int getCounter() {                   //взять количество дефектов
        return counter;
    }

    boolean equals (int id, int counter){       //сравнить id дефектов
        return defects[counter].getId() == id;
    }

    void changeStatus(int counter, String status){ //смена статуса дефекта
        defects[counter].setStatus(status);
    }
}
