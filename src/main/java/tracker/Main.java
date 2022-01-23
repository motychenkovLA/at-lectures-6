package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int WEEK = 5;
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        String[] bugs = new String[10];
        String toDoList = null;

        while (!Objects.equals(toDoList, "quit")) {
            System.out.println("Введите: add, list или quit");
            toDoList = scanner.nextLine();
            switch (toDoList) {
                case "add":
                    if (i < bugs.length) {
                        System.out.println("Введите резюме дефекта");
                        String resume = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        String severity = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        int countDays = scanner.nextInt();
                        scanner.nextLine();
                        boolean takeWeek = countDays > WEEK;
                        bugs[i] = "Номер дефекта: " + i + " | " + "Резюме: " + resume + " | " +
                                "Критичность: " + severity + " | " + "Дней на исправление: " + countDays +
                                " | " + "Займет больше рабочей недели: " + takeWeek;
                        i++;
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (int a = 0; a < i; a++) {
                        System.out.println(bugs[a]);
                    }
                    break;

                case "quit":
                    break;

                default:
                    System.out.println("Введено не корректное значение, повторите попытку");
                    break;

            }
        }
    }
}