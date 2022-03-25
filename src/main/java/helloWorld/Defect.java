package helloWorld;

import java.util.Objects;

public class Defect {
    final private long id;
    final private String description;
    private Criticality critical;
    private int daysNumber;
    private Attachment attachment;
    static private int numberOfBug = 1;
    Status status = Status.OPEN;

    public Defect(String description, Criticality critical, int daysNumber, Attachment attachment) {
        this(description);
        this.critical = critical;
        this.daysNumber = daysNumber;
        this.attachment = attachment;
    }

    public Defect(String description) {
        this.description = description;
        id = numberOfBug++;
    }

    public long getId() {
        return id;
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


    public void setDefectAttachment(DefectAttachment defectAttachment) {
        this.attachment = defectAttachment;
    }


    public int getDaysNumber() {
        return daysNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Criticality getCritical() {
        return critical;
    }

    public void setCritical(Criticality critical) {
        this.critical = critical;
    }


    public void setDaysNumber(int daysnumber) {
        if (daysnumber == 0) this.daysNumber = 1;
        else this.daysNumber = daysnumber;
    }

    @Override
    public String toString() {
        return id + " | " + description + " |  " + critical + " | " + daysNumber + " | " + "Вложение: " + attachment + " | " + status;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Defect)) return false;
        Defect defect = (Defect) o;
        return id == defect.id && daysNumber == defect.daysNumber && description.equals(defect.description) && critical == defect.critical && attachment.equals(defect.attachment) && status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, critical, daysNumber, attachment, status);
    }
}