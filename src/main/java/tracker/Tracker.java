package tracker;

import java.util.Scanner;

class Tracker {

    public static void addDefect() {
        Scanner scanner = new Scanner(System.in);
        Defect def;
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Выберите тип вложения: \n для добавления комментария введите comment \n " +
                "для добавления ссылки на другой дефект введите link");
        String attachment = scanner.nextLine();
        if (attachment.equals("comment")) {
            System.out.println("Введите комментарий");
            CommentAttachment attCom = new CommentAttachment(scanner.nextLine());
            def = new Defect(name, attCom);
        } else if (attachment.equals("link")) {
            System.out.println("Введите ссылку на дефект в виде ID этого дефекта");
            DefectAttachment attDef = new DefectAttachment(scanner.nextInt());
            scanner.nextLine();
            def = new Defect(name, attDef);
        } else {
            System.out.println("Введена несуществующая операция \n");
            return;
        }
        System.out.println("Введите критичность дефекта из списка: blocker, critical, major, minor, trivial");
        def.setCriticality(scanner.nextLine());
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        def.setDaysNumber(scanner.nextInt());
        scanner.nextLine();
        Repository.add(def);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                    + " \n quit - выход");
            String operation = scanner.nextLine();
            switch (operation) {
                case "add":
                    addDefect();
                    break;
                case "list":
                    for (int i = 0; i < Repository.countBug; i++) {
                        System.out.println(Repository.getAll()[i].getInfo());
                    }
                    System.out.println("\n\n");
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Введена несуществующая операция\n");
            }
        }
    }
}



