package tracker;


public class Defect {
    private final String resume;
    private final String critical;
    private final int numberOfDays;
    private static long numberOfDefects=0;
    private final long id;
    public Defect(String resume, String critical, int numberOfDays) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
    }

    public String getDefectInfo() {
        return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
}
