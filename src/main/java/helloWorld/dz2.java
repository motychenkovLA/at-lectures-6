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
        String Bug_Resume = scanner.nextLine();
    //  Варианты критичности бага
        String[] Case_Bug_Severity = new String[2];
        Case_Bug_Severity [0] = "Низкий";
        Case_Bug_Severity [1] = "Высокий";
    //  Вывод вариантов ввода критичности бага
        boolean check = false;
        String Bug_Severity = null;
        while(!check) {
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
    }
}
