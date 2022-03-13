package bugTracker;
import java.util.*;

public class Main{

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Map<Long, Defect> repository = new HashMap<>();

            while (true) {
                System.out.println("\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                        "Введите change, чтобы изменить статус дефекта\n" +
                        "Введите list, чтобы вывести список дефектов\n" +
                        "Введите quit для выхода из прогруммы ");
                String selectionInTheMainMenu = scanner.nextLine();

                if (selectionInTheMainMenu.equals("add")) {
                    addDefect(repository,scanner);
                } else if (selectionInTheMainMenu.equals("change")) {
                    changeStatusOfDefect(repository,scanner);
                } else if (selectionInTheMainMenu.equals("list")) {
                    repository.forEach((id, defect) -> System.out.println(defect.getInfo()));
                } else if (selectionInTheMainMenu.equals("quit")) {
                    System.out.println("До свидания!");
                    break;
                } else {
                    System.out.println("Нет такого пункта меню. Введите корректный пункт меню.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Изменение статуса дефекта. Пункт меню.
    private static void changeStatusOfDefect(Map<Long, Defect> repository, Scanner scanner) {
        long idForChangeStatus;
        while (true) {
            try {
                System.out.println("Введите id дефекта для изменения статуса: ");
                idForChangeStatus = Long.parseLong(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом.");
            }
        }
        if (repository.get(idForChangeStatus) != null) {
            System.out.println("Введите новый статус дефекта: ");
            String newStatus = scanner.nextLine();
            if(!Transition.checkTransition(repository.get(idForChangeStatus).getStatus().getName(),newStatus)){
                System.out.println("Данный переход по статусу не валиден. Статус изменен не будет.");
            } else {
                repository.get(idForChangeStatus).setStatus(Status.findByName(newStatus));
            }
        } else {
            System.out.println("Такого id дефекта нет.");
        }
    }

    //Добавление нового дефекта. Пункт меню.
    private static void addDefect(Map<Long, Defect> repository, Scanner scanner) {
        String summary;
        Priority priority;
        int dayCount;
        String attachmentType;
        int defectAttachment;

        System.out.println("Введите резюме дефекта: ");
        summary = scanner.nextLine();

        while (true) {
            System.out.println("Введите критичность дефекта, например:\nВысокая;\n" +
                    "Средняя;\nНизкая.");
            String priorityLine = scanner.nextLine();
            if (Priority.findByName(priorityLine) != null) {
                priority = Priority.findByName(priorityLine);
                break;
            } else {
                System.out.println("Нет такой критичности дефекта. Введите корректную критичность дефекта.");
            }
        }
        while (true) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                dayCount = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом.");
            }
        }
        System.out.println("Выберите тип вложения\n1 - комментарий\n2 - ссылка на другой дефект: ");
        attachmentType = scanner.nextLine();

        if (attachmentType.equals("1")) {
            System.out.println("Введите комментарий: ");
            String commentAttachment = scanner.nextLine();
            Attachment attachment = new CommentAttachment(commentAttachment);

            Defect newDefect = new Defect(summary, priority, dayCount, attachment);
            repository.put(newDefect.getId(), newDefect);
        } else if (attachmentType.equals("2")) {
            while (true) {
                try {
                    System.out.println("Введите ссылку на другой дефект: ");
                    defectAttachment = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Вводимое значение должно быть числом.");
                }
            }
            Attachment attachment = new DefectAttachment(defectAttachment);

            Defect newDefect = new Defect(summary, priority, dayCount, attachment);
            repository.put(newDefect.getId(), newDefect);
        } else {
            System.out.println("Нет такого типа вложения.");
            Defect newDefect = new Defect(summary, priority, dayCount);
            repository.put(newDefect.getId(), newDefect);
        }
    }
}