package tracker;

public class CommentAttachment extends Attachment {
    String comment; // todo 3 - не приватный
    CommentAttachment(String comment) { // todo 3 - не публичны
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
}
