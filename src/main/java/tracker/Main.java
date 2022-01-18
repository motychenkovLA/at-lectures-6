
package tracker;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        final int workWeek = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String resumeBug = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Low, Medium, High)");
        String criticalBug = scanner.nextLine();

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int dayCountBug = scanner.nextInt();
        scanner.nextLine();

        boolean compareWeek = dayCountBug > workWeek;

        System.out.println("Резюме  | Серьезность | Кол-во дней на исправление | займет больше рабочей недели (true/false)");
        System.out.println(resumeBug + "  |  " + criticalBug + "  |  " + dayCountBug + "  |  " + compareWeek);

    }
}
