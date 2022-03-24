package tracker;

import java.util.Objects;

public class Transition {
    Status from;
    Status to;

    public Transition(Status from, Status to){
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object a) {
        if (this == a) return true;
        if (a == null || getClass() != a.getClass()) return false;
        Transition tr = (Transition) a;
        return Objects.equals(from, tr.from) && Objects.equals(to, tr.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from,to);
    }

}
