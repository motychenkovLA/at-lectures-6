package tracker;


import java.util.Objects;

public class Defect {
    private String resume;
    private Severity critical;
    private Status status;
    private int numberOfDays;
    private final long id;
    private Attachment attachment;


    // todo 5 - в ТЗ нет ничего о том что дефект должен перестать выдавать себе id
    public Defect(Long id, String resume, Severity critical, int numberOfDays, Attachment attachment) {
        this.id = id;
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

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return numberOfDays == defect.numberOfDays && id == defect.id && Objects.equals(resume, defect.resume) && critical == defect.critical && status == defect.status && Objects.equals(attachment, defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resume, critical, status, numberOfDays, id, attachment);
    }
}
