package tracker;


public class Defect {
    private static long numberOfDefects=0;
    private String resume;
    private String critical;
    private int numberOfDays;
    private final long id;
    // todo 3 - нет атачмента, есть набор полей
    private String comment;
    private long attachmentId;
    private String attachment;

    public Defect(String resume, String critical, int numberOfDays, String comment) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = "comment";
        this.comment = comment;
    }
    public Defect(String resume, String critical, int numberOfDays, long id) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = "id";
        this.attachmentId = id;
    }
    public String getDefectInfo() {
        if (attachment.equals("id")) {
            DefectAttachment defectAttachment = new DefectAttachment(attachmentId);
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + defectAttachment.toString();
        } else {
            CommentAttachment commentAttachment = new CommentAttachment(comment);
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + commentAttachment.toString();
        }

    }
}
