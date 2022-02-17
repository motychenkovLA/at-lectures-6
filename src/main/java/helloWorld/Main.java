package helloWorld;

import java.util.Scanner;

class Main {
    public static void addDefect() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        Defect def = new Defect(name);
        System.out.println("Введите критичность дефекта:\nLow\nMedium\nHigh\nCritical");
        def.setCritical(scanner.nextLine());
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        def.setDaysNumber(scanner.nextInt());
        scanner.nextLine();
        Repository.add(def);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add - добавить новый дефект" + "\nlist - вывести список дефектов" + "\nquit - выход из программы ");
            String operation = scanner.nextLine();
            switch (operation) {
                case "add":
                    addDefect();
                    break;
                case "list":
                    for (int i = 0; i < Repository.countOfBug; i++) {
                        System.out.println(Repository.getAll()[i].getInfo());
                    }
                    System.out.println("\n\n");
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Введена неизвестная команда\n");
            }
        }
    }
}
