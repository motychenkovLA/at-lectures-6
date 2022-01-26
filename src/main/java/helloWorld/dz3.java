package helloWorld;
import java.util.Objects;
import java.util.Scanner;
public class dz3 {
    public static void  main (String[] args) {
        /*  Задание:
         *   Главное меню: добавить дефект add(как в dz1), вывести список list, выйти из программы quit
         *   После добавления дефекта происходит возврат в главное меню
         *   Максимум хранится 10 дефектов. Если больше - пользовательское сообщение и возврат в главное меню
         *   В списке дефекты отображаются в виде:
         *       Номер (0-9) / резюме /  серьезность / количество дней на исправление
         */
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean work = false;
        while (!work) {
            System.out.println("Главное меню. Add - новый дефект. List - Список дефектов. Quit - выйти.");
            String UserCommand = scanner.nextLine();
            switch (UserCommand){
                default:
                    System.out.println("Введите правильную команду. Возврат в главное меню...");
                    break;
                case "Quit":
                    work=true;
                    break;
                case "List":
                    System.out.println("List - Список дефектов!");
                    break;
                case "Add":
                    scanner = new Scanner(System.in);
                    //  Ввести резюме
                    System.out.println("Напишите резюме дефекта:");
                    String Bug_Resume = scanner.nextLine();
                    //  Варианты критичности бага
                    String[] Case_Bug_Severity = new String[2];
                    Case_Bug_Severity[0] = "Низкий";
                    Case_Bug_Severity[1] = "Высокий";
                    //  Вывод вариантов ввода критичности бага
                    boolean check = false;
                    String Bug_Severity = null;
                    while (!check) {
                        System.out.println("Оцените и введите критичность дефекта. Варианты: ");
                        for (String value : Case_Bug_Severity) {
                            System.out.println(value);
                        }
                        Bug_Severity = scanner.nextLine();
                        //  Проверка введенного варианта
                        for (String s : Case_Bug_Severity) {
                            if (Objects.equals(Bug_Severity, s)) {
                                check = true;
                                break;
                            }
                        }
                    }
                    //  Ввести кол-во дней
                    System.out.println("Введите Число - ожидаемое количество дней на исправление дефекта:");
                    byte Bug_NumberOfDays = scanner.nextByte();
                    //  Проверка: займёт ли кол-во дней больше рабочей недели
                    boolean BiggerThanWeek = Bug_NumberOfDays > 4;
                    //  Вывод итоговой информации о заведенном дефекте
                    System.out.println("Резюме: " + Bug_Resume);
                    System.out.println("Критичность: " + Bug_Severity);
                    System.out.println("Займет количество дней: " + Bug_NumberOfDays);
                    System.out.println("Займёт больше рабочей недели: " + BiggerThanWeek);
                    break;
            }
        }
        System.out.println("Завершение работы");
    }
}
