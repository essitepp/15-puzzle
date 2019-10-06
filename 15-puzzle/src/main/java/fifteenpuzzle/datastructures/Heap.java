package fifteenpuzzle.datastructures;

import fifteenpuzzle.puzzle.State;

public class Heap {

    private State[] array;
    private int nextIndex;

    public Heap() {
        this.array = new State[10];
        this.nextIndex = 1;
    }

    public void add(State state) {
        array[nextIndex] = state;
        sortAdded(nextIndex);
        nextIndex++;
        if (nextIndex == array.length) {
            increaseSize();
        }
    }

    public State peek() {
        return array[1];
    }

    public State poll() {
        if (nextIndex == 1) {
            return null;
        }
        State returnValue = array[1];
        array[1] = array[nextIndex - 1];
        nextIndex--;
        sortAfterRemove();
        return returnValue;
    }

    private void sortAdded(int index) {
        int parentIndex = index / 2;
        if (parentIndex == 0) {
            return;
        }
        while (array[index].compareTo(array[parentIndex]) < 0) {
            State copy = array[index];
            array[index] = array[parentIndex];
            array[parentIndex] = copy;
            index = parentIndex;
            if (index == 1) {
                break;
            }
            parentIndex = index / 2;
        }
    }

    private void increaseSize() {
        State[] newArray = new State[2 * array.length];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.array = newArray;
    }

    private void sortAfterRemove() {
        int index = 1;
        while (true) {
            int leftChild = 2 * index;
            int rightChild = 2 * index + 1;
            if (leftChild < nextIndex && array[leftChild].compareTo(array[index]) < 0) {
                if (rightChild < nextIndex && array[rightChild].compareTo(array[leftChild]) < 0) {
                    State copy = array[rightChild];
                    array[rightChild] = array[index];
                    array[index] = copy;
                    index = rightChild;
                } else {
                    State copy = array[leftChild];
                    array[leftChild] = array[index];
                    array[index] = copy;
                    index = leftChild;
                }
            } else if (rightChild < nextIndex && array[rightChild].compareTo(array[index]) < 0) {
                State copy = array[rightChild];
                array[rightChild] = array[index];
                array[index] = copy;
                index = rightChild;
            } else {
                break;
            }
        }
    }

}
