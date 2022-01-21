import java.util.Scanner;
public class DZ2 {
    public static void main(String[] args) {

        System.out.println("Введите резюме дефекта:");
        Scanner scanner = new Scanner(System.in);
        String resumeBug = scanner.nextLine();
        System.out.println("Выберете критичность дефекта:\nБлокирующий\nКритический\nЗначительный\nНезначительный\nТривиальный");
        String PriorityBug = scanner.nextLine();
        System.out.println("Введите количество дней на исправление дефекта:");
        int numberDayFixBug = scanner.nextInt();
        final int numberDayWorkWeeks = 5;
        boolean t = numberDayFixBug > numberDayWorkWeeks;
        System.out.println("Резюме: "+ resumeBug + "\nКритичность: "+ PriorityBug + "\nКоличество дней на исправление: " + numberDayFixBug+ "\nБольше рабочей недели: " + t);
    }
}
