# Number of Islands (DFS) - Java

## Problem Overview

This project contains a Java implementation of the **Number of Islands** problem using the **Depth First Search (DFS)** algorithm.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. The goal is to count how many separate islands exist in the grid.

This problem is commonly asked in coding interviews and appears on **LeetCode-200 as **Number of Islands**.

---

## Problem Statement

Given a 2D grid consisting of `'1'` (land) and `'0'` (water), return the **number of islands**.

Two land cells are considered part of the same island if they are connected **up, down, left, or right**.

---

## Approach Used

The solution uses **Depth First Search (DFS)**.

### Steps

1. Traverse every cell of the grid.
2. If a cell contains `'1'`, it represents the start of a new island.
3. Call DFS to explore all connected land cells.
4. During DFS, mark visited land cells as `'0'` to avoid revisiting.
5. Increase the island count.
6. Continue until the entire grid is processed.

---

## Algorithm (DFS)

```id="dfs_code"
DFS(i, j):
    If cell is out of bounds OR cell is water ('0')
        return

    Mark current cell as visited ('0')

    Explore neighbors
        DFS(i-1, j)
        DFS(i+1, j)
        DFS(i, j-1)
        DFS(i, j+1)
```

---

## Time and Space Complexity

**Time Complexity**

```id="time_complexity"
O(N × M)
```

Every cell in the grid is visited at most once.

**Space Complexity**

```id="space_complexity"
O(N × M)
```

Due to recursion stack in the worst case.

---

## Example

### Input Grid

```id="input_grid"
1 1 0 0 0
1 1 0 0 0
0 0 1 0 0
0 0 0 1 1
```

### Output

```id="output"
Number of Islands: 3
```

---

## How to Run

1. Clone the repository
2. Open the project in Eclipse or any Java IDE
3. Compile and run the Java file

```id="run_command"
Run As → Java Application
```

---

## Concepts Covered

* Depth First Search (DFS)
* Graph traversal in grids
* Recursion
* Matrix traversal

---

## Author

Adarsh Kumar Jha
