package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task_2 18/01/22
        System.out.println("Введите резюме дефекта: ");
        Scanner scanner = new Scanner(System.in);
        String defectSummary = scanner.nextLine();
        System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High) – требуется исправить в первую очередь;\n" +
                "P2 – Средняя (Medium) – требуется исправить во вторую очередь, когда нет дефектов с высоким приоритетом;\n" +
                "P3 – Низкая (Low) – исправляется в последнюю очередь, когда все дефекты с более высоким приоритетом уже исправлены.");
        String defectPriority = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
        int defectDayCount = scanner.nextInt();
        String weekResult = defectDayCount > 5 ? "\nИсправление займет больше рабочей недели" : "\nИсправление в рамках рабочей недели";

        System.out.println("Резюме: " + defectSummary + "\nСерьезность: " + defectPriority + "\nКоличество дней на исправление: " +
                defectDayCount + weekResult);


    }
}
