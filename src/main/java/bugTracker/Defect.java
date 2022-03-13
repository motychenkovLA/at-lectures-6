package bugTracker;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class Defect {
    private static final AtomicLong idGenerator = new AtomicLong(1000);

    private final Long ID = idGenerator.getAndIncrement();
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
    public Status getStatus(){ return status; }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Defect defect = (Defect) o;
        return ID.equals(defect.ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID);
    }
}
