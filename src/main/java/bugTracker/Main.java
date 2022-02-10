package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите максимальное количество дефектов: ");
        int maxCountOfDefects = scanner.nextInt();
        scanner.nextLine();
        Repository repository = new Repository(maxCountOfDefects);

        while (true) {
            System.out.println("\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")) {
                if (repository.getNumOfBug() < maxCountOfDefects) {
                    System.out.println("Введите резюме дефекта: ");
                    String summary = scanner.nextLine();

                    System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                            "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                    int dayCount = scanner.nextInt();
                    scanner.nextLine();

                    Defect newDefect = new Defect(summary, priority, dayCount);
                    repository.add(newDefect);
                } else {
                    System.out.println("Достигнуто максимальное количество дефектов");
                }

            } else if (selectionInTheMainMenu.equals("list")) {
                repository.getAll();
            } else if (selectionInTheMainMenu.equals("quit")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Нет такого пункта меню. Введите корректный пункт меню.");
            }
        }
    }
}