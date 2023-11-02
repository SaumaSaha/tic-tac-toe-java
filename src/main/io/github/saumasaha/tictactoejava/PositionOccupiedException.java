package io.github.saumasaha.tictactoejava;

public class PositionOccupiedException extends Throwable {
  private final int position;

  PositionOccupiedException(int position) {
    super("Position Already Occupied");
    this.position = position;
  }

}
