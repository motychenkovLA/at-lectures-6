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

                        System.out.println("Выберите критичность дефекта из списка:");
                        Severity[] severitys = Severity.values();
                        for (Severity severity : severitys)
                            System.out.println(severity);
                        System.out.println();
                        System.out.println("Введите цифру которая, соответствует критичности: 1 - блокирующий, " +
                                "2 - критический, 3 - значительный, 4 - незначительный");
                        Severity severityBug = null;
                        int numSeverity = scanner.nextInt();
                        scanner.nextLine();
                        switch (numSeverity) {
                            case 1:
                                severityBug = Severity.BLOCKER;
                                break;
                            case 2:
                                severityBug = Severity.CRITICAL;
                                break;
                            case 3:
                                severityBug = Severity.MAJOR;
                                break;
                            case 4:
                                severityBug = Severity.MINOR;
                                break;
                            default:
                                System.out.println("Такого значения не существует");
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
                                    repository.addDefect(new Defect(resumeBug, severityBug, daysToFixBug, commentAttachment));
                                    break;
                                case "link":
                                    System.out.println("Введите ссылку (id) дефекта");
                                    String idBug = scanner.nextLine();
                                    DefectAttachment defectAttachment = new DefectAttachment(idBug);
                                    repository.addDefect(new Defect(resumeBug, severityBug, daysToFixBug, defectAttachment));
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
                    if(!repository.repositoryIsEmpty()) {
                        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
                        long idDefectForChangeStatus = scanner.nextLong();
                        scanner.nextLine();
                        Defect defectForChangeStatus = repository.findDefectById(idDefectForChangeStatus);
                        if (defectForChangeStatus != null) {
                            System.out.println("Выберите новый статус из списка:");
                            Status statuses[] = Status.values();
                            for (Status status : statuses)
                                System.out.println(status.getInRus());
                            System.out.println("Введите цифру которая, соответствует статусу: 1 - открыт, 2 - в работе, 3 - закрыт");
                            int numStatus = scanner.nextInt();
                            scanner.nextLine();
                            switch (numStatus) {
                                case 1:
                                    defectForChangeStatus.setStatus(Status.OPEN);
                                    break;
                                case 2:
                                    defectForChangeStatus.setStatus(Status.INWORK);
                                    break;
                                case 3:
                                    defectForChangeStatus.setStatus(Status.CLOSED);
                                    break;
                                default:
                                    System.out.println("Такого значения не существует");
                                    break;
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