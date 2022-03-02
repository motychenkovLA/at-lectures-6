package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{
    private String idDefect; // todo 3 - long же

    public DefectAttachment(String idDefect) {
        this.idDefect = idDefect;
    }

    public String getIdDefect() {
        return idDefect;
    }

    public void setIdDefect(String idDefect) {
        this.idDefect = idDefect;
    }

    @Override
    public String toString() {
        return idDefect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefectAttachment)) return false;
        DefectAttachment that = (DefectAttachment) o;
        return Objects.equals(idDefect, that.idDefect);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefect);
    }
}
