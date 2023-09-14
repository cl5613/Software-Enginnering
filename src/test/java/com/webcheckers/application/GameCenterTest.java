package com.webcheckers.application;

import static org.junit.jupiter.api.Assertions.*;

import com.webcheckers.model.Player;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag ("Application-tier")
public class GameCenterTest {
    @Test
    public void TestCreateGame() {
        GameCenter gameCenter = new GameCenter();
        Player player1 = new Player("James");
        Player player2 = new Player("Dan");
        gameCenter.newGame(player1, player2);

        int expectedListLength = 1;
        int actualListLength = gameCenter.getGameList().size();

        int expectedGamesPlayed = 0;
        int actualGamesPlayed = gameCenter.getGamesPlayed();

        assertEquals(expectedListLength, actualListLength);
        assertEquals(expectedGamesPlayed, actualGamesPlayed);
    }
}
