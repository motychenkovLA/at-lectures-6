package tracker;

public class Defect {
    // todo 1 - они все и так находятся в классе дефект, нет смысла уточнять что ...Bug
    long idBug;
    String resumeBug;
    String severityBug;
    int daysToFixBug;

    public Defect(long idBug, String resumeBug, String severityBug, int daysToFixBug) {
        this.idBug = idBug;
        this.resumeBug = resumeBug;
        this.severityBug = severityBug;
        this.daysToFixBug = daysToFixBug;
    }


    String getBugsInfo() {
        String bugsInfo = "Id дефекта: " + idBug + " | " + "Резюме: " + resumeBug +
                                " | " + "Критичность: " + severityBug + " | " +
                                "Дней на исправление: " + daysToFixBug;
        return bugsInfo;
    }

}

