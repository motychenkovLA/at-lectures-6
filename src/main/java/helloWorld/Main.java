package helloWorld;

import java.util.Scanner;

class Main {
    public static void addDefect() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();


        Status status;
        Defect def = new Defect(name);
        System.out.println("Введите критичность дефекта:\nLOW\nMEDIUM\nHIGH\nCRITICAL");
        String criticalString = scanner.nextLine();
        Criticality critical = Criticality.valueOf(criticalString);
        def.setCritical(critical);


        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        def.setDaysNumber(scanner.nextInt());
        scanner.nextLine();
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
            System.out.println("add - добавить новый дефект" + "\nchange - изменить статус" + "\nlist - вывести список дефектов" + "\nquit - выход из программы");
            String operation = scanner.nextLine();


            switch (operation) {

                case "change":
                    long id;
                    while (true) {
                        System.out.println("Введите Id дефекта:");
                        id = scanner.nextLong();
                        scanner.nextLine();
                        if (Repository.getDefect(id) == null) {
                            System.out.println("Нет дефекта с таким Id");
                        } else {
                            break;
                        }
                    }
                    Status status;
                    while (true) {
                        System.out.println("Введите новый статус: \nOPEN\nINWORK\nCLOSED\nANALYSIS");
                        String inputStatus = scanner.nextLine();
                        status = Status.valueOf(inputStatus);
                        if (status == null) {
                            System.out.println("Статус не найден");
                        } else {
                            Repository.getDefect(id).setStatus(status);
                            break;
                        }
                    }
                    break;


                case "add":
                    addDefect();
                    break;
                case "list":
                    for (int i = 0; i < Repository.countOfBug; i++) {
                        System.out.println(Repository.getAll()[i].getInfo());
                    }
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Введена неизвестная команда\n");


            }
        }
    }
}

