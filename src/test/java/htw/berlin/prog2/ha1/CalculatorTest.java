package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName ("Should display 0 when digits are deleted")
    void testDigitsAreDeleted() {
        Calculator calc = new Calculator();
        //Eingabe
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressDigitKey(3);

        // sicherstellen, dass jetzt 0 nicht steht
        assertEquals("123", calc.readScreen());

        // alles löschen
        calc.pressClearKey();

        // Erwartung
        assertEquals("0", calc.readScreen());

    }

    @Test
    @DisplayName ("Should display only 9 digits")
    void testScreensize() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(9);
        calc.pressDigitKey(8);
        calc.pressDigitKey(7);
        calc.pressDigitKey(6);
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);
        calc.pressDigitKey(9);

        String expected = "987699999";
        String actual = calc.readScreen();
        assertEquals(expected, actual);

    }

    @Test
    @DisplayName ("Should only delete the current digit when click once on CE ")
    void testDeleteLastDigit() {
        Calculator calc = new Calculator();
        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(3);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(1);
        calc.pressClearKey();
        calc.pressEqualsKey();

        String expected = "5";
        String actual = calc.readScreen();
        assertEquals(expected, actual);
    }
}

