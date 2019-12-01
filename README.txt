Thabani Dube

These are solutions to the follwiong problems involving applications of the folliwing graph algorithm's:
1. Kruskal's minimum-spanning-tree algorithm
2. Bellman-Ford weighted digraph shortest path algorithm

The implementations are solutions to the following problems:

PROBLEM 2:
Given is a weighted undirected graph G = (V, E) with positive weights and a subset of its edges F ⊆ E.
An F-containing spanning tree of G is a spanning tree that contains all edges from F (there might be
other edges as well). Give an algorithm that finds the cost of the minimum-cost F-containing spanning
tree of G and runs in time O(m log n) or O(n^2).
Input: The first line of the text file in input stores n and m. The following lines store data about edges
(u, v) in order u, v, weight, 0 or 1. It writes 0 if the edge is not in the set F, 1 otherwise.
Output: Only one value, the cost of the tree or -1 if there is no such tree. The output is written to Java
standard output.

PROBLEM 4:
In the small land of Akrokeraunaia, there are a number of magic cities. One of them is the capital.
Cities are connected to each other through roads. Every year a single person from each city can visit the
capital. Visitors are selected based on a competition. The rules are as follows:
1. The candidates will start running from their cities. (at the same times)
2. The entry into the capital will be permitted only for a fixed amount of time (T) from when they all
start running.
3. Whoever can enter the capital during that fixed time will surely be permitted to visit the capital
city.
Given the connections and the distances between the cities and the capital, the aim is to write a
program that finds out how many candidates can visit the capital. In designing the program you can
assume the candidates will find a route so that they can get to the capital before the entry closes, if
there is one.
Note: cities are numbered from 0 to V-1.
Input:
First line will contain the number of cities (V), number of roads (E) and time for which gate will be
open for the capital (T).
E lines will follow, each containing 3 integers in the format:
c1 c2 t
where c1 and c2 are the two cities having a road between them and it takes time t to go from one city to
another. Note that all the roads are bidirectional and the city numbered 0 is the capital city.
Output:
A single integer (in standard output) representing number of candidates that can visit the capital.
Constraints: 1 <= V <= 100, 1 <= E <= 100, 1 <= t <= 100


This repo contains the following files: 

1.  README.txt
2.  P2.java - implementation for Problem 2
3.  P4.java - implementation for Problem 4
4.  p2_in1  - sample input for P2.java
5.  p2_in2  - sample input for P2.java
6.  p2_out1 - expected output
7.  p2_out2 - expected output
8.  p4_in1  - sample input for P4.java
9.  p4_in2  - sample input for P4.java
10. p4_out1 - expected output
11. p4_out2 - expected output


To test Problem 2 and 4 use the follwong commands on the cmd:

java P2 <intputFileName>
java P4 <intputFileName>

Output will be informative on the console and you can match this with the provided test files
 * java P2 p2_in1 will produce same result as given in p2_out1
 * java P2 p2_in2 will produce same result as given in p2_out2

 * java P4 p4_in1 will produce same result as given in p4_out1
 * java P4 p4_in2 will produce same result as given in p4_out2


