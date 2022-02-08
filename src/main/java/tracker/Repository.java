package tracker;

import java.util.Arrays;

public class Repository {

    private Defect[] defects;
    private static int currentDefectCount; // todo 3 - один счетчик на все репозитории, хотя у каждого свой массив

    // todo 1 - если размер подгоняется автоматически, нет смысла передавать его в конструктор
    public Repository(int MaxBug) {
        defects=new Defect[MaxBug];
        currentDefectCount = 0; // todo 3 - создание объекта репо сбрасывает счетчики у всех существующих
    }

    public void add(Defect defect) {
        if (currentDefectCount > defects.length-1) { // todo 1 - >= читаемее
            defects = Arrays.copyOf(defects, defects.length+10); // todo 0 - лучше не добавлять а умножать на какое-нибудь число
        }
        defects[currentDefectCount] = defect;
        currentDefectCount++;
    }

    public Defect[] getAll() {
        // todo 3 - возвращается массив содержащий не только добавленные дефекты, но и нулы
        //   утечка данных, снаружи можно редактировать список дефектов, редактируя массив
        return defects;
    }
}
