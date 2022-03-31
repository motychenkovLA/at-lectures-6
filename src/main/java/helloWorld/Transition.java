package helloWorld;

import java.util.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Transition {
    Status statusFrom;
    Status statusTo;
    private static Set<Transition> SET_OF_TRANSITION = new HashSet<>();

    public Transition(Status statusFrom, Status statusTo) {
        this.statusFrom = statusFrom;
        this.statusTo = statusTo;
    }

    static {
        SET_OF_TRANSITION.add(new Transition(Status.OPEN, Status.INWORK));
        SET_OF_TRANSITION.add(new Transition(Status.OPEN, Status.ANALYSIS));
        SET_OF_TRANSITION.add(new Transition(Status.INWORK, Status.CLOSED));
        SET_OF_TRANSITION.add(new Transition(Status.ANALYSIS, Status.CLOSED));
    }

    public static List<Status> getValidStatus(Status currentStatus) {

        List<Status> statusList = new ArrayList<>();
        for (Transition transition : SET_OF_TRANSITION) {
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


