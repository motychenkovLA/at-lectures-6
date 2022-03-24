package helloWorld;

import java.util.Objects;

public class CommentAttachment extends Attachment {

    private String comment;

    public CommentAttachment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return comment;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        if (this.hashCode() != obj.hashCode()) return false;
        CommentAttachment commentAttachment = (CommentAttachment) obj;
        return this.comment.equals(commentAttachment.comment);
    }

    @Override
    public int hashCode() {
        return comment.hashCode();
    }


}
//