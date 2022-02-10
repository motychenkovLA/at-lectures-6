package tracker;

public class Defect {

    private static int countDefects = 0;
    private final long id;
    private String resume;
    private String severity;
    private int daysToFix;

    public Defect(String resume, String severity, int daysToFix) {
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
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

    String getBugsInfo() {
        return "Id дефекта: " + id + " | " + "Резюме: " + resume +
                " | " + "Критичность: " + severity + " | " +
                "Дней на исправление: " + daysToFix;
    }

}

