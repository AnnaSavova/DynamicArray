package dynamicarray;

import java.util.Objects;

/**
 * Representation of a Dynamic Array
 *
 * @author Anna Savova
 *
 */

public class DynamicArray {
    /** Number of elements in the array */
    protected int used;
    /** List of values */
    protected int[] elements;

    /**
     * Creates a new DynamicArray with the given properties.
     *
     * @param capacity      The capacity of the array
     */
    public DynamicArray(int capacity){
        assert capacity > 0;
        this.used = 0;
        elements = new int[capacity];
    }

    public DynamicArray() {
        this.used = 0;
        this.elements = null;
    }

    /**
     *
     */
    private boolean isValidIndex(int index){
        return (index >= 0 && index <= used);
    }


    /**
     * Adds an element to the end of the array.
     * @param value         element that will be added
     */
    public void add(int value) throws Exception {
        ensureCapacity(used + 1);
        set(used++, value);
    }

    /**
     * Removes the element from the end of the array.
     */
    public void remove(){
        assert !isEmpty();
        --used;
    }

    /**
     * Adds an element at given index
     * @param index         the position of the new element
     * @param value         element that will be added
     */
    public void add(int index, int value) throws Exception{
        if (!isValidIndex(index)) {
            throw new Exception();
        }
        ensureCapacity(used + 1);

        for(int i = index; i < used; ++i) {
            elements[i+1] = elements[i];
        }
        elements[index] = value;
    }

    /**
     * Removes the element from the end of the array.
     * @param index         the position of the removed element
     */

    public void remove(int index) throws Exception {
        if (isEmpty() || !isValidIndex(index)){
            throw new Exception();
        }

        for(int i = index; i < used-1; ++i)
            elements[i] = elements[i+1];

        --used;
    }

    /**
     * Clone arr to an array of size limit
     */
    private int[] cloneArray(int[] arr, int limit)
    {
        int[] buffer = new int[limit];
        int elementsToCopy = Math.min(limit, arr.length);

        for(int i = 0; i < used; ++i) {
            buffer[i] = arr[i];
        }
        
        return arr;
    }

    /**
     * Allocates memory for the array
     * @param newSize       number of expected element capacity
     */
    public void ensureCapacity(int newSize){
        assert newSize > 0;

        if(Objects.isNull(elements)) {
            elements = new int[newSize];
        }
        else if(newSize > elements.length) {
            elements = cloneArray(elements, Math.max(elements.length * 2, newSize));
        }
    }

    /**
     * Trims down capacity to the number of elements
     */
    public void trimToSize(){
        if(used < capacity()) {
            elements = cloneArray(elements, used);
        }
    }

    /**
     * Returns the number of elements in the array
     */
    public int size(){
        return used;
    }

    /**
     * Returns capacity of the array:
     *
     * @return array capacity
     */
    public int capacity(){
        return Objects.isNull(elements) ? 0 : elements.length;
    }

    /**
     * Checks whether array is empty
     *
     * @return      true if no elements in array
     *              false if array not empty
     */
    public boolean isEmpty(){
        return used == 0;
    }

    /**
     * Removes all elements from array
     */
    public void clear(){
        used = 0;
    }

    /**
     * Checks whether element is in the array
     *
     * @param value     value the array is checked for
     * @return          true if element is in array
     *                  false if it is not
     */
    public boolean contains(int value) throws Exception {
        for (int i=0; i < size(); i++){
            if(get(i) == value){
                return true;
            }
        }
        return false;
    }

    /**
     * Return the value of element at given index
     *
     * @param index     index of the given element
     * @return          element at the given index
     */
    public int get(int index) throws Exception {
        //assert index<used;
        if (!isValidIndex(index)){
            throw new Exception();
        }
            
        return this.elements[index];
    }

    /**
     * Sets a new value at given index and returns the old
     *
     * @param index     index of the changed element
     * @param value     value to change element to
     *
     * @return          old value of element
     */
    public int set(int index, int value) throws Exception {
        int old = -1;
        //assert index < used;
        if ( !isValidIndex(index)) {
            throw new Exception();
        }

        old = this.elements[index];
        this.elements[index] = value;
        return old;
    }
}
