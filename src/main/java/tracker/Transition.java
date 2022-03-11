package tracker;

public class Transition {
    private final Status from;
    private final Status to;

    public Transition(Status from, Status to) {

        this.from = from;
        this.to = to;
    }

    public static boolean dataValidation(Status oldStatus, Status newStatus) {
        return (oldStatus == Status.OPEN && newStatus == Status.IN_WORK) || (oldStatus == Status.IN_WORK && newStatus == Status.CLOSE);
    }

}
