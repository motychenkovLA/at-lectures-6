package tracker;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository(10);
        Scanner scanner = new Scanner(System.in);
        String command = null;
        String attachmentBug; // todo 1 - Объявление задолго до использования
        String answer; // todo 1 - неиспользуемая переменная


        while (!Objects.equals(command, "quit")) {
            System.out.println("Введите: add, list, quit или change");
            command = scanner.nextLine();
            switch (command) {
                case "add":
                    if (!repository.repositoryIsFull()) {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();

                        System.out.println("Введите критичность дефекта из списка");
                        Severity[] severitys = Severity.values();
                        for (Severity severity : severitys)
                            System.out.println(severity);
                        System.out.println();
                        String severityBug = scanner.nextLine();

                        System.out.println("Введите количество дней на исправление дефекта");
                        int daysToFixBug = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Выберите тип вложение: comment или link");
                        attachmentBug = scanner.nextLine();

                        switch (attachmentBug) {
                            case "comment":
                                System.out.println("Введите комментарий");
                                String comment = scanner.nextLine();
                                CommentAttachment commentAttachment = new CommentAttachment(comment);
                                repository.addDefect(new Defect(resumeBug, severityBug, daysToFixBug, commentAttachment));
                                break;
                            case "link":
                                System.out.println("Введите ссылку (id) дефекта");
                                String idBug = scanner.nextLine();
                                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                                repository.addDefect(new Defect(resumeBug, severityBug, daysToFixBug, defectAttachment));
                                break;
                            default:
                                System.out.println("Не верный тип вложения, повторите попытку");
                                break;
                        }
                    } else {
                        System.out.println("Превышено максимально допустимое кол-во дефектов");
                    }
                    break;

                case "list":
                    for (Defect defect : repository.getAllDefects()) {
                        System.out.println(defect.getBugsInfo());
                    }
                    break;

                case "change":
                    if(!repository.repositoryIsEmpty()) {
                        repository.getAllDefects(); // todo 3 - выражение ничего не делает
                        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
                        long idDefectForChangeStatus = scanner.nextLong();
                        scanner.nextLine();
                        Defect defectForChangeStatus = repository.findDefectById(idDefectForChangeStatus);
                        // todo 5 - нет проверки что дефект нашелся по id
                        System.out.println("Выберите новый статус из списка");
                        Status statuses[] = Status.values();
                        for (Status status : statuses)
                            System.out.println(status);
                        System.out.println();
                        // todo 3 - с valueOf есть проблемы
                        //  - значения выводятся на английском (вернее даже на джававском), хотя весь остальной UI на русском
                        //  - метод падает если вводим неправильное название
                        //  хотелось бы сделать enum так, чтобы у него было читаемое русскоязычное отображение и возможность по этому отображению безопасно получить значение
                        Status newStatus = Status.valueOf(scanner.nextLine());
                        defectForChangeStatus.setStatus(newStatus);
                    } else {
                        System.out.println("В репозитории нет дефектов");
                    }
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