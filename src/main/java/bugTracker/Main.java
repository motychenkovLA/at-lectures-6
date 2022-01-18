package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task_2 18/01/22
        final int WORK_DAYS_IN_WEEK = 5;

        System.out.println("Введите резюме дефекта: ");
        Scanner scanner = new Scanner(System.in);
        String defectSummary = scanner.nextLine();
        System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
        String defectPriority = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
        int defectDayCount = scanner.nextInt();
        boolean moreThanWeek = defectDayCount > WORK_DAYS_IN_WEEK;

        System.out.println("Резюме: " + defectSummary + "\nСерьезность: " + defectPriority +
                "\nКоличество дней на исправление: " + defectDayCount +
                "\nЗаймет больше рабочей недели: " + moreThanWeek);


    }
}
