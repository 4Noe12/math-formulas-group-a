package dev.gugel.mathformulas.shape2d.v1.resources;

import dev.gugel.mathformulas.shape2d.v1.input.SquareInput;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class SquareResourcesTest {

    private SquareInput squareInput;

    private final String user = "restUser";
    private final String pw = "changeit";

    private final String urlAllValues = "/v1/square";

    private final String urlDoc = "/v1/square/doc";

    private final String urlArea = "/v1/square/area";
    private final String outputKeyArea = "area";

    private final String urlPerimeter = "/v1/square/perimeter";
    private final String outputKeyPerimeter = "perimeter";

    @BeforeEach
    void setUp() {
        squareInput = new SquareInput(5.0 );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAllValuesUnauthorized() {
        given()
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlAllValues ).then()
                .statusCode( 401 );
    }

    @Test
    void getAllValues() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( 25.0f ) )
                .body( outputKeyPerimeter, equalTo( 20.0f ) );
    }

    @Test
    void getAllValuesFailedByNull() {
        squareInput = new SquareInput( null );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getAllValuesFailedByNegative() {
        squareInput = new SquareInput( -5.0 );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlAllValues ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getArea() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlArea ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( 25.0f ) );
    }

    @Test
    void getAreaFailedByNull() {
        squareInput = new SquareInput( null );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlArea ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyArea, equalTo( null ) );
    }

    @Test
    void getPerimeter() {
        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlPerimeter ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyPerimeter, equalTo( 20.0f ) );
    }

    @Test
    void getPerimeterFailedByNull() {
        squareInput = new SquareInput( null );

        given().auth().basic( user, pw )
                .contentType( ContentType.JSON ).body( squareInput )
                .when().post( urlPerimeter ).then()
                .statusCode( 200 )
                .contentType( ContentType.JSON )
                .body( outputKeyPerimeter, equalTo( null ) );
    }

    @Test
    void getDocumentation() {
        given().auth().basic( user, pw )
                .when().get( urlDoc ).then()
                .statusCode( 200 )
                .contentType( ContentType.TEXT );
    }
}