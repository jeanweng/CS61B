public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int first;
    private int last;

    public ArrayDeque(){
        items = (T[])new Object[4];
        size = 0;
        first = -1;
        last = -1;
    }

//    public ArrayDeque(ArrayDeque other){
//        System.arraycopy(items, 0, other, 0, other.size());
//        size = other.size();
//    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public T get(int index){
        if(index >= size && index < 0) return null;
        return items[index];
    }

    public void printDeque(){
        if(first == -1){
            return;
        }
        if(first <= last){
            for(int i = first; i <= last; i++){
                System.out.print(items[i] + " ");
            }
        }else{
            for(int i = first; i < items.length; i++){
                System.out.print(items[i] + " ");
            }
            for(int i = 0; i <= last; i++){
                System.out.print(items[i] + " ");
            }
        }
//        System.out.println("Deque without rearrange order: ");
//        for(int i = 0; i < items.length; i++){
//            System.out.print(items[i] + " ");
//        }
//        System.out.println();
//        System.out.println("size = " + size);
//        System.out.println("first = " + first + ": " + items[first]);
//        System.out.println("last = " + last+ ": " + items[last]);
//        System.out.println("length = " + items.length);
    }

    public void resize(int factor){
        T[] resized = factor == 1? (T[]) new Object[items.length * 2]: (T[]) new Object[items.length / 2];
        int beforeEnd = items.length - first;
        if (first > last) {
            for (int i = 0; i < items.length - first; i++) {
                resized[(resized.length - beforeEnd + i) % resized.length] = items[first + i];
            }
            for (int i = 0; i <= last; i++) {
                resized[i] = items[i];
            }
            first = resized.length - beforeEnd;
        }else{
            for(int i = first; i <= last; i++){
                resized[i] = items[i];
            }
        }
        items = resized;
    }

    public void addFirst(T item){
        if(size == items.length){
            resize(1);
        }
        if(first == -1){
            first++;
            last++;
        }
        else if(first == 0) {
            first = items.length - 1;
        }else {
            first--;
        }
        items[first] = item;
        size++;
    }

    public void addLast(T item){
        if(size == items.length){
            resize(1);
        }
        if(last == -1){
            items[0] = item;
            last = 0;
        }else{
            last++;
            items[last] = item;
        }
        size++;
    }

    public T removeFirst(){
        if(size == 0) {
            return null;
        }
        T removed = items[first];
        items[first] = null;
        if(first == items.length - 1) {
            first = 0;
        }else{
            first++;
        }
        size--;
        if(size <= items.length / 2){
            resize(-1);
        }
        return removed;
    }

    public T removeLast(){
        if(size == 0){
            return null;
        }
        T removed = items[last];
        items[last] = null;
        if(last == 0){
            last = items.length - 1;
        }else{
            last--;
        }
        size--;
        if(size <= items.length / 2){
            resize(-1);
        }
        return removed;
    }
}
