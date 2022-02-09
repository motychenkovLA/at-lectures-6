package tracker;


public class Defect {
    // todo 0 - лучше статик поля объявить до не-статик полей
    //   финалить что-то кроме id не обязательно, но в принципе можно
    //   гетеры-сеттеры пока не используются, но можно добавить
    private final String resume;
    private final String critical;
    private final int numberOfDays;
    private static long numberOfDefects=0;
    private final long id;
    public Defect(String resume, String critical, int numberOfDays) {
        numberOfDefects++;
        this.id = numberOfDefects;
        this.resume = resume;
        this.critical = critical;
        this.numberOfDays = numberOfDays;
    }

    public String getDefectInfo() {
        return "" + id + " | " + resume + " | " + critical + " | " + numberOfDays;
    }
}
