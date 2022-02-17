package tracker;

public class Defect {

    private static int countDefects = 0;
    private final long id;
    private String resume;
    private String severity; // todo 3 - не Severity
    private int daysToFix;
    private Attachment attachment;
    private Status status;


    public Defect(String resume, String severity, int daysToFix, Attachment attachment) {
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

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
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
                " | " + "Критичность: " + severity + " | " +
                "Дней на исправление: " + daysToFix + " | " + "Вложение: " + attachment  +
                " | " + "Статус: " + status;
    }

}

