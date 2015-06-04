package com.beepscore.android.arbitrarylinkedlist;

import android.util.Log;

import junit.framework.TestCase;

import java.util.HashMap;

/**
 * Created by stevebaker on 5/16/15.
 */
public class ArbitraryLinkedListManagerTest extends TestCase {

    ArbitraryLinkedListManager listManager;

    public void setUp() throws Exception {
        super.setUp();
        listManager = new ArbitraryLinkedListManager();
    }

    public Node getSampleListMultipleArbitrary() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();

        a.value = "A";
        b.value = "B";
        c.value = "C";
        d.value = "D";

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        a.arbitrary = c;
        d.arbitrary = b;

        return a;
    }

    public Node getSampleListArbitraryLinksToStart() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        Node d = new Node();

        a.value = "a";
        b.value = "b";
        c.value = "c";
        d.value = "d";

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = null;

        c.arbitrary = a;

        return a;
    }

    /*
     * Check test data
     */
    public void testGetSampleListArbitraryLinksToStart() {
        Node startNode = getSampleListArbitraryLinksToStart();
        assertNotNull(startNode.next);
        assertNotNull(startNode.next.next);
        assertNotNull(startNode.next.next.next);
        assertNull(startNode.next.next.next.next);

        assertEquals("a", startNode.value);
        assertEquals("b", startNode.next.value);
    }

    public void testArbitraryLinkedListManager() {
        assertNotNull(listManager);
    }

    public void testCorrespondingNodes() {
        listManager.correspondingNodes = new HashMap<Node, Node>();

        Node originalNode = new Node();
        listManager.correspondingNodes.put(originalNode, null);
        // get value for key
        assertNull(listManager.correspondingNodes.get(originalNode));

        Node cloneNode = new Node();
        listManager.correspondingNodes.put(originalNode, cloneNode);
        assertEquals(cloneNode, listManager.correspondingNodes.get(originalNode));
    }

    public void testCloneOriginalNext() {
        Node a = new Node();
        Node b = new Node();
        Node cloneA = new Node();

        a.value = "a";
        b.value = "b";
        a.next = b;

        listManager.correspondingNodes = new HashMap<Node, Node>();
        listManager.cloneOriginalNext(a, cloneA);
        assertNotNull(cloneA.next);

        // cloneOriginalNext doesn't set cloned next node's value
        assertNull(cloneA.next.value);
    }


    public void testCloneList() {
        Node startNode = getSampleListArbitraryLinksToStart();
        Node cloneStartNode = listManager.cloneList(startNode);

        Log.d("correspondingNodes",
                listManager.correspondingNodes.toString());

        assertEquals(cloneStartNode,
                listManager.correspondingNodes.get(startNode));

        assertEquals(4, listManager.correspondingNodes.size());

        assertNotNull(cloneStartNode.next);
        assertNotNull(cloneStartNode.next.next);
        assertNotNull(cloneStartNode.next.next.next);
        assertNull(cloneStartNode.next.next.next.next);

        assertEquals("a", cloneStartNode.value);
        assertEquals("b", cloneStartNode.next.value);
        assertEquals("c", cloneStartNode.next.next.value);
        assertEquals("d", cloneStartNode.next.next.next.value);
    }

    public void testCloneListArbitraryLinksToStart() {
        Node startNode = getSampleListArbitraryLinksToStart();
        Node cloneStartNode = listManager.cloneList(startNode);

        assertNull(cloneStartNode.arbitrary);
        assertNull(cloneStartNode.next.arbitrary);
        assertNotNull(cloneStartNode.next.next.arbitrary);
        assertNull(cloneStartNode.next.next.next.arbitrary);

        assertEquals("c", cloneStartNode.next.next.value);
        assertEquals("a", cloneStartNode.next.next.arbitrary.value);
    }

    public void testCloneListMultipleArbitraryArbitrary() {
        Node startNode = getSampleListMultipleArbitrary();
        Node cloneStartNode = listManager.cloneList(startNode);

        assertNotNull(cloneStartNode.arbitrary);
        assertNull(cloneStartNode.next.arbitrary);
        assertNull(cloneStartNode.next.next.arbitrary);
        assertNotNull(cloneStartNode.next.next.next.arbitrary);

        assertEquals("A", cloneStartNode.value);
        assertEquals("C", cloneStartNode.arbitrary.value);

        assertEquals("D", cloneStartNode.next.next.next.value);
        assertEquals("B", cloneStartNode.next.next.next.arbitrary.value);
    }
}

