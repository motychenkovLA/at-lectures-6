package tracker;

public class Defect {
    String [] defects;
    void setConstStyle(int CONST_STYLE) {
        this.defects = new String[CONST_STYLE];
    }
    void defect(int numberOfDefects, String resume, String critical, int numberOfDays) {
        defects[numberOfDefects] = "" + numberOfDefects + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
    void getDefects() {
        for (String defect:defects) {
            if (defect == null) {
                break;
            }
            System.out.println(defect);
        }
    }
}
