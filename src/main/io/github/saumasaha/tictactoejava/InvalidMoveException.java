package io.github.saumasaha.tictactoejava;

public class InvalidMoveException extends Throwable {
  private final int position;

  public InvalidMoveException(int position) {
    super("Invalid Move");
    this.position = position;
  }
}
