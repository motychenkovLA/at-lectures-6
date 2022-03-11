package tracker;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import static tracker.Main.takeLong;

public class Transition {
    private final Status from;
    private final Status to;
    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }
    // todo 3 - работает с консолью и с репо, не ответственность транзишена
    // todo 5 - не валидирует перевод статуса
    public static void dataValidation(Scanner console, Map<Long, Defect> map, Set<Transition> transitions) {
        Defect defect;
        while (true) {
            defect = map.get((takeLong(console, "Введите Id дефекта:")));
            if (defect != null) {
                break;
            }
            System.out.println("Нет дефекта с таким Id");
        }
        while (true) {
            System.out.println("Введите новый статус: Открыто, Закрыто или В работе");

            String inputStatus = console.nextLine();
            Status newStatus = Status.getStatus(inputStatus);
            if (newStatus != null) {
                transitions.add(new Transition(defect.getStatus(), newStatus));
                defect.setStatus(newStatus);
                return;
            }
            System.out.println("Статус не найден");
        }
    }

}
