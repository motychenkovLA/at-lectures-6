package tracker;

import java.util.*;

class Tracker {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {

                System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                        + " \n change - изменить статус дефекта\n stats - вывод статистики по дефектам \n quit - выход");
                String operation = scanner.nextLine();
                switch (operation) {
                    case "add":
                        Steps.addDefect(scanner);
                        break;
                    case "list":
                        Steps.list();
                        break;
                    case "change":
                        Steps.change(scanner);
                        break;
                    case "stats":
                        Steps.stats();
                        break;
                    case "quit":
                        return;
                    default:
                        System.out.println("Введена несуществующая операция\n");
                }
            }
        }
    }
}



