import java.util.Scanner;
import java.util.Arrays;
public class DZ {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        String command = "r";
        String[] arrayDefects = new String[10];
        int countDefects = 0;

        while(!command.equals("Quit")) {
            System.out.println("Главное меню : \n1.Add\n2.List\n3.Quit");
            System.out.println("Введите команду:");
            command = scanner.nextLine();
            if (command.equals("Add")) {
                if(countDefects < arrayDefects.length) {
                    System.out.println("Введите резюме дефекта:");
                    String resumeBug = sc.nextLine();
                    System.out.println("Выберете критичность дефекта:\nБлокирующий\nКритический\nЗначительный" +
                            "\nНезначительный\nТривиальный");
                    String priorityBug = sc.nextLine();
                    System.out.println("Введите количество дней на исправление дефекта:");
                    int numberDayFixBug = sc.nextInt();
                    final int NUMBER_DAY_WORK_WEEKS = 5;
                    boolean validWorkDay = numberDayFixBug > NUMBER_DAY_WORK_WEEKS;
                    arrayDefects[countDefects] = "Номер дефекта " + countDefects + " Резюме: " + resumeBug + " Критичность: " + priorityBug + " Количество дней на исправление: "
                            + numberDayFixBug + " Больше рабочей недели: " + validWorkDay;
                    countDefects++;
                }
                else
                    System.out.println("Хранилище может содержать не более 10 дефектов");
            }
            else if (command.equals("List")) {
                for (int i = 0; i < arrayDefects.length; i++) {

                    System.out.println(arrayDefects[i]);
                }
            }
            else if (command.equals("Quit")) {
                break;
            }
            else {
                System.out.println("Такой команды нет");

            }
        }
    }
}
