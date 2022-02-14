package tracker;

public class DefectAttachment extends Attachment {
    private long id;
    public DefectAttachment(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Id связанного дефекта: " + id;
    }
}
