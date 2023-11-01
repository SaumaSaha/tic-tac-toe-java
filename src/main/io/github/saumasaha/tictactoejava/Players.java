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

  public Player currentPlayer() {
    return this.players.get(this.currentPlayerIndex);
  }

  public void changeCurrentPlayer() {
    this.currentPlayerIndex = (this.currentPlayerIndex + 1) % this.players.size();
  }
}
