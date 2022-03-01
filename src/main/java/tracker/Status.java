package tracker;

import java.util.StringJoiner;

public enum Status {
    OPEN("Открыт"),
    IN_PROGRESS("Исправление"),
    TESTING("Тестирование"),
    DELAYED("Отложен"),
    CLOSE("Закрыт");

    private final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
    public static Status getStatusByValue(String value) {
        for (Status item : Status.values()) {
            if (item.statusName.equals(value)) {
                return item;
            }
        }
        return null;
    }

    public static String list() {
        StringJoiner joiner = new StringJoiner(" / ");
        for (Status item : Status.values()) {
            joiner.add(item.statusName);
        }
        return joiner.toString();
    }
}
