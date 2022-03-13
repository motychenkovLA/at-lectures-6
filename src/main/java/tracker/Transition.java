package tracker;

import java.util.*;

public class Transition {

    private final Status statusFrom;
    private final Status statusTo;
    private static final Set<Transition> transitions = new HashSet<>();

    public Transition(Status statusFrom, Status statusTo) {
        this.statusFrom = statusFrom;
        this.statusTo = statusTo;
    }

    static  {
        transitions.add(new Transition(Status.OPEN, Status.INWORK));
        transitions.add(new Transition(Status.INWORK, Status.CLOSED));
        transitions.add(new Transition(Status.OPEN, Status.CLOSED));
    }

    public static List<Status> getValidStatus(Status currentStatus) {
        List<Status> statusList = new ArrayList<>();
        for (Transition transition : transitions) {
            if (transition.getStatusFrom().equals(currentStatus)) {
                statusList.add(transition.getStatusTo());
            }
        }
        return statusList;
    }

    public Status getStatusFrom() {
        return statusFrom;
    }

    public Status getStatusTo() {
        return statusTo;
    }
}
