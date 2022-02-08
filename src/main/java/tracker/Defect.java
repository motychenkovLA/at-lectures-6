package tracker;


import java.util.Scanner;

public class Defect {
    private String resume;
    private String critical;
    private int numberOfDays;
    static long numberOfDefects=0; // todo 3 - нет модификатора доступа
    private final long id;

    // todo 3 - нет модификатора доступа
    Defect() {
        numberOfDefects++;
        this.id = numberOfDefects;
        // todo 3 - дефект не должен отвечать за работу с консолью
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        this.resume = console.nextLine();
        System.out.println("Введите критичность дефекта: критично, некритично или *****");
        this.critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        this.numberOfDays = console.nextInt();

    }

    // todo 3 - нет модификатора доступа
    // todo 1 - обманывающее название, метод возвращает не дефект, а его описание/текстовое представление
    String getDefect() {
        return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
    // todo 3 - нет модификатора доступа
    long getId() {
        return id;
    }

}
