package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository(10);

        try (Scanner scanner = new Scanner(System.in)) {
            String command = null;
            while (!Objects.equals(command, "quit")) {
                System.out.println("Введите: add, list, quit или change");
                command = scanner.nextLine();
                switch (command) {
                    case "add":
                        addDefect(repository, scanner);
                        break;

                    case "list":
                        displayDefectList(repository);
                        break;

                    case "change":
                        changeDefectStatus(repository, scanner);
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
    public static int canParseInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат введенного значения, повторите попытку");
            }
        }
    }
    public static void addDefect(Repository repository, Scanner scanner) {
        if (repository.repositoryIsFull()) {
            System.out.println("Превышено максимально допустимое кол-во дефектов");
            return;
        }
        System.out.println("Введите резюме дефекта");
        String resumeBug = scanner.nextLine();

        System.out.println("Введите критичность дефекта из списка");
        Severity[] severitys = Severity.values();
        for (Severity severity : severitys) {
            System.out.println(severity.getInRus());
        }
        String severityInput = scanner.nextLine();
        Severity severity = Severity.getSeverity(severityInput);
        if (severity == null) {
            System.out.println("Такого значение не существует");
            return;
        }
        System.out.println("Введите количество дней на исправление дефекта");
        int daysToFixBug = canParseInt(scanner);

        System.out.println("Выберите тип вложение: comment или link");
        // todo по желанию - лучше переработать, потому что сейчас из-за ошибки в названии типа дефекта,
        //  приходится заново вводить все остальные данные
        // Пока не нашла решения как это сделать

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
                long idBug = canParseInt(scanner);
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
        if (repository.repositoryIsEmpty()) {
            System.out.println("В репозитории нет дефектов");
            return;
        }
        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
        long idDefectForChangeStatus = canParseInt(scanner);
        Defect defectForChangeStatus = repository.findDefectById(idDefectForChangeStatus);
        if (defectForChangeStatus == null) {
            System.out.println("Дефекта с таким id не существует");
            return;
        }
        System.out.println("Введите новый статус дефекта из списка");
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            System.out.println(status.getInRus());
        }
        String statusInput = scanner.nextLine();
        Status newStatus = Status.getStatus(statusInput);
        if (newStatus == null) {
            System.out.println("Такого значение не существует");
            return;
        }
        defectForChangeStatus.setStatus(newStatus);
    }
}