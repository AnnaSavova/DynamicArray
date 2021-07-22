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
        //REVIEW: преди беше:
        //   assert Objects.equals(emptyArr.isEmpty(), true);
        // В този тип случаи е по-добре директно да се остави булевото условие, вместо да се сравнява с true
        assert emptyArr.isEmpty();
    }
    
    @Test
    public void remove_throwsE(){
        //REVIEW: потърсих за подходящ начин да направим това в JUnit. Преди беше:
        // try {
        //     emptyArr.remove(1);
        // } catch (Exception e){
        //     return;
        // }
        // assert false;
        // по-компактният запис е по-долу. Коригирано е и на другите места.
        // Всъщност има и още един вариант, затова разписвам функцията наново по-долу, 
        // но това работи само за JUnit 4
        try {
            emptyArr.remove(1);
            fail("No exception thrown");
        }
        catch (MyException e) {
        }
    }

    //REVIEW: още по-компактен и семантично по-ясен синтаксис за тестове, които
    // очакват да се хвърли изключение. Но е специфичен за JUnit4
    @Test
    public void remove_throwsE() throws Exception{
        exception.expect(Exception.class);
        emptyArr.remove(1);
    }

    @Test
    public void get_throwsE(){
        try {
            emptyArr.get(2);
            fail("No exception thrown");
        } catch (Exception e){
        }
    }
    @Test
    public void set_throwsE(){
        try {
            emptyArr.set(3, 12435);
            fail("No exception thrown");
        } catch(Exception e){
        }
    }
    @Test
    public void contains_throwsE(){
        try{
            emptyArr.contains(5);
            fail("No exception thrown");
        } catch (Exception e){
        }
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

    /// Returns an element, which is guaranteed to not be among the
    /// ones that are currently in the array
    int generateUniqueElement() {
        return elCount + 10;
    }

    /// Ensure that the elements in the array are correctly ordered
    boolean assertArrayIsCorrectlyOrderedUntil(int limit)
    {
        for(int i = 0; i < limit; ++i) {
            if(dArr.get(i) != i) {
                return false;
            }
        }
        return true;
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
        // REVIEW По-добре е да отречем условието
        // преди беше:
        //   assert Objects.equals(dArr.isEmpty(), false);
        assert ! dArr.isEmpty();
    }
    @Test
    public void ensureCapacity_altersCapacity(){
        dArr.ensureCapacity(79);
        assert dArr.capacity() == 79;
    }
    @Test
    public void trimToSize_trimsCapacity(){
        dArr.trimToSize();
        assert dArr.size() == dArr.capacity();
    }
    @Test
    public void add_correctlyInserts() throws Exception {
        // REVIEW
        // 1. Тук няма нужда да хващаме изключението -- ако се хвърли, значи нещо не е наред
        // try{
        //     dArr.add(2415);
        // } catch (Exception e){
            
        //     return;
        // }
        // 2. Понеже е възможно в някакъв момент да решим да тестваме, да речем с 3000 елемента, по-добре е
        // вместо да фиксираме елемента, да генерираме такъв, който няма как да се срещне в масива.
        
        int newElem = generateUniqueElement(); //REVIEW Гарантирано не е в масива, защото вътре са елементите [0,elCount-1]
        dArr.add(newElem);
        assert !dArr.isEmpty();
        assert dArr.size() == elCount + 1;
        assert dArr.capacity() >= elCount + 2;
        assert dArr.get(elCount) == newElem; //REVIEW още един тест, с който гарантираме, че елементът е добавен коректно
        assert arrayIsCorrectlyOrderedUntil() //REVIEW и още един тест, който гарантира, че другите елементи не са се разместили
    }
    @Test
    public void remove_throwsE(){
        dArr.remove(3);
        assert dArr.size() == elCount-1;
    }
    @Test
    public void clear_clearsElements(){
        dArr.clear();
        assert dArr.size() == 0;
    }
    @Test
    public void get_returnsCorrectElement() throws Exception {
        for (int i = 0; i < elCount; i++){
            assert dArr.get(i) == i;
        }
    }
    @Test
    public void set_setsCorrectValues() throws Exception {
        int val = generateUniqueElement();
        for (int i = 0; i < elCount; i++){
            dArr.set(i,val);
            assert dArr.get(i) == val;
        }
    }
}