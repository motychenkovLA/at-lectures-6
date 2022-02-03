package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        int numberOfDefects = 0;
        final int CONST_STYLE = 10; // todo 1 - константа с названием константа
        // todo 1 - объявление переменных задолго до использования
        String resume;
        String critical;
        int numberOfDays;
        Defect defectList = new Defect();
        defectList.setConstStyle(CONST_STYLE);
        while (run) {
            Scanner console = new Scanner(System.in);
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "list":
                    defectList.getDefects();
                    break;
                case "add":
                    if (numberOfDefects >= CONST_STYLE) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                        break;
                    }
                    System.out.println("Введите резюме");
                    resume = console.nextLine();
                    System.out.println("Введите критичность дефекта: критично, некритично или *****");
                    critical = console.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    numberOfDays = console.nextInt();
                    console.nextLine();
                    defectList.defect(numberOfDefects, resume, critical, numberOfDays);
                    numberOfDefects++;
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
