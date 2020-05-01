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
        //Checks out if out of length.
        if(size == items.length){
            resize();
        }
        //the list go backward
        T[] temp_item = (T[]) new Object[items.length];
        System.arraycopy(items, 0 , temp_item, 1, size);
        //Must at first
        items[0] = item;
        size += 1;
    }

    //Adds the item at last.
    public void addLast(T item){
        if(size == items.length){
            resize();
        }
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
        //Checks the usesage.
        if(checkusage() == false){
            resize();
        }
        return rmitem;
    }

    public T removeLast(){
        if(items == null){
            return null;
        }
        T rmitem = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        //Checks the usage.
        if(checkusage() == false){
            resize();
        }
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
        System.arraycopy(other, 0, temp_item, 0, other.size);
        items = temp_item;
        //size keeps the same.
    }

    //Checks if the usage > 25%
    public boolean checkusage(){
        if((size * 4 ) >= items.length){
            return true;
        }
        else{
            return false;
        }
    }

    //Creates a bigger new items, keep the usesage at 25%.
    private void resize(){
        int capacity = size * 4;
        T[] temp_items = (T[]) new Object[capacity];
        System.arraycopy(items, 0, temp_items, 0, size);
        items = temp_items;
    }




}
