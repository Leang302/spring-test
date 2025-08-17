package org.example.springtest.parameterizedtest;

import org.example.springtest.model.entity.User;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;


import java.time.Month;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamerterizedTest {

    // this is for single parameter method test
    @ParameterizedTest(name = "is even")
    @ValueSource(ints = {0, 10, 4, -4, 6, 12})
    void isEven(int n) {
        assertTrue(n % 2 == 0);
    }

    // this is for enum parameter method test
    @ParameterizedTest(name = "Month test")
    @EnumSource(value = Month.class, names = {"APRIL"})
    void someMonths_Are30DaysLong(Month month) {
        final boolean isALeapYear = false;
        assertEquals(30, month.length(isALeapYear));
    }

    // this is for multi parameter method test
    @ParameterizedTest
    @CsvSource({
            "1,2,3",
            "5, 7, 12",
            "10, -5, 5"
    })
    void add_returnsSum(int a, int b, int expected) {
        assertEquals(expected, a + b);
    }


        // test from actual csv file
//    @ParameterizedTest
//    @CsvFileSource(resources = "src/test/java/org/example/springtest/resources/csvFile.xlsx", numLinesToSkip = 1)
//    void add_returnsSumCsv(int a, int b, int expected) {
//        assertEquals(expected, a + b);
//    }

    static List<Arguments> stringAndLengthProvider() {
        return List.of(
                Arguments.of("apple", 5),
                Arguments.of("banana", 6),
                Arguments.of("cherry", 6)
        );
    }
    @ParameterizedTest
    @MethodSource("stringAndLengthProvider")
    void length_matchesExpected(String word, int expectedLength) {
        assertEquals(expectedLength, word.length());
    }


    //real use case to check if the method work
    static List<Arguments> userProvider(){
        return List.of(
                Arguments.of(new User(1L,"leang"),5),
                Arguments.of(new User(1L,"lean"),4)
        );
    }
    @ParameterizedTest
    @MethodSource("userProvider")
    void testUserNameLength(User user,Integer expectedLength){
            assertEquals(expectedLength,user.getName().length());
    }
}
