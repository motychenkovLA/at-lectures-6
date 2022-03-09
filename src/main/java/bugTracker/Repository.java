package bugTracker;
import java.util.Arrays;

public class Repository {
    private int numOfBug = 0;
    private Defect[] defects = new Defect[10];

    void add (Defect defect){
        if (numOfBug == defects.length) {
            defects = Arrays.copyOf(defects, defects.length * 2);
        }
        defects[numOfBug] = defect;
        numOfBug++;
    }
    public Defect getById(int id) {
        for (Defect defect : defects) {
            if (defect == null) {
                continue;
            }
            if (id == defect.getId()) {
                return defect;
            }
        }
        return null;
    }

    Defect[] getAll(){
        return defects;
    }

    void changeStatus(int id, String name) {
        if (getById(id) != null) {
            getById(id).setStatus(Status.findByName(name));
        }
    }
}
