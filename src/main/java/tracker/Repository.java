package tracker;

public class Repository {

    Defect[] listBug;
    int countBug = 0;

    public Repository(int size) {
        listBug = new Defect[size];

    }

    public boolean check() {
        return (countBug > listBug.length - 1);
    }

    public void add(Defect def) {
        listBug[countBug] = def;
        countBug++;
    }

    public void getAll() {
        for (int i = 0; i < countBug; i++) {
            System.out.println(listBug[i].getInfo());
        }
        System.out.println("\n\n");
    }
}
