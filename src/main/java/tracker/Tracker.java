package tracker;

import java.util.Scanner;

class Tracker {
    public static void main(String[] args) {

        Repository list = new Repository(3);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                    + " \n quit - выход");
            String operation = scanner.nextLine();

            switch (operation) {
                case "add":
                    if (list.check()) {
                        System.out.println("Ошибка. Превышено допустимое количество дефектов");
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    String name = scanner.nextLine();
                    Defect def = new Defect(name);
                    System.out.println("Введите критичность дефекта из списка: blocker, critical, major, minor, trivial");
                    def.setCriticality(scanner.nextLine());
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    def.setDaysNumber(scanner.nextInt());
                    scanner.nextLine();
                    list.add(def);
                    break;
                case "list":
                    list.getAll();
                    break;
                case "quit":
                    return;
                default:
                    System.out.println("Введена несуществующая операция\n");
            }
        }
    }
}



