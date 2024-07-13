
import algorithms.divideandconquer.QuickSort;
import algorithms.divideandconquer.MergeSort;
import algorithms.greedy.PrimMST;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Choose an algorithm to run:");
            System.out.println("1. QuickSort");
            System.out.println("2. MergeSort");
            System.out.println("3. Prim's MST");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    runQuickSort(scanner);
                    break;
                case 2:
                    runMergeSort(scanner);
                    break;
                case 3:
                    runPrimMST(scanner);
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void runQuickSort(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void runMergeSort(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(arr);
        System.out.println("Sorted array:");
        printArray(arr);
    }

    private static void runPrimMST(Scanner scanner) {
        System.out.println("Enter the number of vertices:");
        int V = scanner.nextInt();
        int[][] graph = new int[V][V];
        System.out.println("Enter the adjacency matrix:");
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                graph[i][j] = scanner.nextInt();
            }
        }
        PrimMST primMST = new PrimMST();
        primMST.primMST(graph);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
