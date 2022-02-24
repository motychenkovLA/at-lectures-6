package Tracker;

public class DefectAttachment extends Attachment{

    int defectAttachment;

    public DefectAttachment(int defectAttachment) {
        this.defectAttachment = defectAttachment;
    }

    @Override
    public String asString() {
        return "Связанный дефект: ID:" + defectAttachment;
    }
}
