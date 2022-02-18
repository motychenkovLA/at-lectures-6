package tracker;

public class DefectAttachment extends Attachment {

    int attachmentID;

    public DefectAttachment(int attachmentID) {
        this.attachmentID = attachmentID;
    }

    public String toString() {
        return "Ссылка на дефект: " + attachmentID;
    }
}
