package tracker;
import java.util.Arrays;
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
                    if (Defect.getCountDefects() < repository.maxBugs) {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();
                        System.out.println("Введите критичность дефекта");
                        String severityBug = scanner.nextLine();
                        System.out.println("Введите количество дней на исправление дефекта");
                        int daysToFixBug = scanner.nextInt();
                        scanner.nextLine();

                        repository.addDefect(Defect.getCountDefects(), new Defect(resumeBug, severityBug,
                                daysToFixBug));

                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (int a = 0; a < Defect.getCountDefects(); a++) {
                        System.out.println(Arrays.toString(repository.getAllDefects()));
                    }
                    break;


            }
        }
    }
}