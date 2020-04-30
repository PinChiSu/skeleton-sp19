public class ArrayDeque<T> {
    //create the basic T[], size.
    public T[] items;
    public int size;
    //Create a new integer counting the useage.

    public ArrayDeque(){
        items = (T[]) new Object[8]; // 括號裡表示是這個Object的意思
        size = 0;
    }

    // Adds the item in the AarrayDeque.
    public void addFirst(T item){
        //Must at first
        items[0] = item;
        size += 1;
    }

    //Adds the item at last.
    public void addLast(T item){
        items[size] = item;
        size += 1;
    }

    //Makes sure if AD is empty.
    public boolean isEmpty(){
        if(items == null){
            return true;
        }
        else {
            return false;
        }
    }

    //Gets the size.
    public int size(){
        return size;
    }

    //print all the items in AD.
    public void printDeque(){
        for(int i = 0; i < items.length; i++){
            System.out.print(items[i]+" ");
        }
        System.out.println();
    }

    public T removeFirst(){
        if(items == null){
            return null;
        }
        //Create the new array and copy all the items in it.
        T rmitem = items[0];
        T[] temp_item = (T[]) new Object[items.length];
        System.arraycopy(items, 1 , temp_item, 0 ,size - 1);
        items[0] = null;
        items = temp_item;
        size -= 1;
        return rmitem;
    }

    public T addLast(){
        if(items == null){
            return null;
        }
        T rmitem = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return rmitem;
    }

    //Gets the item on the index position.
    public T get(int index){
        if(index > size){
            return null;
        }
        return items[index];
    }

    //Creates a deep copy of other, which means the whole new AD.
    public ArrayDeque(ArrayDeque other){
        T[] temp_item = (T[]) new Object[items.length];
        System.arraycopy(other, 0, temp_item, 0, size);
        items = temp_item;
        //size keeps the same.
    }




}
