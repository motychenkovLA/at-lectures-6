package tracker;

public class Defect {
    final private long id;
    final private String name;
    Criticality criticality;
    private int daysNumber;
    Attachment attachment;
    Status status = Status.OPENED;
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

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        if (daysNumber < 1) this.daysNumber = 1;
        else this.daysNumber = daysNumber;
    }

    public void changeStatus(Status status) {
        this.status = status;
    }

    public String toString() {
        return "ID: " + id + ", Статус: " + status + ", Резюме дефекта: " + name + ", Критичность: " + criticality +
                ", Количество дней на исправление: " + daysNumber + ", Вложение: " + attachment;
    }
}
