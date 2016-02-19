# Practice

## Task 1: Sorting 

Sort random array of integer numbers using 2 of the following sort algorithms: 

- bubble sort
- optimized bubble sort 
- insertion sort 
- selection sort

---
Note: I've implemented all of the above algorithms

See the solution - [ArraySort.java](ArraySort.java)

## Task 2: Search for an element in the array

Take 2 integer numbers from the console: 

- array size `n` and 
- number to search `i` in the array

Generate random array of integers of size `n` and print it. Verify if the element `i` is present in the array, if it does, print `true`, otherwise print `false` 

Use several search algorithms. For example: 

- regular search one by one;
- binary search 

Compare execution time.

---
See the solution - [ArraySearch.java](ArraySearch.java)

## Task 3: Count element occurrences in a String

Your program should request an input of 1 symbol form the consoles and count a number occurrences of this symbol in a pre-created text and print it to the console. The text may be hard-coded as a String in your code or stored in .txt file

---
See the solution - [CountOccurences.java](CountOccurences.java)

## Task 4: Find Minimum

Create a class `FindMinimum` with the following methods:

1. `findMin` that takes 2 integer arguments and returns the lowest
2. `findMin` that takes 2 integer arguments and returns the lowest (using the first method)
3. `findMin` that takes 2 integer arguments and returns the lowest (using the previous method)

---
See the solution - [FindMinimum.java](FindMinimum.java)

## Task 5: Tower of Hanoi 

There are 3 sticks "A", "B", "C". On the "A" stick there are "n" (this number should be taken from the console) disks, represented by integers from 1 to N (where 1 is the smallest and n is the biggest). You should move the tower from "A" to "C" following the rule that each disk may be only put on the bigger disk (n can only be lowest, 1 can be putted on any disk) 

Create a program that will take the number of disks and print the steps required to move the tower to the "C" stick (example: "1 moved from A to C").  

Use recursive method. 

---
See the solution - [HanoiTower.class](HanoiTower.class)