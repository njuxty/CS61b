public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first = 7;
    private int last = 0;

    public ArrayDeque() {
        items = (T[])new Object[8];
        size = 0;
    }

    public void resize() {
        T[] resizedArray = (T[])new Object[items.length * 2];
        System.arraycopy(items, 0, resizedArray, 0, last);
        System.arraycopy(items, first + 1, resizedArray, resizedArray.length - items.length + first + 1,
                items.length - first - 1);
        first = resizedArray.length - items.length + first;
    }

    public void addFirst(T item) {
        if (last > first) {
            resize();
        }
        items[first] = item;
        size += 1;
        first -= 1;

    }

    public void addLast(T item) {
        if (last > first) {
            resize();
        }
        items[last] = item;
        size += 1;
        last += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(T item: items){
            System.out.print(item + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        T pop;
        pop = items[first + 1];
        first += 1;
        if(first >= items.length){
            first = 0;
        }
        size -= 1;
        return pop;
    }

    public T removeLast() {
        if (isEmpty()) {
            System.out.println("empty list!!!");
            return null;
        }
        T pop;
        pop = items[last - 1];
        last -= 1;
        if(last <= 0){
            last = items.length - 1;
        }
        size -= 1;
        return pop;
    }

    public T get(int index) {
        if (size() == 0 || index >= size()) {
            return null;
        }
        return items[index];
    }
}
