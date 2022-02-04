package tracker;

public class Defect {
    long id;
    String resume;
    String severity;
    int daysToFix;

    public Defect(long id, String resume, String severity, int daysToFix) {
        this.id = id;
        this.resume = resume;
        this.severity = severity;
        this.daysToFix = daysToFix;
    }

    String getBugsInfo() {
        String bugsInfo = "Id дефекта: " + id + " | " + "Резюме: " + resume +
                                " | " + "Критичность: " + severity + " | " +
                                "Дней на исправление: " + daysToFix;
        return bugsInfo;
    }

}

