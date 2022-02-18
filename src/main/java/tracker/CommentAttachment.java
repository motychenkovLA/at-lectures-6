package tracker;

public class CommentAttachment extends Attachment {
    String attachmentСomment;

    public CommentAttachment(String attachmentСomment) {
        this.attachmentСomment = attachmentСomment;
    }

    public String toString() {
        return "Комментарий: " + attachmentСomment;
    }
}
