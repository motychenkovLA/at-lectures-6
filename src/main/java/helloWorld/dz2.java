package helloWorld;

import java.util.Scanner;

public class dz2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите резюме дефекта");
        String description = scanner.nextLine();
        System.out.println("Введите критичность дефекта:\nLow\nMedium\nHigh\nCritical");
        String critical = scanner.nextLine();
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int daysNumber = scanner.nextInt();
        int workWeek = 5;
        boolean moreThanWorkWeek = daysNumber >= workWeek;
        System.out.println(description + " | " + critical + " | " + daysNumber + " | Займёт больше рабочей недели:" + moreThanWorkWeek);


    }
}





