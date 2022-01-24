package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String[] bugs = new String[10];
        String[] resumeBug = new String[bugs.length];
        String[] severityBug = new String[bugs.length];
        int[] daysToFixBug = new int[bugs.length];

        // todo 1 - toDoList -> command, input, action, не понятно при чем тут лист
        // не очень понятен комментарий: лист - перечень, toDoList - перечень того, что сделать
        String commandList = null;

        int countBugs = 0;
        while (!Objects.equals(commandList, "quit")) {
            System.out.println("Введите: add, list или quit");
            commandList = scanner.nextLine();
            switch (commandList) {
                case "add":
                    if (countBugs < bugs.length) {
                        System.out.println("Введите резюме дефекта");
                        resumeBug[countBugs] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        severityBug[countBugs] = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        daysToFixBug[countBugs] = scanner.nextInt();
                        scanner.nextLine();
                        bugs[countBugs] = "Номер дефекта: " + countBugs + " | " + "Резюме: " + resumeBug[countBugs] +
                                " | " + "Критичность: " + severityBug[countBugs] + " | " +
                                "Дней на исправление: " + daysToFixBug[countBugs];
                        countBugs++;
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (int a = 0; a < countBugs; a++) {
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