
package tracker;

import java.util.*;

// todo 1 - Dz2 -> Main или Tracker. через shift-f6, чтоб не сломать
public class Dz2 {

    public static void main(String[] args) {

        //System.out.println("hi"); // todo 0 - зачем оно тут?
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String resumeBug = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Low, Medium, Hight)"); // todo 0 - High
        String criticalBug = scanner.nextLine();

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int dayCountBug = scanner.nextInt();
        // todo 3 - scanner.nextLine(), чтоб потом не потерять

        // todo 0 - рабочая неделя 5 дней
        // todo 3 - лучше вынести длину недели в константу в начало main
        boolean compareWeek = dayCountBug > 7;

        System.out.println("Резюме  | Серьезность | Кол-во дней на исправление | займет больше рабочей недели (true/false)");
        System.out.println(resumeBug + "  |  " + criticalBug + "  |  " + dayCountBug + "  |  " + compareWeek);

    }
}
