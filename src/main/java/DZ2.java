import java.util.Scanner;
public class DZ2 {
    public static void main(String[] args) {

        System.out.println("Введите резюме дефекта:");
        Scanner scanner = new Scanner(System.in);
        String resumeBug = scanner.nextLine();
        System.out.println("Выберете критичность дефекта:\nБлокирующий\nКритический\nЗначительный" +
        "\nНезначительный\nТривиальный");
        String priorityBug = scanner.nextLine();
        System.out.println("Введите количество дней на исправление дефекта:");
        int numberDayFixBug = scanner.nextInt();
        final int NUMBER_DAY_WORK_WEEKS = 5;
        boolean validWorkDay = numberDayFixBug > NUMBER_DAY_WORK_WEEKS;
        System.out.println("Резюме: "+ resumeBug + "\nКритичность: "+ priorityBug + "\nКоличество дней на исправление: "
                + numberDayFixBug+ "\nБольше рабочей недели: " + validWorkDay);
    }
}
