package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int WORK_DAYS_IN_WEEK = 5;
        final int MAX_COUNT_OF_BUGS = 10;

        Defect [] defects = new Defect[MAX_COUNT_OF_BUGS];
        int numOfBug = 0;

        while (true){
            System.out.println("\n\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            Scanner scanner = new Scanner(System.in);

            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")){

                if (numOfBug<MAX_COUNT_OF_BUGS) {
                    System.out.println("Введите резюме дефекта: ");
                    String summary = scanner.nextLine();

                    System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                            "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                    int dayCount = scanner.nextInt();

                    Defect newDefect = new Defect(numOfBug, summary, priority, dayCount);
                    defects[numOfBug] = newDefect;
                    numOfBug++;

                } else {
                    System.out.println("Достигнуто максимальное количество дефектов!");
                }
            }
            else if (selectionInTheMainMenu.equals("list")) {
                for (int i = 0; i<numOfBug; i++){

                    boolean moreThanWeek = defects[i].getDayCount() > WORK_DAYS_IN_WEEK;
                    System.out.println("ID: " + defects[i].id + " | Резюме: " + defects[i].getSummary() + " | Серьезность: " +
                            defects[i].getPriority() + " | Количество дней на исправление: " +
                            defects[i].getDayCount() + " | Займет больше рабочей недели: " + moreThanWeek);
                }
            }
            else if (selectionInTheMainMenu.equals("quit")) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Нет такого пункта меню. Введите корректный пункт меню.");
            }
        }
    }
}
