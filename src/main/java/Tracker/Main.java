package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem;
        //неговорящее имя переменной - исправлено
        int defectNumber = 0;
        final int WORK_WEEK = 5;
        //магическое число 10 - исправлено
        final int MAX_NUMBER_OF_DEFECTS = 10;
        //не дефект а дефектЫ - переменная больше не используется
        //плохое решение хранить данные в строке - исправлено
        String[] resume = new String[MAX_NUMBER_OF_DEFECTS];
        String[] criticality = new String[MAX_NUMBER_OF_DEFECTS];
        int[] daysToFix = new int[MAX_NUMBER_OF_DEFECTS];


        Scanner scanner = new Scanner(System.in);

        //рабочее решение но с ходу непонятно зачем оно тут - испралвено
        boolean isRun = true;
        while (isRun){
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            //необходимо отформатировать кейсы, обромить {} - исправлено
            switch (menuItem){
                case 1: {
                    if (defectNumber < MAX_NUMBER_OF_DEFECTS) {
                        System.out.println("Введите описание дефекта");
                        resume[defectNumber] = scanner.nextLine();
                        System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                        criticality[defectNumber] = scanner.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление");
                        daysToFix[defectNumber] = scanner.nextInt();
                        defectNumber++;
                    } else System.out.println("Превышено максимальное количество дефектов!");
                    System.out.println();
                    break;
                }

                case 2: {
                    //не то что бы придираюсь но в консоли выглядит ужасно), можно переделать с таблицы на карточки - исправлено
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < defectNumber; i++) {
                        boolean fixInAWeek = daysToFix[i] < WORK_WEEK;
                        System.out.println(i+1 + "." + "Описание: " + resume[i] + "|"
                                                     + "  Критичность: " + criticality[i] + "|"
                                                     + "  Дней на исправление: " + daysToFix[i]+ "|"
                                                     + "  Займёт меньше рабочей недели: " + fixInAWeek);
                    }
                    System.out.println();
                    break;
                }
                case 3: {
                    //тут можно сказать пользователю что то типа - До свидания!) - исправлено
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