import java.util.ArrayList;

class StorageBox<T> {
    //Fields
    private ArrayList<T> box;

    //Constructor
    public T StorageBox() {

    }

    //Method
    boolean isEmpty() {
        return box.isEmpty();
    }
    boolean isFull() {
        return !box.isEmpty();
    }
    void push(Object x) {
        T var = new Object x;
        box.add(T);
    }
    Object pop() {
        if (isEmpty()) {
            return null;
        } else {
            T v = box.get(0);
            return v;
        }
    }

}

public class Excercise {
    public static void main(String[] args) {
        System.out.println("Hello");
    }
}
