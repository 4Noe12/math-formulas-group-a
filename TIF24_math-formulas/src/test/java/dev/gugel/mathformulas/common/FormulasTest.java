package dev.gugel.mathformulas.common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormulasTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateRectangleArea() {
        assertEquals( 12.0, Formulas.calculateRectangleArea( 3.0, 4.0 ) );
    }

    @Test
    void calculateRectangleAreaFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateRectangleArea( null, 4.0) ),
                () -> assertNull( Formulas.calculateRectangleArea( 3.0, null) )
        );
    }

    @Test
    void calculateRectanglePerimeter() {
        assertEquals( 14.0, Formulas.calculateRectanglePerimeter( 3.0, 4.0 ) );
    }

    @Test
    void calculateRectanglePerimeterFailed() {
        assertAll(
                () -> assertNull( Formulas.calculateRectanglePerimeter( null, 4.0 ) ),
                () -> assertNull( Formulas.calculateRectanglePerimeter( 3.0, null ) )
        );
    }

    @Test
    void calculateSquareArea() {
        assertEquals( 16.0, Formulas.calculateSquareArea( 4.0 ) );
    }

    @Test
    void calculateSquareAreaFailed() {
        assertNull( Formulas.calculateSquareArea( null ) );
    }

    @Test
    void calculateSquarePerimeter() {
        assertEquals( 16.0, Formulas.calculateSquarePerimeter( 4.0 ) );
    }

    @Test
    void calculateSquarePerimeterFailed() {
        assertNull(Formulas.calculateSquarePerimeter(null));
    }
}