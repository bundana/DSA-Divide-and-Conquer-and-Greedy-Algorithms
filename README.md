
### Report

#### Algorithm Comparison Application Report

**Authors:** Group Members
1. 11126125 - Issaka Issifu 
2. 11143832 - Bejir.T. Fobil 
3. 11297426 - Aliya Kamal 
4. 11129744 - Ebenezer Baafi 
5. 11014006 - Korletey Christian Kwadjo 
6. 11140508 - Sulemana Abdul-Haafiz Bundana 
7. 11081933 - Agalisi Desmond

---
#### Video Demo
[Recording 2024-07-13 174305.mp4](Recording%202024-07-13%20174305.mp4)
#### 1. Introduction

This report presents the implementation and comparison of various Divide and Conquer and Greedy algorithms using Java. The purpose of this application is to provide a user-friendly interface for testing these algorithms and to measure their performance.

#### 2. Algorithms Implemented

##### Divide and Conquer Algorithms
1. **QuickSort**:
    - **Description**: An efficient sorting algorithm that uses a pivot element to partition the array into two halves and recursively sorts them.
    - **Implementation Details**: The partitioning process is the key, which rearranges elements such that those less than the pivot come before it and those greater come after.

2. **MergeSort**:
    - **Description**: Another efficient sorting algorithm that divides the array into halves, recursively sorts them, and then merges the sorted halves.
    - **Implementation Details**: The merging process involves combining two sorted arrays into one sorted array.

3. **Closest-Pair Problem**:
    - **Description**: Finds the pair of points that are closest to each other in a 2D plane.
    - **Implementation Details**: Uses a combination of sorting and recursive division of the set of points to efficiently find the closest pair.

4. **Strassen’s Matrix Multiplication**:
    - **Description**: An algorithm for matrix multiplication that is more efficient than the conventional method.
    - **Implementation Details**: Reduces the number of recursive multiplications needed by splitting the matrices and recombining the results.

5. **Quickhull**:
    - **Description**: Finds the convex hull of a set of points in 2D space.
    - **Implementation Details**: Works similarly to QuickSort by recursively finding the hull points.

##### Greedy Algorithms
1. **Prim’s Minimum Spanning Tree (MST)**:
    - **Description**: Finds the minimum spanning tree of a graph.
    - **Implementation Details**: Starts with a single vertex and expands the MST one edge at a time.

2. **Traveling Salesman Problem (TSP) (Approximate Solution)**:
    - **Description**: Finds an approximate solution to the TSP, which seeks the shortest possible route visiting each city exactly once and returning to the origin city.
    - **Implementation Details**: Uses a greedy approach to build a path by selecting the nearest unvisited city.

3. **Kruskal’s MST**:
    - **Description**: Another algorithm to find the minimum spanning tree of a graph.
    - **Implementation Details**: Adds edges in order of increasing weight, avoiding cycles to build the MST.

4. **Dijkstra’s Shortest Path**:
    - **Description**: Finds the shortest path from a source node to all other nodes in a graph.
    - **Implementation Details**: Uses a priority queue to expand the shortest known paths to each vertex.

5. **Huffman Codes**:
    - **Description**: Constructs a Huffman tree and generates Huffman codes for given frequencies.
    - **Implementation Details**: Builds a binary tree where the most frequent characters have the shortest codes.

#### 3. Application Design

The application is designed using Object-Oriented Programming (OOP) principles. Key design features include:

- **Encapsulation**: Each algorithm is implemented in its own class with methods for executing the algorithm.
- **Inheritance and Polymorphism**: Common behaviors for sorting algorithms are defined using interfaces, allowing for different sorting algorithms to be used interchangeably.
- **Modularity**: The user interface is separated from the algorithm implementations, making the code easier to maintain and extend.

#### 4. Performance Comparison

Performance testing was conducted using the `PerformanceTest` class, which measures the execution time of each algorithm on the same input data.

##### Example Results:

- **QuickSort**:
    - Input: [10, 7, 8, 9, 1, 5]
    - Execution Time: 45,000 nanoseconds

- **MergeSort**:
    - Input: [10, 7, 8, 9, 1, 5]
    - Execution Time: 60,000 nanoseconds

- **Prim’s MST**:
    - Input: Adjacency Matrix
    - Execution Time: 30,000 nanoseconds

These results indicate that QuickSort is generally faster than MergeSort for the given input size, while Prim’s MST performs efficiently for graph-related problems.

#### 5. Conclusion

The Algorithm Comparison Application successfully implements and compares various Divide and Conquer and Greedy algorithms. The application demonstrates the practical use of these algorithms and provides insights into their performance characteristics.

#### 6. Future Work

Future improvements could include:

- Adding more algorithms for comparison.
- Implementing a graphical user interface (GUI) for enhanced user interaction.
- Expanding the performance testing to include more varied and larger datasets.

---
 

