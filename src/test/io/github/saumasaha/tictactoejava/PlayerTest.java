package io.github.saumasaha.tictactoejava;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlayerTest {
  private Player player;

  @Test
  void getNameTest() {
    Assertions.assertEquals(this.player.getName(), "sauma");
  }

  @BeforeEach
  void setup() {
    this.player = new Player("sauma", Symbol.X);
  }
}
