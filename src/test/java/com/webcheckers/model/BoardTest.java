package com.webcheckers.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag ("Model-tier")
public class BoardTest {
    @Test
    public void TestBoardRows(){
        //Setup
        Board board= new Board();
        int expectedRows= 8;
        //Invoke
        int actualRows= board.getRows().length;
        //Assert
        assertEquals(expectedRows,actualRows);
    }
    @Test
    public void TestBoardFirstSquare(){
        //Setup
        Board board= new Board();
        Color expectedSquareColor= Color.WHITE;
        //Invoke
        Color actualSquareColor= board.getRows()[0].getSquare(0).getSquareColor();
        //Assert
        assertEquals(expectedSquareColor,actualSquareColor);
    }
    @Test
    public void TestBoardSecondSquare(){
        //Setup
        Board board= new Board();
        Color expectedSecondSquareColor= Color.BLACK;
        //Invoke
        Color actualSecondSquareColor=board.getRows()[0].getSquare(1).getSquareColor();
        //Assert
        assertEquals(expectedSecondSquareColor,actualSecondSquareColor);
    }
}
