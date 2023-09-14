package com.webcheckers.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag ("Model-tier")
public class GameTest {
    @Test
    public void TestGame(){
        //Setup
        Player player1= new Player("Cameron");
        Player player2= new Player("Tyler");
        String expected= "Game - [Cameron vs. Tyler]";
        //Invoke
        Game game= new Game(player1,player2);
        String actual= game.toString();
        //Assert
        assertEquals(expected,actual);
    }
    
}
