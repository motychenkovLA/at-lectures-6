package tracker;

public enum Status {
    OPEN("открыт"),
    INWORK("в работе"),
    CLOSED("закрыт");

    private final String inRus;

    Status(String inRus) {
        this.inRus = inRus;
    }

    public String getInRus() {
        return inRus;
    }

    public static Status getStatus(String statusInput) {
        for (Status status : Status.values()) {
            if (status.getInRus().equals(statusInput)) {// todo 1 - раз внутри класса, можно не вызывать геттер а взять поле напрямую
                return status;
            }
        }
        return null;
    }
}
