package tracker;

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
}
