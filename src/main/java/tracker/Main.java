package tracker;

import java.util.Scanner;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;

// todo 3 - сложные конструкции методов
//   if (проверка валидности) {
//       // валидный кейс
//   } else {
//       // негативный кейс
//   }
//   можно заменить на
//   if (!проверка валидности) {
//      // негативный кейс
//      return;
//   }
//   // валидный кейс
public class Main {


    public static void main(String[] args) {
        boolean run = true;
        try (Scanner console = new Scanner(System.in)) {
            int maxDefects = takeInt(console, "Введите максимальное количество дефектов:");
            Repository repository = new Repository(maxDefects);
            while (run) {
                System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Введите \"change\", чтобы изменить статус. Чтобы выйти, введите \"quit\"");
                String action = console.nextLine();
                switch (action) {
                    case "change":
                        change(console, repository);
                        break;

                    case "list":
                        list(repository);

                        break;
                    case "add":
                        add(console, repository, maxDefects);

                        break;
                    case "quit":
                        run = false;
                        break;
                }
            }
        }
    }

    private static void add(Scanner console, Repository repository, int maxDefects) {

        if (repository.isFull()) {
            System.out.println("Невозможно добавить больше " + maxDefects + " дефектов");
        } else {
            System.out.println("Введите резюме");
            String resume = console.nextLine();
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
            int numberOfDays = takeInt(console, "Введите ожидаемое количество дней на исправление дефекта");
            int typeInclosure = takeInt(console, "Введите номер типа вложения: 1 - комментарий, 2 - ссылка на другой дефект");

            if (typeInclosure == 1) {
                System.out.println("Введите комментарий");
                repository.add(new Defect(resume, critical, numberOfDays, new CommentAttachment(console.nextLine())));
            } else {
                while (true) {
                    try {
                        System.out.println("Введите id дефекта");
                        // todo 3 - takeLong ?
                        DefectAttachment defect = new DefectAttachment(parseLong(console.nextLine()));
                        repository.add(new Defect(resume, critical, numberOfDays, defect));
                        break;
                    } catch (Exception e) {
                        System.out.println("Введите корректные данные");
                    }
                }

            }
        }
    }

    private static void list(Repository repository) {
        for (Defect defect : repository.getAll()) {
            System.out.println(defect.getDefectInfo());
        }
    }

    private static void change(Scanner console, Repository repository) {
        long id;
        while (true) {
            id = takeLong(console, "Введите Id дефекта:");
            if (repository.getDefect(id) == null) {
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

    private static int takeInt(Scanner console, String notification) {
        while (true) {
            try {
                System.out.println(notification);
                return parseInt(console.nextLine());
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
            }
        }

    }

    private static long takeLong(Scanner console, String notification) {
        while (true) {
            try {
                System.out.println(notification);
                return parseLong(console.nextLine());
            } catch (Exception e) {
                System.out.println("Введите корректные данные");
            }
        }

    }


}
