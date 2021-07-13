package test;

import dynamicarray.DynamicArray;
import org.junit.jupiter.api.Test;

import java.util.Objects;


class EmptyDynamicArrayTest {
    public DynamicArray emptyArr = new DynamicArray();

    @Test
    public void size_returnsZeroForEmpty(){
        assert emptyArr.size() == 0;
    }
    @Test
    public void capacity_returnsZeroForEmpty(){
        assert emptyArr.capacity() == 0;
    }
    @Test
    public void isEmpty_returnsTrueForEmpty(){
        assert Objects.equals(emptyArr.isEmpty(), true);
    }
    @Test
    public void remove_throwsE(){
        try {
            emptyArr.remove(1);
        } catch (Exception e){
            return;
        }
        assert false;
    }
    @Test
    public void get_throwsE(){
        try {
            emptyArr.get(2);
        } catch (Exception e){
            return;
        }
        assert false;
    }
    @Test
    public void set_throwsE(){
        try {
            emptyArr.set(3, 12435);
        } catch(Exception e){
            return;
        }
        assert false;
    }
    @Test
    public void contains_throwsE(){
        try{
            emptyArr.contains(5);
        } catch (Exception e){
            return;
        }
        assert false;
    }
    @Test
    public void clear_noChangeToArr(){
        emptyArr.clear();
        assert emptyArr.isEmpty();
    }
    @Test
    public void add_correctlyInserts() throws Exception {
        emptyArr.add(54923);
        assert !emptyArr.isEmpty();
        assert emptyArr.size() == 1;
        assert emptyArr.capacity() == 2;
    }
}

class NonEmptyDynamicArrayTest {
    public DynamicArray dArr = new DynamicArray();
    public final int elCount = 10;

    public NonEmptyDynamicArrayTest() throws Exception {
        for (int i = 0; i < elCount; i++){
            dArr.add(i);
        }
    }
    // loop for get and set. Two tests per each
    @Test
    public void capacity_returnsCorrectCapacity(){
        assert dArr.capacity() == elCount;
    }
    @Test
    public void size_returnsCorrectSize(){
        assert dArr.size() == elCount-1;
    }
    @Test
    public void isEmpty_returnsFalseForNonEmpty(){
        assert Objects.equals(dArr.isEmpty(), false);
    }
    @Test
    public void get_returnsCorrectIndex() throws Exception {
        assert dArr.get(elCount-1) == elCount-1;
    }
    @Test
    public void trimToSize_trimsCapacity(){
        dArr.trimToSize();
        assert dArr.size() == dArr.capacity();
    }
    @Test
    public void clear_clearsElements(){
        dArr.clear();
        assert dArr.size() == 0;
    }
}