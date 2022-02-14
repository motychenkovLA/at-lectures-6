package tracker;

public class DefectAttachment extends Attachment{
    private String idDefect;

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
}
