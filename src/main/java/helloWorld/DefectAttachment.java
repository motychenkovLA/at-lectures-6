package helloWorld;

public class DefectAttachment extends Attachment {

    private int idDefect;

    public DefectAttachment(int idDefect) {
        this.idDefect = idDefect;
    }

        public String toString() {
        return "Ссылка на дефект " + idDefect;

    }
}
