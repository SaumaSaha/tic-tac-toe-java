package io.github.saumasaha.tictactoejava;

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
//    Integer[] moves = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    this.view.render(this.game.gameState());

    while (!this.game.gameState().gameWon() && !this.game.gameState().gameDraw()) {
      int position = this.inputController.takeInput();

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
