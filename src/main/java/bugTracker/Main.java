package bugTracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Repository repository = new Repository();

        while (true) {
            //Регулярное выражение для решения проблемы со сканером. Пропускаем все пустые символы
            //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            System.out.println("\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                    "Введите list, чтобы вывести список дефектов\n" +
                    "Введите quit для выхода из прогруммы ");
            String selectionInTheMainMenu = scanner.nextLine();

            if (selectionInTheMainMenu.equals("add")) {
                System.out.println("Введите резюме дефекта: ");
                String summary = scanner.nextLine();

                System.out.println("Введите критичность дефекта, например:\nP1 – Высокая (High);\n" +
                        "P2 – Средняя (Medium);\nP3 – Низкая (Low).");
                String priority = scanner.nextLine();

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