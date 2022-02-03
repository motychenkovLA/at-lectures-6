package tracker;


public class Defect {
    int numberOfDefects;
    String resume;
    String critical;
    int numberOfDays;

    Defect(int numberOfDefects, String resume, String critical, int numberOfDays) {
        this.numberOfDefects = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
    }

    String printDefect() {
        return "" + numberOfDefects + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
}
