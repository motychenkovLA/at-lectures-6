package tracker;

public enum Status {
    OPEN("Открыт"),
    INPROGRESS("Исправление"),
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
