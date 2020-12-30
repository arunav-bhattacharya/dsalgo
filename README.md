# Data Structures & Algorithms

> This is a repo of most commonly used Data Structures & Algorithms written in Java 8, and can also be a used as a guide for preparing for product based company interviews. The repo is currently in progress. The topics that are present is marked as complete -

## Topics

### 0 Big O
- [ ] Asymptotic Analysis

### 1 Arrays
- [x] Insertion
- [x] Deletion
- Searching
    - [x] Linear Search
    - [x] Binary Search
- [ ] Duplicate Check
- [ ] Random Shuffle

### 2 Simple Sorting
- [x] **Bubble Sort**
    - Array is sorted from the end.
    - Iterate through the array to compare 2 successive elements to check LHS > RHS. If yes, swap them.
    - Largest element goes to the right hand side after each iteration.
- [x] **Selection Sort**
    - Array is sorted from the front
    - Iterate through the array to find the shortest element and bring it to the front of the array.
- [x] **Insertion Sort**
    - From start to end there is only one iteration.
    - During each iteration, each element is compared with previous element.
    - If LHS > RHS, then we can swap until it is placed in the correct position.
- [ ] **Sorting Objects**

### 3 Stack
- [x] Stack implementation using Array
- [x] Reversing a String using Stack
- [x] Bracket Checker using Stack
- [ ] Infix to Postfix
    
### 4 Queues
- [x] Queue implementation using Array
- [x] Circular Queue
- [x] Priority Queue using Array

### 5 Linked Lists
- [x] Implement insert, delete, find using -
    -  [x] Singly Linked List 
    -  [x] Double-ended or Circular Linked List
    -  [x] Doubly Linked List
- [x] Implement Abstract Data-Type(ADT) using a Linked List 
    -  [x] Implement Stack using a Linked List
    -  [x] Implement Queue using a Linked List
- [x] Sorted Linked List
- [ ] Remove duplicates from Linked List
- [ ] Concatenate 2 Linked Lists
- [ ] Merge 2 Linked Lists
- [ ] Reverse a Linked List
    
### 6 Recursion
- [x] Factorials
- [x] Fibonacci
- [x] Binary Search
- [ ] Towers of Hanoi
- [ ] Anagrams

### 7 Advanced Sorting
- [x] Merge Sort 
     -  [x] Recursive
     -  [x] Iterative
- [x] Shell Sort using Comparable
- [x] Quick/Partition Sort using Comparator
    
### 8 Binary Search Trees (BST)

#### Binary Tree

- Height of a Tree
- Level of a Tree

#### Strict Binary Tree

#### N-ary Tree

#### Strict N-ary Tree

#### Representation of Binary Tree
- Array
- Linked List

#### Tree Traversals
- Pre-Order
- In-Order
- Post-Order
- Level-Order

#### Implementation of BST 

- [x] Implement Binary Search Tree using Linked List
    -  [x] Insertion
    -  [x] Search
    -  [x] Deletion
    -  Display Recursive Traversals
          - [x] Preorder
          - [x] Inorder
          - [x] Postorder
    -  Display Iterative Traversals
          - [x] Preorder
          - [x] Inorder
          - [x] Postorder
    -  Display Traversals without Stack or Queue (Threaded Binary Tree)
          - [ ] Preorder
          - [ ] Inorder
          - [ ] Postorder
    - [x] Level Order Traversal
    - [ ] Huffman Coding for keys compression

### 9 Balanced Search Trees

#### 2-3 Tree

#### 2-3-4 Tree

#### AVL Tree

#### Red-Black Trees
- It is a height balanced BST

1. Every node is either Red or Black.
2. Root is always Black.
3. Null child is also Black.   
4. If node is Red, children must be Black. No two consecutive red nodes can exist. Parent and children of Red Node is always Black for balanced Red-Black Tree.
5. Every path from root to leaf-node or null-child, must contain same number of black nodes, i.e. the black height should be the same.
6. New inserted node is Red. If there is any violation after insertion, then fix it using the below mentioned rules.
7. Height of Red-Black Tree is `log N <= height <= 2 log N`

##### Fixing Rule violations in Red-Black Tree:
- Re-color/Change the color of the nodes
- Perform rotations (LL, LR, RR, RL)

#### Implementation of Balanced Search Trees 

- [ ] *Implement 2-3 Tree (Not mandatory)*
    - [ ] Insertion
    - [ ] Search
    - [ ] Deletion
    - [ ] Display
- [ ] *Implement 2-3-4 Tree (Not mandatory)*
    - [ ] Insertion
    - [ ] Search
    - [ ] Deletion
    - [ ] Display
- [x] *Implement AVL Tree (Not mandatory)* 
    - [x] Insertion
    - [x] Search
    - [x] Deletion
    - [x] Display
- [ ] *Implement Red Black Tree (Not mandatory)* 
    - [x] Insertion
    - [x] Search
    - [ ] Deletion
    - [x] Display
- [ ] *Implement Interval Search Tree (Not mandatory)* 
    - [ ] Insertion
    - [ ] Search
    - [ ] Deletion
    - [ ] Display
             
### 10 Heaps
> Heaps need to satisfy the Heap condition, which states each nodes key is going to be greater than or equal to the keys of its children (for Max Heap and vice-versa for Min Heap).

#### Properties of Heap:
- Heap is a complete Binary Tree
- For Max Heap, every node/element/key should be greater than or equal to its children.
- For Min Heap, every node/element/key should be lesser than or equal to its children.
- Height of complete Binary Tree is always `log N`.
- Heap represented using an array, for a parent node of index `i`, the child nodes can be accessed using the following formula -
    - `leftChild = 2*i + 1`
    - `rightChild = 2*i + 2`
