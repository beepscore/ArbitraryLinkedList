# Purpose
As an exercise, write app to "clone" a linked list.
Each node has two links, "next" and "arbitrary".

# References

# Results

## Problem Statement and additional info
The cloned list is not simply a copy of the original list.
The cloned list has the topological structure of the original list,
but the cloned nodes are new instances.

### next link
Shows "next" link as edge to "next" node.

### arbitrary link
Arbitrary can point to nothing.
Assume arbitrary can't point to itself.

### Example Structure
[A] -> [B] -> [C] -> [D]
[A].arbitrary => C
[D].arbitrary => B

### Node class
Problem statement gives node as Java class

    class Node {
        String value;
        Node next
        Node arbitrary
    }

### Notes
Objective C references all objects as pointers e.g. (Node * )node
Java doesn't use this notation.

