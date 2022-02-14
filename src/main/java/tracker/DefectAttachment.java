package tracker;

// todo 0 - нужны пустые строчки между членами класса
public class DefectAttachment extends Attachment {
    private long id; // todo 1 - можно зафиналить
    public DefectAttachment(long id) {
        this.id = id;
    }
    @Override
    public String toString() {
        return "Id связанного дефекта: " + id;
    }
}
