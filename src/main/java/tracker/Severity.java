package tracker;

public enum Severity {
    LOW("Низкая"),
    MEDIUM("Средняя"),
    HIGH("Высокая");

    final String critName;

    Severity(String critName) {
        this.critName = critName;
    }

    @Override
    public String toString() {
        return critName;
    }

    public static Severity getSeverityByValue(String value) {
        for (Severity item : Severity.values()) {
            if (item.critName.equals(value)) {
                return item;
            }
        }
        return null;
    }
}
