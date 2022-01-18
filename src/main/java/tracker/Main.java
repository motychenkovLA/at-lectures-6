package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int workweek = 5;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        String resume = console.nextLine();
        // tod 1 - "выдать список вариантов" для критичностей
        System.out.println("Введите критичность дефекта: критично, некритично или *****");
        String critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        // tod 1 - lowerCamelCase, numberOfDays
        int numberOfDays = console.nextInt();
        console.nextLine();
        // tod 3 - здесь console.nextLine(), чтобы потом не забыть
        // tod 1 - lowerCamelCase, moreThanWeek
        // todo0 - рабочая неделя 5 дней
        // tod 3 - лучше вынести 7 (5) в именованную константу в начало main
        boolean moreThanWeek = numberOfDays>workweek;
        System.out.println("Резюме:" + resume + "|" + "Критичность:" + critical + "|" +"Дней на исправление:" + numberOfDays + "|" + moreThanWeek);

    }
}
