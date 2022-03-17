package Tracker;


import java.util.HashMap;
import java.util.Map;

public class Repository {

    Map<Long, Defect> defectMap = new HashMap<>();

    void add(Defect defect) {                         //костыль безразмерного массива
        defectMap.put(defect.getId(), defect);
    }

    void getAll() {
        for (Defect value : defectMap.values()) {
            System.out.println(value.getInfo());
        }
    }


    public boolean checkId(long id){
        return defectMap.containsKey(id);
    }

    public DefectStatus getStatus(long id){
       return defectMap.get(id).getStatus();
    }

        void changeStatus (long id, DefectStatus status){ //смена статуса дефекта
            defectMap.get(id).setStatus(status);
        }
    }
