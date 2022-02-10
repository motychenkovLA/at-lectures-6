package tracker;

public class Defect {

    private static int countDefects = 0;
    private final long id;
    private String resume;
    private String severity;
    private int daysToFix;

    // todo 3 - конструктор создает не валидный дефект
    public Defect(long id) {
        this.id = id;
    }

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

    // todo 3 - публикуется внутренняя информация
    public static int getCountDefects() {
        return countDefects;
    }

    // todo 5 - модифицируется внутренняя имнформация
    public static void setCountDefects(int countDefects) {
        Defect.countDefects = countDefects;
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

    // todo - ?
//    String getBugsInfo() {
//        String bugsInfo = "Id дефекта: " + idBug + " | " + "Резюме: " + resumeBug +
//                                " | " + "Критичность: " + severityBug + " | " +
//                                "Дней на исправление: " + daysToFixBug;
//        return bugsInfo;
//    }

}

