package Tracker;

public abstract class Attachment {

    String attachment;

    public Attachment(String attachment) {
        this.attachment = attachment;
    }

    public String asString() {
    return attachment;
    }

}
