package tracker;

import java.util.*;
import java.util.stream.Stream;

public class Steps {

    static Map<Long, Defect> map = new TreeMap<>();

    public static void addDefect(Scanner scanner) {
        Defect def;
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка: \n BLOCKER \n CRITICAL\n MAJOR \n" +
                " MINOR\n TRIVIAL");
        Criticality criticality;
        try {
            criticality = Criticality.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Введенная критичность отсутствует в списке");
            return;
        }
        System.out.println("Выберите тип вложения: \n для добавления комментария введите comment \n " +
                "для добавления ссылки на другой дефект введите link");
        String attachment = scanner.nextLine();
        if (attachment.equals("comment")) {
            System.out.println("Введите комментарий");
            CommentAttachment attCom = new CommentAttachment(scanner.nextLine());
            def = new Defect(name, criticality, attCom);
        } else if (attachment.equals("link")) {
            System.out.println("Введите ссылку на дефект в виде ID этого дефекта");
            int id;
            while (true) {
                try {
                    id = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат.Введите еще раз ссылку на дефект в виде ID этого дефекта");
                }
            }
            DefectAttachment attDef = new DefectAttachment(id);
            def = new Defect(name, criticality, attDef);
        } else {
            System.out.println("Введена несуществующая операция \n");
            return;
        }
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int i;
        while (true) {
            try {
                i = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат.Введите ожидаемое количество дней на исправление дефекта еще раз");
            }
        }
        def.setDaysNumber(i);
        map.put(def.getId(), def);
    }

    public static void list() {
        for (Map.Entry m : map.entrySet()) {
            System.out.println(m.getValue());
        }
        System.out.println("\n");
    }

    public static void change(Scanner scanner) {
        System.out.println("Введите ID дефекта");
        Defect def = map.get(scanner.nextLong());
        scanner.nextLine();
        System.out.println("Введите статус дефекта из списка:  \n OPENED\n IN_PROCESS\n REJECTED\n CLOSED");

        Status to = Status.valueOf(scanner.nextLine());
        Set<Transition> set = new HashSet<>();
        set.add(new Transition(Status.OPENED, Status.IN_PROCESS));
        set.add(new Transition(Status.OPENED, Status.REJECTED));
        set.add(new Transition(Status.IN_PROCESS, Status.CLOSED));
        set.add(new Transition(Status.REJECTED, Status.CLOSED));
        if (set.contains(new Transition(def.getStatus(), to))) {
            def.setStatus(to);
        } else {
            System.out.println("Переход в этот статус невозможен");
            System.out.println("\n");
        }
    }

    public static void stats() {

        int daysNumber[] = new int[map.size()];
        Status statuses[] = new Status[map.size()];
        int i = 0;
        for (Map.Entry m : map.entrySet()) {
            Defect def = (Defect) m.getValue();
            daysNumber[i] = def.getDaysNumber();
            statuses[i] = def.getStatus();
            i++;
        }
        IntSummaryStatistics statistics = Arrays.stream(daysNumber)
                .summaryStatistics();
        System.out.println(statistics);
        Collection<Status> collection = Arrays.asList(statuses);
        long countOpened = collection.stream()
                .filter(Status.OPENED::equals)
                .count();
        long countInProcess = collection.stream()
                .filter(Status.IN_PROCESS::equals)
                .count();
        long countRejected = collection.stream()
                .filter(Status.REJECTED::equals)
                .count();
        long countClosed = collection.stream()
                .filter(Status.CLOSED::equals)
                .count();
        System.out.println("Количество дефектов в статусе OPENED: " + countOpened +
                ",\nколичество дефектов в статусе IN_PROCESS: " + countInProcess +
                ",\nколичество дефектов в статусе REJECTED: " + countRejected +
                ",\nколичество дефектов в статусе CLOSED: " + countClosed + "\n");
    }
}
