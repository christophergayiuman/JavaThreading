package com.company;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

public class PebbleTest {
    // create a pebble
    Pebble pebble = new Pebble(10);

    @Test
    void testGetWeight() {
        // checks pebble weight
        assertEquals(10, pebble.getWeight());
    }

}