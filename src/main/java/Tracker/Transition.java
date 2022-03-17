package Tracker;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


public class Transition {
    private final static Set<Transition> transitionSet = new HashSet<>();
    static {
        transitionSet.add(new Transition(DefectStatus.NEW, DefectStatus.OPEN));
        transitionSet.add(new Transition(DefectStatus.OPEN, DefectStatus.IN_WORK));
        transitionSet.add(new Transition(DefectStatus.IN_WORK, DefectStatus.CLOSED));
        transitionSet.add(new Transition(DefectStatus.NEW, DefectStatus.CLOSED));
    }

    private final DefectStatus from;
    private final DefectStatus to;

    public Transition(DefectStatus from, DefectStatus to) {
        this.from = from;
        this.to = to;
    }

    public static void TransitionValidate(DefectStatus from, DefectStatus to, long id, Repository repository){
        Transition potentialTransition = new Transition(from, to);
        if (transitionSet.contains(potentialTransition)){
            repository.changeStatus(id, to);
            System.out.println("Статус успешно изменён с " + from.ruName + " на " + to.ruName);
        }
        else System.out.println("Нельзя изменить текущий статус c " + from.ruName + " на " + to.ruName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        return from == that.from && to == that.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
