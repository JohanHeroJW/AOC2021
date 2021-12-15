package com.aoc2021.day4;

import java.util.List;

public class BingoTile {

  private List<Integer> bingoTile; /*
  0-4             0   1   2   3   4
  5-9             5   6   7   8   9
  10-14           10  11  12  13  14
  15-19           15  16  17  18  19
  20-24           20  21  22  23  24
  */
  private boolean hadBingo;
  public BingoTile(List<Integer> bingoTile, boolean hadBingo) {
    this.bingoTile = bingoTile;
    this.hadBingo = false;
  }

  public BingoTile(List<Integer> tempList) {
    this.bingoTile = tempList;
  }

  public List<Integer> getBingoTile() {
    return bingoTile;
  }


  public boolean isHadBingo() {
    return hadBingo;
  }

  public void setHadBingo(boolean hadBingo) {
    this.hadBingo = hadBingo;
  }
}
