public class LinkedListDeque <T>{
    private class StuffNode{
        public T item;
        public StuffNode next;
        public StuffNode prev;

        public StuffNode(T i, StuffNode p, StuffNode n){
            item = i;
            next = n;
            prev = p;
        }
    }

    //create two sentinels
    private StuffNode sentinel1;
    private StuffNode sentinel2;
    private int size;

    public LinkedListDeque(){
        sentinel1 = new StuffNode(null, null, null);
        sentinel2 = new StuffNode(null, sentinel1, null);
        sentinel1.next = sentinel2;
        size = 0;
    }

    public LinkedListDeque(T x){
        //sentinel's item remain null.
        sentinel1 = new StuffNode(null , null, null);
        sentinel1.next = new StuffNode(x, sentinel1, sentinel2);
        sentinel2 = new StuffNode(null , null, null);
        sentinel2.prev = sentinel1.next;
        size += 1;
    }

    public void addFirst(T item){
        sentinel1.next = new StuffNode(item, sentinel1, sentinel1.next);
        sentinel1.next.next.prev = sentinel1.next;
        size += 1;
    }

    public void addLast(T item){
        sentinel2.prev = new StuffNode(item, sentinel2.prev, sentinel2);
        sentinel2.prev.prev.next = sentinel2.prev;
        size += 1;
    }

    public boolean isEmpty(){
        if(sentinel1.next == null && sentinel2.prev == null){
            return true;
        }
        else {
            return false;
        }
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        StuffNode p1 = sentinel1;
        while (p1.next != sentinel2){
            System.out.print(p1.next.item + " ");
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
        return rmitem;
    }

    public T removeLast(){
        T rmitem;
        StuffNode rm = sentinel2.prev;
        if(sentinel2.prev == sentinel1){
            return null;
        }
        rmitem = sentinel2.prev.item;
        sentinel2.prev = sentinel2.prev.prev;
        sentinel2.prev.next = sentinel2;
        rm = null;
        return rmitem;
    }

    public T get(int index){
        int i = 0;
        StuffNode p = sentinel1;
        while (i <= index){
            if(p.next == sentinel2){
                return null;
            }
            p.next = p.next.next;
        }
        return p.next.item;
    }

    public  LinkedListDeque(LinkedListDeque other){

    }

    public T getRecursive(int index){

    }



    
}
