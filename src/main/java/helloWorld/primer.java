package helloWorld;
import java.util.Scanner;
public class primer {
    public static void main(String[] args) {

        final int WORK_DAYS_IN_WEEK = 5;
        final int MAX_COUNT_OF_BUGS = 10;

        String [] defectSummaries = new String[MAX_COUNT_OF_BUGS];
        String [] defectPriorities = new String[MAX_COUNT_OF_BUGS];
        int [] daysOfFix = new int[MAX_COUNT_OF_BUGS];
        int numOfBug = 0;

        while (true){
            System.out.println("Введите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            Scanner scanner = new Scanner(System.in);

            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")){

                if (numOfBug<MAX_COUNT_OF_BUGS) {
                    System.out.println("Введите резюме дефекта: ");

                    String defectSummary = scanner.nextLine();
                    System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                            "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                    String defectPriority = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                    int defectDayCount = scanner.nextInt();

                    defectSummaries[numOfBug] = defectSummary;
                    defectPriorities[numOfBug] = defectPriority;
                    daysOfFix[numOfBug] = defectDayCount;
                    numOfBug++;
                } else {
                    System.out.println("Достигнуто максимальное количество дефектов!");
                }
            }
            else if (selectionInTheMainMenu.equals("list")) {
                for (int i = 0; i<numOfBug; i++){

                    boolean moreThanWeek = daysOfFix[i] > WORK_DAYS_IN_WEEK;
                    System.out.println("Резюме: " + defectSummaries[i] + " | Серьезность: " +
                            defectPriorities[i] + " | Количество дней на исправление: " + daysOfFix[i] +
                            " | Займет больше рабочей недели: " + moreThanWeek);
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