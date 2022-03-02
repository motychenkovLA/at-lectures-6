package tracker;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

public class Main {


    public static void main(String[] args) {
        boolean run = true;
        Main main = new Main();
        int maxDefects;
        try (Scanner console = new Scanner(System.in)) {
            while (true) {
                try {
                    System.out.println("Введите максимальное количество дефектов:");
                    maxDefects = parseInt(console.nextLine());

                    break;
                } catch (Exception e) {
                    System.out.println("Введите корректные данные");
                }
            }
            Repository repository = new Repository(maxDefects);
            while (run) {
                System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Введите \"change\", чтобы изменить статус. Чтобы выйти, введите \"quit\"");
                String action = console.nextLine();
                switch (action) {
                    case "change":
                        main.change(console, repository);
                        break;

                    case "list":
                        main.list(repository);

                        break;
                    case "add":
                        main.add(console, repository, maxDefects);

                        break;
                    case "quit":
                        run = false;
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
        }
    }

    private void add(Scanner console, Repository repository, int maxDefects) {

        if (repository.isFull()) {
            System.out.println("Невозможно добавить больше " + maxDefects + " дефектов");

        }
        String resume;

        System.out.println("Введите резюме");
        resume = console.nextLine();


        Severity critical;
        while (true) {

            System.out.println("Введите критичность дефекта: критично, не критично или очень критично");
            String inputCritical = console.nextLine();
            critical = Severity.getSeverity(inputCritical);
            if (critical == null) {
                System.out.println("Критичность не найдена");
            } else {
                break;
            }


        }
        int numberOfDays;
        while (true) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                numberOfDays = parseInt(console.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
            }
        }
        int typeInclosure;
        while (true) {
            try {

                System.out.println("Введите номер типа вложения: 1 - комментарий, 2 - ссылка на другой дефект");
                typeInclosure = parseInt(console.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
            }
        }
        if (typeInclosure == 1) {
            System.out.println("Введите комментарий");
            repository.add(new Defect(resume, critical, numberOfDays, new CommentAttachment(console.nextLine())));
        } else {
            while (true) {
                try {
                    System.out.println("Введите id дефекта");
                    DefectAttachment defect = new DefectAttachment(parseLong(console.nextLine()));
                    repository.add(new Defect(resume, critical, numberOfDays, defect));
                    break;
                } catch (Exception e) {
                    System.out.println("Введите корректные данные");
                }
            }

        }
    }

    private void list(Repository repository) {
        for (Defect defect : repository.getAll()) {
            System.out.println(defect.getDefectInfo());
        }
    }

    private void change(Scanner console, Repository repository) {
        long id;
        while (true) {
            while (true) {
                try {
                    System.out.println("Введите Id дефекта:");
                    id = parseLong(console.nextLine());
                    break;
                } catch (Exception e) {
                    System.out.println("Введите корректные данные");
                }
            }
            if (getDefect(id, repository) == null) {
                System.out.println("Нет дефекта с таким Id");
            } else {
                break;
            }
        }
        Status status;
        while (true) {
            System.out.println("Введите новый статус: Открыто, Закрыто или В работе");
            String inputStatus = console.nextLine();
            status = Status.getStatus(inputStatus);
            if (status == null) {
                System.out.println("Статус не найден");
            } else {
                repository.getDefect(id).setStatus(status);
                break;
            }
        }

    }

    private Defect getDefect(long id, Repository repository) {
        return repository.getDefect(id);
    }


}
