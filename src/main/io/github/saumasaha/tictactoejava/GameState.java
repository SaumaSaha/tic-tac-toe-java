package io.github.saumasaha.tictactoejava;

import io.github.saumasaha.myarraylist.MyArrayList;

public record GameState(MyArrayList<Move> moves, Player currentPlayer, boolean gameDraw, boolean gameWon) {
}
