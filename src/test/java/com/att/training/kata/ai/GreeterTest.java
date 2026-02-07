package com.att.training.kata.ai;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreeterTest {
    @Test
    void shouldReturnHelloAI() {
        Greeter greeter = new Greeter();
        assertEquals("Hello AI", greeter.greet());
    }
}
