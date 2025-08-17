package org.example.springtest.assertion;

import org.example.springtest.model.entity.User;
import org.example.springtest.service.ProductService;
import org.hibernate.boot.model.process.internal.UserTypeResolution;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JUnitAssertionsExercises {

    // ---------- Helpers you can use in the exercises ----------
    static class Calculator {
        static int add(int a, int b) { return a + b; }
        static int divide(int a, int b) { return a / b; }
    }

    static class StringUtil {
        static String normalize(String s) { // trim + lowercase
            return s == null ? null : s.trim().toLowerCase(Locale.ROOT);
        }
    }

    static class UserRepository {
        private final Map<String, String> db = Map.of("u1", "Alice");
        String findName(String id) { return db.get(id); } // returns null when not found
    }

    static class ArrayOps {
        static int[] sort(int[] a) {
            int[] copy = Arrays.copyOf(a, a.length);
            Arrays.sort(copy);
            return copy;
        }
    }

    static class Singleton {
        private static final Singleton INSTANCE = new Singleton();
        private Singleton() {}
        static Singleton getInstance() { return INSTANCE; }
    }

    static class BankAccount {
        private int balance = 100;
        int getBalance() { return balance; }
        void withdraw(int amount) {
            if (amount > balance) throw new IllegalArgumentException("Insufficient funds");
            balance -= amount;
        }
    }
    // -----------------------------------------------------------


    // 1) assertEquals(expected, actual)
    @Test
    void ex1_equals_sum() {
        int sum = Calculator.add(2, 3);
        // TODO: assert that sum equals 5 using assertEquals
        // assertEquals(?, ?);
        assertEquals(5,sum);
    }

    // 2) assertNotEquals(expected, actual)
    @Test
    void ex2_notEquals_normalize() {
        String raw = "  HeLLo  ";
        String normalized = StringUtil.normalize(raw);
        // TODO: assert that normalized is NOT equal to raw
        // assertNotEquals(?, ?);
        assertNotEquals(10,normalized);
    }

    // 3) assertTrue(condition)
    @Test
    void ex3_true_isAdult() {
        int age = 20;
        boolean isAdult = age >= 18;
        // TODO: assert that isAdult is true
        // assertTrue(?);
        assertTrue(isAdult);
    }

    // 4) assertFalse(condition)
    @Test
    void ex4_false_isEven() {
        int n = 7;
        boolean isEven = (n % 2 == 0);
        // TODO: assert that isEven is false
        // assertFalse(?);
        assertFalse(isEven);
    }

    // 5) assertNull(value)
    @Test
    void ex5_null_unknownUser() {
        UserRepository repo = new UserRepository();
        String name = repo.findName("missing-id");
        // TODO: assert that name is null
        // assertNull(?);
        assertNull(name);
    }

    // 6) assertNotNull(value)
    @Test
    void ex6_notNull_knownUser() {
        UserRepository repo = new UserRepository();
        String name = repo.findName("u1");
        // TODO: assert that name is not null
        // assertNotNull(?);
        assertNotNull(name);
    }

    // 7) assertArrayEquals(expectedArray, actualArray)
    @Test
    void ex7_arrayEquals_sorting() {
        int[] input = {3, 1, 4, 2};
        int[] expected = {1, 2, 3, 4};
        int[] actual = ArrayOps.sort(input);
        // TODO: assert that expected and actual arrays are equal
        // assertArrayEquals(?, ?);
        assertArrayEquals(expected,actual);
    }

    // 8) assertSame(expectedRef, actualRef)
    @Test
    void ex8_same_singletonIdentity() {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();
        // TODO: assert that a and b refer to the same object
        // assertSame(?, ?);
        assertSame(a,b);
    }

    // 9) assertNotSame(unexpectedRef, actualRef)
    @Test
    void ex9_notSame_distinctObjects() {
        Object a = new Object();
        Object b = new Object();
        // TODO: assert that a and b are NOT the same reference
        // assertNotSame(?, ?);
        assertNotSame(a,b);
    }

    // 10) assertThrows(type, executable)
    @Test
    void ex10_throws_withdrawTooMuch() {
        BankAccount acct = new BankAccount();
        // TODO: assert that withdrawing 1000 throws IllegalArgumentException
        // assertThrows(?, () -> ?);
        assertThrows(IllegalArgumentException.class,()->{
           acct.withdraw(1000);
        });
        // (Optional) then also assert the balance was not changed (still 100)
        // assertEquals(?, acct.getBalance());
        assertEquals(100,acct.getBalance());
    }


}

