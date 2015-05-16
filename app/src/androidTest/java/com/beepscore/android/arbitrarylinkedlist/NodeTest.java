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

}
