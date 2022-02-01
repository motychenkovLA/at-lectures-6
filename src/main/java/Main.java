import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = "";
        final int MAX_COUNT_DEFECT = 10;
        final int NUMBER_DAY_WORK_WEEKS = 5;
        int countDefects = 0;
        String[] resume = new String[MAX_COUNT_DEFECT];
        String[] priority =  new String[MAX_COUNT_DEFECT];
        int[] numberDayForFix = new int[MAX_COUNT_DEFECT];
        while(true) {
            System.out.println("Главное меню : \n1.Add\n2.List\n3.Quit");
            System.out.println("Введите команду:");
            command = sc.next();
            if(command.equals("Add")) {
                if(countDefects < MAX_COUNT_DEFECT) {
                    System.out.println("Введите резюме дефекта:");
                    String resumeBug = sc.next();
                    resume[countDefects] = resumeBug;
                    System.out.println("Выберете критичность дефекта:\nБлокирующий\nКритический\nЗначительный" +
                            "\nНезначительный\nТривиальный");
                    String priorityBug = sc.next();
                    priority[countDefects] = priorityBug;
                    System.out.println("Введите количество дней на исправление дефекта:");
                    int numberDayFixBug = sc.nextInt();
                    numberDayForFix[countDefects] = numberDayFixBug;
                    countDefects++;
                }
                else
                    // System.out.println("Хранилище может содержать не более MAX_COUNT_DEFECT");
                    System.out.println("Хранилище может содержать не более " + MAX_COUNT_DEFECT);
            }
            else if(command.equals("List")) {
                for(int i = 0; i < MAX_COUNT_DEFECT; i++) {
                    if(resume[i] != null) {
                        System.out.print("Номер дефекта " + i + " ");
                        System.out.print("Резюме " + resume[i] + " ");
                    }
                    if(priority[i] != null)
                        System.out.print("Серьезность " + priority[i] + " ");
                    if(numberDayForFix[i] != 0) {
                        System.out.println("Количество дней на исправление " + (numberDayForFix[i] > NUMBER_DAY_WORK_WEEKS));
                    }
                }
            }
            else if(command.equals("Quit")) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Такой команды нет");
            }
        }
    }
}