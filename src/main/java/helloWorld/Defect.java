package helloWorld;

public class Defect {
    private long id;
    private String description;
    private String critical;
    private int daysNumber;

    static private int counter = 1;

    public Defect(String description, String critical, int daysNumber) {
        id = counter++;
        this.description = description;
        this.critical = critical;
        this.daysNumber = daysNumber;

    }

    String getInfo() {
        return id + " | " + description + "|  " + critical + " | " + daysNumber;
    }
}

