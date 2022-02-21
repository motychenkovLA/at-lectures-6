package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        String command = null;

        while (!Objects.equals(command, "quit")) {
            System.out.println("Введите: add, list, quit или change");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    if (!repository.repositoryIsFull()) {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();

                        Severity severity;
                        System.out.println("Введите критичность дефекта: блокирующий, критический, значительный, " +
                                "незначительный");
                        String severityInput = scanner.nextLine();
                        severity = Severity.getSeverity(severityInput);
                        if (severity == null) {
                            System.out.println("Такого значение не существует");
                            break;
                        }

                        System.out.println("Введите количество дней на исправление дефекта");
                        int daysToFixBug = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Выберите тип вложение: comment или link");
                        String attachmentBug = scanner.nextLine();

                        switch (attachmentBug) {
                            case "comment":
                                System.out.println("Введите комментарий");
                                String comment = scanner.nextLine();
                                CommentAttachment commentAttachment = new CommentAttachment(comment);
                                repository.addDefect(new Defect(resumeBug, severity, daysToFixBug, commentAttachment));
                                break;
                            case "link":
                                System.out.println("Введите ссылку (id) дефекта");
                                String idBug = scanner.nextLine();
                                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                                repository.addDefect(new Defect(resumeBug, severity, daysToFixBug, defectAttachment));
                                break;
                            default:
                                System.out.println("Не верный тип вложения, повторите попытку");
                                break;
                        }
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (Defect defect : repository.getAllDefects()) {
                        System.out.println(defect.getBugsInfo());
                    }
                    break;
                case "change":
                    if (!repository.repositoryIsEmpty()) {
                        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
                        long idDefectForChangeStatus = scanner.nextLong();
                        scanner.nextLine();
                        Defect defectForChangeStatus = repository.findDefectById(idDefectForChangeStatus);
                        if (defectForChangeStatus != null) {
                            Status newStatus;
                            System.out.println("Введите новый статус дефекта: открыт, в работе, закрыт");
                            String statusInput = scanner.nextLine();
                            newStatus = Status.getStatus(statusInput);
                            if (newStatus == null) {
                                System.out.println("Такого значение не существует");
                            }
                            else defectForChangeStatus.setStatus(newStatus);
                        }
                        if (defectForChangeStatus == null) {
                            System.out.println("Дефекта с таким id не существует");
                        }
                    } else {
                        System.out.println("В репозитории нет дефектов");
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