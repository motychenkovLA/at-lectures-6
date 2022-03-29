package tracker;

import java.util.Objects;

public class Defect {
    final private long id;
    final private String name;
    private Criticality criticality;
    private int daysNumber;
    private Attachment attachment;
    private Status status = Status.OPENED;
    static private int counter = 1;

    public Defect(String name, Criticality criticality, Attachment attachment) {
        this.name = name;
        this.attachment = attachment;
        this.criticality = criticality;
        id = counter++;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Criticality getCriticality() {
        return criticality;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        if (daysNumber < 1) this.daysNumber = 1;
        else this.daysNumber = daysNumber;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Статус: " + status + ", Резюме дефекта: " + name + ", Критичность: " + criticality +
                ", Количество дней на исправление: " + daysNumber + ", Вложение: " + attachment;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Defect def = (Defect) a;
        return id == def.id &&
                this.equals(def.getName()) &&
                this.equals(def.getCriticality()) &&
                daysNumber == def.daysNumber &&
                this.equals(def.getAttachment()) &&
                this.equals(def.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, criticality, daysNumber, attachment, status);
    }
}
