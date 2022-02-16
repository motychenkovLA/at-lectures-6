
package tracker;

import java.util.*;


public class Main {

    private static final Repository repository = new Repository();     //создаем репозиторий

    public static void main(String[] args) {

        boolean isRun = true; // показатель того, в работе мы или идем на выход
        Scanner scanner = new Scanner(System.in);


        while (isRun) {

            System.out.println(" Выберите действие " +
                    "\n add (Добавить новый дефект)" +
                    "\n list (Вывести список дефектов)" +
                    "\n change (Изменить статус дефекта)" +
                    "\n quit (Вернуться в главное меню)");

            String action = scanner.nextLine();
            switch (action) {
                case ("add"): {

                    System.out.println("Введите резюме дефекта");
                    String resume = scanner.nextLine();

                    Critical critical; // todo 1 - объявление отдельно от инициализации
                    System.out.println("Введите критичность дефекта (Low, Medium, High)");
                    // todo 3 - есть 2 проблемы с использованием valueOf
                    //  - на вход читаем английские названия, на выход пишем русские, что сбивает с толку
                    //  - если вводится неправильное название, вся программа падает
                    //  стоит сделать методы в енамах, которые будут возвращать значение по русскому названию или нулл, если неверное
                    critical = Critical.valueOf(scanner.nextLine().toUpperCase());

                    System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                    int daysToFix = scanner.nextInt();
                    scanner.nextLine();

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
                            int defectId = scanner.nextInt();
                            scanner.nextLine();
                            attachment = new DefectAttachment(defectId);
                        } else {
                            System.out.println("Ошибочное значение");
                        }
                    }
                    Defect bug = new Defect(resume, critical, daysToFix, attachment, Status.valueOf("OPEN")); // todo 3 - есть более простой способ получить значение енума
                    repository.add(bug);
                    break;
                }
                case ("list"): {
                    Defect[] defects = repository.getAll();
                    for (Defect bug : defects) {
                        System.out.println(bug);
                    }
                    System.out.println();
                    break;
                }
                case ("change"): {
                    System.out.println("Введите номер дефекта, для которого нужно изменить статус:");
                    long defectId = scanner.nextInt();
                    scanner.nextLine();
                    Defect bug = repository.getCheckId(defectId);
                    if (bug == null) {
                        System.out.println("Нет дефекта с таким номером!");
                    } else {
                        System.out.println("Текущий статус дефекта - " + bug.getStatus() + "\nВведите новый статус (OPEN, TESTING, DELAYED, CLOSE): ");
                        bug.setStatus(Status.valueOf(scanner.nextLine().toUpperCase()));
                        System.out.println("Успешно! Текущий статус дефекта - " + bug.getStatus());
                    }
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
