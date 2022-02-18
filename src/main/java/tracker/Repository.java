package tracker;

public class Repository {

    static private int size = 100;
    static Defect[] listBug = new Defect[size];
    static public int countBug = 0;

    static public void add(Defect def) {
        int checkSize = 10;
        if (countBug > size - checkSize) {
            size = size + 100;
            Defect[] temp = listBug;
            listBug = new Defect[size];
            for (int i = 0; i < temp.length; i++) {
                listBug[i] = temp[i];
            }
        }
        listBug[countBug] = def;
        countBug++;
    }

    static public Defect[] getAll() {
        return listBug;
    }
}
