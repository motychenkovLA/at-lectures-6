package Tracker;

public enum DefectPriority {
    LOW("Низкий"),
    MID("Средний"),
    HIGH("Высокий"),
    CRITICAL("Критичный");

    String ruName;

    DefectPriority(String ruName) {
        this.ruName = ruName;
    }
}
