package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

public class Player {
  private final String name;
  private final Symbol symbol;
  private final MyArrayList<Symbol> movesPlayed;

  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
    this.movesPlayed = new MyArrayList<Symbol>();
  }

  public String getName() {
    return this.name;
  }
}
