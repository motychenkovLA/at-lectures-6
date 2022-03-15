package Tracker;

import java.util.Objects;

public class Defect {
    private static int stepId = 1;              //начальное значение и шаг Id
    private final Integer id;                       //порядковый номер дефекта
    private final String resume;                //описание дефекта
    private final DefectPriority priority;      //критичность дефекта
    private final int daysToFix;                //время на иправление
    private DefectStatus status;                //статус дефекта
    private final Attachment attachment;          //вложение



    public Defect(String resume, DefectPriority priority, int daysToFix, DefectStatus status, Attachment attachment) {
        id = stepId;
        stepId++;
        this.resume = resume;
        this.priority = priority;
        this.daysToFix = daysToFix;
        this.status = status;
        this.attachment = attachment;
    }


    int getId() {
        return this.id;
    }

    public void setStatus(DefectStatus status) {
        this.status = status;
    }

    String getInfo() {
        return "ID:" + id
                + ".Статус: " + status.ruName + "|"
                + "  Описание: " + resume + "|"
                + "  Приоритет: " + priority.ruName + "|"
                + "  Дней на исправление: " + daysToFix + "|"
                + attachment.asString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return daysToFix == defect.daysToFix &&
                Objects.equals(id, defect.id) &&
                Objects.equals(resume, defect.resume) &&
                priority == defect.priority &&
                status == defect.status &&
                Objects.equals(attachment, defect.attachment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resume, priority, daysToFix, status, attachment);
    }
}
