package Tracker;

        import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        int menuItem; //пункт меню
        Repository repository = new Repository();
        Scanner scanner = new Scanner(System.in);
        boolean isRun = true;


        while (isRun) {
            System.out.println("Выберите действие(укажите номер пункта меню): \n" +
                    "1.Добавить дефект\n" +
                    "2.Вывести список дефектов\n" +
                    "3.Изменить статус дефекта\n" +
                    "4.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            switch (menuItem) {
                case 1: {
                    System.out.println("Введите описание дефекта");
                    String resume = scanner.nextLine(); //заполняем описание
                    System.out.println("Выберите приоритет дефекта:\n" +
                            "1." + DefectPriority.LOW.ruName + "\n" +
                            "2." + DefectPriority.MID.ruName + "\n" +
                            "3." + DefectPriority.HIGH.ruName + "\n" +
                            "4." + DefectPriority.CRITICAL.ruName);
                    menuItem = scanner.nextInt();
                    scanner.nextLine();
                    String priority;
                    switch (menuItem) {             //заполняем приоритет
                        case 1: priority = DefectPriority.LOW.ruName; break;
                        case 2: priority = DefectPriority.MID.ruName; break;
                        case 3: priority = DefectPriority.HIGH.ruName; break;
                        case 4: priority = DefectPriority.CRITICAL.ruName; break;
                        default: priority = "Не указан";
                    }
                    System.out.println("Введите ожидаемое количество дней на исправление");
                    int daysToFix = scanner.nextInt(); //заполняем количество дней на исправление
                    System.out.println("Добавить вложение к дефекту?\n" +
                            "1.Да\n" +
                            "2.Нет");
                    menuItem = scanner.nextInt();
                    scanner.nextLine();

                    switch (menuItem) {
                        case 1: {
                            System.out.println("Выберите тип вложения:\n" +
                                    "1.Комментарий\n" +
                                    "2.Ссылка на другой дефект");
                            menuItem = scanner.nextInt();
                            scanner.nextLine();
                            switch (menuItem) {
                                case 1: {
                                    System.out.println("Введите комментарий");
                                    CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                                    Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW.ruName, commentAttachment.asString());
                                    repository.add(defect);
                                    System.out.println("Дефект создан");
                                    break;
                                }
                                case 2: {
                                    System.out.println("Введите id дефекта");
                                    DefectAttachment defectAttachment = new DefectAttachment(scanner.nextInt());
                                    Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW.ruName, defectAttachment.asString());
                                    repository.add(defect);
                                    System.out.println("Дефект создан");
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            Defect defect = new Defect(resume, priority, daysToFix, DefectStatus.NEW.ruName, "Вложений нет");
                            repository.add(defect);
                            System.out.println("Дефект создан");
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Список дефектов:");
                    for (Defect defect : repository.getAll()) {
                        System.out.println(defect.getInfo());       //выводим дефекты
                    }
                    break;
                }
                case 3: {
                    System.out.println("Введите id дефекта");
                    int id = scanner.nextInt();
                    boolean found = false;
                    int searchCounter = 0;
                        while (!found && searchCounter < repository.getCounter()) {   //проверяем если ли такой дефект
                           found = repository.equals(id, searchCounter);
                           searchCounter++;
                        }
                        if (found) {
                            System.out.println("Выберите статус дефекта:\n" +   //меняем статус
                            "1." + DefectStatus.NEW.ruName + "\n" +
                            "2." + DefectStatus.OPEN.ruName + "\n" +
                            "3." + DefectStatus.CLOSED.ruName);
                            menuItem = scanner.nextInt();
                            scanner.nextLine();
                            switch (menuItem) {
                                case 1: repository.changeStatus(searchCounter-1, DefectStatus.NEW.ruName); break;
                                case 2: repository.changeStatus(searchCounter-1, DefectStatus.OPEN.ruName); break;
                                case 3: repository.changeStatus(searchCounter-1, DefectStatus.CLOSED.ruName); break;
                                default: System.out.println("Нет такого пункта меню. Статус не был изменён");
                            }

                    }
                    else System.out.println("Такого дефекта нет!");
                    break;
//
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