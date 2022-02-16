
package tracker;

import java.util.*;


public class Main {

    private static final Repository repository = new Repository();     //создаем репозиторий // todo 0 - коммент излишний

    public static void main(String[] args) {

        boolean isRun = true; // показатель того, в работе мы или идем на выход // todo 0 - коммент излишний
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

                    System.out.println("Введите критичность дефекта (Низкая, Средняя, Высокая)");
                    Severity critical = Severity.getSeverityByValue(scanner.nextLine());
                    // todo 5 - ниже проверяется когда водим не валидный статус, здесь проверки нет, null утекает дальше в код
                    //  чтоб сильно не усложнять предлагаю если введено не валидное значение брать Среднее, только надо об это сообщить пользователю

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
                    Defect bug = new Defect(resume, critical, daysToFix, attachment, Status.OPEN);
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
                        System.out.println("Текущий статус дефекта - " + bug.getStatus() + "\nВведите новый статус (Исправление, Тестирование, Отложен, Закрыт): ");
                        Status status=Status.getStatusByValue(scanner.nextLine());
                        if (status == null) {
                            System.out.println("Внимание, вы ввели несуществующий статус - статус изменен не будет");
                        } else {
                            bug.setStatus(status);
                            System.out.println("Успешно! Текущий статус дефекта - " + bug.getStatus());
                        }

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
