package tracker;

import java.util.Objects;

public class Transition {
    Status from;
    Status to;

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

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Transition tr = (Transition) a;
        return this.equals(tr.getFrom()) && this.equals(tr.getTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }

}
