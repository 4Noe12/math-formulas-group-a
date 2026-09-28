package dev.gugel.mathformulas.shape2d.v1.input.validation;

import dev.gugel.mathformulas.shape2d.common.Shape2DinputValidation;
import dev.gugel.mathformulas.shape2d.v1.input.SquareInput;

public class SquareInputValidation extends Shape2DinputValidation {

    private final SquareInput squareInput;

    public SquareInputValidation( SquareInput squareInput ) {
        super();
        this.squareInput = squareInput;
    }

    public SquareInput getSquareInput() {
        return squareInput;
    }

    @Override
    public void validateInputArea() {
        validateValueNotNullOrNegative( getSquareInput().a(), SquareInput.class.getSimpleName() + ".a" );
    }

    @Override
    public void validateInputPerimeter() {
        validateValueNotNullOrNegative( getSquareInput().a(), SquareInput.class.getSimpleName() + ".a" );
    }
}
