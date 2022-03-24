package Tracker;

import java.util.*;
import java.util.stream.Collectors;

//        добавить в главное меню "stats" для вывода статистики по заведенным дефекта
//        при выводе статистики отображать: максимальное, среднее, минимальное количество дней на исправление и таблицу вида "статус - количество дефектов в этом статусе"
//        расчет статистик выполнять через stream api


public class Main {
    public static void main(String[] args) {

        Map<Long, Defect> defectMap = new HashMap<>();
        boolean isRun = true;

        try(Scanner scanner = new Scanner(System.in)) {

            while (isRun) {
                System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                        "1.Добавить дефект\n" +
                        "2.Вывести список дефектов\n" +
                        "3.Изменить статус дефекта\n" +
                        "4.Вывести статистику\n" +
                        "5.Выход");

                int mainMenuItem = checkInt(scanner);

                switch (mainMenuItem) {
                    case 1: {
                        addDefect(scanner, defectMap);
                        break;
                    }
                    case 2: {
                        defectOutput(defectMap);
                        break;
                    }
                    case 3: {
                        changeStatus(scanner, defectMap);
                        break;
                    }
                    case 4: {
                        statsOutput(defectMap);
                        break;
                    }
                    case 5: {
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


    public static void addDefect(Scanner scanner, Map<Long, Defect> defectMap){
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
                        defectMap.put(defect.getId(), defect);
                        System.out.println("Дефект создан");
                        break;
                    }
                    case 2: {
                        System.out.println("Введите id дефекта");
                        DefectAttachment defectAttachment = new DefectAttachment(checkInt(scanner));
                        Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW, defectAttachment);
                        defectMap.put(defect.getId(), defect);
                        System.out.println("Дефект создан");
                        break;
                    }
                }
                break;
            }
            default: {
                Attachment attachment = new Attachment();
                Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW, attachment);
                defectMap.put(defect.getId(), defect);
                System.out.println("Дефект создан");
                break;
            }
        }
    }


    public static void defectOutput(Map<Long, Defect> defectMap){
        System.out.println("Список дефектов:");
        for (Defect value : defectMap.values()) {
            System.out.println(value.getInfo());
        }
    }

    public static void changeStatus(Scanner scanner, Map<Long, Defect> defectMap){
        System.out.println("Введите id дефекта");
        long id = checkInt(scanner);
        DefectStatus currentStatus = defectMap.get(id).getStatus();
        if (defectMap.containsKey(id)) {
            System.out.println("Выберите статус дефекта:\n" +   //меняем статус
                    "1." + DefectStatus.NEW.ruName + "\n" +
                    "2." + DefectStatus.OPEN.ruName + "\n" +
                    "3." + DefectStatus.IN_WORK.ruName + "\n" +
                    "4." + DefectStatus.CLOSED.ruName);
           int menuItem = checkInt(scanner);
            switch (menuItem) {
                case 1:
                   if (Transition.validate(currentStatus,DefectStatus.NEW)) {
                       defectMap.get(id).setStatus(DefectStatus.NEW);
                       System.out.println("Статус успешно изменён с " +  currentStatus.ruName + " на " + DefectStatus.NEW.ruName);
                   }
                    else System.out.println("Нельзя изменить текущий статус c " + currentStatus.ruName + " на " + DefectStatus.NEW.ruName);
                   break;
                case 2:
                    if (Transition.validate( currentStatus, DefectStatus.OPEN)) {
                        defectMap.get(id).setStatus(DefectStatus.OPEN);
                        System.out.println("Статус успешно изменён с " +  currentStatus.ruName + " на " + DefectStatus.OPEN.ruName);
                    }
                    else System.out.println("Нельзя изменить текущий статус c " +  currentStatus.ruName + " на " + DefectStatus.OPEN.ruName);
                    break;
                case 3:
                    if (Transition.validate(currentStatus, DefectStatus.IN_WORK)) {
                        defectMap.get(id).setStatus(DefectStatus.IN_WORK);
                        System.out.println("Статус успешно изменён с " + currentStatus.ruName + " на " + DefectStatus.IN_WORK.ruName);
                    }
                    else System.out.println("Нельзя изменить текущий статус c " + currentStatus.ruName + " на " + DefectStatus.IN_WORK.ruName);
                    break;
                case 4:
                    if (Transition.validate(currentStatus, DefectStatus.CLOSED)) {
                        defectMap.get(id).setStatus(DefectStatus.CLOSED);
                        System.out.println("Статус успешно изменён с " + currentStatus.ruName + " на " + DefectStatus.CLOSED.ruName);
                    }
                    else System.out.println("Нельзя изменить текущий статус c " + currentStatus.ruName + " на " + DefectStatus.CLOSED.ruName);
                    break;
                default:
                    System.out.println("Нет такого пункта меню. Статус не был изменён");
            }
        } else System.out.println("Такого дефекта нет!");
    }

    public static void statsOutput(Map<Long, Defect> defectMap){
        IntSummaryStatistics intSummaryStatistics = defectMap.values().stream().collect(Collectors.summarizingInt(Defect::getDaysToFix));
        System.out.println(
                "Максимальное количество дней на исправление дефекта: " + intSummaryStatistics.getMax() + "\n" +
                "Минимальное количество дней на исправление дефекта: " + intSummaryStatistics.getMin() + "\n" +
                "Среднее количество дней на исправление дефекта: " + intSummaryStatistics.getAverage() + "\n");

        Map<DefectStatus, Long> statusStats = defectMap.values().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
        for (Map.Entry<DefectStatus, Long> longEntry : statusStats.entrySet()) {
            System.out.println("Количество дефектов в статусе " + longEntry);
        }
    }


    static int checkInt(Scanner scanner){
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

