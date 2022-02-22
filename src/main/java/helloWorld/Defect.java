package helloWorld;

public class Defect {
    final private long id;
    final private String description;
    private String critical;
    private int daysNumber;
   private Attachment attachment;
    static private int numberOfBug = 1;

    public Defect(String description, String critical, int daysNumber, Attachment attachment) {
        this(description);
        this.critical=critical;
        this.daysNumber=daysNumber;
        this.attachment=attachment;

    }

    public Defect(String description) {
        this.description = description;
               id = numberOfBug++;
    }


    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public void setCommentAttachment(CommentAttachment comment) {
        this.attachment = comment;
    }
    public String getCritical() {
                return critical;
    }

    public void setDefectAttachment(DefectAttachment defectAttachment) {
        this.attachment = defectAttachment;
    }




    public void setCritical(String critical) {
        this.critical = critical;
    }

    public int getDaysNumber() {
        return daysNumber;
    }


    public void setDaysNumber(int daysnumber) {
        if (daysnumber == 0) this.daysNumber = 1;
        else this.daysNumber = daysnumber;
    }

    String getInfo() {
        return id + " | " + description + "|  " + critical + " | " + daysNumber + "|" + "Вложение: " + attachment;
    }
}




