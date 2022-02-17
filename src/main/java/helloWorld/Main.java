package helloWorld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int maxBugs = 10;
        Defect[] listBug = new Defect[maxBugs];
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


                        Defect def = new Defect(description, critical, daysNumber);
                        listBug[numberOfBug] = def;

                        numberOfBug++;

                    } else {
                        System.out.println("Достигнуто максимальное количество дефектов");
                    }
                    break;


                case "list":
                    for (int i = 0; i < numberOfBug; i++) {


                        System.out.println(listBug[i].getInfo());
                    }
                    System.out.println("\n\n");


                    break;
                case "quit":
                    System.out.println("Выход из программы");
                    return;
                default:
                    System.out.println("Введена несуществующая операция\n");
                    break;
            }
        }
    }
}