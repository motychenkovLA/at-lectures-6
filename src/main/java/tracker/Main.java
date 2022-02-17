package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите максимальное количеество дефектов:");
        int maxDefects = console.nextInt();
        console.nextLine();
        Repository repository = new Repository(maxDefects);
        while (run) {
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Введите \"change\", чтобы изменить статус. Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "change":
                    long id;
                    do {
                        System.out.println("Введите Id дефекта:");
                        id = console.nextLong();
                        console.nextLine();
                        if (repository.getDefect(id) == null) {
                            System.out.println("Нет дефекта с таким Id");
                        } else {
                            break;
                        }
                    } while (true);
                    Status status;
                    do {
                        System.out.println("Введите новый статус: Открыто, Закрыто или В работе");
                        String inputStatus = console.nextLine();
                        status = Status.getStatus(inputStatus);
                        if (status == null) {
                            System.out.println("Статус не найден");
                        } else {
                            break;
                        }
                    } while (true);
                    break;

                case "list":
                    for (Defect defect : repository.getAll()) {
                        System.out.println(defect.getDefectInfo());
                    }
                    break;
                case "add":
                    if (repository.isFull()) {
                        System.out.println("Невозможно добавить больше " + maxDefects + " дефектов");
                        break;
                    }

                    System.out.println("Введите резюме");
                    String resume = console.nextLine();
                    Severity critical;
                    do {
                        System.out.println("Введите критичность дефекта: критично, не критично или очень критично");
                        String inputCritical = console.nextLine();
                        critical = Severity.getSeverity(inputCritical);
                        if (critical == null) {
                            System.out.println("Критичность не найдена");
                        } else {
                            break;
                        }
                    } while (true);
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDays = console.nextInt();
                    console.nextLine();
                    System.out.println("Введите номер типа вложения: 1 - комментарий, 2 - ссылка на другой дефект");
                    int typeInclosure = console.nextInt();
                    console.nextLine();
                    if (typeInclosure == 1) {
                        System.out.println("Введите комментарий");
                        repository.add(new Defect(resume, critical, numberOfDays, new CommentAttachment(console.nextLine())));
                    } else {
                        System.out.println("Введите id дефекта");
                        repository.add(new Defect(resume, critical, numberOfDays, new DefectAttachment(console.nextLong())));
                        console.nextLine();
                    }
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
