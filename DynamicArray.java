package dynamicarray;

import java.util.Objects;

/**
 * Representation of a Dynamic Array
 *
 * @author Anna Savova
 *
 */

public class DynamicArray {
    /** Capacity of the array */
    protected int size;
    /** List of values */
    protected int[] elements;

    /**
     * Creates a new DynamicArray with the given properties.
     *
     * @param size      The capacity of the array
     */
    public DynamicArray(int size){
        if (Objects.isNull(size)){
            this.size = 0;
        } else{
            this.size = size;
        }
    }

    /**
     * Adds an element to the end of the array.
     * @param value         element that will be added
     */
    public void add(int value){
        int s = size();
        set(s, value);
    }

    /**
     * Removes the element from the end of the array.
     */
    public void remove(){
        int s = size();
        int[] newArr = new int[s-1];
        for (int i = 0; i < s-1; i++){
            newArr[i] = get(i);
        }
        this.elements = newArr;
    }

    /**
     * Adds an element at given index
     * @param index         the position of the new element
     * @param value         element that will be added
     */
    public void add(int index, int value){
        int s = size();
        int[] newArr = new int[s+1];

        for (int i = 0; i < index; i++){
            newArr[i] = get(i);
        }
        newArr[index] = value;
        for (int i = index+1; i < s+1; i++){
            newArr[i] = get(i-1);
        }
        this.elements = newArr;
    }

    /**
     * Removes the element from the end of the array.
     * @param index         the position of the removed element
     */

    public void remove(int index){
        int s = size();
        int[] newArr = new int[s-1];

        for (int i = 0; i < index; i++){
            newArr[i] = get(i);
        }
        for (int i = index; i < s-1; i++){
            newArr[i] = get(i+1);
        }
    }

    /**
     * Allocates memory for the array
     * @param newSize       number of expected element capacity
     */
    public void ensureCapacity(int newSize){
        this.size = newSize;
    }

    /**
     * Trims down capacity to the number of elements
     */
    public void trimToSize(){
        this.size = size();
    }

    /**
     * Returns size of the array:
     * @return current array size
     */
    public int size(){
        return elements.length;
    }

    /**
     * Returns capacity of the array:
     *
     * @return array capacity
     */
    public int capacity(){
        return this.size;
    }

    /**
     * Checks whether array is empty
     *
     * @return      true if no elements in array
     *              false if array not empty
     */
    public boolean isEmpty(){
        int s = size();

        if (Objects.isNull(s) || s <= 0){
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all elements from array
     */
    public void clear(){
        int s = size();
        for (int i = 0; i < s; i++){
            remove(s);
        }
    }

    // Това беше дадено като войд в занятието но
    // за мен има повече смисъл да е boolean
    /**
     * Checks whether element is in the array
     *
     * @param value     value the array is checked for
     * @return          true if element is in array
     *                  false if it is not
     */
    public boolean contains(int value){
        int s = size();
        boolean contained = false;
        for (int i=0; i < s; i++){
            if(get(i) == value){
                contained = true;
            }
        }
        return contained;
    }

    /**
     * Return the value of element at given index
     *
     * @param index     index of the given element
     * @return          element at the given index
     */
    public int get(int index){
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
    public int set(int index, int value){
        int old = this.elements[index];
        this.elements[index] = value;
        return old;
    }
}
