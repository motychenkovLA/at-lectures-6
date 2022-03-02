package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment{
    private long idDefect;

    public DefectAttachment(long idDefect) {
        this.idDefect = idDefect;
    }

    public long getIdDefect() {
        return idDefect;
    }

    public void setIdDefect(long idDefect) {
        this.idDefect = idDefect;
    }

    @Override
    public String toString() {

        return String.valueOf(idDefect);
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
