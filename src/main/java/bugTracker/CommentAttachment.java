package bugTracker;

import java.util.Objects;

public class CommentAttachment extends Attachment {
    private String value;

    public CommentAttachment(String value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Комментарий во вложении: " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommentAttachment that = (CommentAttachment) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
