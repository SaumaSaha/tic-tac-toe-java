package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
  private Game game;
  private Player sauma;
  private Player sourov;

  @BeforeEach
  void setup() {
    Players players = this.createPlayers();
    this.game = new Game(players);
  }

  private Players createPlayers() {
    this.sauma = new Player("sauma", Symbol.X);
    this.sourov = new Player("sourov", Symbol.O);
    return new Players(this.sauma, this.sourov);
  }

  private Collection<Move> getFirstList() {
    return List.of(new Move(1, Symbol.X));
  }

  private MyArrayList<Move> getDrawMoves() {
    MyArrayList<Move> moves = new MyArrayList<>();
    moves.add(new Move(1, Symbol.X));
    moves.add(new Move(2, Symbol.X));
    moves.add(new Move(7, Symbol.X));
    moves.add(new Move(6, Symbol.X));
    moves.add(new Move(8, Symbol.X));
    moves.add(new Move(5, Symbol.O));
    moves.add(new Move(3, Symbol.O));
    moves.add(new Move(4, Symbol.O));
    moves.add(new Move(9, Symbol.O));

    return moves;
  }

  private MyArrayList<Move> getWinMovesPlayer1() {
    MyArrayList<Move> moves = new MyArrayList<>();
    moves.add(new Move(1, Symbol.X));
    moves.add(new Move(7, Symbol.X));
    moves.add(new Move(9, Symbol.X));
    moves.add(new Move(8, Symbol.X));
    moves.add(new Move(3, Symbol.O));
    moves.add(new Move(4, Symbol.O));
    moves.add(new Move(5, Symbol.O));

    return moves;
  }

  private MyArrayList<Move> getWinMovesPlayer2() {
    MyArrayList<Move> moves = new MyArrayList<>();
    moves.add(new Move(2, Symbol.X));
    moves.add(new Move(3, Symbol.X));
    moves.add(new Move(6, Symbol.X));
    moves.add(new Move(1, Symbol.O));
    moves.add(new Move(5, Symbol.O));
    moves.add(new Move(9, Symbol.O));

    return moves;
  }


  private GameState getFirstGameState() {
    return new GameState(new MyArrayList<>(this.getFirstList()), this.sourov, false, false);
  }

  private GameState getDrawGameState() {
    return new GameState(this.getDrawMoves(), this.sauma, true, false);
  }

  private GameState getWinGameStatePlayer1() {
    return new GameState(this.getWinMovesPlayer1(), this.sauma, false, true);
  }

  private GameState getWinGameStatePlayer2() {
    return new GameState(this.getWinMovesPlayer2(), this.sourov, false, true);
  }

  private void makeGameDraw() throws PositionOccupiedException, InvalidMoveException {
    this.game.movePlayed(1);
    this.game.movePlayed(5);
    this.game.movePlayed(2);
    this.game.movePlayed(3);
    this.game.movePlayed(7);
    this.game.movePlayed(4);
    this.game.movePlayed(6);
    this.game.movePlayed(9);
    this.game.movePlayed(8);
  }

  private void makeGameWinPlayer1() throws PositionOccupiedException, InvalidMoveException {
    this.game.movePlayed(1);
    this.game.movePlayed(3);
    this.game.movePlayed(7);
    this.game.movePlayed(4);
    this.game.movePlayed(9);
    this.game.movePlayed(5);
    this.game.movePlayed(8);
  }

  private void makeGameWinPlayer2() throws PositionOccupiedException, InvalidMoveException {
    this.game.movePlayed(2);
    this.game.movePlayed(1);
    this.game.movePlayed(3);
    this.game.movePlayed(5);
    this.game.movePlayed(6);
    this.game.movePlayed(9);
  }

  @Test
  void shouldUpdateTheGameWhenCurrentPlayerPlaysAMove() throws PositionOccupiedException, InvalidMoveException {
    GameState actualGameState = this.getFirstGameState();
    this.game.movePlayed(1);
    assertEquals(actualGameState, this.game.gameState());
  }

  @Test
  void shouldGiveTheGameStateAsDraw() throws PositionOccupiedException, InvalidMoveException {
    GameState actualGameState = this.getDrawGameState();
    this.makeGameDraw();
    assertEquals(actualGameState, this.game.gameState());
  }

  @Test
  void shouldGiveTheWinningGameStateWhenPlayer1Wins() throws PositionOccupiedException, InvalidMoveException {
    GameState actualGameState = this.getWinGameStatePlayer1();
    this.makeGameWinPlayer1();
    assertEquals(actualGameState, this.game.gameState());
  }

  @Test
  void shouldGiveTheWinningGameStateWhenPlayer2Wins() throws PositionOccupiedException, InvalidMoveException {
    GameState actualGameState = this.getWinGameStatePlayer2();
    this.makeGameWinPlayer2();
    assertEquals(actualGameState, this.game.gameState());
  }

  @Test
  void shouldThrowAnPositionOccupiedExceptionException() {
    PositionOccupiedException e = assertThrows(PositionOccupiedException.class, () -> {
      this.game.movePlayed(1);
      this.game.movePlayed(1);
    });
    assertEquals("Position Already Occupied", e.getMessage());
  }

  @Test
  void shouldThrowAnInvalidMoveException() {
    InvalidMoveException e = assertThrows(InvalidMoveException.class, () -> {
      this.game.movePlayed(10);
    });
    assertEquals("Invalid Move", e.getMessage());
  }
}
