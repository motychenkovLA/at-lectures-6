package helloWorld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int maxBugs = 10;


        String[] descriptions = new String[maxBugs];
        String[] criticals = new String[maxBugs];
        int[] daysNumbers = new int[maxBugs];
        int numberOfBug = 0;

                while (true) {
            System.out.println("add - добавить новый дефект" + "\nlist - вывести список дефектов" + "\nquit - выход из программы ");


            Scanner scanner = new Scanner(System.in);
            String menu = scanner.nextLine();

            switch (menu) {
                case "add":

                    if (numberOfBug < maxBugs) {
                        System.out.println("Введите резюме дефекта");

                        String description = scanner.nextLine();
                        System.out.println("Введите критичность дефекта:\nLow\nMedium\nHigh\nCritical");
                        String critical = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        int daysNumber = scanner.nextInt();


                        descriptions[numberOfBug] = description;
                        criticals[numberOfBug] = critical;
                        daysNumbers[numberOfBug] = daysNumber;
                        numberOfBug++;

                    } else {
                        System.out.println("Достигнуто максимальное количество дефектов");
                    }
                    break;
                case "list":
                    for (int i = 0; i < numberOfBug; i++) {
                        int workWeek = 5;
                        boolean moreThanWorkWeek = daysNumbers[i] >= workWeek;
                        System.out.println(descriptions[i] + " | " + criticals[i] + " | " + daysNumbers[i] + " | Займёт больше рабочей недели:" + moreThanWorkWeek);
                    }

                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    break;
            }
        }
    }
}