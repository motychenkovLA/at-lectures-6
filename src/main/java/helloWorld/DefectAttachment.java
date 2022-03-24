package helloWorld;

import java.util.Objects;

public class DefectAttachment extends Attachment {

    private int idDefect;

    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект " + this.idDefect;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DefectAttachment)) {
            return false;
        }

        DefectAttachment attachment = (DefectAttachment) obj;
        return idDefect == attachment.idDefect;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDefect);

    }
}
//