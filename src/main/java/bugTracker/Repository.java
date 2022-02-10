package bugTracker;

public class Repository {
    private int countOfDefects;
    private int numOfBug = 0;
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

    void getAll(){
        for (int i = 0; i < numOfBug; i++){
            String info = defects[i].getInfo();
            System.out.println(info);
        }
    }
}
