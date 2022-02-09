package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите максимальное количеество дефектов:");
        int maxDefects = console.nextInt();
        Repository repository = new Repository(maxDefects);
        while (run) {
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
            String action = console.nextLine();
            switch (action) {
                case "list":
                    for (Defect defect : repository.getAll()) {
                        if (defect == null) break;
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
                    System.out.println("Введите критичность дефекта: критично, некритично или *****");
                    String critical = console.nextLine();
                    System.out.println("Введите ожидаемое количество дней на исправление дефекта");
                    int numberOfDays = console.nextInt();
                    repository.add(new Defect(resume, critical, numberOfDays));
                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
