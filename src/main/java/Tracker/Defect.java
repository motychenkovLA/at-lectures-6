package Tracker;

public class Defect {
    //todo апперкейс
    int Id;
    String resume;       //описание дефекта
    String sewerity;  //критичность дефекта
    int daysToFix;       // время на иправление

    //todo нужен конструктор алл аргс

    //    void printDefectInfo(int WORK_WEEK){ //метод для вывода дефекта
//        boolean fixInAWeek = daysToFix < WORK_WEEK;
//        System.out.println(Id + ". Описание: " + resume + "|"
//                         + "  Критичность: " + criticality + "|"
//                         + "  Дней на исправление: " + daysToFix+ "|"
//                         + "  Займёт меньше рабочей недели: " + fixInAWeek);
//    }

    String getInfo(int WORK_WEEK){
        boolean fixInAWeek = daysToFix < WORK_WEEK;
        return Id + ". Описание: " + resume + "|"
                + "  Критичность: " + sewerity + "|"
                + "  Дней на исправление: " + daysToFix+ "|"
                + "  Займёт меньше рабочей недели: " + fixInAWeek;
    }

}
