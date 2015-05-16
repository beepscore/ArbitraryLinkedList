package com.beepscore.android.arbitrarylinkedlist;

import junit.framework.TestCase;

/**
 * Created by stevebaker on 5/16/15.
 */
public class NodeTest extends TestCase {

    public void testNodePropertiesNull() {
        Node node = new Node();
        assertNotNull(node);

        assertNull(node.value);
        assertNull(node.next);
        assertNull(node.arbitrary);
    }

    public void testNodeProperties() {
        Node curly = new Node();
        Node larry = new Node();
        Node moe = new Node();

        String testCurlyValue = "Curly";
        curly.value = testCurlyValue;
        curly.next = larry;
        curly.arbitrary = moe;

        assertEquals(testCurlyValue, curly.value);
        assertEquals(larry, curly.next);
        assertEquals(moe, curly.arbitrary);
    }
}
