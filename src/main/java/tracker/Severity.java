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
            if (item.toString().equals(value)) { // todo 1 - toString сложно + публичный интерфейс, можно просто само поле вытащить
                return item;
            }
        }
        return null;
    }
}
