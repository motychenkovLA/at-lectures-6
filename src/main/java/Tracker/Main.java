package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem; //пункт меню
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;


        while (isRun) {
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            switch (menuItem) {
                case 1: {
                    System.out.println("Введите описание дефекта");
                    String resume = scanner.nextLine(); //заполняем описание
                    System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                    String priority = scanner.nextLine(); //заполняем критичность
                    System.out.println("Введите ожидаемое количество дней на исправление");
                    int daysToFix = scanner.nextInt(); //заполняем количество дней на исправление
                    Defect defect = new Defect(resume, priority, daysToFix);
                    repository.add(defect);
                    break;
                }
                case 2: {
                    System.out.println("Список дефектов:");
                    for (Defect defect : repository.getAll()) {
                        System.out.println(defect.getInfo()); //выводим дефекты
                    }
                    break;
                }
                case 3: {
                    System.out.println("До новых встреч!");
                    isRun = false;
                    break;
                }
                default: {
                    System.out.println("Нет такого пункта меню!");
                    System.out.println();
                }
            }
        }
    }
}