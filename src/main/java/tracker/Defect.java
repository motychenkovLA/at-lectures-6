package tracker;


public class Defect {
    private static long numberOfDefects=0;
    private String resume;
    private String critical;
    private int numberOfDays;
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
