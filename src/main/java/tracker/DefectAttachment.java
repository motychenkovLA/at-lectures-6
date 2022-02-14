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

    // todo 1 - не очень читаемое представление
    @Override
    public String toString() {
        return "DefectAttachment{" +
                "idDefect='" + idDefect + '\'' +
                '}';
    }
}
