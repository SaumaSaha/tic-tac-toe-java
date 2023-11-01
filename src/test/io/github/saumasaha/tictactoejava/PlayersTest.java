package io.github.saumasaha.tictactoejava;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {
  private Players players;

  @BeforeEach
  void setup() {
    Player sauma = new Player("sauma", Symbol.X);
    Player sourov = new Player("sourov", Symbol.O);
    this.players = new Players(sauma, sourov);
  }

  @Test
  void shouldGiveTheCurrentPlayer() {
    assertEquals(this.players.currentPlayer().getName(), "sauma");
  }

  @Test
  void shouldChangeTheCurrentPlayer() {
    assertEquals(this.players.currentPlayer().getName(), "sauma");
    this.players.changeCurrentPlayer();
    assertEquals(this.players.currentPlayer().getName(), "sourov");
  }
}
