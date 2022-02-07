package tracker;

import java.util.Scanner;

class Tracker {
    public static void main(String[] args) {
        int maxNumBugs = 10;
        Defect[] listBug = new Defect [maxNumBugs];

        int countBug = 0;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите операцию из списка:\n add - добавить новый дефект \n list - вывести список дефектов"
                    + " \n quit - выход");
            String operation = scanner.nextLine();
            switch (operation) {
                case "add":
                    if (countBug > maxNumBugs - 1) {
                        System.out.println("Ошибка. Превышено допустимое количество дефектов");
                        break;
                    }
                    System.out.println("Введите резюме дефекта");
                    String name = scanner.nextLine();
                    System.out.println("Введите критичность дефекта из списка: blocker, critical, major, minor, trivial");
                    String criticality = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int daysnumber = scanner.nextInt();
                    Defect def = new Defect(name, criticality, daysnumber);
                    listBug[countBug] = def;
                    countBug++;
                    break;
                case "list":
                    for (int i = 0; i < countBug; i++) {
                        System.out.println(listBug[i].getInfo());
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



