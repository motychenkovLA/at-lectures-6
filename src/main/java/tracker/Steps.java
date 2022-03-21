package tracker;

import java.util.Scanner;

public class Steps {
    public static void addDefect(Scanner scanner) {
        Defect def;
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка: \n BLOCKER \n CRITICAL\n MAJOR \n" +
                " MINOR\n TRIVIAL");
        Criticality criticality;
        try {
            criticality = Criticality.valueOf(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("Вы не ввели критичность из списка");
            return;
        }
        System.out.println("Выберите тип вложения: \n для добавления комментария введите comment \n " +
                "для добавления ссылки на другой дефект введите link");
        String attachment = scanner.nextLine();
        if (attachment.equals("comment")) {
            System.out.println("Введите комментарий");
            CommentAttachment attCom = new CommentAttachment(scanner.nextLine());
            def = new Defect(name, criticality, attCom);
        } else if (attachment.equals("link")) {
            System.out.println("Введите ссылку на дефект в виде ID этого дефекта");
            int id;
            while (true) {
                try {
                    id = Integer.parseInt(scanner.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат.Введите еще раз ссылку на дефект в виде ID этого дефекта");
                }
            }
            DefectAttachment attDef = new DefectAttachment(id);
            def = new Defect(name, criticality, attDef);
        } else {
            System.out.println("Введена несуществующая операция \n");
            return;
        }
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        int i;
        while (true) {
            try {
                i = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат.Введите ожидаемое количество дней на исправление дефекта еще раз");
            }
        }
        def.setDaysNumber(i);
        Repository.add(def);
    }
}
