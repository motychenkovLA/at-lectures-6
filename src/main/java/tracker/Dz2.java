
package tracker;

import java.util.*;

public class Dz2 {

    public static void main(String[] args) {

        //System.out.println("hi");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите резюме дефекта");
        String resumeBug = scanner.nextLine();

        System.out.println("Введите критичность дефекта (Low, Medium, Hight)");
        String criticalBug = scanner.nextLine();

        System.out.println("Введите ожидаемое кол-во дней на исправление дефекта");
        int dayCountBug = scanner.nextInt();

        boolean compareWeek = dayCountBug > 7;

        System.out.println("Резюме  | Серьезность | Кол-во дней на исправление | займет больше рабочей недели (true/false)");
        System.out.println(resumeBug + "  |  " + criticalBug + "  |  " + dayCountBug + "  |  " + compareWeek);

    }
}
