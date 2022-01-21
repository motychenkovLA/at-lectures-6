package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem = 0;
        int i = 0;
        final int WORK_WEEK = 5;
        String[] defect;
        defect = new String[10];
        Scanner scanner = new Scanner(System.in);


        while (menuItem != 3){
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();
            switch (menuItem){
                case 1: if (i < defect.length) {
                    System.out.println("Введите описание дефекта");
                    String resume = scanner.nextLine();
                    System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                    String criticality = scanner.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление");
                    int daysToFix = scanner.nextInt();
                    boolean fixInAWeek = daysToFix < WORK_WEEK;
                    defect[i] = resume + " | " + criticality + " | " + daysToFix + " | " + fixInAWeek;
                    i++;
                }
                else System.out.println("Превышено максимальное количество дефектов!");
                    System.out.println();
                    break;

                case 2:
                    System.out.println( "Описание дефекта | Критичность | Дней на исправление | Займет меньше рабочей недели");
                    for (int j = 0;j < i;j++) {
                        System.out.println(defect[j]);
                    }
                    break;

                case 3:
                    break;

                default:
                    System.out.println("Такого номера нет!") ;
                    System.out.println();
            }

        }
    }
}