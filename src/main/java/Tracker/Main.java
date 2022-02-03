package Tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int menuItem;                                           //пункт меню
        int defectCounter = 0;                                  //счётчик дефектов
        final int WORK_WEEK = 5;                                //количество рабочих дней в неделе
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
                        //todo переделать в соответствии с конструктором
                        System.out.println("Введите описание дефекта");
                        defects[defectCounter] = new Defect();                                  //создаём экземпляр дефекта
                        defects[defectCounter].Id = defectCounter + 1;                          //присваеваем Id дефекта
                        defects[defectCounter].resume = scanner.nextLine();                     //заполняем описание
                        System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                        defects[defectCounter].sewerity = scanner.nextLine();                //заполняем критичность
                        System.out.println("Введите ожидаемое количество дней на исправление");
                        defects[defectCounter].daysToFix = scanner.nextInt();                   //заполняем количество дней на исправление
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
//                               defects[i].printDefectInfo(WORK_WEEK);                             //вывод методом printDefectInfo()
                                 System.out.println(defects[i].getInfo(WORK_WEEK));                 // вывод методом getInfo(), который возвращает строку
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