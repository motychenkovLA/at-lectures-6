package tracker;

public class DefectAttachment extends Attachment {

    private int link;

    public DefectAttachment(int link) {
        this.link = link;
    }

    public String toString() {
        return "Ссылка на дефект: " + link;
    }
}
