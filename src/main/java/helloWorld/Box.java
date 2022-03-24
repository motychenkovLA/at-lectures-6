package helloWorld;

import java.util.Objects;

public class Box {
    int height;
    int width;
    int length;
    int volume;

    Integer s = null;

    public Box(int height, int width, int length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }


    public int getLength() {
        return length;
    }

    public int getVolume(int height, int width, int length){
        volume = height*width*length;
        int s;
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box box = (Box) o;
        return height == box.height
                && width == box.width
                && length == box.length;
    }
    public void method(String ... arr){

    }

    @Override
    public int hashCode() {
        return Objects.hash(height, width, length, volume, s);
    }
}
