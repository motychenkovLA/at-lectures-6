package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // todo 0 - escape -> runProgram, run, итд
        boolean escape = true;
        int numberOfDefects = 0;
        // todo 3 - 10 это константа
        // todo 0 - type[] без пробела
        String [] resumeArray = new String[10];
        String [] criticalArray = new String[10];
        int [] numberOfDaysArray = new int[10];
        // todo 1 - тело while без отступа
        while (escape){

        Scanner console1 = new Scanner(System.in);
        System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
        // todo 0 - deistvie -> action, command
        String deistvie = console1.nextLine();
        switch (deistvie) {
            case "list":
                // todo 3 - если всегда известно количество заведенных дефектов (numberOfDefects), нет смысла проверять на null
                // todo 5 - i выходит за пределы массива, трекер падает если вызвать list после добавления 10 дефектов
                for (int i = 0; i <= numberOfDefects; i++) {
                    if (resumeArray[0] == null) {
                        System.out.println("Пока дефектов нет");
                        break;
                    }
                    else if (resumeArray[i] != null) {
                    System.out.println("" + i +  "|" + "Резюме:" + resumeArray[i] + "|" + "Критичность:" + criticalArray[i] + "|" + "Дней на исправление:" + numberOfDaysArray[i]);
                }
                    else break;
                }
                break;

            case "add":
                // todo 3 - добавляется один дефект, количество уже заведенных известно, зачем цикл?
                for (int j = 0; j < 10; j++) {
                    if (numberOfDefects == 10) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                        break;
                    }

                    if (resumeArray[j] == null) {
                        // todo 3 - создается второй сканнер
                        Scanner console = new Scanner(System.in);
                        System.out.println("Введите резюме");
                       resumeArray[j] = console.nextLine();

                        System.out.println("Введите критичность дефекта: критично, некритично или *****");
                        criticalArray[j] = console.nextLine();
                        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                        numberOfDaysArray[j] = console.nextInt();
                        console.nextLine();
                        numberOfDefects++;
                        break;
                    }
                }
                break;
            case "quit":
                escape = false;
            // todo 3 - break;


        }
    }
}}
