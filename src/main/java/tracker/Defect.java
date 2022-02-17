package tracker;

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

    String getBugsInfo() {
        return "Id дефекта: " + id + " | " + "Резюме: " + resume +
                " | " + "Критичность: " + severity.getInRus() + " | " +
                "Дней на исправление: " + daysToFix + " | " + "Вложение: " + attachment  +
                " | " + "Статус: " + status.getInRus();
    }

}

