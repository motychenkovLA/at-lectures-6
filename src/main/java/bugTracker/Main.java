package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int WORK_DAYS_IN_WEEK = 5;
        final int MAX_COUNT_OF_BUGS = 10;

        //todo в множественном числе - defects
        Defect [] defect = new Defect[MAX_COUNT_OF_BUGS];
        int numOfBug = 0;

        while (true){
            System.out.println("\n\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            Scanner scanner = new Scanner(System.in);

            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")){

                if (numOfBug<MAX_COUNT_OF_BUGS) {
                    Defect newDefect = new Defect();
                    newDefect.setId(numOfBug);
                    System.out.println("Введите резюме дефекта: ");

                    newDefect.setDefectSummary(scanner.nextLine());

                    System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                            "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                    newDefect.setDefectPriority(scanner.nextLine());

                    System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                    newDefect.setDefectDayCount(scanner.nextInt());

                    defect[numOfBug] = newDefect;
                    numOfBug++;
                } else {
                    System.out.println("Достигнуто максимальное количество дефектов!");
                }
            }
            else if (selectionInTheMainMenu.equals("list")) {
                for (int i = 0; i<numOfBug; i++){
                //todo в выводе пропустила ID
                    boolean moreThanWeek = defect[i].getDefectDayCount() > WORK_DAYS_IN_WEEK;
                    System.out.println("Резюме: " + defect[i].getDefectSummary() + " | Серьезность: " +
                            defect[i].getDefectPriority() + " | Количество дней на исправление: " +
                            defect[i].getDefectDayCount() + " | Займет больше рабочей недели: " + moreThanWeek);
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
