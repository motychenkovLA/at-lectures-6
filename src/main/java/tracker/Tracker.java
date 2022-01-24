package tracker;

import java.util.Scanner;

class Tracker {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка: blocker, critical, major, minor, trivial");
        String criticality = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int numberOfDays = scanner.nextInt();
        boolean result = numberOfDays > 7;
        System.out.println("Резюме дефекта: " + name + "\nКритичность: " + criticality +
                "\nКоличество дней на исправление: " + numberOfDays + "\nИсправление займет больше недели: " + result);
    }
}
