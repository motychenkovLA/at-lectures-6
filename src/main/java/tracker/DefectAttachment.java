package tracker;

public class DefectAttachment extends Attachment {
    long id; // todo 3 - не приватный
    DefectAttachment(long id) { // todo 3 - не публичный
        this.id = id;
    }
    @Override
    public String toString() {
        return "Id связанного дефекта: " + id;
    }
}
