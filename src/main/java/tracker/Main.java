
package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        final int WORK_WEEK = 5; // константа, кол-во рабочих дней
        final int MAX_BUG = 10;  //константа, максимальное кол-во дефектов

        boolean isRun = true; // показатель того, в работе мы или идем на выход
        int  countBug = 0; //кол-во заведенных дефектов

        String[] defects  = new String[MAX_BUG]; //массив дефектов

        Scanner scanner = new Scanner(System.in);

        while (isRun) {
            System.out.println(" Выберите действие " +
                    "\n add (Добавить новый дефект)" +
                    "\n list (Вывести список дефектов)" +
                    "\n quit (Вернуться в главное меню)");

            String action = scanner.nextLine();
            switch (action) {
                case ("add"): {
                    if (countBug > MAX_BUG - 1) {
                        System.out.println("В списке есть уже " + MAX_BUG + " дефектов, больше ввести не возможно!");
                    }else {
                        System.out.println("Введите резюме дефекта");
                        String resumeBug = scanner.nextLine();

                        System.out.println("Введите критичность дефекта (Low, Medium, High)");
                        String criticalBug = scanner.nextLine();

                        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                        int dayCountBug = scanner.nextInt();
                        scanner.nextLine();

                        defects[countBug] = countBug + "  |  " + resumeBug + "  |  " + criticalBug + "  |  " + dayCountBug;
                        countBug++;

                    }
                    break;
                }
                case ("list"): {
                    System.out.println(" Номер |  Резюме  | Серьезность | Кол-во дней на исправление ");
                    for (int i = 0; i < countBug; i++) {
                        System.out.println(defects[i]);
                    }
                    break;
                }
                case ("quit"): {
                    isRun = false;
                    break;
                }    }
        }





    }
}
