package com.webcheckers.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag ("Model-tier")
public class PieceTest {
  @Test
  public void TestCreatePiece() {
    Color expectedColor = Color.RED;
    PieceType expectedType = PieceType.PAWN;
    Piece newPiece = new Piece(expectedColor);

    Color actualColor = newPiece.getColor();
    PieceType actualType = newPiece.getType();

    //Analyze state of newPiece
    assertEquals(expectedColor, actualColor);
    assertEquals(expectedType, actualType);
  }
  @Test
  public void TestPieceKingMe() {
    Piece newPiece = new Piece(Color.WHITE);
    PieceType expectedType = PieceType.KING;

    // King newPiece
    newPiece.kingMe();
    PieceType actualType = newPiece.getType();

    // Check newPiece is King type
    assertEquals(expectedType, actualType);
  }
}

