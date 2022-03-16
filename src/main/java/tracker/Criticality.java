package tracker;

public enum Criticality {
    BLOCKER,
    CRITICAL,
    MAJOR,
    MINOR,
    TRIVIAL;

    public static Criticality getCriticality(String critical) {
        for (Criticality criticality : Criticality.values()) {
            if (critical.equals(criticality.toString())) {
                return criticality;
            }
        }
        return null;
    }
}
