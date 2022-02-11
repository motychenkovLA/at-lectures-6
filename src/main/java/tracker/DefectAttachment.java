package tracker;

public class DefectAttachment extends Attachment {
    long id;
    DefectAttachment(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Id связанного дефекта: " + id;
    }
}
