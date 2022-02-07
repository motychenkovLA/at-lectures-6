package tracker;

public class Defect {
    private long id;
    private  String name;
    private String criticality;
    private int daysnumber;
    static private int counter = 1;

    public Defect(String name, String criticality, int daysnumber) {
        this.name = name;
        this.criticality = criticality;
        this.daysnumber = daysnumber;
        id = counter++;
    }
    String getInfo () {
        return   id + ", Резюме дефекта: " + name + ", Критичность: " + criticality +
                ", Количество дней на исправление: " + daysnumber;
    }
}
