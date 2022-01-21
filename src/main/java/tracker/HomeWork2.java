package tracker;

import java.util.Scanner;

// todo 0 - HomeWork2 -> Main, переименовать можно через shift-f6
public class HomeWork2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта");
        String severity = scanner.nextLine();

        System.out.println("Введите количество дней на исправление дефекта");
        int countDays = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Резюме дефекта: " + resume);
        System.out.println("Критичность дефекта: " + severity);
        System.out.println("Кол-во дней на испр. дефекта: " + countDays);
        // todo 3 - "займет больше рабочей недели (true/false)"
    }
}
