package tracker;


import java.util.Scanner;

public class Defect {
    private String resume;
    private String critical;
    private int numberOfDays;
    static long numberOfDefects=0;
    private final long id;

    Defect() {
        numberOfDefects++;
        this.id = numberOfDefects;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        this.resume = console.nextLine();
        System.out.println("Введите критичность дефекта: критично, некритично или *****");
        this.critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        this.numberOfDays = console.nextInt();

    }

    String getDefect() {
        return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
    long getId() {
        return id;
    }

}
