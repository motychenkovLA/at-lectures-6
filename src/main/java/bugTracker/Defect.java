package bugTracker;

public class Defect {
    long id;
    //todo поля и так находятся в классе Defect не нужно перегружать название уже известной информацией)
    // достаточно просто - summary, priority и т.д.
    String defectSummary;
    String defectPriority;
    int defectDayCount;

    //todo В принципе пправильно, но вариант с инициализацией через конструктор логичнее.

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
