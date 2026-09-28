package dev.gugel.mathformulas.common;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class Formulas {

    private Formulas() {
        // This class should not be instantiated
    }

    // --- Rectangle ---
    /**
     *
     * @param a length
     * @param b width
     * @return area of a rectangle
     */
    public static Double calculateRectangleArea( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;

        return a * b;
    }

    /**
     *
     * @param a length
     * @param b width
     * @return perimeter of a rectangle
     */
    public static Double calculateRectanglePerimeter( Double a, Double b ) {
        if( a == null ) return null;
        if( b == null ) return null;

        return 2 * a + 2 * b;
    }

	// --- Square ---
	/**
	 *
	 * @param a side length
	 * @return area of a square
	 */
	public static Double calculateSquareArea( Double a) {
		if( a == null ) return null;

		return a * a;
	}

    /**
     *
     * @param a side length
     * @return perimeter of a square
     */
	public static Double calculateSquarePerimeter( Double a) {
		if( a == null ) return null;

		return 4 * a;
	}
}
