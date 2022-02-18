package Tracker;

public class CommentAttachment extends Attachment{

    public CommentAttachment(String attachment) {
        super(attachment);
    }

    @Override
    public String asString() {
        return "Комментарий: " + super.asString();
    }
}
