package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий: " + comment;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        CommentAttachment attCom = (CommentAttachment) a;
        return Objects.equals(comment, attCom.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
