package io.github.saumasaha.tictactoejava;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) throws PositionOccupiedException, InvalidMoveException {
    Player sauma = new Player("sauma", Symbol.X);
    Player sourov = new Player("sourov", Symbol.O);
    Players players = new Players(sauma, sourov);
    Game game = new Game(players);
    GameView view = new GameView();
    GameController controller = new GameController(game, new Scanner(System.in), view);
    controller.start();
  }
}
