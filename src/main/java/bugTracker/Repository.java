package bugTracker;

public class Repository {
    private int countOfDefects;
    private int numOfBug = 0;
    //todo инкапсулировать
    Defect[] defects;

    public Repository(int count){
        this.countOfDefects = count;
        defects = new Defect[count];
    }

    public int getNumOfBug() {return numOfBug;}

    void add (Defect defect){
        defects[numOfBug] = defect;
        numOfBug++;
    }

    //todo сделать в соответствии с заданием
    void getAll(){
        for (int i = 0; i < numOfBug; i++){
            String info = defects[i].getInfo();
            System.out.println(info);
        }
    }
}
