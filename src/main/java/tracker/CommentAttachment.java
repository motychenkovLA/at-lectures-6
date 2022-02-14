package tracker;

// todo 5 - класс нигде не используется
public class CommentAttachment extends Attachment{

    private String comment;

    public CommentAttachment(String attachmentType, String comment) {
        super(attachmentType);
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "CommentAttachment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
