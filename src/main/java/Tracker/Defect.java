package Tracker;

public class Defect {
    private static int stepId = 1;      //начальное значение и шаг Id
    private final int id;               //порядковый номер дефекта
    private final String resume;        //описание дефекта
    private final String priority;      //критичность дефекта
    private final int daysToFix;        //время на иправление
    private final String attachment;    //вложение
    private String status;        //статус дефекта


    public Defect(String resume, String priority, int daysToFix, String status, String attachment) {
        id = stepId;
        stepId++;
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.status = status;
        this.attachment = attachment;
    }

    int getId(){
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    String getInfo() {
        return "ID:" + id
                + ".Статус: " + status + "|"
                + "  Описание: " + resume + "|"
                + "  Приоритет: " + priority + "|"
                + "  Дней на исправление: " + daysToFix + "|"
                + attachment;
    }

}
