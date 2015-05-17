package com.beepscore.android.arbitrarylinkedlist;

import junit.framework.TestCase;

import java.util.HashSet;

/**
 * Created by stevebaker on 5/16/15.
 */
public class ArbitraryLinkedListManagerTest extends TestCase {

    public void testArbitraryLinkedListManager() {
        ArbitraryLinkedListManager listManager = new ArbitraryLinkedListManager();
        assertNotNull(listManager);
    }

    public void testClonedNodeSet() {
        ArbitraryLinkedListManager listManager = new ArbitraryLinkedListManager();
        listManager.clonedNodeSet = new HashSet<Node>();

        Node curly = new Node();
        assertFalse(listManager.clonedNodeSet.contains(curly));
        listManager.clonedNodeSet.add(curly);
        assertTrue(listManager.clonedNodeSet.contains(curly));
    }
}

