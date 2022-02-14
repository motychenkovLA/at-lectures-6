package tracker;

public class CommentAttachment extends Attachment {

    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    // todo 1 - не очень читаемое представление
    @Override
    public String toString() {
        return "CommentAttachment{" +
                "comment='" + comment + '\'' +
                '}';
    }
}
