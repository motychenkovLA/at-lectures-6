package tracker;


public class Defect {
    String defect;

    void addDefect(int numberOfDefects, String resume, String critical, int numberOfDays) {
        defect = "" + numberOfDefects + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
    String getDefect() {
        return defect;
    }
}
