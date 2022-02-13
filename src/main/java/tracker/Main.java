
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
                    "\n quit (Вернуться в главное меню)");

            String action = scanner.nextLine();
            switch (action) {
                case ("add"): {

                    System.out.println("Введите резюме дефекта");
                    String resume = scanner.nextLine();

                    System.out.println("Введите критичность дефекта (Low, Medium, High)");
                    String priority = scanner.nextLine();

                    System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                    int daysToFix = scanner.nextInt();
                    scanner.nextLine();

                    boolean correctType = false; // показатель корректности введенного типа дефекта
                    Attachment attachment = null;

                    while (!correctType) {
                        System.out.print("Введите тип вложения (comment, defect): ");
                        String attachmentType = scanner.nextLine();
                        if (attachmentType.equals("comment")) {
                            correctType = true;
                            System.out.print("Введите комментарий: ");
                            String comment = scanner.nextLine();
                            attachment = new CommentAttachment(comment);
                        } else if (attachmentType.equals("defect")) {
                            correctType = true;
                            System.out.print("Введите номер дефекта: ");
                            int defectId = scanner.nextInt();
                            scanner.nextLine();
                            attachment = new DefectAttachment(defectId);
                        } else {
                            System.out.println("Ошибочное значение");
                        }
                    }
                    Defect bug = new Defect(resume, priority, daysToFix, attachment);
                    repository.add(bug);
                    break;
                }
                case ("list"): {
                    Defect[] defects = repository.getAll();
                    for(Defect bug : defects){
                        System.out.println(bug);
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
