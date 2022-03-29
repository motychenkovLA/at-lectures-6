package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
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
        return this.equals(attCom.getComment());
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }
}
