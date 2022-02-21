package tracker;

import java.util.Scanner;

class Tracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                    + " \n change - изменить статус дефекта\n quit - выход");
            String operation = scanner.nextLine();
            switch (operation) {
                case "add":
                    StepAdd.addDefect();
                    break;
                case "list":
                    for (int i = 0; i < Repository.countBug; i++) {
                        System.out.println(Repository.getAll()[i]);
                    }
                    System.out.println("\n");
                    break;
                case "change":
                    System.out.println("Введите ID дефекта");
                    Defect def = Repository.getDefect(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println("Введите статус дефекта из списка:  \n OPENED\n ASSIGNED\n FIXED\n" +
                            " REOPENED\n CLOSED");
                    def.changeStatus(Status.valueOf(scanner.nextLine()));
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Введена несуществующая операция\n");
            }
        }
    }
}



