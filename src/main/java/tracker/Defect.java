package tracker;


public class Defect {
    private static long numberOfDefects = 0;
    private String resume;
    private Severity critical;
    private Status status;
    private int numberOfDays;
    private final long id;
    private Attachment attachment;


    public Defect(String resume, Severity critical, int numberOfDays, Attachment attachment) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = attachment;
        this.status = Status.OPEN;
    }

    public String getDefectInfo() {
        return "" + id + " | " + status.getRuName() + " | " + resume + " | " + critical.getRuName() + " | " + numberOfDays + " | " + attachment.toString();

    }

    public long getId() {
        return id;

    }

}
