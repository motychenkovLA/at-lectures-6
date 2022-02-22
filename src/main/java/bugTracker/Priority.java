package bugTracker;

public enum Priority {
    P1("Высокая"),
    P2("Средняя"),
    P3("Низкая");

    private String name;

    Priority(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }
    static Priority findByName(String name) {
        for (Priority priority : Priority.values()) {
            if (priority.getName().equals(name)) {
                return priority;
            }
        }
        return null;
    }
}
