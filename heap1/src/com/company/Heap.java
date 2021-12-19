package com.company;

public class Heap {
    private int currentSize;
    private int[] heapArray;

    // Constructors
    public Heap()
    {
        setCurrentSize(0);
        heapArray = new int[1];
    }

    public Heap(int capacity)
    {
        setCurrentSize(0);
        heapArray = new int[capacity + 1];
    }

    // Heap Operations
    public int[] buildHeap(int[] array)
    {
        // Builds the heap from an array that you have provided
        currentSize = array.length;
        heapArray = new int[(currentSize + 1)];

        for (int i = 0; i < array.length; i++) {
            heapArray[i + 1] = array[i];
        }

        for (int i = currentSize / 2; i > 0; i--)
        {
            percolateDown(i);
        }
        return heapArray;
    }

    private void percolateDown(int hole)
    {
        // Organizes the elements of the heap and percolate down the elements for not violating heap properties
        int child;
        int tmp = heapArray[hole];

        for( ; hole * 2 <= currentSize; hole = child)
        {
            child = hole * 2;

            if(child != currentSize && Integer.compare(heapArray[child + 1], heapArray[child]) < 0)
            {
                child++;
            }

            if(Integer.compare(heapArray[child], tmp) < 0)
            {
                heapArray[hole] = heapArray[child];
            }
            else
                break;
        }

        heapArray[hole] = tmp;
    }

    public int getMinValue()
    {
        // first element is minimun
        // returns the frist element
        return heapArray[1];
    }

    public int getHeight()
    {
        // returns the height of heap
        return (int)Math.ceil(Math.log(currentSize + 1) / Math.log(2)) - 1;
    }
    public boolean checkMinHeap(int[] array){
        return _checkMinHeap(array, 1);
    }
    private boolean _checkMinHeap(int [] arr, int i){
        if (i >= (arr.length - 2) / 2)
            return true;
        // if parent is less than left child
        // and
        // parent is less than right child
        // and
        // call for left child and call for right child
        if (arr[i] <= arr[2 * i ] && arr[i] <= arr[2 * i + 1] && _checkMinHeap(arr, 2 * i) && _checkMinHeap(arr, 2 * i + 1))
            return true;

        return false;
    }
    public void insert(int value)
    {

        // if size of heapArray is less than currentSize + 1
        // increment the size.
        while(currentSize + 1 >= heapArray.length){
            enlargeArray(1 + heapArray.length);
        }
        // insert the value
        heapArray[currentSize+1] = value;
        // increment the size
        currentSize++;
        // heapify
        percolateUp (value, currentSize);
    }

    private void percolateUp(int value, int hole)
    {
        if(hole <= 1)return;
        int par = hole/2;
        // if parent node is greater than child node, then swap both
        // the nodes and call percolateUp for parent node
        if(heapArray[par] > value){
            int temp = heapArray[par];
            heapArray[par] = value;
            heapArray[hole] = temp;
            percolateUp(value, par);
        }
    }


    public boolean search(int value)
    {
        // Searches the heap for if the given value is present or not, returns TRUE if value is present, FALSE otherwise

        // IMPLEMENT THIS METHOD
        // ...
        for(int i=0;i<currentSize;i++){
            if(heapArray[i] == value)
                return true;

        }
        return false;
    }

    // Helper Methods
    public boolean isEmpty()
    {
        return currentSize == 0;
    }

    public void makeEmpty()
    {
        currentSize = 0;
    }

    private void enlargeArray(int newSize)
    {
        // Enlarges array to the new size
        int[] old = heapArray;
        heapArray = new int[newSize];

        for( int i = 1; i < old.length; i++)
            heapArray[i] = old[i];
    }

    public void printHeap()
    {
        // Prints the heap elements one by one
        for (int i = 1; i < heapArray.length; i++)
        {
            System.out.println(heapArray[i]);
        }

        System.out.println("---------------------------");
    }

    // Getters and Setters
    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public int[] getHeapArray() {
        return heapArray;
    }

    public void setHeapArray(int[] heapArray) {
        this.heapArray = heapArray;
    }
}
