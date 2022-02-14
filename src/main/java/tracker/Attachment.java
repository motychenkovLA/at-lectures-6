package tracker;

// todo 5 - класс нигде не используется
public class Attachment {
    private String attachmentType;

    public Attachment(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    public String getAttachment() {
        return attachmentType;
    }

    public void setAttachment(String attachment) {
        this.attachmentType = attachment;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachment='" + attachmentType + '\'' +
                '}';
    }
}
