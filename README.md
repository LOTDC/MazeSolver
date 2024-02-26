# MazeSolver (Java)

## Overview

This Java program, named `MSolver`, is designed to solve maze problems and find all reachable treasure paths within the maze. The program uses a stack-based approach to explore paths and store solutions.

## Table of Contents

- [Classes](#classes)
  - [`Stack`](#1-stack)
  - [`MSolver`](#2-msolver)
- [Usage](#usage)
- [Input File Format](#input-file-format)
- [Example](#example)
- [Output](#output)
- [Notes](#notes)


## Classes

### 1. `Stack`

#### Description

- The `Stack` class is used to store and manage elements in a stack data structure.
- It includes a nested `Node` class for creating nodes in the stack.

#### Methods

1. `push(String a)`: Adds an element to the stack.
2. `pop()`: Removes and returns the top element from the stack.
3. `size()`: Returns the size of the stack.

### 2. `MSolver`

#### Description

- The `MSolver` class contains the main functionality for solving mazes and finding reachable paths.
- It includes a recursive method (`ms`) to explore paths within the maze.
- The `print` method is used to print and organize the reachable paths.

#### Methods

1. `ms(char[][] m, boolean[][] cp, String mp, int a, int b, int c, int d)`: Recursive method to find all reachable treasure paths in the maze.
2. `print(Stack a)`: Organizes and prints reachable paths in order of size.
3. `main(String[] args)`: The main method to execute the program.

#### Map
Example:maze1.txt

|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |  
|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:| 
| + | - | - | + | - | - | + | - | - | + | - | - | + | - | - | + |
| a | a | a | a | a | a | a | a | a | a | a | a | a | a | E |  &#124; |
| + | b | + | c | + | - | - | + | - | - | + | - | - | + |  - | &#124;  |
| &#124;| d | + | + | &#124; | - | - | + | - | - | + | - | - | + | -  | &#124; |
| +  | e | + | + | - | - | + | - | - | + | - | - | + | - | - |  + |
| &#124; | f | g | f | g | - | + | - | - | + | - | - | + | - | -  |  +  |
| + | - | - | + | h | - | + | - | - | + | - | - | + | - | - | &#124; |
|&#124;| a | + |&#124;| d | + |&#124; | - | - |&#124;| d | + | b | c | E |&#124;   |
|+| a | + |&#124;| e | + | &#124; | E | - | + | d | + | a | + |  +     |&#124;|
|&#124;| a | b | c | d | a | b | c | d | s | a | d | s | d | a | &#124;|
|+| - | - | + | - | - | + | - | - | + | - | - | + | - |  - | +|
|   |   |   |   |   |   |   |   |   |   |   |   |   |   |   |   | 

## Usage

1. Run the program.
2. Enter the filename of the maze text file when prompted.
3. The program reads the maze, explores paths, and prints the reachable treasure paths.

## Maze features are as follows:

- Walls are represented with “+”, “-“, and “|” characters. When you see one of these characters, you can not go any further.
- Available paths are represented with lover case characters, when you see one of these characters, you can move forward.
- Treasures are represented with capital “E” characters. When you see this character, this means that you can find a path successfully.
- Avoid visiting already visited paths.
- The maze has always an entrance at the beginning of the second row and it can contain more than one “E” character. For this case, you should try to find paths for all “E”, if it is possible, there may be some E that are not reachable.
- In the end, it should print all paths according to the increasing order of path lengths. You should read the maze file name from the console.


## Example

```java
javac MSolver.java
java MSolver
Enter the filename: maze.txt
