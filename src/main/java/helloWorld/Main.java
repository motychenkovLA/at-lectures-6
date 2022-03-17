package helloWorld;

import java.util.Scanner;

class Main {

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


    public static Status getStatusFromConsole(Scanner scanner) {

        Boolean completed = false;
        Status status = null;

        while (!completed) {
            try {
                System.out.println("Введите новый статус: \nOPEN\nINWORK\nCLOSED\nANALYSIS");
                String inputStatus = scanner.nextLine();
                status = Status.valueOf(inputStatus);
                completed = true;

            } catch (IllegalArgumentException e) {
                System.out.println("Статус не найден. Повторите ввод.");

            }
        }

        return status;
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


    public static void addDefect(Scanner scanner) {

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
                Repository.add(def);
                break;

            case "link":
                System.out.println("Введите ссылку (id) дефекта");
                int idBug = scanner.nextInt();
                scanner.nextLine();
                DefectAttachment defectAttachment = new DefectAttachment(idBug);
                def.setDefectAttachment(defectAttachment);
                Repository.add(def);
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

                    case CHANGE:
                        long id;
                        while (true) {
                            System.out.println("Введите Id дефекта:");
                            id = scanner.nextLong();
                            scanner.nextLine();
                            if (Repository.getDefect(id) == null) {
                                System.out.println("Нет дефекта с таким Id");
                            } else {
                                Repository.getDefect(id).setStatus(getStatusFromConsole(scanner));
                                break;
                            }
                        }
                        break;


                    case ADD:
                        addDefect(scanner);
                        break;
                    case LIST:
                        for (Defect defect : Repository.getAll()) {
                           if (defect!=null) {System.out.println(defect);}

                        }
                        break;
                    case QUIT:
                        return;
                    default:
                        System.out.println("Введена неизвестная команда\n");


                }
            }
        }
    }
}
