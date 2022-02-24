package Tracker;

public enum DefectStatus {
    NEW("Новый"),
    OPEN("Открытый"),
    CLOSED("Закрытый");


    String ruName;

    DefectStatus(String ruName) {
        this.ruName = ruName;
    }
}
