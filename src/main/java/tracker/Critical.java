package tracker;

// todo 0 - скорее всего это Severity
public enum Critical {
    LOW("Низкая"),
    MEDIUM("Средняя"),
    HIGH("Высокая");

    final String critName;

    Critical(String critName) {
        this.critName = critName;
    }

    @Override
    public String toString() {
        return critName;
    }
}
