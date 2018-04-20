/** Lab 5 (List ADT)
 Nicholas Romano (No partners)
 **/
import java.util.Collection;
import java.util.Iterator;

public class URArrayList<E> implements URList<E> {
    private Object[] array;
    private static final int DEFAULT_SIZE = 25;
    private int size = 0;
    public URArrayList(int size){
        array = new Object[size];
    }
    public URArrayList(){
        this(DEFAULT_SIZE);
    }
    @Override
    public boolean add(E e) {
        ensureCapacity(size + 1);
        array[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        ensureCapacity(index);
        array[index] = element;
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        for(E e : c){
            array[size++] = e;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for(E e: c){
            array[index++] = e;
        }
        return true;
    }

    @Override
    public void clear() {
        int currentIndex = 0;
        while(iterator().hasNext()){
            array[currentIndex] = null;
            currentIndex++;
        }
    }

    @Override
    public boolean contains(Object o) {
        int currentIndex = 0;
        while(iterator().hasNext()){
            if(array[currentIndex] == o){
                return true;
            }
            currentIndex++;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for(E e : c){
            if(!contains(e)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public E get(int index){
        if(index < size){
            return((E) array[index]);
        }
        else{
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
    }

    public int indexOf(Object O){
        int currentIndex = 0;
        while(iterator().hasNext()){
            if(array[currentIndex] == O) { return currentIndex;}
        }
        throw new IndexOutOfBoundsException("Index " + currentIndex + " is out of bounds");
    }

    public boolean isEmpty(){
        return size > 0;
    }
    @Override
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int currentIndex = 0;
            @Override
            public boolean hasNext() {
                currentIndex++;
                return currentIndex < size;
            }
            @Override
            public E next() {
                currentIndex++;
                return (E) array[currentIndex];

            }
        };
    }

    public E remove(int index){
        ensureCapacity(size+1);
        E removedValue = (E) array[index];
        for(int i = index; index < size;){
            array[i] = array [i +1];
        }
        return removedValue;
    }

    public boolean remove(Object o){
        int currentIndex = 0;
        ensureCapacity(size+1);
        while(iterator().hasNext()){
            if(array[currentIndex] == o){
                remove(currentIndex);
            }
        }
        return true;
    }

    public boolean removeAll(Collection<? extends E> c){
        for(E e : c){
            remove(e);
        }
        return true;
    }

    public E set(int index, E element){
        array[index] = element;
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    public URList<E> subList(int fromIndex, int toIndex){
        URList<E> subArrayList = new URArrayList<>(0);
        int currentIndex = 0;
        while(iterator().hasNext()){
            if((currentIndex >= fromIndex)&&(currentIndex < toIndex)){
                subArrayList.add((E) array[currentIndex]);
            }
        }
        return subArrayList;
    }

    @Override
    public Object[] toArray() {
        Object[] simpleArray = new Object[size];
        int currentIndex = 0;
        while(iterator().hasNext()){
            simpleArray[currentIndex] = array[currentIndex];
        }
        return simpleArray;
    }
    // Increases the capacity of this ArrayList instance, if necessary,
    // to ensure that it can hold at least the number of elements specified
    // by the minimum capacity argument.
    void ensureCapacity(int minCapacity){
        if(size < minCapacity){
            size = minCapacity;
        }
    }
    // Returns the current capacity of the list
    int getCapacity(){
        return size;
    }
}