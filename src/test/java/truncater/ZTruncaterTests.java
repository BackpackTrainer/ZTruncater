package truncater;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

//  Tests in the test table
//  Input String    Expected Output
//  "Z"                 ""
//  "ZABC"              "ABC"
//  "ZZBCDEF"           "BCDEF"
//  "AZBCD"             "ABCD"
//  "ABCDEFGHI"         "ABCDEFGHI"
//  "ABZCDEFGHI"        "ABZCDEFGHI"

//TODO:  Implement the remaining tests.
//TODO:  Rename the unit under test to uut.


public class ZTruncaterTests {

    ZTruncater truncater;
    String testString;
    String expectedOutput;
    String actualOutput;

    @BeforeEach
    public void setUp()  {
        truncater = new ZTruncater();
    }

    @AfterEach
    public void tearDown()  {
        truncater = null;
    }

    @Test
    public void testSingleZInLeadingPosition()  {
        testString = "Z";
        expectedOutput = "";

        actualOutput = truncater.truncateZInFirstTwoPositions(testString);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testLeadingDoubleZ() {
        testString = "ZZBCDEF";


    }

    @Test
    public void testZInSecondPlace() {

    }

    @Test
    public void testNoZ() {

    }

    @Test
    public void testZInThirdPosition() {

    }

    //These next two tests were not in the list of test cases, but I thought
    //it would be a good idea to do this additional testing.
    @Test
    public void testWithNumbersAndLeadingZ() {
        testString = "Z123456";



    }

    @Test
    public void testWithSymbolsAndLeadingDoubleZ() {
        testString = "ZZ!@#$%^&*";


    }

    //These tests show how we test exceptions using features of JUnit 5
    //The first two check that the correct exception was thrown and that the message in the exception is correct
    //The last test is a generic test to make sure an exception was thrown.  We would not use this test if we had the first
    //two exception tests.  It is only here to illustrate the use of @NullAndEmptySource

    @ParameterizedTest
    @NullSource
    public void testWithNullPointer(String nullString) {
        NullPointerException npe = assertThrows(NullPointerException.class,
                () -> truncater.truncateZInFirstTwoPositions(nullString));
        assertEquals("Token cannot be a null String", npe.getMessage());
    }

    @ParameterizedTest
    @EmptySource
    public void testWithEmpty(String emptyString) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
                () -> truncater.truncateZInFirstTwoPositions(emptyString));
        assertEquals("Token cannot be an empty String", e.getMessage());

    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testThrowingExceptions(String badString) {
        assertThrows(Exception.class,
                () -> truncater.truncateZInFirstTwoPositions(badString));
    }
}