- Similarly, parent of a child node `i` can be accessed using the following formula -
    - `parent = (i-1)/2 //rounded of to the lowest int`

#### Insertion in Max Heap

For a Heap represented using array, the following process is followed for insertion of a new element in the heap - 
- New element will be inserted at the end of the array.
- Re-arrange the elements in the Heap by moving up the higher element to the top, until all children in the heap is smaller than the parent.
- Time complexity of the operation is `O(logN)`.  
- During insert, _largest element is moved from leaf to root_.

#### Deletion in Max Heap

Again for a Heap represented using array, the largest element can be deleted using a similar process.
- The topmost element (or root) in the heap (the first element in the array) is deleted.
- After deletion the last element in the array will take the position of the root.
- Re-arrange the elements following the binary heap rule, i.e., moving the highest element to the top so that all the nodes in heap is greater than equal to its children.
- Time complexity of the operation is `O(logN)`.
- During delete, _smallest element is moved from root to leaf_.

#### Heap Sort

- The deleted element from the heap can be added to the end of the array.
- After deleting all the elements in the array and moving it to the end of the array, the array becomes sorted.
- Since each delete operation in heap takes `O(logN)`, so for performing delete operations on `N` elements to make the array sorted, the total time complexity for Heap sort is `O(NlogN)`.

#### Heapify

- Heapify is a fast way of creating a heap.
- Whenever insertion is performed, check for a valid heap for all nodes starting from the leaf node.
- Once leaf node is validated, check for its parents as well until the root node.
- Since each insert operation in heap takes `O(logN)`, so for performing insert operations on `N` elements to build the heap, the total time complexity for Heapify for `N` elements is `O(NlogN)`.

#### Implementation of Heap:
  
- [x] Implement using Array
    -  Insertion
    -  Search
    -  Deletion
    -  Display
- [x] Heap Sort
- [x] Implement Priority Queue using Heap
- [x] Create a Heap using Heapify 

### 11 Hash Tables

#### Hashing & Hash-Function

#### Hash-Collision

#### Hashing Technique

- Open Hashing
  - Chaining
- Closed Hashing
  - Open addressing
    - Linear Probing
    - Quadratic Probing
    - Double Hashing
  
#### Chaining

#### Linear Probing

#### Quadratic Probing

#### Double Hashing

#### Hash Functions
- Mod
- Mid Square
- Folding

#### Implementation

- [x] Implement using Array - Linear Probing
    -  Insertion
    -  Search
    -  Deletion
    -  Display
- [x] Implement using Array - Quadratic Probing
    -  Insertion
    -  Search
    -  Deletion
    -  Display
- [x] Implement using Array - Double Hashing
    -  Insertion
    -  Search
    -  Deletion
    -  Display
- [x] Implement using Linked List - Double Hashing
    -  Insertion
    -  Search
    -  Deletion
    -  Display

### 12 Graphs
- [x] Graph Representation
    - [x] Adjacency Matrix
    - [x] Adjacency List
- [x] Undirected Graph    
    - [x] Implement Breadth First Search
    - [x] Implement Depth First Search
    - [x] Shortest path from vertex u to v
    - [x] Connected components 
    - [x] Cycle Detection 
    - [x] Check if a Graph is bipartite
    - [x] Find all bridges in a graph
    - [ ] Find all articulation points in a graph
- [x] Directed Graph 
    - [x] Topological Sort
    - [x] Cycle Detection
    - [x] Depth-First Order
    - [x] Strongly connected components
        - [x] Kosaraju-Sharir's Algorithm

### 13 Advanced Graph Algorithms
- [x] Edge-Weighted Digraph
    - [x] Representation                           
- [x] Minimum Cost Spanning Tree
    - [x] Prim's Algorithm
    - [x] Kruskal's Algorithm
- [ ] Shortest Path Algorithm
    - [x] Dijkstra's (single-source, supports positive edges only)
    - [ ] Bellman Ford (single-source, supports negative edges also)
    - [ ] Floyd Warshall (all pair)
- [ ] Max Flow
    - [ ] Ford-Fulkerson
    
### 14 Tries
- [x] Representation
    - [x] Using Arrays
    - [x] Using HashMap
- [x] Operations
    - [x] Insertion
    - [x] Deletion
    - [x] String Search     
    - [x] Prefix Search

### 15 Substring Search
- [x] Brute-Force
- [x] Knutt-Morris-Pratt (KMP)
- [ ] Boyer-Moore
- [x] Rabin-Karp

### 16 Union-Find / Disjoint Sets
- [x] Implement Quick-Find
- [x] Implement Quick-Union

### 17 Dynamic Programming
- [ ] Memoization
- [ ] Tabulation
- [ ] Problems
    https://www.youtube.com/playlist?list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr

### 18 Backtracking
- [ ] Problems
    - [ ] N Queens
    - [ ] Sum of Subsets
    - [ ] Graph Coloring
    - [ ] Hamiltonian Cycle

### 19 Branch & Bound
- [ ] Problems
    - [ ] Job Sequencing
    - [ ] 0/1 Knapsack
    - [ ] Travelling Salesman 

### 20 Bit Manipulation Techniques
- [ ] Bitwise Operators 
    - [ ] Complement (~)
    - [ ] And (&)
    - [ ] Or (|)
    - [ ] XOR (^)
    - [ ] Left Shift (<<)
    - [ ] Right Shift (>>)

### 21 Matrices
- [ ] Diagonal Matrix
- [ ] Lower Triangular Matrix
- [ ] Upper Triangular Matrix
- [ ] Tri-Diagonal Matrix
- [ ] Toeplitz Matrix
- [ ] Sparse Matrix

### 22 Miscellaneous 
- [ ] Segment Trees
- [ ] Suffix Tree
- [ ] Suffix Array