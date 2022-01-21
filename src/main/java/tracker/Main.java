package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int week = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта");
        String severity = scanner.nextLine();

        System.out.println("Введите количество дней на исправление дефекта");
        int countDays = scanner.nextInt();
        scanner.nextLine();

        boolean takeWeek = countDays > week;

        System.out.println("Резюме дефекта: " + resume);
        System.out.println("Критичность дефекта: " + severity);
        System.out.println("Кол-во дней на испр. дефекта: " + countDays);
        System.out.println("Займет больше рабочей недели: " + takeWeek);
    }
}
