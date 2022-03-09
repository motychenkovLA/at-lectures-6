package tracker;

import java.util.StringJoiner;

public enum Severity {
    LOW("Низкая"),
    MEDIUM("Средняя"),
    HIGH("Высокая");

    private final String critName;

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

    public static String list() {
        StringJoiner joiner = new StringJoiner(" / ");
        for (Severity item : Severity.values()) {
            joiner.add(item.critName);
        }
        return joiner.toString();
    }
}
