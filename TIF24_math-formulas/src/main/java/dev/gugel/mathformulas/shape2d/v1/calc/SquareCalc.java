package dev.gugel.mathformulas.shape2d.v1.calc;

import dev.gugel.mathformulas.common.Formulas;
import dev.gugel.mathformulas.shape2d.common.Shape2Dcalc;
import dev.gugel.mathformulas.shape2d.v1.input.SquareInput;
import dev.gugel.mathformulas.shape2d.v1.output.Shape2Doutput;

public class SquareCalc implements Shape2Dcalc {

	private final SquareInput squareInput;

	public SquareCalc(SquareInput squareInput) {
		this.squareInput = squareInput;
	}

	private SquareInput getSquareInput() {
		return squareInput;
	}

	@Override
	public Shape2Doutput calculateAllValues() {
		return new Shape2Doutput( calculateArea().area(), calculatePerimeter().perimeter(), null );
	}

	@Override
	public Shape2Doutput calculateArea() {
		return new Shape2Doutput( Formulas.calculateSquareArea( getSquareInput().a()),null,null );
	}

	@Override
	public Shape2Doutput calculatePerimeter() {
		return new Shape2Doutput(null, Formulas.calculateSquarePerimeter( getSquareInput().a()),null );
	}
}
