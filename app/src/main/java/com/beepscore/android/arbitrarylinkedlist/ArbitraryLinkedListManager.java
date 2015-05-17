package com.beepscore.android.arbitrarylinkedlist;

import java.util.Set;

/**
 * Created by stevebaker on 5/15/15.
 * Manages an Arbitrary Linked List of Node objects.
 */
public class ArbitraryLinkedListManager {

    /**
     * Keeps inventory of cloned nodes.
     * Can check to avoid re-cloning a node that already exists.
     */
    public Set<Node> clonedNodeSet;

}
