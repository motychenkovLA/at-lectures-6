package Tracker;

public enum DefectStatus {
    NEW("Новый"),
    OPEN("Открытый"),
    IN_WORK("В работе"),
    CLOSED("Закрытый");


    final String  ruName;

    DefectStatus(String ruName) {
        this.ruName = ruName;
    }
}
