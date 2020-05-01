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


    // Adds the item in the AarrayDeque.
    public void addFirst(T item) {
        //Checks out if out of length.
        if (size == items.length) {
            resize();
        }
        size += 1;
    }

    //Adds the item at last.
    public void addLast(T item) {
        if (size == items.length) {
            resize();
        }
        items[size] = item;
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
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (items == null) {
            return null;
        }
        //Create the new array and copy all the items in it.
        T rmitem = items[0];
        T[] tempItem = (T[]) new Object[items.length];
        System.arraycopy(items, 1, tempItem, 0, size - 1);
        items[0] = null;
        items = tempItem;
        size -= 1;
        if ((size -= 1) < 0) {
            size = 0;
        }
        //Checks the usage.
        if (!checkusage()) {
            resize();
        }
        return rmitem;
    }

    public T removeLast() {
        if (items == null) {
            return null;
        }
        T rmitem = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        if ((size -= 1) < 0) {
            size = 0;
        }
        //Checks the usage.
        if (!checkusage()) {
            resize();
        }
        return rmitem;
    }

    //Gets the item on the index position.
    public T get(int index) {
        if (index > size) {
            return null;
        }
        return items[index];
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
    private boolean checkusage() {
        return (size * 4) >= items.length;
    }

    //Creates a bigger new items, keep the usage at 25%.
    private void resize() {
        int capacity = size * 4;
        T[] tempItems = (T[]) new Object[capacity];
        System.arraycopy(items, 0, tempItems, 0, size);
        items = tempItems;
    }




}
