package tracker;

import java.util.HashSet;
import java.util.Objects;
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
        Transition newTransition = new Transition(oldStatus, newStatus);
        return transitions.contains(newTransition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from != null && from.equals(that.from) && to != null && to.equals(that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
