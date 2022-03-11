package helloWorld;

import java.io.IOException;
import java.util.Scanner;

class Main {

    public static Criticality setCriticality() {
        Scanner scanner = new Scanner(System.in);
        Boolean completed = false;
        Criticality critical = null;

        while (!completed) {
            try {
                System.out.println("Введите критичность дефекта:\nLOW\nMEDIUM\nHIGH\nCRITICAL");
                String criticalString = scanner.nextLine();
                critical = Criticality.valueOf(criticalString);
                completed = true;
            } catch (Exception ex) {
                System.out.println("Введено некорректное значение. Повторите ввод");
            }
        }

        return critical;
    }


    public static Command setCommand() {
        Scanner scanner = new Scanner(System.in);
        Boolean completed = false;
        Command command = null;

        while (!completed) {
            try {
                System.out.println("ADD - добавить новый дефект" + "\nCHANGE - изменить статус" + "\nLIST - вывести список дефектов" + "\nQUIT - выход из программы");
                String inputCommand = scanner.nextLine();
                command = Command.valueOf(inputCommand);
                completed = true;
            }
            catch (Exception ex) {
                System.out.println("Введена неизвестная команда");
            }
        }

        return command;
    }


    public static Status setStatus() {
        Scanner scanner = new Scanner(System.in);
        Boolean completed = false;
        Status status = null;

        while (!completed) {
            try {
                System.out.println("Введите новый статус: \nOPEN\nINWORK\nCLOSED\nANALYSIS");
                String inputStatus = scanner.nextLine();
                status = Status.valueOf(inputStatus);
                completed = true;
            }
            catch (Exception ex) {
                System.out.println("Статус не найден. Повторите ввод.");
            }
        }

        return status;
    }

    public static Integer setDays() {
        Scanner scanner = new Scanner(System.in);
        Boolean completed = false;
        Integer days = null;

        while (!completed) {
            try {
                System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                String daysString = scanner.nextLine();
                days = Integer.parseInt(daysString);
                completed = true;
            } catch (Exception ex) {

                System.out.println("Введено некорректное значение. Повторите ввод");
            }
        }
        return days;
    }


    public static void addDefect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();


        Status status;
        Defect def = new Defect(name);
//        System.out.println("Введите критичность дефекта:\nLOW\nMEDIUM\nHIGH\nCRITICAL");
//        String criticalString = scanner.nextLine();
//        Criticality critical = Criticality.valueOf(criticalString);
        def.setCritical(setCriticality());


        //    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        def.setDaysNumber(setDays());
        //scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Command operation = setCommand();

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
                            Repository.getDefect(id).setStatus(setStatus());
                            break;
                        }
                    }
                    break;


                case ADD:
                    addDefect();
                    break;
                case LIST:
                    for (int i = 0; i < Repository.countOfBug; i++) {
                        System.out.println(Repository.getAll()[i].getInfo());
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

