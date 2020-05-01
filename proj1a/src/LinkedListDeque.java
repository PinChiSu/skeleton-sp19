public class LinkedListDeque<T> {
    private class StuffNode {
        private T item;
        private StuffNode next;
        private StuffNode prev;

        public StuffNode(T i, StuffNode p, StuffNode n) {
            item = i;
            next = n;
            prev = p;
        }
    }

    //create two sentinels
    private StuffNode sentinel1;
    private StuffNode sentinel2;
    private int size;

    public LinkedListDeque() {
        sentinel1 = new StuffNode(null, null, null);
        sentinel2 = new StuffNode(null, sentinel1, null);
        sentinel1.next = sentinel2;
        size = 0;
    }
    /**sp19
    public LinkedListDeque(T x) {
        //sentinel's item remain null.
        sentinel1 = new StuffNode(null , null, null);
        sentinel1.next = new StuffNode(x, sentinel1, sentinel2);
        sentinel2 = new StuffNode(null , null, null);
        sentinel2.prev = sentinel1.next;
        size += 1;
    }
     */

    public void addFirst(T item) {
        sentinel1.next = new StuffNode(item, sentinel1, sentinel1.next);
        sentinel1.next.next.prev = sentinel1.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel2.prev = new StuffNode(item, sentinel2.prev, sentinel2);
        sentinel2.prev.prev.next = sentinel2.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return sentinel1.next == sentinel2 && sentinel2.prev == sentinel1;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        StuffNode p1 = sentinel1;
        while (p1.next != sentinel2) {
            System.out.print(p1.next.item + " ");
            p1.next = p1.next.next;
        }
        //print out a new line.
        System.out.println();

    }

    public T removeFirst(){
        T rmitem;
        if(sentinel1.next == sentinel2){
            return null;
        }
        rmitem = sentinel1.next.item;
        StuffNode rm = sentinel1.next;
        sentinel1.next = sentinel1.next.next;
        sentinel1.next.prev = sentinel1;
        rm = null;
        if (size >= 0) {
            size -= 1;
        } else {
            size = 0;
        }
        return rmitem;
    }

    public T removeLast() {
        T rmitem;
        StuffNode rm = sentinel2.prev;
        if(sentinel2.prev == sentinel1){
            return null;
        }
        rmitem = sentinel2.prev.item;
        sentinel2.prev = sentinel2.prev.prev;
        sentinel2.prev.next = sentinel2;
        rm = null;
        if (size >= 0) {
            size -= 1;
        } else {
            size = 0;
        }
        return rmitem;
    }

    public T get(int index) {
        int i = 0;
        StuffNode p = sentinel1;
        while (i <= index) {
            if (p.next == sentinel2) {
                return null;
            }
            p.next = p.next.next;
            i++;
        }
        return p.next.item;
    }

    public T getRecursive(int index) {
        //consider if the LLD is empty.
        if (this.sentinel1.next == this.sentinel2) {
            return null;
        }
        return this.getRecursive(index, this.sentinel1.next);
    }

    private T getRecursive(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        }
        if (p.next == sentinel2) {
            return null;
        }
        return getRecursive(index - 1, p.next);
    }

    /** sp19
    public  LinkedListDeque(LinkedListDeque other) {
        sentinel1 = new StuffNode(null, null, null);
        sentinel2 = new StuffNode(null, sentinel1, null);
        sentinel1.next = sentinel2;
        size = 0;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }

    }
     */




}
