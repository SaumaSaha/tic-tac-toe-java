package io.github.saumasaha.tictactoejava;

import java.util.Scanner;

public class InputController {
  private final Scanner scanner;

  public InputController(Scanner scanner) {
    this.scanner = scanner;
  }

  public int takeInput() {
    System.out.print("Enter position[1-9]: ");
    return this.scanner.nextInt();
  }
}
