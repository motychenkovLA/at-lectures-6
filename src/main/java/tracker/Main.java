
package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        final int MAX_BUG = 10;  //константа, максимальное кол-во дефектов

        boolean isRun = true; // показатель того, в работе мы или идем на выход
        int  countBug = 0; //кол-во заведенных дефектов

        String[] defectResumes  = new String[MAX_BUG]; //массив резюме дефектов
        String[] defectCrits  = new String[MAX_BUG]; //массив критичностей дефектов
        int[] defectDays  = new int[MAX_BUG]; //массив критичностей дефектов

        Scanner scanner = new Scanner(System.in);

        while (isRun) {
            System.out.println(" Выберите действие " +
                    "\n add (Добавить новый дефект)" +
                    "\n list (Вывести список дефектов)" +
                    "\n quit (Вернуться в главное меню)");

            String action = scanner.nextLine();
            switch (action) {
                case ("add"): {
                    if (countBug >= MAX_BUG) {
                        System.out.println("В списке есть уже " + MAX_BUG + " дефектов, больше ввести невозможно!");
                    }else {
                        System.out.println("Введите резюме дефекта");
                        defectResumes[countBug] = scanner.nextLine();

                        System.out.println("Введите критичность дефекта (Low, Medium, High)");
                        defectCrits[countBug] = scanner.nextLine();

                        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                        defectDays[countBug] = scanner.nextInt();
                        scanner.nextLine();

                        countBug++;
                    }
                    break;
                }
                case ("list"): {
                    System.out.println(" Номер |  Резюме  | Серьезность | Кол-во дней на исправление ");
                    for (int i = 0; i < countBug; i++) {
                        System.out.println(i + "  |  " + defectResumes[i] + "  |  " + defectCrits[i] + "  |  " + defectDays[i]);
                    }
                    break;
                }
                case ("quit"): {
                    isRun = false;
                    break;
                }
            }
        }
    }
}
