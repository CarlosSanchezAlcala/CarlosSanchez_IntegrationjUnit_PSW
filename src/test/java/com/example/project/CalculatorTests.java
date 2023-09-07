/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package com.example.project;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTests {

    static Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("Antes de cada método");
    }

    @Disabled("Se deshabilitó por problemas con la clase principal")
    @Test
    @DisplayName("1.5 + 1.5 = 3.0")
    void addsTwoNumbers() {
        //Calculator calculator = new Calculator();
        assertEquals(3.0, calculator.add(1.5, 1.5), "1 + 1 should equal 2");
        System.err.println("Se está ejecutando la suma");
    }

    @RepeatedTest(value = 5, name = "test: {displayName}, repeticiones: {totalRepetitions}, actual: {currentRepetition}")
    @DisplayName("Suma de números")
    void addNumbers() {
        assertEquals(3.0, calculator.add(1.5, 1.5), "1 + 1 should equal 2");
    }

    @RepeatedTest(value = 5, name = "test: {displayName}, repeticiones: {totalRepetitions}, actual: {currentRepetition}")
    @DisplayName("Resta de números")
    void restNumbers() {
        double resultadoEsperado = calculator.rest(6.0, 3.0);
        assertEquals(3.0, resultadoEsperado, "6 - 3 debería ser igual a 3");
    }

    @RepeatedTest(value = 5, name = "test: {displayName}, repeticiones: {totalRepetitions}, actual: {currentRepetition}")
    @DisplayName("Multiplicación multiple con varias condiciones")
    void multiNumbers() {
        double resultadoEsperado = calculator.multiply(2.0, 2.0, 2.0);
        double resultadoEsperado2 = calculator.multiply(3.0, 3.0, 3.0);

        assertAll(
                "Multiplicadores",
                () -> assertEquals(8, resultadoEsperado, "El resultado deseado en esta oportunidad es: 8.0"),
                () -> assertEquals(27, resultadoEsperado2, "El resultado deseado en esta oportunidad es: 27.0")
        );
    }

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "0,    1,   1",
            "1,    2,   3",
            "49,  51, 100",
            "1,  100, 101"
    })
    void add(int first, int second, int expectedResult) {
        //Calculator calculator = new Calculator();
        assertEquals(expectedResult, calculator.add(first, second),
                () -> first + " + " + second + " should equal " + expectedResult);
    }

    @Test
    void isTrue() {

        Random random = new Random();

        int numeroRandom = random.nextInt(11);
        System.err.println("El número es: " + numeroRandom);
        if (numeroRandom >= 5) {
            System.err.println("El número: " + numeroRandom + " si es mayor o igual a 5");
        } else {
            System.err.println("El número: " + numeroRandom + " no es mayor o igual a 5");
        }
        assertTrue(numeroRandom >= 5);
    }

    @AfterEach
    void afterEach() {
        System.out.println("Después de cada método");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Después de todos los métodos de la clase");
    }
}
