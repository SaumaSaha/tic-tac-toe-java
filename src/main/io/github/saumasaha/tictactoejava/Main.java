package io.github.saumasaha.tictactoejava;

public class Main {
  public static void main(String[] args) throws PositionOccupiedException {
    Player sauma = new Player("sauma", Symbol.X);
    Player sourov = new Player("sourov", Symbol.O);
    Players players = new Players(sauma, sourov);
    Game game = new Game(players);
    game.movePlayed(1);
    System.out.println();
  }
}
