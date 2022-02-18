package tracker;

public class Defect {
    final private long id;
    final private String name;
    private String criticality;
    private int daysNumber;
    Attachment attachment;
    static private int counter = 1;

    public Defect(String name, Attachment attachment) {
        this.name = name;
        this.attachment = attachment;
        id = counter++;
    }

    public int getDaysNumber() {
        return daysNumber;
    }

    public void setDaysNumber(int daysNumber) {
        if (daysNumber < 1) this.daysNumber = 1;
        else this.daysNumber = daysNumber;
    }

    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        if (criticality.equals("blocker") || criticality.equals("critical") ||
                criticality.equals("major") || criticality.equals("minor") || criticality.equals("trivial"))
            this.criticality = criticality;
        else this.criticality = "major";
    }

    public String getInfo() {
        return "ID: " + id + ", Резюме дефекта: " + name + ", Критичность: " + criticality +
                ", Количество дней на исправление: " + daysNumber + ", Вложение: " + attachment;
    }
}
