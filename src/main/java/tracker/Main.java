package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        int numberOfDefects = 0;
        final int arraySize = 10;
        String[] resumeArray = new String[arraySize];
        String[] criticalArray = new String[arraySize];
        int[] numberOfDaysArray = new int[arraySize];
        while (run) {
            Scanner console = new Scanner(System.in);
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "list":
                    for (int i = 0; i < numberOfDefects; i++) {
                        System.out.println("" + i + "|" + "Резюме:" + resumeArray[i] + "|" + "Критичность:" + criticalArray[i] + "|" + "Дней на исправление:" + numberOfDaysArray[i]);
                    }
                    break;
                case "add":
                    if (numberOfDefects == arraySize) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                        break;
                    }
                    if (resumeArray[numberOfDefects] == null) {
                        System.out.println("Введите резюме");
                        resumeArray[numberOfDefects] = console.nextLine();

                        System.out.println("Введите критичность дефекта: критично, некритично или *****");
                        criticalArray[numberOfDefects] = console.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        numberOfDaysArray[numberOfDefects] = console.nextInt();
                        console.nextLine();
                        numberOfDefects++;
                    }
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
