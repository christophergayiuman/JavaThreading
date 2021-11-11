package com.company;

import com.company.Pebble;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PebbleTest {
    // create a pebble
    Pebble pebble = new Pebble(10);

    @Test
    void testGetWeight() {
        // checks pebble weight
        assertEquals(10, pebble.getWeight());
    }

}