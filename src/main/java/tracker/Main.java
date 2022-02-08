package tracker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner console = new Scanner(System.in);
        System.out.println("Введите максимальное количеество дефектов:");
        final int MAX_DEFECTS = console.nextInt(); // todo 1 - не константа, значение определяется в рантайме
        Repository repository = new Repository(MAX_DEFECTS);
        while (run) {
            System.out.println("Чтобы добавить новый дефект, введите \"add\". Чтобы вывести список дефектов, введите \"list\". Чтобы выйти, введите \"quit\"");
            Scanner console1 = new Scanner(System.in); // todo 0 - почему 1? куда делась console?
            String action = console1.nextLine();
            switch (action) {
                case "list":

                    for (Defect defect : // todo 1 - форматирование
                            repository.getAll()) {
                        if (defect == null) break;
                        System.out.println(defect.getDefect());
                    }
                    break;
                case "add":
                    // todo 3 - сравнение внутреннего состояния репо с внешней переменной, в общем случае не гарантирует не-заполненность,
                    //  лучше сделать метод, который будет проверять, заполнен ли репо
                    if (repository.getNumberOfDefects() >= MAX_DEFECTS) {
                        System.out.println("Невозможно добавить больше " + MAX_DEFECTS + " дефектов");
                        break;
                    }
                    repository.add(new Defect());

                    break;
                case "quit":
                    run = false;
                    break;
            }
        }
    }
}
