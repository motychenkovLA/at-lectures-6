package tracker;

import java.util.*;

public class Main {
    private static final Map<Long, Defect> defectHashMap = new HashMap<>();

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String command = null;
            while (!Objects.equals(command, "quit")) {
                System.out.println("Введите: add, list, quit или change");
                command = scanner.nextLine();
                switch (command) {
                    case "add":
                        addDefect(scanner);
                        break;
                    case "list":
                        displayDefectList();
                        break;
                    case "change":
                        changeDefectStatus(scanner);
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

    // todo - private
    public static int canParseInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат введенного значения, повторите попытку");
            }
        }
    }

    // todo - private
    public static void addDefect(Scanner scanner) {
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
                Defect newDefectWithCommentAttachment = new Defect(resumeBug, severity, daysToFixBug, commentAttachment);
                defectHashMap.put(newDefectWithCommentAttachment.getId(), newDefectWithCommentAttachment);
                break;
            case "link":
                System.out.println("Введите ссылку (id) дефекта");
                long idBug = canParseInt(scanner);
                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                Defect newDefectWithDefectAttachment = new Defect(resumeBug, severity, daysToFixBug, defectAttachment);
                defectHashMap.put(newDefectWithDefectAttachment.getId(), newDefectWithDefectAttachment);
                break;
            default:
                System.out.println("Не верный тип вложения, повторите попытку");
                break;
        }
    }

    // todo - private
    public static void displayDefectList() {
        for (Defect defect : defectHashMap.values()) {
            System.out.println(defect);
        }
    }

    // todo - private
    public static void changeDefectStatus(Scanner scanner) {
        if (defectHashMap.isEmpty()) {
            System.out.println("В репозитории нет дефектов");
            return;
        }
        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
        long idDefectForChangeStatus = canParseInt(scanner);
        if (!defectHashMap.containsKey(idDefectForChangeStatus)) {
            System.out.println("Дефекта с таким id не существует");
            return;
        }
        Defect defectForChangeStatus = defectHashMap.get(idDefectForChangeStatus);
        Status currentStatus = defectForChangeStatus.getStatus();
        System.out.println("Текущий статус дефекта: " + currentStatus);
        List<Status> statusList = Transition.getValidStatus(currentStatus);
        System.out.println("Список валидных статусов для данного дефекта: " + statusList);
        System.out.println("Введите новый статус дефекта из списка");
        // todo 1 - зачем выводить все возможные, если уже вывели список валидных?
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            System.out.println(status.getInRus());
        }
        String statusInput = scanner.nextLine();
        Status newStatusTo = Status.getStatus(statusInput);
        if (newStatusTo == null) {
            System.out.println("Такого значение не существует");
            return;
        }
        if (!statusList.contains(newStatusTo)) {
            System.out.println("Данный статус не валиден для данного дефекта");
            return;
        }
        defectForChangeStatus.setStatus(newStatusTo);
    }
}