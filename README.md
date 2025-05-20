## Project structure description
All the classes can be found in com.ncr.test.pyramid package and its subpackages.

com.ncr.test.pyramid contains main classes for running Our and Your solution

### Subpackage description:

**data** : contain data model class and appropriate factory class. (**impl** contains implementation of interfaces)

**solver** : contains solution classes to the given task

**utils** : utility classes - nothing you have worry about

### Test part of the project keeps the same logic.

**Task 1** : files to apply and possibly fix build.gradle, settings.gradle.

**Task 2** : class to fix  com.ncr.test.pyramid.solver.impl.NaivePyramidSolver.

**Task 3** : class for your solution com.ncr.pyramid.solver.impl.YourSolver

---
## Solutions

### For task #1
In order to eliminate errors during project build, the build.gradle file has been fixed:
1. Source repository.
2. Reference to the junit dependency used in unit testing.

### For task #2
The original implementation of the pyramid solution contained a bug in the **NaivePyramidSolver.getTotalAbove()** method. 

The method should not return 0 if a row with index 0 is traversed, it should return the value of an element from the corresponding column of that row. In addition, this solution uses recursive calls and is actually a bruteforce algorithm that traverses all possible paths without caching the results of previously traversed branches. 

Recursion builds a binary call tree where each path branches twice (left and right) until we reach row 0. The same subproblems are computed multiple times (a function for the same cell can be called from different paths). The asymptotic complexity to compute the entire pyramid is O(2ⁿ), where n is the number of levels. As a result, this method takes an extremely long time to execute in case of processing massive pyramids with a large number of layers. If n is at least 30, the number of calls already exceeds a billion.

However, this method can be improved by adding caching of already calculated values for previously passed cells. Then the complexity will be reduced to O(n²), because only one recursive call will be made for each cell.

### For task #3
I suggested a simpler and faster solution:

Let's represent this data structure as a branching tree, where the top level is the leaves and the bottom level (with a single value) is the root of the tree.

We will dynamically select local maxima from a pair of branches at nodes at each level in the direction from the leaves to the root. This solution has an asymptotic complexity of O(n²) in time and O(n) in memory. Although in reality the number of passes is even less, calculated by the expression n(n - 1)/2. For example, for 100 levels there will be not 10000 but 4950 passes.



