package tracker;

// todo 0 - неиспользуемый импорт
import java.util.Scanner;

public class Repository {
    int numberOfDefects = 0; // todo 3 - нет модификатор доступа
    final int MAX_DEFECTS;// todo 3 - нет модификатор доступа, формат от константы, но это поле
    Defect[] defectList;// todo 3 - нет модификатор доступа
    // todo 3 - нет модификатор доступа
    Repository(int maxDefects) {
        MAX_DEFECTS = maxDefects;
    defectList = new Defect[MAX_DEFECTS]; // todo 1 - форматирование
    }
    // todo 3 - нет модификатор доступа
    void add(Defect defect) {
        // todo 5 - айди дефекта не имеет никакого отношения к позиции в массиве
        this.numberOfDefects = (int) defect.getId();
        defectList[numberOfDefects-1] = defect;

    }
    // todo 3 - нет модификатор доступа
    Defect[] getAll() {
        // todo 3 - возвращается не список заведенных дефектов, а массив с дефектами и null-ами,
        //   происходит утечка приватных данных, внешний пользователь может менять содержание массива
            return defectList; // todo 1 - форматирование
    }
    // todo 3 - нет модификатор доступа
    // todo 1 - обычно это называется size
    int getNumberOfDefects() {return numberOfDefects;} // todo 1 - форматирование
}
