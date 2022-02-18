package Tracker;

public class Defect {
    private static int stepId = 1;      //начальное значение и шаг Id
    private final int id;               //порядковый номер дефекта
    private final String resume;        //описание дефекта
    private final String priority;      //критичность дефекта
    private final int daysToFix;        //время на иправление
    private final String attachment;


    public Defect(String resume, String priority, int daysToFix, String attachment) {
        id = stepId;
        stepId++;
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.attachment = attachment;

    }

    String getInfo() {
        return "ID:" + id + ".Описание: " + resume + "|"
                + "  Критичность: " + priority + "|"
                + "  Дней на исправление: " + daysToFix + "|"
                + attachment;
    }

}
