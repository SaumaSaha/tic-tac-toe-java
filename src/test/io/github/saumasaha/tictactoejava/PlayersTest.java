package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayersTest {
  private Players players;
  private Player sourov;
  private Player sauma;

  @BeforeEach
  void setup() {
    this.sauma = new Player("sauma", Symbol.X);
    this.sourov = new Player("sourov", Symbol.O);
    this.players = new Players(this.sauma, this.sourov);
  }

  private void registerMoves() {
    this.players.registerMove(1);
    this.players.registerMove(3);
    this.players.registerMove(5);
    this.players.changeCurrentPlayer();
    this.players.registerMove(2);
    this.players.registerMove(6);
    this.players.registerMove(8);
  }


  private void registerWinningMoves() {
    this.players.registerMove(1);
    this.players.registerMove(2);
    this.players.registerMove(3);
  }

  private MyArrayList<Move> getMovesList() {
    MyArrayList<Move> moves = new MyArrayList<>();
    moves.add(new Move(1, Symbol.X));
    moves.add(new Move(3, Symbol.X));
    moves.add(new Move(5, Symbol.X));
    moves.add(new Move(2, Symbol.O));
    moves.add(new Move(6, Symbol.O));
    moves.add(new Move(8, Symbol.O));

    return moves;
  }

  private MyArrayList<Integer[]> getWinningCombinations() {
    MyArrayList<Integer[]> winningCombinations = new MyArrayList<>();
    winningCombinations.add(new Integer[]{1, 2, 3});
    winningCombinations.add(new Integer[]{4, 5, 6});
    winningCombinations.add(new Integer[]{7, 8, 9});
    winningCombinations.add(new Integer[]{1, 4, 7});
    winningCombinations.add(new Integer[]{2, 5, 8});
    winningCombinations.add(new Integer[]{3, 6, 9});
    winningCombinations.add(new Integer[]{1, 5, 9});
    winningCombinations.add(new Integer[]{3, 5, 7});

    return winningCombinations;
  }

  @Test
  void shouldGiveTheCurrentPlayer() {
    assertEquals(this.players.currentPlayer(), this.sauma);
  }

  @Test
  void shouldChangeTheCurrentPlayer() {
    assertEquals(this.players.currentPlayer(), this.sauma);
    this.players.changeCurrentPlayer();
    assertEquals(this.players.currentPlayer(), this.sourov);
  }

  @Test
  void shouldGiveAllTheMovesPlayedByThePlayers() {
    MyArrayList<Move> moves = this.getMovesList();
    this.registerMoves();
    assertEquals(this.players.allMovesPlayed(), moves);
  }

  @Test
  void shouldGiveTrueIfThePlayerWon() {
    this.registerWinningMoves();
    MyArrayList<Integer[]> winningCombinations = this.getWinningCombinations();
    assertTrue(this.players.isWinner(winningCombinations));
  }

  @Test
  void shouldGiveFalseIfThePlayerHasNotWon() {
    this.registerMoves();
    MyArrayList<Integer[]> winningCombinations = this.getWinningCombinations();
    assertFalse(this.players.isWinner(winningCombinations));
  }
}
