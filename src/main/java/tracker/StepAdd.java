package tracker;

import java.util.Scanner;

public class StepAdd {
    public static void addDefect() {
        Scanner scanner = new Scanner(System.in);
        Defect def;
        System.out.println("Введите резюме дефекта");
        String name = scanner.nextLine();
        System.out.println("Введите критичность дефекта из списка: \n BLOCKER \n CRITICAL\n MAJOR \n" +
                " MINOR\n TRIVIAL");
        Criticality criticality = Criticality.valueOf(scanner.nextLine());
        System.out.println("Выберите тип вложения: \n для добавления комментария введите comment \n " +
                "для добавления ссылки на другой дефект введите link");
        String attachment = scanner.nextLine();
        if (attachment.equals("comment")) {
            System.out.println("Введите комментарий");
            CommentAttachment attCom = new CommentAttachment(scanner.nextLine());
            def = new Defect(name, criticality, attCom);
        } else if (attachment.equals("link")) {
            System.out.println("Введите ссылку на дефект в виде ID этого дефекта");
            DefectAttachment attDef = new DefectAttachment(scanner.nextInt());
            scanner.nextLine();
            def = new Defect(name, criticality, attDef);
        } else {
            System.out.println("Введена несуществующая операция \n");
            return;
        }
        System.out.println("Введите ожидаемое количество дней на исправление дефекта");
        def.setDaysNumber(scanner.nextInt());
        scanner.nextLine();
        Repository.add(def);
    }
}
