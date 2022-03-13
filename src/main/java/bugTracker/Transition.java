package bugTracker;

import java.util.HashSet;
import java.util.Set;

public class Transition {
    private Status from;
    private Status to;
    private static Set<Transition> SET_OF_TRANSITION = new HashSet<>();
    static {
        SET_OF_TRANSITION.add(new Transition(Status.OPEN,Status.IN_WORK));
        SET_OF_TRANSITION.add(new Transition(Status.OPEN,Status.REJECTED));
        SET_OF_TRANSITION.add(new Transition(Status.IN_WORK,Status.CLOSED));
        SET_OF_TRANSITION.add(new Transition(Status.REJECTED,Status.CLOSED));
    }

    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public static boolean checkTransition(String from, String to) {
        return SET_OF_TRANSITION.stream().anyMatch(transition -> transition.from.getName().equals(from) &&
                transition.to.getName().equals(to));
    }
}
