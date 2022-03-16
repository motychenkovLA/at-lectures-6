package tracker;


import java.util.Objects;

public class Defect {
    private String resume;
    private Severity critical;
    private Status status;
    private int numberOfDays;
    private int counterId=0;
    private Attachment attachment;
    private long id;


    public Defect(String resume, Severity critical, int numberOfDays, Attachment attachment) {
        id = ++counterId;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
        this.attachment = attachment;
        this.status = Status.OPEN;
    }

    public String getDefectInfo() {
        return "" + id + " | " + status.getRuName() + " | " + resume + " | " + critical.getRuName() + " | " + numberOfDays + " | " + attachment.toString();

    }

    public int getNumberOfDays() {
        return numberOfDays;
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

    public long getId() {
        return id;
    }
}
