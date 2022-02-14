package bugTracker;

public class DefectAttachment extends Attachment {
    public String toString(long comment) {
        return "Ссылка на другой дефект во вложении: " + comment;
    }
}
