package tracker;


public class Defect {
    private static long numberOfDefects = 0;
    private String resume;
    private String critical;
    private int numberOfDays;
    private final long id;
    Attachment attachment; // todo 3 - не приватное
    private String typeOfAttachment; // todo 3 - поле ничего не делает

    // todo 3 - конструктор принимает не атачмент;
    //  писать 10 конструкторов на 10 видов атачментов такая себе идея
    public Defect(String resume, String critical, int numberOfDays, String comment) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.typeOfAttachment = "comment";
        attachment = new CommentAttachment(comment);
    }

    public Defect(String resume, String critical, int numberOfDays, long id) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.typeOfAttachment = "id";
        attachment = new DefectAttachment(id);
    }

    public String getDefectInfo() {
        if (typeOfAttachment.equals("id")) {
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + attachment.toString();
        } else {
            return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays + " | " + attachment.toString();
        }

    }
}
