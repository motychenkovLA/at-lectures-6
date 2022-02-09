package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final int maxBugs = 10;
        Defect[] defectList = new Defect[maxBugs];
        int idBug = 0; // todo 1 - не используется
        String command = null;
        int countBugs = 0;
        while (!Objects.equals(command, "quit")) {
            System.out.println("Введите: add, list или quit");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    if (countBugs < maxBugs) {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        String severityBug = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        int daysToFixBug = scanner.nextInt();
                        scanner.nextLine();

                        defectList[countBugs] = new Defect(countBugs + 1, resumeBug, severityBug, daysToFixBug);
                        countBugs++;
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (int a = 0; a < countBugs; a++) {
                        System.out.println(defectList[a].getBugsInfo());
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