package performance;

import algorithms.divideandconquer.QuickSort;

public class PerformanceTest {
    public static long measureExecutionTime(Runnable algorithm) {
        long startTime = System.nanoTime();
        algorithm.run();
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    public static void main(String[] args) {
        // Example of measuring QuickSort performance
        int[] arr = {10, 7, 8, 9, 1, 5};
        long quickSortTime = measureExecutionTime(() -> {
            QuickSort quickSort = new QuickSort();
            quickSort.sort(arr);
        });
        System.out.println("QuickSort execution time: " + quickSortTime + " nanoseconds");
    }
}
