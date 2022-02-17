package helloWorld;

public class Repository {

    static public int countOfBug = 0;
    static private int size = 100;
    static Defect[] listBug = new Defect[size];


    static public void add(Defect def) {

        if (countOfBug > size - 100) {
            size = size + 10000;
            Defect[] scale = listBug;
            listBug = new Defect[size];
            System.arraycopy(scale, 0, listBug, 0, scale.length);
        }
        listBug[countOfBug] = def;
        countOfBug++;
    }

    static public Defect[] getAll() {
        return listBug;
    }
}












