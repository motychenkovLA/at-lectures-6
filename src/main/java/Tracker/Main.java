package Tracker;


//        заменить класс Repository на Map<Long, Defect> +
//        добавить класс Transition представляющий валидный переход между статусами дефекта с полями from и to +
//        добавить Set<Transition> для хранения всех валидных переходов между статусами +
//        при смене статуса пользователем проверять валидность +

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();
        boolean isRun = true;


        try(Scanner scanner = new Scanner(System.in)) {

            while (isRun) {
                System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                        "1.Добавить дефект\n" +
                        "2.Вывести список дефектов\n" +
                        "3.Изменить статус дефекта\n" +
                        "4.Выход");

                int mainMenuItem = checkInt(scanner);

                switch (mainMenuItem) {
                    case 1: {
                        addDefect(scanner, repository);
                        break;
                    }
                    case 2: {
                        defectOutput(repository);
                        break;
                    }
                    case 3: {
                        changeStatus(scanner, repository);
                        break;
                    }
                    case 4: {
                        System.out.println("До новых встреч!");
                        isRun = false;
                        break;
                    }
                    default: {
                        System.out.println("Нет такого пункта меню!");
                        System.out.println();
                    }
                }
            }
        }
    }


    public static void addDefect(Scanner scanner, Repository repository){
        int menuItem;
        System.out.println("Введите описание дефекта");
        String resume = scanner.nextLine();     //заполняем описание
        System.out.println("Выберите приоритет дефекта:\n" +
                "1." + DefectPriority.LOW.ruName + "\n" +
                "2." + DefectPriority.MID.ruName + "\n" +
                "3." + DefectPriority.HIGH.ruName + "\n" +
                "4." + DefectPriority.CRITICAL.ruName);
        menuItem = checkInt(scanner);
        DefectPriority priority;
        switch (menuItem) {             //заполняем приоритет
            case 1:
                priority = DefectPriority.LOW;
                break;
            case 2:
                priority = DefectPriority.MID;
                break;
            case 3:
                priority = DefectPriority.HIGH;
                break;
            case 4:
                priority = DefectPriority.CRITICAL;
                break;
            default:
                System.out.println("Нет такого приоритета! Будет выставлен средний приоритет по умолчанию");
                priority = DefectPriority.MID;
        }
        System.out.println("Введите ожидаемое количество дней на исправление");
        int daysToFix = checkInt(scanner); //заполняем количество дней на исправление

        System.out.println("Добавить вложение к дефекту?\n" +
                "1.Да\n" +
                "2.Нет");
        menuItem = checkInt(scanner);

        switch (menuItem) {
            case 1: {
                System.out.println("Выберите тип вложения:\n" +
                        "1.Комментарий\n" +
                        "2.Ссылка на другой дефект");
                menuItem = checkInt(scanner);
                switch (menuItem) {
                    case 1: {
                        System.out.println("Введите комментарий");
                        CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                        Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW, commentAttachment);
                        repository.add(defect);
                        System.out.println("Дефект создан");
                        break;
                    }
                    case 2: {
                        System.out.println("Введите id дефекта");
                        DefectAttachment defectAttachment = new DefectAttachment(checkInt(scanner));
                        Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW, defectAttachment);
                        repository.add(defect);
                        System.out.println("Дефект создан");
                        break;
                    }
                }
                break;
            }
            default: {
                Attachment attachment = new Attachment();
                Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW, attachment);
                repository.add(defect);
                System.out.println("Дефект создан");
                break;
            }
        }
    }


    public static void defectOutput(Repository repository){
        System.out.println("Список дефектов:");
        repository.getAll();
    }

    public static void changeStatus(Scanner scanner, Repository repository){
        System.out.println("Введите id дефекта");
        int id = checkInt(scanner);
        if (repository.checkId(id)) {
            System.out.println("Выберите статус дефекта:\n" +   //меняем статус
                    "1." + DefectStatus.NEW.ruName + "\n" +
                    "2." + DefectStatus.OPEN.ruName + "\n" +
                    "3." + DefectStatus.IN_WORK.ruName + "\n" +
                    "4." + DefectStatus.CLOSED.ruName);
           int menuItem = checkInt(scanner);

            switch (menuItem) {
                case 1:
                   Transition.TransitionValidate(repository.getStatus(id), DefectStatus.NEW, id, repository);
                   break;
                case 2:
                    Transition.TransitionValidate(repository.getStatus(id), DefectStatus.OPEN, id, repository);
                    break;
                case 3:
                    Transition.TransitionValidate(repository.getStatus(id), DefectStatus.IN_WORK, id, repository);
                    break;
                case 4:
                    Transition.TransitionValidate(repository.getStatus(id), DefectStatus.CLOSED, id, repository);
                    break;
                default:
                    System.out.println("Нет такого пункта меню. Статус не был изменён");
            }
        } else System.out.println("Такого дефекта нет!");
    }

    public static int checkInt(Scanner scanner){
        while (true){
            try {
                return Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Неверный формат! Необходимо ввести число.");
            }
        }
    }
}

