package tracker;


public class Defect {
    private static long numberOfDefects=0;
    private String resume;
    private String critical;
    private int numberOfDays;
    private final long id;
    CommentAttachment commentAttachment;
    DefectAttachment defectAttachment;
    private String attachment;

    public Defect(String resume, String critical, int numberOfDays, String comment) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = "comment";
        commentAttachment = new CommentAttachment(comment);
    }
    public Defect(String resume, String critical, int numberOfDays, long id) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = "id";
        defectAttachment = new DefectAttachment(id);
    }
    public String getDefectInfo() {
        if (attachment.equals("id")) {
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + defectAttachment.toString();
        } else {
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + commentAttachment.toString();
        }

    }
}
