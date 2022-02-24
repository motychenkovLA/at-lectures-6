package Tracker;

public class CommentAttachment extends Attachment{

    String commentAttachment;

    public CommentAttachment(String commentAttachment) {
        this.commentAttachment = commentAttachment;
    }

    @Override
    public String asString() {
        return "Комментарий: " + commentAttachment;
    }
}
