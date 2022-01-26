package helloWorld;
import java.util.Objects;
import java.util.Scanner;
public class HomeWork {
    public static void  main (String[] args) {
        /*  Задание:
         *   Главное меню: добавить дефект add(как в dz1), вывести список list, выйти из программы quit
         *   После добавления дефекта происходит возврат в главное меню
         *   Максимум хранится 10 дефектов. Если больше - пользовательское сообщение и возврат в главное меню
         *   В списке дефекты отображаются в виде:
         *       Номер (0-9) / резюме /  серьезность / количество дней на исправление
         */
        //  Варианты серьезности бага
        String[] severitys = new String[5];
        severitys[0] = "Blocker";
        severitys[1] = "Critical";
        severitys[2] = "Major";
        severitys[3] = "Minor";
        severitys[4] = "Trivial";
        // Массив резюме
        String[] allresumes = new String[10];
        // Массив серьезности
        String[] allseveritys = new String[10];
        // Массив кол-ва дней
        int[] allnumberofdays = new int[10];
        // Счетчик количества заведенных дефектов
        byte scorer = 0;
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        boolean work = false;
        System.out.println("Начало работы.");
        System.out.println("Главное меню. Add - новый дефект. List - Список дефектов. Quit - выйти.");
        while (!work) {
            String usercommand = scanner.nextLine();
            switch (usercommand){
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
                            System.out.print("Резюме: " + allresumes[j] + " | ");
                            System.out.print("Серьёзность: " + allseveritys[j] + " | ");
                            System.out.println("Кол-во дней на решение: " + allnumberofdays[j] + ".");
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
                        String resume = scanner.nextLine();
                        //  Вывод вариантов ввода критичности бага
                        boolean check = false;
                        String severity = null;
                        while (!check) {
                            System.out.println("Оцените и введите критичность дефекта. Варианты: ");
                            for (String value : severitys) {
                                System.out.println(value);
                            }
                            severity = scanner.nextLine();
                            //  Проверка введенного варианта
                            for (String s : severitys) {
                                if (Objects.equals(severity, s)) {
                                    check = true;
                                    break;
                                }
                            }
                        }
                        //  Ввести кол-во дней
                        System.out.println("Введите Число - ожидаемое количество дней на исправление дефекта:");
                        int numberofdays = scanner.nextInt();
                        scanner.nextLine();
                        //  Проверка: займёт ли кол-во дней больше рабочей недели
                        boolean biggerthanweek = numberofdays > 4;
                        //  Вывод итоговой информации о заведенном дефекте
                        System.out.println("Номер дефекта: " + scorer);
                        System.out.println("Резюме: " + resume);
                        System.out.println("Критичность: " + severity);
                        System.out.println("Займет количество дней: " + numberofdays);
                        System.out.println("Займёт больше рабочей недели: " + biggerthanweek);
                        System.out.println();
                        allresumes[scorer] = resume;
                        allseveritys[scorer] = severity;
                        allnumberofdays[scorer] = numberofdays;
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
