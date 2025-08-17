package org.example.springtest.assertion;

import org.example.springtest.model.entity.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AssertionTest {
    @Test
    void testStringLength(){
        String text = "JUnit";
        int length = text.length();
        assertEquals(5,length);
    }
    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class,()->{
           int result = 1/0;
        });
    }

    @Test
    void testAssertAll(){
        User person = new User(1L,"Alice");
        assertAll(
                ()->assertEquals(1L,person.getId()),
                ()->assertEquals("Alice",person.getName())
        );
    }

}
