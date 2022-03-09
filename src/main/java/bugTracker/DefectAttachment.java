package bugTracker;

import java.util.Objects;

public class DefectAttachment extends Attachment {
    private long value;

    public DefectAttachment(long value){
        this.value = value;
    }

    @Override
    public String toString() {
        return "Ссылка на другой дефект во вложении: " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefectAttachment that = (DefectAttachment) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
