package com.webcheckers.application;

import com.webcheckers.model.Game;
import com.webcheckers.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

public class PlayerLobbyTest {

    private GameCenter gameCenter;
    private Game game;
    private PlayerLobby CuT;

    @BeforeEach
    public void testSetup() {
        gameCenter = mock(GameCenter.class);
        // Setup CuT and create the game
        CuT = new PlayerLobby(gameCenter);
        Player p1 = new Player("James");
        Player p2 = new Player("Connor");
        game = new Game(p1, p2);
    }

    /**
     * Test that you can construct a new Player Service.
     */
    @Test
    public void test_create_service() {
        new PlayerLobby(gameCenter);
    }

    /**
     * Test the creation of a new Game.
     */
    @Test
    public void test_create_game() {
        //  1) game object exists
        assertNotNull(game);

        Player p3 = new Player("Dan");
        assertFalse(CuT.isSignedIn(p3));
        assertFalse(game.getIsGameOver());
    }

    @Test
    public void test_opponent(){
        //Setup
        PlayerLobby pl = new PlayerLobby(gameCenter);
        Player player1 = new Player("Cameron");
        Player player2 = pl.getPlayerOpponent(player1);
        //Assert
        assertNotEquals(player1, player2);
    }
}
