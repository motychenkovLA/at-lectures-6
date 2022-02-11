package tracker;

public abstract class Attachment {
    long id = 3; // todo 3 - что это моделирует?

    // todo 1 - данная реализация нигде не используется
    @Override
    public String toString() {
        return "Attachment{" +
                "id='" + id + '\'' +
                '}';
    }
}
