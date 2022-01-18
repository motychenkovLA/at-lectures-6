package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final int WORK_WEEK = 5;


        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите описание дефекта");
        String resume = scanner.nextLine();
        System.out.println("Введите критичность дефекта: Low, Mid, High, Crit");
        String criticality = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление");
        int daysToFix = scanner.nextInt();
        boolean fixInAWeek = daysToFix < WORK_WEEK;
        System.out.println(resume + " | " + criticality + " | " + daysToFix + " | "+ fixInAWeek);

    }
}
