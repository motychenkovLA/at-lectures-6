package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int WORKWEEK = 5;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        String resume = console.nextLine();
        System.out.println("Введите критичность дефекта: критично, некритично или *****");
        String critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int numberOfDays = console.nextInt();
        console.nextLine();
        boolean moreThanWeek = numberOfDays>WORKWEEK;
        System.out.println("Резюме:" + resume + "|" + "Критичность:" + critical + "|" +"Дней на исправление:" + numberOfDays + "|" + moreThanWeek);

    }
}
