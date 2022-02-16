package tracker;

public enum Status {
    OPEN("Открыт"),
    INPROGRESS("Исправление"), // todo 0 - IN_PROGRESS
    TESTING("Тестирование"),
    DELAYED("Отложен"),
    CLOSE("Закрыт");

    final String statusName;

    Status(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return statusName;
    }
}
