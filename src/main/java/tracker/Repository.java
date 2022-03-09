package tracker;

import java.util.*;

public class Repository {
    private final Map<Long, Defect> repostory = new HashMap<>();
    private Long currentDefectCount;


    public Repository() {
        currentDefectCount = 0L;
    }

    public void add(Defect defect) {
        repostory.put(currentDefectCount, defect);
        currentDefectCount++;
    }

    public Collection<Defect> getAll() {return this.repostory.values();}

    public Defect getById(long id) {
        Defect targetDefect = null;
        for (long i = 0; i < currentDefectCount; i++) {
            if (repostory.get(i).getId() == id) {
                targetDefect = repostory.get(i);
                break;
            }

        }
        return targetDefect;
    }
}
