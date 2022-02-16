package tracker;

public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private Critical critical;
    private Status status;
    private int daysToFix;
    private final Attachment attachment;

    // todo 3 - новые дефекты всегда имеют статус Открыто, этот конструктор позволяет создать в любом
    public Defect(String resume, Critical critical, int daysToFix, Attachment attachment, Status status) {
        this.resume = resume;
        this.critical = critical;
        this.daysToFix = daysToFix;
        this.id = counterOfBugs;
        this.attachment = attachment;
        this.status = status;
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

    public void setCritical(Critical critical) {
        this.critical = critical;
    }

    public Critical getCritical() {
        return critical;
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
                id, resume, critical, daysToFix, status.toString(), attachment.toString());
    }
}
