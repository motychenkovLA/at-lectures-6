
package tracker;

import org.jetbrains.annotations.NotNull;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        Repository repository = new Repository();
        boolean isRun = true;

        try (Scanner scanner = new Scanner(System.in)) {


            while (isRun) {

                System.out.println(" Выберите действие " +
                        "\n add (Добавить новый дефект)" +
                        "\n list (Вывести список дефектов)" +
                        "\n change (Изменить статус дефекта)" +
                        "\n quit (Вернуться в главное меню)");

                String action = scanner.nextLine();

                switch (action) {
                    case ("add"): {
                        addBug(scanner, repository);
                        break;
                    }
                    case ("list"): {
                        listBug(repository);
                        break;
                    }
                    case ("change"): {
                        changeStatusBug(scanner, repository);
                        break;
                    }
                    case ("quit"): {
                        isRun = false;
                        break;
                    }
                    default: {
                        System.out.println("Ошибочное значение");
                        break;
                    }
                }
            }
        }
    }

    public static void addBug(@NotNull Scanner scanner, Repository repository) {
        System.out.println("Введите резюме дефекта");
        String resume = scanner.nextLine();

        System.out.println("Введите критичность дефекта (" + Severity.list() +") :");
        Severity critical = Severity.getSeverityByValue(scanner.nextLine());
        if (critical == null) {
            critical = Severity.MEDIUM;
            System.out.println("Внимание, вы ввели несуществующую критичность - по умолчанию критичность установлена = Средняя");
        }

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int daysToFix = inInt(scanner);

        Attachment attachment = null;

        while (attachment == null) {
            System.out.println("Введите тип вложения (comment, defect): ");
            String attachmentType = scanner.nextLine();
            if (attachmentType.equals("comment")) {
                System.out.println("Введите комментарий: ");
                String comment = scanner.nextLine();
                attachment = new CommentAttachment(comment);
            } else if (attachmentType.equals("defect")) {
                System.out.println("Введите номер дефекта: ");
                int defectId = inInt(scanner);
                scanner.nextLine();
                attachment = new DefectAttachment(defectId);
            } else {
                System.out.println("Ошибочное значение");
            }
        }
        Defect bug = new Defect(resume, critical, daysToFix, attachment);
        repository.add(bug);
    }

    public static void listBug(Repository repository) {
        Defect[] defects = repository.getAll();
        for (Defect bug : defects) {
            System.out.println(bug);
        }
        System.out.println();
    }

    public static void changeStatusBug(@NotNull Scanner scanner, Repository repository) {
        System.out.println("Введите номер дефекта, для которого нужно изменить статус:");
        int defectId = inInt(scanner);
        Defect bug = repository.getById(defectId);

        if (bug == null) {
            System.out.println("Нет дефекта с таким номером!");
            return;
        }

        System.out.println("Текущий статус дефекта - " + bug.getStatus() +
                "\nВведите новый статус (" + Status.list() + "): ");
        Status status = Status.getStatusByValue(scanner.nextLine());
        if (status == null) {
            System.out.println("Внимание, вы ввели несуществующий статус - статус изменен не будет");
            return;
        }
        bug.setStatus(status);
        System.out.println("Успешно! Текущий статус дефекта - " + bug.getStatus());
    }

    public static int inInt(@NotNull Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Введите число");
            }
        }
    }

}
