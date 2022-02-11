package tracker;

public class DefectAttachment extends Attachment {
    private final int defectId;

    public DefectAttachment(int defectId) {
        this.defectId = defectId;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект № :" + this.defectId;
    }

}
