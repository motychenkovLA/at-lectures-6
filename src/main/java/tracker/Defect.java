package tracker;


public class Defect {
    // todo 3 - нет полей, хранится только текстовое представление
    String defect;

    // todo 3 - между созданием и вызовом addDefect, объект существует в не валидном состоянии с null-ом
    void addDefect(int numberOfDefects, String resume, String critical, int numberOfDays) {
        defect = "" + numberOfDefects + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
    String getDefect() {
        return defect;
    }
}
