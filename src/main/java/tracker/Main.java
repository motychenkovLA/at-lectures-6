package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        int numberOfDefects = 0;
        final int MAX_DEFECTS = 10;
        Defect[] defectList = new Defect[MAX_DEFECTS];
        while (run) {
            Scanner console = new Scanner(System.in);
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "list":
                    for (int i = 0; i < numberOfDefects; i++) {
                        System.out.println(defectList[i].printDefect());
                    }

                    break;
                case "add":
                    if (numberOfDefects >= MAX_DEFECTS) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                        break;
                    }

                    System.out.println("Введите резюме");
                    String resume = console.nextLine();
                    System.out.println("Введите критичность дефекта: критично, некритично или *****");
                    String critical = console.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDays = console.nextInt();
                    console.nextLine();
                    defectList[numberOfDefects] = new Defect(numberOfDefects, resume, critical, numberOfDays);

                    numberOfDefects++;
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
