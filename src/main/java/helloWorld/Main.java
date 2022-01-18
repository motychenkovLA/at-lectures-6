package helloWorld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int workweek = 5;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        String resume = console.nextLine();
        // todo 1 - "выдать список вариантов" для критичностей
        System.out.println("Введите критичность дефекта");
        String critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        // todo 1 - lowerCamelCase, numberOfDays
        int numberOfDays = console.nextInt();
        console.nextLine();
        // todo 3 - здесь console.nextLine(), чтобы потом не забыть
        // todo 1 - lowerCamelCase, moreThanWeek
        // todo 0 - рабочая неделя 5 дней
        // todo 3 - лучше вынести 7 (5) в именованную константу в начало main
        boolean moreThanWeek = numberOfDays>workweek;
        System.out.println("Резюме:" + resume + "|" + "Критичность:" + critical + "|" +"Дней на исправление:" + numberOfDays + "|" + moreThanWeek);

    }
}
