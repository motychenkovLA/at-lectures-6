package tracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Комментарий :" + this.comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        // todo 5 - если obj не CommentAttachment упадет
        CommentAttachment attachment = (CommentAttachment) obj;
        // todo 5 - сравнение строк через ==
        return comment == attachment.comment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(comment);
    }

}
