package tracker;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository(10);
        String command = null;

        try (Scanner scanner = new Scanner(System.in)) {

            while (!Objects.equals(command, "quit")) {
                System.out.println("Введите: add, list, quit или change");
                command = scanner.nextLine();
                switch (command) {
                    case "add":
                        // todo 3 - if это все еще логика addDefect-а, должна быть в методе
                        if (!repository.repositoryIsFull()) {
                            addDefect(repository, scanner);
                        } else {
                            System.out.println("Превышено максимально допустимое кол-во дефектов");
                        }
                        break;

                    case "list":
                        displayDefectList(repository);
                        break;

                    case "change":
                        // todo 3 - if это логика changeDefectStatus-а
                        if (!repository.repositoryIsEmpty()) {
                            changeDefectStatus(repository, scanner);
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
        } catch (IllegalStateException e) { // todo 3 - откуда тут IllegalStateException?
            e.printStackTrace();
        }
    }

    // todo 1 - отступ
        public static void addDefect (Repository repository, Scanner scanner){

            System.out.println("Введите резюме дефекта");
            String resumeBug = scanner.nextLine();

            System.out.println("Введите критичность дефекта из списка");
            Severity[] severitys = Severity.values();
            for (Severity severity : severitys) {
                System.out.println(severity.getInRus());
            }
            String severityInput = scanner.nextLine();
            Severity severity;
            severity = Severity.getSeverity(severityInput);
            if (severity == null) {
                System.out.println("Такого значение не существует");
//                break; // todo 5 - продолжает дальше с null-ом в severity
            }
            System.out.println("Введите количество дней на исправление дефекта");
            int daysToFixBug;
            while (true) {
                try {
                    daysToFixBug = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    System.out.println("Не верный формат введенного значения, потворите попытку");
                }
            }

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
        }

    public static void displayDefectList(Repository repository) {
        for (Defect defect : repository.getAllDefects()) {
            System.out.println(defect.getBugsInfo());
        }
    }

    public static void changeDefectStatus(Repository repository, Scanner scanner) {
        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
        long idDefectForChangeStatus = scanner.nextLong(); // todo 3 - используется nextLong вместо nextLine
        scanner.nextLine();
        Defect defectForChangeStatus = repository.findDefectById(idDefectForChangeStatus);
        if (defectForChangeStatus != null) {
            System.out.println("Введите новый статус дефекта из списка");
            Status[] statuses = Status.values();
            for (Status status : statuses) {
                System.out.println(status.getInRus());
            }
            String statusInput = scanner.nextLine();
            Status newStatus; // todo 1 - объявление отдельно от инициализации
            newStatus = Status.getStatus(statusInput);
            if (newStatus == null) {
                System.out.println("Такого значение не существует");
            } else {
                defectForChangeStatus.setStatus(newStatus);
            }
        }
        // todo 3 - проверка на отсутствие дефекта уже после основного кейса
        if (defectForChangeStatus == null) {
            System.out.println("Дефекта с таким id не существует");
        }

    }
}