package tracker;

public class Repository {

    static private int size = 100;
    static Defect[] listBug = new Defect[size];
    static public int countBug = 0;

    static public void add(Defect def) {

        if (countBug > size - 10) {
            size = size + 100;
            System.out.println("Увеличили размер массива");
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
