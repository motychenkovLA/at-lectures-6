package tracker;

public class CommentAttachment extends Attachment {
    private String comment;
    public CommentAttachment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
}
