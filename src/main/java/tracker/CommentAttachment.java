package tracker;

// todo 1 - все еще отступы
public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
            this.comment = comment;
        }

    @Override
    public String toString() {
            return "Комментарий :" + this.comment;
        }

}
