package tracker;

import java.util.HashSet;
import java.util.Set;

public class Transition {
    private final Status from;
    private final Status to;
    private final static Set<Transition> transitions = new HashSet<>();
    static {
        transitions.add(new Transition(Status.OPEN, Status.IN_WORK));
        transitions.add(new Transition(Status.IN_WORK, Status.CLOSE));
    }
    public Transition(Status from, Status to) {
        this.from = from;
        this.to = to;
    }

    public static boolean dataValidation(Status oldStatus, Status newStatus) {
        // todo 3 - Set.contains
        for (Transition transition: transitions) {
            if (transition.from.equals(oldStatus) && transition.to.equals(newStatus)) {
                return true;
            }
        }
        return false;
    }

}
