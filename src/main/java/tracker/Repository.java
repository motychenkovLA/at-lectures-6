package tracker;

public class Repository {
    private Defect[] defectsList;
    public int maxBugs; // todo 3 - не приватное
    public Repository(int maxBugs) {
        this.maxBugs = maxBugs;
        defectsList = new Defect[maxBugs];
    }

    // todo 1 - параметр id не используется
    public void addDefect(int id, Defect defect) {
        // todo 5 - содержание дефекта не имеет никакого отношения к его положению в массиве
        defectsList[Defect.getCountDefects()] = defect;
    }

    // todo 3 - возвращается не список дефектов, а список дефектов и нуллов,
    //  + происходит утечка ссылки на приватные данные
    public Defect[] getAllDefects() {
        return defectsList;
    }
}
