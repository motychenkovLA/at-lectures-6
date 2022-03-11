package tracker;

import java.util.*;
import java.util.stream.Collectors;

public class Repository {

    private final Map<Long, Defect> data = new HashMap<>();

    public void add(Defect defect) {
        data.put(defect.getId(), defect);
    }

    public Collection<Defect> getAll() {
        return this.data.values();
    }

    public Defect getById(long id) {
        return data.get(id);
    }

    public Map<Status, Long> getStatisticsByStatus() {
        return data.values().stream().collect(Collectors.groupingBy(Defect::getStatus, Collectors.counting()));
    }

    public IntSummaryStatistics getStatisticsByDaysToFix() {
        return data.values().stream().collect(Collectors.summarizingInt(Defect::getDaysToFix));
    }
}
