package fifteenpuzzle.datastructures;

public class ArrayList<T> {

    private T[] array;
    private int nextIndex;

    /**
     * Constructs a new empty list.
     */
    public ArrayList() {
        this.array = (T[]) new Object[10];
        this.nextIndex = 0;
    }

    /**
     * Adds the specified object to the list.
     *
     * @param object object to be added to the list
     */
    public void add(T object) {
        array[nextIndex] = object;
        nextIndex++;
        if (nextIndex == array.length) {
            increaseSize();
        }
    }

    /**
     * Returns the object in the specified index of the list.
     *
     * @param i index from which to return object
     * @return object stored in chosen index
     */
    public T get(int i) {
        return array[i];
    }

    /**
     * Returns the number of objects currently in the list.
     *
     * @return number of objects in the list
     */
    public int size() {
        return nextIndex;
    }

    /**
     * Used to double the size of the array.
     */
    private void increaseSize() {
        T[] newArray = (T[]) new Object[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

}
