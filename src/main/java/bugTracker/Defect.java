package bugTracker;
import java.util.concurrent.atomic.AtomicInteger;

public class Defect {
    private static final AtomicInteger idGenerator = new AtomicInteger(1);

    private final Integer ID = idGenerator.getAndIncrement();
    private String summary;
    private String priority;
    private int dayCount;
    private Attachment attachment;
    private Status status;


    public Defect(String summary, Priority priority, int dayCount){
        this.summary = summary;
        this.priority = priority.getName();
        this.dayCount = dayCount;
        this.status = Status.OPEN;
    }

    public Defect(String summary, Priority priority, int dayCount, Attachment attachment){
        this.summary = summary;
        this.priority = priority.getName();
        this.dayCount = dayCount;
        this.attachment = attachment;
        this.status=Status.OPEN;
    }

    public int getId() { return ID; }
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
        Priority.findByName(priority);
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getInfo(){

        String info = "ID: " + ID + " | Резюме: " + summary + " | Серьезность: " +
                priority + " | Количество дней на исправление: " +
                dayCount + " | " + attachment + " | Статус дефекта: " + status.getName();
        return info;
    }

}
