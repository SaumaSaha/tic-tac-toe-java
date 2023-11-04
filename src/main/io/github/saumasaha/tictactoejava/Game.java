package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

public class Game {
  private final MyArrayList<Integer[]> winningCombinations;
  private int maxMoves;
  private Players players;
  private boolean gameDraw;
  private boolean gameWon;

  private Game() {
    this.winningCombinations = new MyArrayList<>() {
      {
        this.add(new Integer[]{1, 2, 3});
        this.add(new Integer[]{4, 5, 6});
        this.add(new Integer[]{7, 8, 9});
        this.add(new Integer[]{1, 4, 7});
        this.add(new Integer[]{2, 5, 8});
        this.add(new Integer[]{3, 6, 9});
        this.add(new Integer[]{1, 5, 9});
        this.add(new Integer[]{3, 5, 7});
      }
    };
  }

  public Game(Players players) {
    this();
    this.maxMoves = 9;
    this.gameDraw = false;
    this.gameWon = false;
    this.players = players;
  }

  private boolean isInvalidMove(int position) {
    return position < 1 || position > 9;
  }

  private boolean isGameDraw() {
    return this.players.allMovesPlayed().size() == this.maxMoves;
  }

  private boolean hasWon() {
    return this.players.isWinner(this.winningCombinations);
  }

  public GameState gameState() {
    return new GameState(this.players.allMovesPlayed(), this.players.currentPlayer(), this.gameDraw, this.gameWon);
  }

  public void movePlayed(int position) throws PositionOccupiedException, InvalidMoveException {
    if (this.isInvalidMove(position)) {
      throw new InvalidMoveException(position);
    }

    this.players.registerMove(position);

    if (this.isGameDraw()) {
      this.gameDraw = true;
      this.gameWon = false;
      return;
    }

    if (this.hasWon()) {
      this.gameWon = true;
      this.gameDraw = false;
      return;
    }

    this.players.changeCurrentPlayer();
  }
}
