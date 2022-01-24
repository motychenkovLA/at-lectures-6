package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem = 0;
        //todo неговорящее имя переменной
        int i = 0;
        final int WORK_WEEK = 5;
        //todo не дефект а дефектЫ
        String[] defect;
        //todo магическое число 10
        //todo плохое решение хранить данные в строке
        defect = new String[10];
        Scanner scanner = new Scanner(System.in);

        //todo рабочее решение но с ходу непонятно зачем оно тут
        while (menuItem != 3){
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            //todo необходимо отформатировать кейсы, обромить {}
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
                    //todo не то что бы придираюсь но в консоли выглядит ужасно), можно переделать с таблицы на карточки
                    System.out.println( "Описание дефекта | Критичность | Дней на исправление | Займет меньше рабочей недели");
                    for (int j = 0;j < i;j++) {
                        System.out.println(defect[j]);
                    }
                    break;

                case 3:
                    //todo тут можно сказать пользователю что то типа - До свидания!)
                    break;

                default:
                    System.out.println("Такого номера нет!") ;
                    System.out.println();
            }

        }
    }
}