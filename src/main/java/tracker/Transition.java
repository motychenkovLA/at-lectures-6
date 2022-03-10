package tracker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transition {

    private static final Set<Transition> transitions = new HashSet<>();

    static  {
        transitions.add(new Transition(Status.OPEN, Status.IN_PROGRESS));
        transitions.add(new Transition(Status.OPEN, Status.DELAYED));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.TESTING));
        transitions.add(new Transition(Status.IN_PROGRESS, Status.DELAYED));
        transitions.add(new Transition(Status.TESTING, Status.CLOSE));
        transitions.add(new Transition(Status.TESTING, Status.REOPEN));
        transitions.add(new Transition(Status.CLOSE, Status.REOPEN));
        transitions.add(new Transition(Status.DELAYED, Status.IN_PROGRESS));
        transitions.add(new Transition(Status.DELAYED, Status.TESTING));
    }

    private final Status from;
    private final Status to;

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public Status getFrom() {
        return from;
    }

    public Status getTo() {
        return to;
    }

    public static List<Status> getValidStatuses(Status status) {
        List<Status> statusList = new ArrayList<>();
        for (Transition item : transitions) {
            if (item.getFrom().equals(status)) {
                statusList.add(item.getTo());
            }
        }
        return statusList;
    }
}