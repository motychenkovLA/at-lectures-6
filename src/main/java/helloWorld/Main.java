package helloWorld;

import java.util.*;

class Main {
    private static final Map<Long, Defect> defectHashMap = new HashMap<>();
    static long keyDefect = 0;

    public static Criticality getCriticalityFromConsole(Scanner scanner) {

        Boolean completed = false;
        Criticality critical = null;

        while (!completed) {
            try {
                System.out.println("Введите критичность дефекта:\nLOW\nMEDIUM\nHIGH\nCRITICAL");

                String criticalString = scanner.nextLine();
                critical = Criticality.valueOf(criticalString);
                completed = true;

            } catch (IllegalArgumentException ex) {
                System.out.println("Введено некорректное значение. Повторите ввод");

            }
        }

        return critical;
    }


    public static Command getCommandFromConsole(Scanner scanner) {

        Boolean completed = false;
        Command command = null;

        while (!completed) {
            try {
                System.out.println("ADD - добавить новый дефект" + "\nCHANGE - изменить статус" + "\nLIST - вывести список дефектов" + "\nQUIT - выход из программы");
                String inputCommand = scanner.nextLine();
                command = Command.valueOf(inputCommand);
                completed = true;

            } catch (IllegalArgumentException ex) {
                System.out.println("Введена неизвестная команда");

            }
        }

        return command;
    }


    public static Integer getDaysFromConsole(Scanner scanner) {

        Boolean completed = false;
        Integer days = null;

        while (!completed) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                String daysString = scanner.nextLine();
                days = Integer.parseInt(daysString);
                completed = true;
            } catch (NumberFormatException ex) {

                System.out.println("Введено некорректное значение. Повторите ввод");

            }
        }
        return days;
    }


    public static void addDefect(Map<Long, Defect> repository, Scanner scanner) {

        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();


        Defect def = new Defect(name);

        def.setCritical(getCriticalityFromConsole(scanner));


        def.setDaysNumber(getDaysFromConsole(scanner));
        System.out.println("Выберите тип вложения: comment или link");

        String attachmentOfBug = scanner.nextLine();
        switch (attachmentOfBug) {
            case "comment":
                System.out.println("Введите комментарий");
                String comment = scanner.nextLine();
                CommentAttachment commentAttachment = new CommentAttachment(comment);
                def.setCommentAttachment(commentAttachment);

                repository.put(def.getId(), def);
                break;

            case "link":
                System.out.println("Введите ссылку (id) дефекта");
                int idBug = scanner.nextInt();
                scanner.nextLine();
                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                def.setDefectAttachment(defectAttachment);
                repository.put(def.getId(), def);
                break;

            default:
                System.out.println("Не верный тип вложения, повторите попытку");
                break;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {


            while (true) {
                Command operation = getCommandFromConsole(scanner);

                switch (operation) {

                    case ADD:
                        addDefect(defectHashMap, scanner);
                        break;
                    case LIST:
                        for (Defect defect : defectHashMap.values()) {
                            if (defect != null) {
                                System.out.println(defect);
                            }

                        }
                        break;
                    case QUIT:
                        return;
                    default:
                        System.out.println("Введена неизвестная команда\n");

                    case CHANGE:

                        long id;

                        if (defectHashMap.isEmpty()) {
                            System.out.println("В репозитории нет дефектов");
                            return;
                        }
                        System.out.println("Введине id дефекта, у которого необходимо поменять статус");
                        long idDefectForChangeStatus = canParseInt(scanner);

                        Defect defectForChangeStatus = defectHashMap.get(idDefectForChangeStatus);
                        if (!defectHashMap.containsKey(idDefectForChangeStatus)) {
                            System.out.println("Дефекта с таким id не существует");
                            return;
                        }

                        System.out.println("Введите новый статус дефекта из списка.\nПример доступных переходов:\nOPEN(Открыт) - INWORK(В работе)\nOPEN(Открыт) - ANALYSIS(На анализе)\nINWORK(В работе) - CLOSED(Закрыт)\nANALYSIS(На анализе) - CLOSED(Закрыт)");
                        Status[] statuses = Status.values();

                        for (Status status : statuses) {
                            System.out.println(status.getInRus());
                        }

                        Status currentStatus = defectForChangeStatus.getStatus();
                        String statusInput = scanner.nextLine();

                        Status newStatusTo = Status.getStatus(statusInput);

                        List<Status> statusList = Transition.getValidStatus(currentStatus);
                        if (newStatusTo == null || !statusList.contains(newStatusTo)) {
                            System.out.println("Такого значение не существует");
                            return;
                        }
                        defectForChangeStatus.setStatus(newStatusTo);


                }
            }
        }
    }

    private static int canParseInt(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Не верный формат введенного значения");
            }
        }
    }
}