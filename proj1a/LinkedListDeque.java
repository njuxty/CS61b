public class LinkedListDeque<T> {
    private TNode sentinel;
    private int size;

    public class TNode {
        public TNode prev;
        public T item;
        public TNode next;

        public TNode(T i, TNode p, TNode n) {
            item = i;
            prev = p;
            next = n;
        }

        private T getRecursive(int index){
            if(index == 0){
                return this.item;
            }
            return next.getRecursive(index -1);
        }
    }

    public LinkedListDeque() {
        sentinel = new TNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        sentinel.next = new TNode(item, sentinel, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new TNode(item, sentinel.prev, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        TNode p = sentinel.next;
        for (int i = 0; i < size(); i++) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        T pop;
        pop = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return pop;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        T pop;
        pop = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return pop;
    }

    public T get(int index) {
        if (size() == 0 || index >= size()) {
            return null;
        }
        TNode p = sentinel.next;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (size() == 0 || index >= size()) {
            return null;
        }
        return sentinel.next.getRecursive(index);
    }

}
