public class ArrayDeque<T> {
    //create the basic T[], size.
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;
    //Create a new integer counting the usage.

    public ArrayDeque() {
        items = (T[]) new Object[8]; // 括號裡表示是這個Object的意思
        size = 0;
        nextFirst = 0;
        nextLast = 1;
    }


    //Moves nextFirst forward, if out of range, being circular.
    private int forward(int index) {
        index -= 1;
        if (index < 0) {
            index = items.length - 1;
        }
        return index;
    }

    //Moves nextLast backward, if out of range, being circular.
    private int backward(int index) {
        index += 1;
        if (index == items.length) {
            index = 0;
        }
        return index;
    }

    // Adds the item in the AarrayDeque.
    public void addFirst(T item) {
        //Checks out if out of length.
        if (size == items.length) {
            resize();
        }
        items[nextFirst] = item;
        nextFirst = forward(nextFirst);
        size += 1;
    }

    //Adds the item at last.
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[nextLast] = item;
        nextLast = backward(nextLast);
        size += 1;
    }

    //Makes sure if AD is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    //Gets the size.
    public int size() {
        return size;
    }

    //print all the items in AD.
    public void printDeque() {
        int i = nextFirst + 1;
        while (i != nextFirst) {
            if (items[i] != null) {
                System.out.print(items[i] + " ");
            }
            i++;
            if (i == items.length) {
                i = 0;
            }
        }
        System.out.println();
    }

    public T removeFirst() {
        if (items == null) {
            return null;
        }
        //Let the nextFirst go backward, and let the remove item equals null.
        nextFirst = backward(nextFirst);
        T removeItem = items[nextFirst];
        size -= 1;
        //items[nextFirst] = null;
        //Checks the usage.
        if (!checkUsage()) {
            resize();
        }
        return removeItem;
    }

    public T removeLast() {
        if (items == null) {
            return null;
        }

        nextLast = forward(nextLast);
        T removeItem = items[nextLast];
        //items[nextLast] = null;
        size -= 1;
        if (!checkUsage()) {
            resize();
        }
        return removeItem;
    }

    //Gets the item on the index position.
    public T get(int index) {
        //Find the first position, and the plus index+1, find the position.
        int position = (backward(nextFirst) + index) % items.length;
        return items[position];
    }

    //Creates a deep copy of other, which means the whole new AD.
    /**Part of sp19 CS61B
     public ArrayDeque(ArrayDeque other) {
     T[] tempItem = (T[]) new Object[items.length];
     System.arraycopy(other, 0, tempItem, 0, other.size);
     items = tempItem;
     //size keeps the same.
     }
     */

    //Checks if the usage > 25%
    private boolean checkUsage() {
        return (size * 4) >= items.length && size > 16;
    }

    //Creates a bigger new items, keep the usage at 25%.
    private void resize() {
        int capacity = size * 4;
        T[] tempItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, tempItems, 0, tempItems.length);
        items = tempItems;
        //System.out.println(items.length);
    }


    /*
    public static void main(String[] args) {
        ArrayDeque<Integer> test = new ArrayDeque<>();
        test.addFirst(2);
        test.removeFirst();
        //test.removeLast();


    }
     */


}
