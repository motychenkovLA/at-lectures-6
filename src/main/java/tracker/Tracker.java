package tracker;

import java.util.Scanner;

class Tracker {

    public static void addDefect (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        Defect def = new Defect(name);
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



