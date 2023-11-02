package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

import java.util.List;

public class Player {
  private final String name;
  private final Symbol symbol;
  private final MyArrayList<Move> moves;

  public Player(String name, Symbol symbol) {
    this.name = name;
    this.symbol = symbol;
    this.moves = new MyArrayList<>();
  }

  public String getName() {
    return this.name;
  }

  public Symbol getSymbol() {
    return this.symbol;
  }

  public void addMove(int position) {
    Move move = new Move(position, this.symbol);
    this.moves.add(move);
  }

  public MyArrayList<Move> movesPlayed() {
    return new MyArrayList<>(this.moves);
  }

  public boolean hasPlayed(Integer[] moves) {
    MyArrayList<Integer> positions = this.moves.map(Move::position);
    return positions.containsAll(List.of(moves));
  }
}
