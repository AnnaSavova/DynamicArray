package test;

import dynamicarray.DynamicArray;
import org.junit.jupiter.api.Test;


class DynamicArrayTest {
    private final DynamicArray darr = new DynamicArray();
    @Test
    public void notEmpty() {
        assert !darr.isEmpty();
    }

    // до колко мога да reference-вам base класа
}