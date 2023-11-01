package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

public class Player {
  private final String name;
  private final Symbol symbol;
  private final MyArrayList<Integer> moves;

  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
    this.moves = new MyArrayList<Integer>();
  }

  public String getName() {
    return this.name;
  }

  public Symbol getSymbol() {
    return this.symbol;
  }

  public void addMove(int move) {
    this.moves.add(move);
  }

  public MyArrayList<Integer> movesPlayed() {
    return this.moves;
  }
}
