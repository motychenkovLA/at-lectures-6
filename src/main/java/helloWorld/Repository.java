package helloWorld;

public class Repository {

    static public int countOfBug = 0;
    static private int size = 100;
    static private Defect[] listBug = new Defect[size];


    static public void add(Defect def) {

        if (countOfBug > size - 10) {
            size = size + 100;
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


    static public Defect getDefect(long id) {
        for ( int i=0; i < countOfBug; i++) {
            if (listBug[i].getId() == id ) {
                return listBug[i];
            }
        }
        return null;
    }
}


//







