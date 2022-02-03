package bugTracker;

public class Defect {
    long id;
    String summary;
    String priority;
    int dayCount;

    public Defect(long id, String summary, String priority, int dayCount){
        this.id = id;
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
    }

    public long getId() { return id; }
    public String getSummary(){
        return summary;
    }
    public String getPriority(){
        return priority;
    }
    public int getDayCount(){
        return dayCount;
    }


}
