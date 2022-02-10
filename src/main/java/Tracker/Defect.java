package Tracker;

public class Defect {
    private static int i = 1;
    private final int id;              //порядковый номер дефекта
    private final String resume;       //описание дефекта
    private final String priority;     //критичность дефекта
    private final int daysToFix;       // время на иправление

    public Defect(String resume, String priority, int daysToFix) {
        id = i;
        i++;
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
    }

    String getInfo() {
        return "ID:" + id + ".Описание: " + resume + "|"
                + "  Критичность: " + priority + "|"
                + "  Дней на исправление: " + daysToFix;
    }

}
