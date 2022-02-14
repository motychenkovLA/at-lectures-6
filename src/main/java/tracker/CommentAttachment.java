package tracker;

// todo 0 - нужны пустые строчки между членами класса
public class CommentAttachment extends Attachment {
    private String comment; // todo 1 - можно зафиналить
    public CommentAttachment(String comment) {
        this.comment = comment;
    }
    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }
}
