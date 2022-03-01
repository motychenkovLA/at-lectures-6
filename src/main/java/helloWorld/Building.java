package helloWorld;

public abstract class Building {

    private int countFlour;

    public abstract void getPrice();

    public int getCountFloar() {
        return countFlour;
    }

    public void setCountFloar(int countFloar) {
        this.countFlour = countFloar;
    }

    public Building(int countFloar) {
        this.countFlour = countFloar;
    }
}
