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
                    String status = console.nextLine();
                    // todo 3 - достаются все дефекты вместо одного нужного
                    for (Defect defect : repository.getAll()) {
                        if (defect.getId() == id) {
                            defect.changeStatus(status);
                        }

                    }
                    // todo 1 - статус не всегда успешно изменен, пользователь может ввести неверный ид
                    System.out.println("Статус успешно изменен!");

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
                    String critical = console.nextLine();
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
