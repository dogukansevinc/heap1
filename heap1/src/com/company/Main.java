package com.company;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        // insert random values
        heap.insert(52);
        heap.insert(25);
        heap.insert(2);
        heap.insert(10);
        // print the heap
        heap.printHeap();
        // print minimum value
        System.out.println( heap.getMinValue() );
        // print height
        System.out.println( heap.getHeight() );

        int[] arrayC = {90, 70, 2, 15, 65, 164, 18, 40, 58, 77, 303};
        // build heap from array
        int[] min_heap =  heap.buildHeap(arrayC);
        // check for min heap
        System.out.println( heap.checkMinHeap(min_heap) );
        // print the heap
        heap.printHeap();

    }
    
}
