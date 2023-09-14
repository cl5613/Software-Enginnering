package com.webcheckers.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag ("Model-tier")
public class SquareTest {
    @Test
    public void TestCreateSquare() {
        Color expectedColor = Color.RED;
        int expectedCellIdx = 1;
        Square newSquare = new Square(expectedCellIdx, expectedColor);

        Color actualColor = newSquare.getSquareColor();
        int actualCellIdx = newSquare.getCellIdx();

        //Analyze state of newSquare
        assertEquals(expectedColor, actualColor);
        assertEquals(expectedCellIdx, actualCellIdx);
    }
    @Test
    public void TestSquareFunctionality() {
        Square newSquare = new Square(1, Color.RED);

        boolean expectedIsFilled = false;
        boolean expectedIsValid = true;

        boolean actualIsFilled = newSquare.isFilled();
        boolean actualIsValid = newSquare.isValid();

        assertEquals(expectedIsFilled, actualIsFilled);
        assertEquals(expectedIsValid, actualIsValid);
    }
}
