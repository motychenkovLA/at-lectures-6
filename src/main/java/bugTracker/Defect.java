package bugTracker;
import java.util.concurrent.atomic.AtomicLong;

public class Defect {
    private static final AtomicLong idGenerator = new AtomicLong(1);

    private final Long ID = idGenerator.getAndIncrement();
    private String summary;
    private String priority;
    private int dayCount;
    private Attachment attachment;


    public Defect(String summary, String priority, int dayCount){
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
    }

    public Defect(String summary, String priority, int dayCount, Attachment attachment){
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
        this.attachment = attachment;
    }

    public long getId() { return ID; }
    public String getSummary(){
        return summary;
    }
    public String getPriority(){
        return priority;
    }
    public int getDayCount(){
        return dayCount;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public String getInfo(){

        String info = "ID: " + ID + " | Резюме: " + summary + " | Серьезность: " +
                priority + " | Количество дней на исправление: " +
                dayCount + " | " + attachment;
        return info;
    }

}
