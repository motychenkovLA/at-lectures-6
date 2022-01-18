package helloWorld;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Введите резюме");
        String resume = console.nextLine();
        System.out.println("Введите критичность дефекта");
        String critical = console.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int NUMBER_OF_DAY = console.nextInt();
        boolean MORE_THAN_7 = NUMBER_OF_DAY>7;
        System.out.println("Резюме:" + resume + "|" + "Критичность:" + critical + "|" +"Дней на исправление:" + NUMBER_OF_DAY + "|" + MORE_THAN_7);

    }
}
