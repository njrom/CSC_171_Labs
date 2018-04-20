/** Lab 5 (List ADT)
 Nicholas Romano (No partners)
 **/
import java.util.Collection;
import java.util.Iterator;

public class URLinkedList<E> implements URList<E> {
    private URNode<E> header = new URNode<E>(null,null,null);
    @Override
    public boolean add(E e) {
        URNode currentNode = header;
        while(iterator().hasNext()){
            currentNode = currentNode.next(); //Iterates through the list till currentNode is the lastNode of the list
        }
        if(currentNode.element() == null){
            currentNode.setElement(e);
            return true;
        }
        else{
            URNode<E> nextNode = new URNode(e, currentNode, null);
            currentNode.setNext(nextNode);
            return true;
        }
    }
    @Override
    public void add(int index, E element) {
        URNode currentNode = header;
        int currentIndex = 0;
        while(iterator().hasNext()){
            currentNode = currentNode.next();
            index++;
            if(currentIndex == index){
                currentNode.setElement(element);
                return;
            }
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }
    @Override
    public boolean addAll(Collection<? extends E> c) {
        URNode currentNode = header;
        while((iterator().hasNext())){
            currentNode = currentNode.next();
        }  // Iterates to the end of the list
        for(E e: c){
            URNode<E> nextNode = new URNode<E>(e, currentNode, null);
            nextNode.setElement(e);
            currentNode.setNext(nextNode);
            currentNode = currentNode.next();
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        URNode currentNode = header;
        while(iterator().hasNext()){

        }
        return false;
    }

    @Override
    public void clear() {
        URNode currentNode = header;
        currentNode.setElement(null);
        currentNode.setNext(null); // Resetting the value and cutting list off at the head.

    }

    @Override
    public boolean contains(Object o) {
        URNode<E> currentNode = header;
        while(iterator().hasNext()) {
            if(currentNode.element() == o) {return true;}
            currentNode = currentNode.next();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<? extends E> c) {
        for(E e : c){
            if(!(contains(e))){
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
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentIndex == index) {return currentNode.element();}
            currentIndex++;
            currentNode = currentNode.next();
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    public int indexOf(Object O){
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentNode.element() == O) {return currentIndex;}
            currentIndex++;
            currentNode = currentNode.next();
        }
        throw new IndexOutOfBoundsException("Index " + currentIndex+ " is out of bounds.  Element not in linked list");
    }

    public boolean isEmpty() {
        URNode<E> currentNode = header;
        if (currentNode == null) {
            return true;
        }
        while (iterator().hasNext()) {
            if (currentNode.element() != null) {
                return false;
            }
            currentNode = currentNode.next();
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            URNode<E> currentNode = header;
            @Override
            public boolean hasNext() {
                currentNode = currentNode.next();
                return currentNode == null;
            }

            @Override
            public E next() {
                currentNode = currentNode.next();
                return currentNode.element();

            }
        };
    }

    public E remove(int index){
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentIndex == index){
                currentNode.prev().setNext(currentNode.next());
            }
            currentNode = currentNode.next();
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    public boolean remove(Object o){
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentNode.element() == o){
                currentNode.prev().setNext(currentNode.next());
            }
            currentNode = currentNode.next();
        }
        return true;
    }

    public boolean removeAll(Collection<? extends E> c){
        for(E e: c){
            remove(e);
        }
        return true;
    }

    public E set(int index, E element){
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentIndex == index){
                currentNode.setElement(element);
            }
            currentNode = currentNode.next();
            currentIndex++;
        }
        throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
    }

    @Override
    public int size() {
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            currentNode = currentNode.next();
            currentIndex++;
        }
        return currentIndex+1; // Plus 1 because index starts at zero
    }

    public URList<E> subList(int fromIndex, int toIndex){
        int currentIndex = 0;
        URNode<E> currentNode = header;
        while(iterator().hasNext()){
            if(currentIndex == fromIndex){
                header = currentNode;
            }
            if(currentIndex == toIndex){
                currentNode.setNext(null);
            }
            currentNode = currentNode.next();
            currentIndex++;
        }
        return this;
    }

    @Override
    public Object[] toArray() {
        URNode currentNode = header;
        int currentIndex = 0;
        Object[] arr = new Object[size()];
        while(iterator().hasNext()){
            arr[currentIndex] = currentNode.element();
            currentIndex++;
            currentNode = currentNode.next();
        }
        return arr;
    }

    // Inserts the specified element at the beginning of this list.
    public void addFirst(E e){
        URNode newHeader = new URNode(e, null, header);
        header = newHeader;
    }
    // Appends the specified element to the end of this list.
    public void addLast(E e){
        URNode currentNode = header;
        while(iterator().hasNext()){
            currentNode = currentNode.next();
        }
        currentNode.setNext(new URNode(e, currentNode, null));
    }
    // Retrieves, but does not remove, the first element of this list, or returns null if this list is empty.
    public E peekFirst(){
        return header.element();
    }
    // Retrieves, but does not remove, the last element of this list, or returns null if this list is empty.
    public E peekLast(){
        URNode currentNode = header;
        while(iterator().hasNext()){
            currentNode = currentNode.next();
        }
        return (E) currentNode.element();
    }
    // Retrieves and removes the first element of this list, or returns null if this list is empty.
    public E pollFirst(){
        if(isEmpty()){
            return null;
        }
        E firstEl = header.element();
        header.setElement(null);
        return firstEl;
    }
    // Retrieves and removes the last element of this list, or returns null if this list is empty.
    public E pollLast(){
        if(isEmpty()){
            return null;
        }
        URNode currentNode = header;
        while(iterator().hasNext()){
            currentNode = currentNode.next();
        }
        E firstEl = (E) currentNode.element();
        currentNode.setElement(null);
        return firstEl;
    }
}
