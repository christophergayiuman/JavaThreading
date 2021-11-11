package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PebbleTest {
    // create a pebble
    Pebble pebble = new Pebble(10);

    @Test
    void testGetWeight() {
        // checks pebble weight
        assertEquals(10, pebble.getWeight());
    }

}