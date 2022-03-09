package bugTracker;

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
    public boolean equals(Object bugId) {
        return (this == bugId);
    }

    @Override
    public native int hashCode();
}
