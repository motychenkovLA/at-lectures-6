package Tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{

    int defectAttachment;

    public DefectAttachment(int defectAttachment) {
        this.defectAttachment = defectAttachment;
    }

    @Override
    public String asString() {
        return "Связанный дефект: ID:" + defectAttachment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return defectAttachment == that.defectAttachment;
    }

    @Override
    public int hashCode() {
        return Objects.hash(defectAttachment);
    }
}
