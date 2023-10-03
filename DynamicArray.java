package main;
class DynamicArray {

    private int[] arr;
    private int size;
    private int capacity;

    // Constructor to initialize the dynamic array
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[this.capacity];
    }

    // Return the element at valid index i
    public int get(int i) {
        return arr[i];
    }

    // Set the element at valid index i to n
    public void set(int i, int n) {
        arr[i] = n;
    }

    // Push n to the end of the array
    public void pushback(int n) {
        if (size == capacity) {
            resize();
        }
        arr[size] = n;
        size++;
    }

    // Pop and return the element at the end of the array, assuming non-empty array
    public int popback() {
        if (size > 0) {
            size--; // soft delete the last element
        }
        return arr[size];

        /* Example
        [10 20 30 40 - -]
        size = 4
        capacity = 6
        size-- so that it becomes 3
        arr[3] = 40, the value we want to return
        */
    }

    // Double the capacity of the array
    private void resize() {
        capacity *= 2;
        int[] newArr = new int[capacity];
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
    }

    // Return the number of elements in the array
    public int getSize() {
        return size;
    }

    // Return the capacity of the array
    public int getCapacity() {
        return capacity;
    }
}

