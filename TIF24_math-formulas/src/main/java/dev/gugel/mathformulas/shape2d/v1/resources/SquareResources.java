package dev.gugel.mathformulas.shape2d.v1.resources;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dev.gugel.mathformulas.shape2d.common.Shape2Dcalc;
import dev.gugel.mathformulas.shape2d.common.Shape2DinputValidation;
import dev.gugel.mathformulas.shape2d.common.Shape2Dresources;
import dev.gugel.mathformulas.shape2d.v1.calc.SquareCalc;
import dev.gugel.mathformulas.shape2d.v1.input.SquareInput;
import dev.gugel.mathformulas.shape2d.v1.input.validation.SquareInputValidation;
import dev.gugel.mathformulas.shape2d.v1.output.Shape2Doutput;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path( "/v1" )
public class SquareResources implements Shape2Dresources<SquareInput, Shape2Doutput> {

    @RolesAllowed( "restUser" )
    @Path( "/square" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getAllValues( SquareInput inputSI )
    {
        Shape2DinputValidation squareInputValidation = new SquareInputValidation( inputSI );
        squareInputValidation.validateInputAllValues();
        if( squareInputValidation.isValid() ) {
            Shape2Dcalc squareCalc = new SquareCalc( inputSI );
            return squareCalc.calculateAllValues();
        } else {
            return new Shape2Doutput( null, null, squareInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/square/area" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getArea( SquareInput inputSI )
    {
        Shape2DinputValidation squareInputValidation = new SquareInputValidation( inputSI );
        squareInputValidation.validateInputArea();
        if( squareInputValidation.isValid() ) {
            Shape2Dcalc squareCalc = new SquareCalc( inputSI );
            return squareCalc.calculateArea();
        } else {
            return new Shape2Doutput( null, null, squareInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/square/perimeter" )
    @POST
    @Produces( MediaType.APPLICATION_JSON )
    @Consumes( MediaType.APPLICATION_JSON )
    @Override
    public Shape2Doutput getPerimeter( SquareInput inputSI )
    {
        Shape2DinputValidation squareInputValidation = new SquareInputValidation( inputSI );
        squareInputValidation.validateInputPerimeter();
        if( squareInputValidation.isValid() ) {
            Shape2Dcalc squareCalc = new SquareCalc( inputSI );
            return squareCalc.calculatePerimeter();
        } else {
            return new Shape2Doutput( null, null, squareInputValidation.getMessageOutputList() );
        }
    }

    @RolesAllowed( "restUser" )
    @Path( "/square/doc" )
    @GET
    @Produces( MediaType.TEXT_PLAIN )
    @Override
    public String getDocumentation()
    {
        SquareInput squareInput = getInputDummy();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonString = gson.toJson( squareInput );

        return """
                ########################
                Square Input
                ########################

                REST
                'Content-Type: application/json'
                'Basic: cmVzdFVzZXI6Y2hhbmdlaXQ='

                ########################

                Input parameters as SI units:

                <description>   <formula symbol> : <unit>   (<abbreviation>)   as <data type>

                side length     a                : metre    (m)                as Double

                ########################

                Input JSON Objekt:

                """ + jsonString;
    }

    @Override
    public SquareInput getInputDummy() {
        return new SquareInput( 5.0 );
    }
}
