package main;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class DynamicArrayTest {

    private DynamicArray dynamicArray;

    @Before
    public void setUp() {
        dynamicArray = new DynamicArray(3);
    }

    @Test
    public void testGetCapacity() {
        assertEquals(3, dynamicArray.getCapacity());
    }

    @Test
    public void testPushAndPop() {
        dynamicArray.pushback(10);
        dynamicArray.pushback(20);
        dynamicArray.pushback(30);
        assertEquals(30, dynamicArray.popback());
        assertEquals(20, dynamicArray.popback());
        assertEquals(10, dynamicArray.popback());

        // Size has been reset to 0 after pushing and popping the same amount of times
    }

    @Test
    public void testGetAndSet() {
        dynamicArray.pushback(100);
        dynamicArray.pushback(200);
        dynamicArray.set(0, 300);
        assertEquals(300, dynamicArray.get(0));

        // Reset the size to 0
        dynamicArray.popback();
        dynamicArray.popback();
    }

    @Test
    public void testGetSize() {
        assertEquals(0, dynamicArray.getSize());
        dynamicArray.pushback(100);
        dynamicArray.pushback(200);
        assertEquals(2, dynamicArray.getSize());

        // Reset the size to 0
        dynamicArray.popback();
        dynamicArray.popback();
    }

    @Test
    public void testResize() {
        assertEquals(3, dynamicArray.getCapacity());
        dynamicArray.pushback(100);
        dynamicArray.pushback(200);
        dynamicArray.pushback(300);
        dynamicArray.pushback(400);
        assertEquals(6, dynamicArray.getCapacity()); // Upon resizing, the capacity doubles
        assertEquals(4, dynamicArray.getSize()); // We pushed 4 numbers in, so even tho capacity is 6, size should only
                                                 // be 4

        // Reset the size to 0
        dynamicArray.popback();
        dynamicArray.popback();
        dynamicArray.popback();
        dynamicArray.popback();
    }
}
