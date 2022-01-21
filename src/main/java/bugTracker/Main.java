package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int WORK_DAYS_IN_WEEK = 5;
        String [] listOfBugs = new String[10];
        int numOfBug = 0;

        while (true){
            System.out.println("\n\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            Scanner scanner = new Scanner(System.in);
            String selectionInTheMainMenu;
            selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")){
                System.out.println("Зашел в add");

                while (numOfBug<10){
                    System.out.println("Введите резюме дефекта: ");

                    String defectSummary = scanner.nextLine();
                    System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                            "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                    String defectPriority = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                    int defectDayCount = scanner.nextInt();
                    boolean moreThanWeek = defectDayCount > WORK_DAYS_IN_WEEK;

                    String bugDesc = "Резюме: " + defectSummary + " | Серьезность: " + defectPriority +
                            " | Количество дней на исправление: " + defectDayCount +
                            " | Займет больше рабочей недели: " + moreThanWeek;

                    listOfBugs[numOfBug] = bugDesc;
                    numOfBug++;
                    break;
                }
            }
            if (selectionInTheMainMenu.equals("list")) {
                for (int i = 0; i<numOfBug; i++){
                    System.out.println(listOfBugs[i]);
                }
            }
            if (selectionInTheMainMenu.equals("quit")) {
                break;
            }
        }
    }
}
