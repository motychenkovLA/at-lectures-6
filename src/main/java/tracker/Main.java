package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        String command = null;


        while (!Objects.equals(command, "quit")) {
            System.out.println("Введите: add, list или quit");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    if (!repository.repositoryIsFull()) {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        String severityBug = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        int daysToFixBug = scanner.nextInt();
                        scanner.nextLine();

                        repository.addDefect (new Defect(resumeBug, severityBug, daysToFixBug));

                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (Defect defect : repository.getAllDefects()) {
                        System.out.println(defect.getBugsInfo());
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