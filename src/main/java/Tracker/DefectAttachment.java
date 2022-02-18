package Tracker;

public class DefectAttachment extends Attachment{
    public DefectAttachment(String attachment) {
        super(attachment);
    }

    @Override
    public String asString() {
        return "Связанный дефект: ID:" + super.asString();
    }
}
