
package tracker;

import java.util.*;


public class Main {
    final static int MAX_BUG = 2;                                       //первоначальная размерность репозитория
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

                    System.out.print("Введите тип вложения (comment, defect): ");
                    String attachmentType = scanner.nextLine();

                    Attachment attachment = null;
                    if (attachmentType.equals("comment")) {
                        System.out.print("Введите комментарий: ");
                        String comment = scanner.nextLine();
                        attachment = new CommentAttachment(comment);
                    } else if (attachmentType.equals("defect")) {
                        System.out.print("Введите номер дефекта: ");
                        int defectId = scanner.nextInt();
                        scanner.nextLine();
                        attachment = new DefectAttachment(defectId);
                    } else {
                        System.out.println("Ошибочное значение");
                        attachment = new CommentAttachment("Пользователь ввел непонятно что");
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
                default: { System.out.println("Ошибочное значение"); break; }
            }
        }
    }
}
