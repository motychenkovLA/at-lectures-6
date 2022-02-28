package tracker;

import java.util.Objects;

public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private Severity severity;
    private Status status;
    private int daysToFix;
    private final Attachment attachment;

    public Defect(String resume, Severity severity, int daysToFix, Attachment attachment) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
        this.id = counterOfBugs;
        this.attachment = attachment;
        this.status = Status.OPEN;
        counterOfBugs++;

    }

    public long getId() {
        return id;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getResume() {
        return resume;
    }

    public void setCritical(Severity severity) {
        this.severity = severity;
    }

    public Severity getCritical() {
        return severity;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public String toString() {
        return String.format(
                "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Статус: %s| Вложение: %s",
                id, resume, severity, daysToFix, status.toString(), attachment.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        Defect defect = (Defect) obj;
        return id == defect.id &&
                status == defect.status &&
                resume.equals(defect.resume) &&
                severity == defect.severity &&
                daysToFix == defect.daysToFix &&
                attachment.equals(defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, resume, severity, daysToFix, attachment);
    }
}
