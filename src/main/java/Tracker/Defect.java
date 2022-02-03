package Tracker;

public class Defect {
    int Id;
    String resume;       //описание дефекта
    String criticality;  //критичность дефекта
    int daysToFix;       // время на иправление

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
                + "  Критичность: " + criticality + "|"
                + "  Дней на исправление: " + daysToFix+ "|"
                + "  Займёт меньше рабочей недели: " + fixInAWeek;
    }

}
