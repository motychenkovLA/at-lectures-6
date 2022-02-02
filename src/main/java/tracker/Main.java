
package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        final int MAX_BUG = 10;  //константа, максимальное кол-во дефектов

        boolean isRun = true; // показатель того, в работе мы или идем на выход
        int  countBug = 0; //кол-во заведенных дефектов

        Defect[] defects  = new Defect[MAX_BUG]; //массив дефектов

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
                        String resume = scanner.nextLine();

                        System.out.println("Введите критичность дефекта (Low, Medium, High)");
                        String priority = scanner.nextLine();

                        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
                        int daysToFix = scanner.nextInt();
                        scanner.nextLine();

                        Defect bug = new Defect(resume, priority, daysToFix);
                        defects[countBug] = bug;
                        countBug++;
                    }
                    break;
                }
                case ("list"): {
                    for(Defect bug : defects){
                        if (bug != null) System.out.println(bug.toString());
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
