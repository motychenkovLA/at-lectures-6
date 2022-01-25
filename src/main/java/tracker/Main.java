package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int maxBugs = 10;
        String[] resumeBug = new String[maxBugs];
        String[] severityBug = new String[maxBugs];
        int[] daysToFixBug = new int[maxBugs];

        String command = null;
        int countBugs = 0;
        while (!Objects.equals(command, "quit")) {
            System.out.println("Введите: add, list или quit");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    if (countBugs < maxBugs) {
                        System.out.println("Введите резюме дефекта");
                        resumeBug[countBugs] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        severityBug[countBugs] = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        daysToFixBug[countBugs] = scanner.nextInt();
                        scanner.nextLine();
                        countBugs++;
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (int a = 0; a < countBugs; a++) {
                        System.out.println("Номер дефекта: " + a + " | " + "Резюме: " + resumeBug[a] +
                                " | " + "Критичность: " + severityBug[a] + " | " +
                                "Дней на исправление: " + daysToFixBug[a]);
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