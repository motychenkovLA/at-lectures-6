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
        //  Варианты серьезности бага
        String[] Case_Bug_Severity = new String[5];
        Case_Bug_Severity[0] = "Blocker";
        Case_Bug_Severity[1] = "Critical";
        Case_Bug_Severity[2] = "Major";
        Case_Bug_Severity[3] = "Minor";
        Case_Bug_Severity[4] = "Trivial";
        // Массив резюме
        String[] ArrayResume = new String[10];
        // Массив серьезности
        String[] ArraySeverity = new String[10];
        // Массив кол-ва дней
        byte[] ArrayNumberOfDays = new byte[10];
        // Счетчик количества заведенных дефектов
        byte scorer = 0;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean work = false;
        System.out.println("Начало работы.");
        System.out.println("Главное меню. Add - новый дефект. List - Список дефектов. Quit - выйти.");
        while (!work) {
            String UserCommand = scanner.nextLine();
            switch (UserCommand){
                default:
                    System.out.println("Доступные команды: Add, List, Quit.");
                    break;
                case "Quit":
                    work=true;
                    break;
                case "List":
                    System.out.println("Список дефектов:");
                    for (byte j = 0; j<=scorer; j++){
                        if ((scorer > 0)&(scorer-1>=j)) {
                            System.out.print(j + ": ");
                            System.out.print("Резюме: " + ArrayResume[j] + " | ");
                            System.out.print("Серьёзность: " + ArraySeverity[j] + " | ");
                            System.out.println("Кол-во дней на решение: " + ArrayNumberOfDays[j] + ".");
                        }else {
                            if (j <= 9) {
                                System.out.println("Есть свободное место для дефектов в количестве " +
                                        (10-j) + ", но дефекты ещё не заведены.");
                            }
                        }
                    }
                    if (scorer == 10) {
                        System.out.println("Больше нет свободного места для заведения дефектов.");
                    }
                    break;
                case "Add":
                    if (scorer<=9) {
                        scanner = new Scanner(System.in);
                        //  Ввести резюме
                        System.out.println("Номер дефекта: " + scorer);
                        System.out.println("Напишите резюме дефекта:");
                        String Bug_Resume = scanner.nextLine();
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
                        System.out.println("Номер дефекта: " + scorer);
                        System.out.println("Резюме: " + Bug_Resume);
                        System.out.println("Критичность: " + Bug_Severity);
                        System.out.println("Займет количество дней: " + Bug_NumberOfDays);
                        System.out.println("Займёт больше рабочей недели: " + BiggerThanWeek);
                        System.out.println();
                        ArrayResume[scorer] = Bug_Resume;
                        ArraySeverity[scorer] = Bug_Severity;
                        ArrayNumberOfDays[scorer] = Bug_NumberOfDays;
                        scorer++;
                        break;
                    }else{
                        System.out.println("Больше нет свободного места для заведения дефектов!");
                    }
            }
        }
        System.out.println("Завершение работы.");
    }
}
