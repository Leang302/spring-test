package org.example.springtest.service;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

@Slf4j
// when we use order this is mandatory
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductServiceTest {
    @BeforeEach
    void runBeforeEach(){
        log.info("Run before each");
    }
    @AfterEach
    void tearDown() {
        log.info("Run after each test");
    }
    @Test
    @Order(2)
    void myTest(){
            log.info("Running my test 1");
    }
    @Test
    @Order(1)
    void myTest2(){
        log.info("Running my test 2");
    }
    @AfterAll
    static void done() {
        log.info("@AfterAll - executed after all test methods.");
    }
}
