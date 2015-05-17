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

### Example Linked List Structure
Arrows -> show "next" links

    [a] -> [b] -> [c] -> [d]
    [a].arbitrary == c
    [d].arbitrary == b

### Node class
Problem statement gives node as Java class

    class Node {
        String value;
        Node next
        Node arbitrary
    }
