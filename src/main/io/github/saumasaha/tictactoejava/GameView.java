package io.github.saumasaha.tictactoejava;

public class GameView {
  private void printBoard(GameState gameState) {
    String[] board = new String[9];
    gameState.moves().forEach(move -> board[move.position() - 1] = move.symbol().name());

    System.out.print("\033[H\033[2J");

    for (int index = 0; index < board.length; index++) {
      if (index % 3 == 0) System.out.println();
      String symbol = board[index] == null ? " " : board[index];
      System.out.print("|" + symbol + "|");
    }
    System.out.println();
  }

  public void render(GameState gameState) {
    this.printBoard(gameState);
    Player currentPlayer = gameState.currentPlayer();
    System.out.println(currentPlayer.getName() + "'s Turn" + "[" + currentPlayer.getSymbol().name() + "]");
  }

  public void renderGameOver(GameState gamestate) {
    this.printBoard(gamestate);
    if (gamestate.gameWon()) {
      System.out.println(gamestate.currentPlayer().getName() + " Won ");
      return;
    }
    System.out.println("Game Draw");

  }

  public void renderError(String message) {
    System.out.println(message);
  }

}
