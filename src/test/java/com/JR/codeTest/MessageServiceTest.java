package com.JR.codeTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class MessageServiceTest {
    @DisplayName("Test MessageService.get()")
    @Test
    void testGet() {
        Assertions.assertEquals("Hello Junit5", MessageService.get());
    }
}
