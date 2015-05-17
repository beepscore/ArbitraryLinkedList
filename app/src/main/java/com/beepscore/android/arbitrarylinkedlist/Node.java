package com.beepscore.android.arbitrarylinkedlist;

/**
 * Created by stevebaker on 5/15/15.
 */
public class Node {
    String value;
    Node next;
    Node arbitrary;

    @Override
    public String toString() {
        String valueString = "null";
        if (value != null) {
            valueString = value.toString();
        }
        String description = "value:" + valueString;
        return description;
    }
}

