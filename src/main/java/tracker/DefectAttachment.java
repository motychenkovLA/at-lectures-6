package tracker;

// todo 5 - класс нигде не используется
public class DefectAttachment extends Attachment{
    private String idDefect;

    public DefectAttachment(String attachmentType, String idDefect) {
        super(attachmentType);
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
        return "DefectAttachment{" +
                "idDefect='" + idDefect + '\'' +
                '}';
    }
}
