package com.beepscore.android.arbitrarylinkedlist;

import java.util.HashMap;

/**
 * Created by stevebaker on 5/15/15.
 * Manages an Arbitrary Linked List of Node objects.
 */
public class ArbitraryLinkedListManager {

    /**
     * Maps original node to cloned node
     * Can check to avoid re-cloning a node that already exists.
     */
    // Use Map interface, Dictionary is obsolete.
    // http://docs.oracle.com/javase/7/docs/api/java/util/Dictionary.html
    // Also HashMap allows value null, Dictionary HashTable doesn't
    public HashMap<Node, Node> correspondingNodes;

    /**
     * Clones list from start node through last node inclusive.
     * At each original node, make a clone and record them in correspondingNodes.
     * @param startNode is the starting node in the original list
     * @return the starting node in the clone list
     */
    public Node cloneList(Node startNode) {

        if (startNode == null) {
            return null;
        }

        correspondingNodes = new HashMap<Node, Node>();

        Node originalNode = startNode;

        while (originalNode != null) {

            Node cloneNode = null;
            if (correspondingNodes.get(originalNode) != null) {
                // The corresponding cloneNode already exists. Use it.
                cloneNode = correspondingNodes.get(originalNode);
            } else {
                cloneNode = new Node();
                // put cloneNode in correspondingNodes immediately to
                // prevent accidental duplication later
                correspondingNodes.put(originalNode, cloneNode);
            }

            cloneOriginalProperties(originalNode, cloneNode);

            // Note at the last node originalNode.next == null
            originalNode = originalNode.next;
        }
        return correspondingNodes.get(startNode);
    }

    protected void cloneOriginalProperties(Node originalNode, Node cloneNode) {
        cloneNode.value = originalNode.value;
        cloneOriginalNext(originalNode, cloneNode);
        cloneOriginalArbitrary(originalNode, cloneNode);
    }

    protected void cloneOriginalNext(Node originalNode, Node cloneNode) {
        if (originalNode.next != null) {
            cloneNode.next = new Node();
            correspondingNodes.put(originalNode.next, cloneNode.next);
        }
    }

    protected void cloneOriginalArbitrary(Node originalNode, Node cloneNode) {
        if (originalNode.arbitrary != null) {

            if (correspondingNodes.get(originalNode.arbitrary) != null) {
                // The corresponding clone node already exists. Use it.
                cloneNode.arbitrary = correspondingNodes.get(originalNode.arbitrary);
            } else {
                cloneNode.arbitrary = new Node();

                // This fixes failing testCloneListMultipleArbitraryArbitrary
                // However setting it elsewhere might be more readable.
                // TODO consider moving this elsewhere
                cloneNode.arbitrary.value = originalNode.arbitrary.value;

                correspondingNodes.put(originalNode.arbitrary, cloneNode.arbitrary);
            }
        }
    }

}
