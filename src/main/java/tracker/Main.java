package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите максимальное количеество дефектов:");
        int maxDefects = console.nextInt();
        console.nextLine();
        Repository repository = new Repository(maxDefects);
        while (run) {
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Введите \"change\", чтобы изменить статус. Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "change":
                    System.out.println("Введите Id дефекта:");
                    long id = console.nextLong();
                    console.nextLine();
                    System.out.println("Введите новый статус:");
                    // todo 3 - с valueOf есть пара проблем
                    //  - если введено не верное значение программа падает
                    //  - они на английском, а весь остальной UI на русском
                    //  стоит добавить в енамы возможность их нормального отображения и их безопасного получения по этому отображению
                    Status status = Status.valueOf(console.nextLine());
                    repository.getDefect(id).changeStatus(status); // todo 5 - упадет если нет дефекта с таким ид

                    break;
                case "list":
                    for (Defect defect : repository.getAll()) {
                        System.out.println(defect.getDefectInfo());
                    }
                    break;
                case "add":
                    if (repository.isFull()) {
                        System.out.println("Невозможно добавить больше " + maxDefects + " дефектов");
                        break;
                    }

                    System.out.println("Введите резюме");
                    String resume = console.nextLine();
                    System.out.println("Введите критичность дефекта: критично, некритично или ахтунг");
                    Severity critical = Severity.valueOf(console.nextLine());
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDays = console.nextInt();
                    console.nextLine();
                    System.out.println("Введите номер типа вложения: 1 - комментарий, 2 - ссылка на другой дефект");
                    int typeInclosure = console.nextInt();
                    console.nextLine();
                    if (typeInclosure == 1) {
                        System.out.println("Введите комментарий");
                        repository.add(new Defect(resume, critical, numberOfDays, new CommentAttachment(console.nextLine())));
                    } else {
                        System.out.println("Введите id дефекта");
                        repository.add(new Defect(resume, critical, numberOfDays, new DefectAttachment(console.nextLong())));
                        console.nextLine();
                    }
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
