package bugTracker;

public class CommentAttachment extends Attachment {
    private String value;

    public CommentAttachment(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Комментарий во вложении: " + value;
    }
}
