package helloWorld;
import java.util.Objects;
import java.util.Scanner;
public class dz2 {
    public static void  main (String[] args){
    /*  Задание:
    *       Предложить юзеру ввести резюме дефекта, принять Строку - Bug_Resume
    *       Предложить юзеру ввести критичность и выдать список вариантов, принять Строку - Bug_Severity
    *       Предложить юзеру ввести ожидаемое количество дней на исправление дефекта, принять Число - Bug_NumberOfDays
    *       Вывести информацию о заведенном дефекте в виде:
    *           Резюме | Серьезность | Количество дней на исправление | Займёт больше рабочей недели (true/false)
    */
        java.util.Scanner scanner = new java.util.Scanner(System.in);
    //  Ввести резюме
        System.out.println("Напишите резюме дефекта:");
        String resume = scanner.nextLine();
    //  Варианты критичности бага
        String[] severitys = new String[2];
        severitys [0] = "Низкий";
        severitys [1] = "Высокий";
    //  Вывод вариантов ввода критичности бага
        boolean check = false;
        String severity = null;
        while(!check) {
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
        System.out.println("Резюме: " + resume);
        System.out.println("Критичность: " + severity);
        System.out.println("Займет количество дней: " + numberofdays);
        System.out.println("Займёт больше рабочей недели: " + biggerthanweek);
    }
}
