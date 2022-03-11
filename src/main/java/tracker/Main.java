package tracker;

import java.util.*;

public class Main {
    private static final Map<Long, Defect> defectHashMap = new HashMap<>();
    static long keyDefect = 0;


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

    public static int canParseInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат введенного значения, повторите попытку");
            }
        }
    }

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
                defectHashMap.put(keyDefect, new Defect(resumeBug, severity, daysToFixBug, commentAttachment));
                break;
            case "link":
                System.out.println("Введите ссылку (id) дефекта");
                long idBug = canParseInt(scanner);
                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                defectHashMap.put(keyDefect, new Defect(resumeBug, severity, daysToFixBug, defectAttachment));
                break;
            default:
                System.out.println("Не верный тип вложения, повторите попытку");
                break;
        }
        keyDefect++;
        // todo 5 - дефект кладется в мапу по некоему keyDefect за которые отвечает Main,
        //  а позже извлекается в changeDefectStatus по своему собственному id за который отвечает Defect
    }

    public static void displayDefectList() {
        for (Defect defect : defectHashMap.values()) {
            System.out.println(defect);
        }
    }

    public static void changeDefectStatus(Scanner scanner) {
        if (defectHashMap.isEmpty()) {
            System.out.println("В репозитории нет дефектов");
            return;
        }
        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
        long idDefectForChangeStatus = canParseInt(scanner);
        // todo 1 - извлечение стоит до проверки на наличие
        Defect defectForChangeStatus = defectHashMap.get(idDefectForChangeStatus);
        if (!defectHashMap.containsKey(idDefectForChangeStatus)) {
            System.out.println("Дефекта с таким id не существует");
            return;
        }
        System.out.println("Введите новый статус дефекта из списка");
        Status[] statuses = Status.values();
        for (Status status : statuses) {
            System.out.println(status.getInRus());
        }

        Status currentStatus = defectForChangeStatus.getStatus();
        String statusInput = scanner.nextLine();
        Status newStatusTo = Status.getStatus(statusInput);

        List<Status> statusList = Transition.getValidStatus(currentStatus);
        if (newStatusTo == null || !statusList.contains(newStatusTo)) {
            System.out.println("Такого значение не существует");
            return;
        }
        defectForChangeStatus.setStatus(newStatusTo);
    }
}