package helloWorld;

import java.util.Scanner;

public class dz2 { public static void  main (String[] args) {
    Scanner scanner = new Scanner(System.in);
            System.out.println("Введите резюме дефекта");
    String Description = scanner.nextLine();
    System.out.println("Введите критичность дефекта:\nLow\nMedium\nHigh\nCritical");
    String Critical = scanner.nextLine();
            System.out.println("Введите ожидаемое количество дней на исправление дефекта");
int NumberOfDays = scanner.nextInt();
    int DayOfWeek=5;
    boolean WorkWeek = NumberOfDays>=DayOfWeek;
    System.out.println(Description + " | " + Critical + " | " + NumberOfDays + " | Займёт больше рабочей недели:" + WorkWeek);

}
}





