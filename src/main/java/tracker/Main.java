package tracker;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;


public class Main {

    public static void main(String[] args) {
        boolean run = true;
        try (Scanner console = new Scanner(System.in)) {
            int maxDefects = takeInt(console, "Введите максимальное количество дефектов:");
            Map<Long, Defect> map = new HashMap<>();
            while (run) {
                System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Введите \"change\", чтобы изменить статус. Введите \"stats\", чтобы вывести статистику. Чтобы выйти, введите \"quit\"");
                String action = console.nextLine();
                switch (action) {
                    case "change":
                        change(console, map);
                        break;

                    case "list":
                        list(map);

                        break;
                    case "add":
                        add(console, map, maxDefects);
                        break;
                    case "stats":
                        stats(map);
                        break;
                    case "quit":
                        run = false;
                        break;
                }
            }
        }
    }

    private static void add(Scanner console, Map<Long, Defect> map, int maxDefects) {


        if (map.size() >= maxDefects) {
            System.out.println("Невозможно добавить больше " + maxDefects + " дефектов");
            return;
        }
        System.out.println("Введите резюме");
        String resume = console.nextLine();
        Severity critical;
        while (true) {
            System.out.println("Введите критичность дефекта: критично, не критично или очень критично");
            String inputCritical = console.nextLine();
            critical = Severity.getSeverity(inputCritical);
            if (critical != null) {
                break;
            }
            System.out.println("Критичность не найдена");
        }
        int numberOfDays = takeInt(console, "Введите ожидаемое количество дней на исправление дефекта");
        int typeInclosure = takeInt(console, "Введите номер типа вложения: 1 - комментарий, 2 - ссылка на другой дефект");
        Attachment attachment;
        if (typeInclosure != 1) {
            attachment = new DefectAttachment(takeLong(console, "Введите id дефекта"));
        } else {
            System.out.println("Введите комментарий");
            attachment = new CommentAttachment(console.nextLine());
        }
        Defect defect = new Defect(resume, critical, numberOfDays, attachment);
        map.put(defect.getId(), defect);

    }

    private static void list(Map<Long, Defect> map) {
        for (Defect defect : map.values()) {
            System.out.println(defect.getDefectInfo());
        }
    }

    private static void change(Scanner console, Map<Long, Defect> map) {
        Defect defect;
        while (true) {
            defect = map.get((takeLong(console, "Введите Id дефекта:")));
            if (defect != null) {
                break;
            }
            System.out.println("Нет дефекта с таким Id");
        }
        while (true) {
            System.out.println("Введите новый статус: Открыто, Закрыто или В работе");

            String inputStatus = console.nextLine();
            Status newStatus = Status.getStatus(inputStatus);
            if (newStatus == null) {
                System.out.println("Статус не найден");
                continue;
            }
            if (!Transition.dataValidation(defect.getStatus(), newStatus)) {
                System.out.println("Невозможно перевести дефект в этот статус");
                continue;
            }
            defect.setStatus(newStatus);
            break;

        }

    }

    private static void stats(Map<Long, Defect> map) {

        Map<Status, Long> statistic = map.values().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
        IntSummaryStatistics numberOfDays = map.values().stream().collect(Collectors.summarizingInt(Defect::getNumberOfDays));
        System.out.println("Максимальное количество дней на исправление дефекта - " + numberOfDays.getMax());
        System.out.println("Среднее количество дней на исправление дефекта - " + numberOfDays.getAverage());
        System.out.println("Минимальное количество дней на исправление дефекта - " + numberOfDays.getMin());
        statistic.forEach((key, value) -> {
            System.out.printf("В статусе %s %d дефектов", key, value);
            System.out.println();
        });


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

    static long takeLong(Scanner console, String notification) {
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
