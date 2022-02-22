package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Repository repository = new Repository();
        Priority priority;

        while (true) {
            //Регулярное выражение для решения проблемы со сканером. Пропускаем все пустые символы
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите change, чтобы изменить статус дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")) {
                System.out.println("Введите резюме дефекта: ");
                String summary = scanner.nextLine();

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

                System.out.println("Введите ожидаемое количество дней на исправление дефекта: ");
                int dayCount = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Выберите тип вложения\n1 - комментарий\n2 - ссылка на другой дефект: ");
                String attachmentType = scanner.nextLine();

                if (attachmentType.equals("1")) {
                    System.out.println("Введите комментарий: ");
                    String commentAttachment = scanner.nextLine();
                    Attachment attachment = new CommentAttachment(commentAttachment);

                    Defect newDefect = new Defect(summary, priority, dayCount, attachment);
                    repository.add(newDefect);
                } else if (attachmentType.equals("2")) {
                    System.out.println("Введите ссылку на другой дефект: ");
                    long defectAttachment = scanner.nextLong();
                    scanner.nextLine();
                    Attachment attachment = new DefectAttachment(defectAttachment);

                    Defect newDefect = new Defect(summary, priority, dayCount, attachment);
                    repository.add(newDefect);
                } else {
                    System.out.println("Нет такого типа вложения.");
                    Defect newDefect = new Defect(summary, priority, dayCount);
                    repository.add(newDefect);
                }
            } else if (selectionInTheMainMenu.equals("change")) {
                System.out.println("Введите id дефекта для изменения статуса: ");
                int idForChangeStatus = Integer.parseInt(scanner.nextLine());
                if (repository.getById(idForChangeStatus) != null) {
                    System.out.println("Введите новый статус дефекта: ");
                    String newStatus = scanner.nextLine();
                    repository.changeStatus(idForChangeStatus,newStatus);
                } else {
                    System.out.println("Такого id дефекта нет.");
                }

            } else if (selectionInTheMainMenu.equals("list")) {
                for (Defect j : repository.getAll()){
                    if (j == null){
                        break;
                    }
                    System.out.println(j.getInfo());
                }
            } else if (selectionInTheMainMenu.equals("quit")) {
                System.out.println("До свидания!");
                break;
            } else {
                System.out.println("Нет такого пункта меню. Введите корректный пункт меню.");
            }
        }
    }
}