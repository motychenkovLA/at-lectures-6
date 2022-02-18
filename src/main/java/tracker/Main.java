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

                        System.out.println("Введите цифру которая, соответствует критичности: 1 - блокирующий, " +
                                "2 - критический, 3 - значительный, 4 - незначительный");
                        Severity severity;
                        while (true) {
                            int numSeverity = scanner.nextInt();
                            scanner.nextLine();
                            if (numSeverity == 1) {
                                severity = Severity.BLOCKER;
                                System.out.println(severity.getInRus());
                                break;
                            }
                            if (numSeverity == 2) {
                                severity = Severity.CRITICAL;
                                System.out.println(severity.getInRus());
                                break;
                            }
                            if (numSeverity == 3) {
                                severity = Severity.MAJOR;
                                System.out.println(severity.getInRus());
                                break;
                            }
                            if (numSeverity == 4) {
                                severity = Severity.MINOR;
                                System.out.println(severity.getInRus());
                                break;
                            } else {
                                System.out.println("Такого значения не существует, повторите попытку");
                            }
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
                            System.out.println("Введите цифру которая, соответствует статусу: 1 - открыт, 2 - в работе, 3 - закрыт");
                            Status status;
                            while (true) {
                                int numStatus = scanner.nextInt();
                                scanner.nextLine();
                                if (numStatus == 1) {
                                    status = Status.OPEN;
                                    defectForChangeStatus.setStatus(status);
                                    break;
                                }
                                if (numStatus == 2) {
                                    status = Status.INWORK;
                                    defectForChangeStatus.setStatus(status);
                                    break;
                                }
                                if (numStatus == 3) {
                                    status = Status.CLOSED;
                                    defectForChangeStatus.setStatus(status);
                                    break;
                                } else {
                                    System.out.println("Такого значения не существует, повторите попытку");
                                }
                            }
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