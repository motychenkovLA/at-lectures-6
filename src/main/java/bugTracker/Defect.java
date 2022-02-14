package bugTracker;
import java.util.concurrent.atomic.AtomicLong;

public class Defect {
    private static final AtomicLong idGenerator = new AtomicLong(1);

    private final Long ID = idGenerator.getAndIncrement();
    private String summary;
    private String priority;
    private int dayCount;
    private long defectAttachment;
    private String commentAttachment;
    private String finalAttachment;


    public Defect(String summary, String priority, int dayCount){
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
    }

    public Defect(String summary, String priority, int dayCount, String commentAttachment){
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
        this.commentAttachment = commentAttachment;
    }

    public Defect(String summary, String priority, int dayCount, long comment){
        this.summary = summary;
        this.priority = priority;
        this.dayCount = dayCount;
        this.defectAttachment = comment;
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
        if (commentAttachment != null) {
            CommentAttachment commentAttach = new CommentAttachment();
            finalAttachment = commentAttach.toString(commentAttachment);;
        } else if (defectAttachment != 0) {
            DefectAttachment defectAttach = new DefectAttachment();
            finalAttachment = defectAttach.toString(defectAttachment);
        } else {
            finalAttachment = "Нет комментариев";
        }

        String info = "ID: " + ID + " | Резюме: " + summary + " | Серьезность: " +
                priority + " | Количество дней на исправление: " +
                dayCount + " | " + finalAttachment;
        return info;
    }

}
