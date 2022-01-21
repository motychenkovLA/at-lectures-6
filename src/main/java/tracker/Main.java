package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        boolean escape = true;
        int numberOfDefects = 0;
        String [] resumeArray = new String[10];
        String [] criticalArray = new String[10];
        int [] numberOfDaysArray = new int[10];
        while (escape){
        Scanner console1 = new Scanner(System.in);
        System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
        String deistvie = console1.nextLine();
        switch (deistvie) {
            case "list":
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
                for (int j = 0; j < 10; j++) {
                    if (numberOfDefects == 10) {
                        System.out.println("Невозможно добавить больше 10 дефектов");
                        break;
                    }

                    if (resumeArray[j] == null) {
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



        }
    }
}}
