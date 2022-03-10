package tracker;

import java.util.*;

public class Repository {

    private final Map<Long, Defect> data = new HashMap<>();

    public void add(Long id, Defect defect) {
        data.put(id, defect);
    }

    public Collection<Defect> getAll() {return this.data.values();}


    public Defect getById(long id) { return data.get(id); }
}
