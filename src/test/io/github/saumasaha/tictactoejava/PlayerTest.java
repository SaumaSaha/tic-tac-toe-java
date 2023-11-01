package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
  private Player player;

  private MyArrayList<Integer> getMoves() {
    MyArrayList<Integer> moves = new MyArrayList<>();
    moves.addAll(List.of(1, 3, 5));

    return moves;
  }

  private void addMoves() {
    this.player.addMove(1);
    this.player.addMove(3);
    this.player.addMove(5);
  }

  @BeforeEach
  void setup() {
    this.player = new Player("sauma", Symbol.X);
  }

  @Test
  void shouldGiveTheNameOfThePlayer() {
    assertEquals(this.player.getName(), "sauma");
  }

  @Test
  void shouldGiveTheSymbolThePlayerPlays() {
    assertEquals(this.player.getSymbol(), Symbol.X);
  }

  @Test
  void shouldGiveAllTheMovesPlayedByThePlayer() {
    this.addMoves();
    MyArrayList<Integer> moves = this.getMoves();
    assertEquals(this.player.movesPlayed(), moves);
  }
}
