package Tracker;

public class Defect {
    int id;              //порядковый номер дефекта
    String resume;       //описание дефекта
    String priority;     //критичность дефекта
    int daysToFix;       // время на иправление

    public Defect(int id, String resume, String priority, int daysToFix) {
        this.id = id;
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
    }


    String getInfo(){
        return id + ". Описание: " + resume + "|"
                + "  Критичность: " + priority + "|"
                + "  Дней на исправление: " + daysToFix;
    }

}
