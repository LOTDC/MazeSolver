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

## Usage

1. Run the program.
2. Enter the filename of the maze text file when prompted.
3. The program reads the maze, explores paths, and prints the reachable treasure paths.

## Input File Format

- The maze text file should consist of characters representing the maze structure.
- The entrance is denoted by '1' and '0', and 'E' indicates the exit.
- '|' and '-' represent walls, and '+' is used for corners.
- The program ignores walls and corners during path exploration.

## Example

```java
javac MSolver.java
java MSolver
Enter the filename: maze.txt
