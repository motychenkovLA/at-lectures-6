package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private final int defectId;

    public DefectAttachment(int defectId) {
        this.defectId = defectId;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект № :" + this.defectId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }
        // todo 5 - если obj не DefectAttachment упадет
        DefectAttachment attachment = (DefectAttachment) obj;
        return defectId == attachment.defectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defectId);
    }

}
