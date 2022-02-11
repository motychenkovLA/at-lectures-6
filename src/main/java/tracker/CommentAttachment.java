package tracker;

public class CommentAttachment extends Attachment {
    private final String comment;

    public CommentAttachment(String comment) {
            this.comment = comment;
        }

        // todo 0 - отступ
        @Override
        public String toString() {
            return "Комментарий :" + this.comment;
        }

}
