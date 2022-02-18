package Tracker;

        import java.util.Scanner;

//при создании дефекта также предложить пользователю выбрать тип вложения: комментарий или ссылка на другой дефект
//при вводе комментария принять от пользователя строку
//при вводе ссылки на дефект принять id этого дефекта
//прикрепление реализовать в виде класса Attachment с двумя наследниками CommentAttachment для комментария и DefectAttachment для ссылки на дефект
//в классе Attachment создать метод String asString(), возвращающий его строковое представление, переопределить метод в наследниках
//при выводе дефекта на консоль выводить также и вложение, используя его метод asString


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
                    "3.Выход");
            menuItem = scanner.nextInt();
            scanner.nextLine();

            switch (menuItem) {
                case 1: {
                    System.out.println("Введите описание дефекта");
                    String resume = scanner.nextLine(); //заполняем описание
                    System.out.println("Введите критичность дефекта: Low, Mid, High, Critical");
                    String priority = scanner.nextLine(); //заполняем критичность
                    System.out.println("Введите ожидаемое количество дней на исправление");
                    int daysToFix = scanner.nextInt(); //заполняем количество дней на исправление
                    System.out.println("Добавить вложение к дефекту?\n" +
                            "1.Да\n" +
                            "2.Нет");
                    menuItem = scanner.nextInt();
                    scanner.nextLine();

                    switch (menuItem){
                        case 1:{
                            System.out.println("Выберите тип вложения:\n"+
                                    "1.Комментарий\n"+
                                    "2.Ссылка на другой дефект");
                            menuItem = scanner.nextInt();
                            scanner.nextLine();
                            switch (menuItem){
                                case 1:{
                                    System.out.println("Введите комментарий");
                                    CommentAttachment commentAttachment = new CommentAttachment(scanner.nextLine());
                                    Defect defect = new Defect(resume, priority, daysToFix, commentAttachment.asString());
                                    repository.add(defect);
                                    System.out.println("Дефект создан");
                                    break;
                                }
                                case 2:{
                                    System.out.println("Введите id дефекта");
                                    DefectAttachment defectAttachment = new DefectAttachment(scanner.nextLine());
                                    Defect defect = new Defect(resume, priority, daysToFix, defectAttachment.asString());
                                    repository.add(defect);
                                    System.out.println("Дефект создан");
                                    break;
                                }
                            }
                            break;
                        }
                        case 2: {
                            Defect defect = new Defect(resume, priority, daysToFix, "Вложений нет");
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
                        System.out.println(defect.getInfo()); //выводим дефекты
                    }
                    break;
                }
                case 3: {
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