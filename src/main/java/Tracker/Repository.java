package Tracker;


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


    public boolean checkId(int id){
        boolean found = false;
        for (int i = 0; i < counter && !found; i++) {
           found = defects[i].getId() == id;
        }
        return found;
    }

    public int getPosById(int id) {
        int position = 0;
        for (int i = 0; i < counter; i++) {
            if (defects[i].getId() == id) position = i;
        }
        return position;
    }
        void changeStatus ( int counter, DefectStatus status){ //смена статуса дефекта
            defects[counter].setStatus(status);
        }
    }
