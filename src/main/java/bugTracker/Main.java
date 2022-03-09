package bugTracker;
import java.io.IOException;
import java.util.Scanner;

public class Main implements AutoCloseable{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Repository repository = new Repository();
            while (true) {
                System.out.println("\n\t Главное меню\nВведите add для добавления нового дефекта\n" +
                        "Введите change, чтобы изменить статус дефекта\n" +
                        "Введите list, чтобы вывести список дефектов\n" +
                        "Введите quit для выхода из прогруммы ");
                String selectionInTheMainMenu = scanner.nextLine();

                if (selectionInTheMainMenu.equals("add")) {
                    repository.addDefect(repository,scanner);
                } else if (selectionInTheMainMenu.equals("change")) {
                    repository.changeStatusOfDefect(repository,scanner);
                } else if (selectionInTheMainMenu.equals("list")) {
                    for (Defect j : repository.getAll()){
                        if (j == null){
                            break;
                        }
                        System.out.println(j.getInfo());
                    }
                } else if (selectionInTheMainMenu.equals("quit")) {
                    System.out.println("До свидания!");
                    break;
                } else {
                    System.out.println("Нет такого пункта меню. Введите корректный пункт меню.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {
        System.out.println("Сканер закрыт.");
    }
}