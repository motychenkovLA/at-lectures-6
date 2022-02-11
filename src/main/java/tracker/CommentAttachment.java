package tracker;

public class CommentAttachment extends Attachment {
    String comment;
    CommentAttachment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
}
