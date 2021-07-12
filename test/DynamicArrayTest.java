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
}

class NonEmptyDynamicArrayTest {
    public DynamicArray dArr = new DynamicArray();

    for (int i = 0; i < 10; i++){  // не знам защо ми дава грешка.
        dArr.add(i);
    }

    @Test
    public void capacity_returnsCorrectCapacity(){
        assert dArr.capacity() == i;
    }
    @Test
    public void size_returnsCorrectSize(){
        assert dArr.size() == i-1;
    }
    @Test
    public void isEmpty_returnsFalseForNonEmpty(){
        assert Objects.equals(dArr.isEmpty(), false);
    }
    @Test
    public void get_returnsCorrectIndex(){
        assert dArr.get(i-1) == i-1;
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