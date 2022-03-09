package bugTracker;

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
    public boolean equals(Object comment) {
        return (this == comment);
    }

    @Override
    public native int hashCode();
}
