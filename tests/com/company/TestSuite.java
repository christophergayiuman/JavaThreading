package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BagTest.class,
        GameSetupTest.class,
        PebbleGameTest.class,
        PebbleTest.class
})

public class TestSuite {
}

