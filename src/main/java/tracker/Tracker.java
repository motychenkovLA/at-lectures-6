package tracker;

import java.util.Scanner;

class Tracker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                    + " \n quit - выход");
            String operation = scanner.nextLine();
            switch (operation) {
                case "add":
                    StepAdd.addDefect();
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



