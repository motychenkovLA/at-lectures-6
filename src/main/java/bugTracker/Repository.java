package bugTracker;
import java.util.Arrays;
import java.util.Scanner;

public class Repository {
    private int numOfBug = 0;
    private Defect[] defects = new Defect[10];

    void add (Defect defect){
        if (numOfBug == defects.length) {
            defects = Arrays.copyOf(defects, defects.length * 2);
        }
        defects[numOfBug] = defect;
        numOfBug++;
    }
    public Defect getById(int id) {
        for (Defect defect : defects) {
            if (defect == null) {
                continue;
            }
            if (id == defect.getId()) {
                return defect;
            }
        }
        return null;
    }

    Defect[] getAll(){
        return defects;
    }

    void changeStatus(int id, String name) {
        if (getById(id) != null) {
            getById(id).setStatus(Status.findByName(name));
        }
    }

    //Добавление нового дефекта. Пункт меню.
    void addDefect (Repository repository, Scanner scanner) {
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
            repository.add(newDefect);
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
            repository.add(newDefect);
        } else {
            System.out.println("Нет такого типа вложения.");
            Defect newDefect = new Defect(summary, priority, dayCount);
            repository.add(newDefect);
        }
    }

    //Изменение статуса дефекта. Пункт меню.
    void changeStatusOfDefect (Repository repository, Scanner scanner) {
        int idForChangeStatus;
        while (true) {
            try {
                System.out.println("Введите id дефекта для изменения статуса: ");
                idForChangeStatus = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Вводимое значение должно быть числом.");
            }
        }
        if (repository.getById(idForChangeStatus) != null) {
            System.out.println("Введите новый статус дефекта: ");
            String newStatus = scanner.nextLine();
            repository.changeStatus(idForChangeStatus,newStatus);
        } else {
            System.out.println("Такого id дефекта нет.");
        }
    }
}
