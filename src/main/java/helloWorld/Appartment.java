package helloWorld;

public final class Appartment extends Building implements Liveable{

    private int countRoom;

    public Appartment(int countFloar, int countRoom) {
        super(countFloar);
        this.countRoom = countRoom;
    }

    @Override
    public void getPrice() {
    }

    @Override
    public void checkIn() {

    }


}
