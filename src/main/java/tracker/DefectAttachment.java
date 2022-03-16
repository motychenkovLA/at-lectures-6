package tracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {

    private int link;

    public DefectAttachment(int link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Ссылка на дефект: " + link;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        DefectAttachment attDef = (DefectAttachment) a;
        return link == attDef.link;
    }

    @Override
    public int hashCode() {
        return Objects.hash(link);
    }
}
