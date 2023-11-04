package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

public class Players {
  MyArrayList<Player> players;
  private int currentPlayerIndex;

  public Players(Player player1, Player player2) {
    this.players = new MyArrayList<>();
    this.players.add(player1);
    this.players.add(player2);
    this.currentPlayerIndex = 0;
  }

  private boolean isPositionFilled(int position) {
    return this.allMovesPlayed().some(move -> move.position() == position);
  }

  public Player currentPlayer() {
    return this.players.get(this.currentPlayerIndex);
  }

  public void changeCurrentPlayer() {
    this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
  }

  public MyArrayList<Move> allMovesPlayed() {
    MyArrayList<Move> movesPlayed = new MyArrayList<>();

    for (Player player : this.players) {
      movesPlayed.addAll(player.movesPlayed());
    }

    return movesPlayed;
  }

  public void registerMove(int position) throws PositionOccupiedException {
    if (this.isPositionFilled(position))
      throw new PositionOccupiedException(position);

    this.currentPlayer().addMove(position);
  }

  public boolean isWinner(MyArrayList<Integer[]> winningCombinations) {
    Player currentPlayer = this.players.get(this.currentPlayerIndex);
    return winningCombinations.some(currentPlayer::hasPlayed);
  }
}
