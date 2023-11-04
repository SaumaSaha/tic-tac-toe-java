package io.github.saumasaha.tictactoejava;

import java.util.InputMismatchException;

public class GameController {
  private final Game game;
  private final InputController inputController;
  private final GameView view;

  public GameController(Game game, InputController inputController, GameView view) {
    this.game = game;
    this.inputController = inputController;
    this.view = view;
  }

  public void start() {
    this.view.render(this.game.gameState());

    while (!this.game.gameState().gameWon() && !this.game.gameState().gameDraw()) {
      try {
        int position = this.inputController.takeInput();
        this.game.movePlayed(position);
      } catch (PositionOccupiedException | InvalidMoveException e) {
        this.view.renderError(e.getMessage());
      } catch (InputMismatchException e) {
        this.inputController.consumeNull();
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
