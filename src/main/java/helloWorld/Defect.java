package helloWorld;

public class Defect {
    final private long id;
    final private String description;
    private String critical;
    private int daysNumber;

    static private int numberOfBug = 1;

    public Defect(String description) {
        this.description = description;
        id = numberOfBug++;
    }

    public String getCritical() {
        return critical;
    }

    public void setCritical(String critical) {
        this.critical = critical;
    }

    public int getDaysNumber() {
        return daysNumber;
    }


    public void setDaysNumber(int daysnumber) {
        if (daysnumber == 0) this.daysNumber = 1;
        else this.daysNumber = daysnumber;
    }

    String getInfo() {
        return id + " | " + description + "|  " + critical + " | " + daysNumber;
    }
}




