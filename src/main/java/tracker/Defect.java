package tracker;

public class Defect {
    private static long counterOfBugs = 0;
    private final long id;
    private String resume;
    private String priority;
    private int daysToFix;
    private final Attachment attachment;


    public Defect(String resume, String priority, int daysToFix, Attachment attachment) {
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.id = counterOfBugs;
        this.attachment = attachment;
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

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getPriority() {
        return priority;
    }

    public void setDaysToFix(int daysToFix) {
        this.daysToFix = daysToFix;
    }

    public int getDaysToFix() {
        return daysToFix;
    }

    public String toString() {
        return String.format(
                "Дефект: %d | Резюме: %s | Критичность: %s | Кол-во дней на исправление: %d | Вложение: %s",
                id, resume, priority, daysToFix, attachment.toString());
    }
}
