package io.github.saumasaha.tictactoejava;

import java.util.Scanner;

public class GameController {
  private final Game game;
  private final Scanner scanner;
  private final GameView view;

  public GameController(Game game, Scanner scanner, GameView view) {
    this.game = game;
    this.scanner = scanner;
    this.view = view;
  }

  public void start() {
//    Integer[] moves = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    this.view.render(this.game.gameState());

    while (!this.game.gameState().gameWon() && !this.game.gameState().gameDraw()) {
      System.out.print("Enter position[1-9]: ");
      int position = this.scanner.nextInt();

      try {
        this.game.movePlayed(position);
      } catch (PositionOccupiedException | InvalidMoveException e) {
        this.view.renderError(e.getMessage());
      }

      GameState gamestate = this.game.gameState();
      if (gamestate.gameDraw() || gamestate.gameWon()) {
        this.view.renderGameOver(gamestate);
        return;
      }

      this.view.render(gamestate);
    }
  }
}
