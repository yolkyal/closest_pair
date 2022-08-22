# closest_pair
Two implementations of solutions to the Closest Pair Problem in Computational Geometry

The Closest Pair Problem is defined as follows: Given n points in metric space, find the pair of points with the smallest distance between them.

This repository contains two solutions to this problem:

Naive: This is a standard naive approach whereby each point is compared for distance with every other point, keeping a record of the closest pair found which is then output. This solution has O(n^2) worst case and average time complexity.

Randomised Linear: This solution first approximates a shortest distance between points by comparing each point with one random other point. Next, each point is snapped to a coordinate grid separated by this distance. Finally, we iterate through this grid, comparing each cell's points to the points in the adjacent cells, thereby massively reducing the number of comparisons made. This soluaiton has O(n^2) worst case complexity but O(n) average time complexity.
