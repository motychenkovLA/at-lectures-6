package tracker;

import java.util.Objects;

public class Defect {

    private static int countDefects = 0;
    private final long id;
    private String resume;
    private Severity severity;
    private int daysToFix;
    private Attachment attachment;
    private Status status;

    public Defect(String resume, Severity severity, int daysToFix, Attachment attachment) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.attachment = attachment;
        this.status = Status.OPEN;
        this.id = countDefects;
        countDefects++;
    }

    public long getId() {
        return id;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Id дефекта: " + id + " | " + "Резюме: " + resume +
                " | " + "Критичность: " + severity.getInRus() + " | " +
                "Дней на исправление: " + daysToFix + " | " + "Вложение: " + attachment +
                " | " + "Статус: " + status.getInRus();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Defect)) return false;
        Defect defect = (Defect) o;
        return id == defect.id && daysToFix == defect.daysToFix && resume.equals(defect.resume) && severity == defect.severity && attachment.equals(defect.attachment) && status == defect.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, severity, daysToFix, attachment, status);
    }
}

