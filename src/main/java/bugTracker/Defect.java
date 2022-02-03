package bugTracker;

public class Defect {
    long id;
    String defectSummary;
    String defectPriority;
    int defectDayCount;

    public Defect(){

    }

    //public Defect(long id, String defectSummary, String defectPriority, int defectDayCount){
    //    this.id = id;
    //    this.defectSummary = defectSummary;
    //    this.defectPriority = defectPriority;
    //    this.defectDayCount = defectDayCount;
    //}

    public long getId() { return id; }
    public String getDefectSummary(){
        return defectSummary;
    }
    public String getDefectPriority(){
        return defectPriority;
    }
    public int getDefectDayCount(){
        return defectDayCount;
    }

    public void setId(long id){ this.id = id; }
    public void setDefectSummary(String defectSummary){
        this.defectSummary = defectSummary;
    }
    public void setDefectPriority(String defectPriority){
        this.defectPriority = defectPriority;
    }
    public void setDefectDayCount(int defectDayCount){
        this.defectDayCount = defectDayCount;
    }
}
