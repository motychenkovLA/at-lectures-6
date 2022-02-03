package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem;                                           //пункт меню
        int defectCounter = 0;                                  //счётчик дефектов
        final int MAX_NUMBER_OF_DEFECTS = 10;                   //максимальное количество дефектов
        Defect[] defects = new Defect[MAX_NUMBER_OF_DEFECTS];   //массив дефектов
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;

        while (isRun){
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            switch (menuItem){
                case 1: {
                    if (defectCounter < MAX_NUMBER_OF_DEFECTS) {
                        //переделать в соответствии с конструктором - исправлено
                        System.out.println("Введите описание дефекта");
                        String resume = scanner.nextLine();                                                     //заполняем описание
                        System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                        String priority = scanner.nextLine();                                                   //заполняем критичность
                        System.out.println("Введите ожидаемое количество дней на исправление");
                        int daysToFix = scanner.nextInt();                                                      //заполняем количество дней на исправление
                        defects[defectCounter] = new Defect(defectCounter + 1, resume, priority, daysToFix); //создаём экземпляр дефекта
                        defectCounter++;
                    } else {
                        System.out.println("Превышено максимальное количество дефектов!");
                        System.out.println();
                    }
                    break;
                }
                case 2: {
                    System.out.println("Список дефектов:");
                    for (int i = 0; i < defectCounter; i++) {
                                 System.out.println(defects[i].getInfo());                 // вывод методом getInfo(), который возвращает строку
                       }
                    System.out.println();
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