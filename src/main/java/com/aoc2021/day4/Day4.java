package com.aoc2021.day4;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

  public static void main(String[] args) throws IOException {
    String input = readFileAsString("src/main/resources/input4.txt");
    List<Integer> bingoNumbers = Arrays.stream(input.substring(0, input.indexOf("\n")).split(","))
        .map(Integer::parseInt).collect(
            Collectors.toList());
    List<BingoTile> bingoTiles = getTiles("src/main/resources/input4.txt");

    int part1 = startBingo(bingoTiles, bingoNumbers);
    int part2 = startBingo2(bingoTiles, bingoNumbers);

    System.out.println("Day1: " + part1);
    System.out.println("Day1: " + part2);

  }

  public static int startBingo(List<BingoTile> bingoTiles, List<Integer> bingoNumber) {

    int firstBingo = 0;
    for (int j = 0; j < bingoNumber.size(); j++) {
      for (int i = 0; i < bingoTiles.size(); i++) {
        if (!bingoTiles.get(i).isHadBingo()) {
          int index = bingoTiles.get(i).getBingoTile().indexOf(bingoNumber.get(j));
          if (index != -1) {
            bingoTiles.get(i).getBingoTile().set(index, -1);
            if (isBingo(bingoTiles.get(i))) {
              firstBingo = bingoTiles.get(i).getBingoTile().stream().filter(k -> k != -1)
                  .mapToInt(Integer::intValue).sum() * bingoNumber.get(j);
              return firstBingo;
            }
          }
        }
      }
    }
    return -1;
  }

  public static int startBingo2(List<BingoTile> bingoTiles, List<Integer> bingoNumber) {

    int lastBingo = 0;
    for (int j = 0; j < bingoNumber.size(); j++) {
      for (int i = 0; i < bingoTiles.size(); i++) {
        if (!bingoTiles.get(i).isHadBingo()) {
          int index = bingoTiles.get(i).getBingoTile().indexOf(bingoNumber.get(j));
          if (index != -1) {
            bingoTiles.get(i).getBingoTile().set(index, -1);
            if (isBingo(bingoTiles.get(i))) {
              lastBingo = bingoTiles.get(i).getBingoTile().stream().filter(k -> k != -1)
                  .mapToInt(Integer::intValue).sum() * bingoNumber.get(j);
            }
          }
        }
      }
    }
    return lastBingo;
  }

  /*
    0-4             0   1   2   3   4
    5-9             5   6   7   8   9
    10-14           10  11  12  13  14
    15-19           15  16  17  18  19
    20-24           20  21  22  23  24
    */
  private static boolean isBingo(BingoTile bingoTile) {

    //X-led
    for (int i = 0; i < bingoTile.getBingoTile().size(); i = i + 5) {
      List<Integer> arr = bingoTile.getBingoTile();
      if (arr.get(i).equals(-1) && arr.get(i + 1).equals(-1) && arr.get(i + 2).equals(-1)
          && arr.get(i + 3).equals(-1) && arr.get(i + 4).equals(-1)) {
        bingoTile.setHadBingo(true);
        return true;
      }
    }
    //Y-led
    for (int i = 0; i < 5; i = i + 1) {
      List<Integer> arr = bingoTile.getBingoTile();
      if (arr.get(i).equals(-1) && arr.get(i + 5).equals(-1) && arr.get(i + 10).equals(-1)
          && arr.get(i + 15).equals(-1) && arr.get(i + 20).equals(-1)) {
        bingoTile.setHadBingo(true);
        return true;
      }
    }
    return false;
  }

  public static List<BingoTile> getTiles(String filePath) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(filePath));
    List<BingoTile> bingoTileList = new ArrayList<>();
    String st;
    br.readLine();
    br.readLine(); // throws the first two lines
    while ((st = br.readLine()) != null) {
      List<Integer> tempList = new ArrayList<>();
      for (int i = 0; i < 5; i++) {
        List<Integer> arr = Arrays.stream(st.split("\\s+"))
            .filter(item -> !item.isEmpty())
            .map(Integer::parseInt)
            .collect(Collectors.toList());
        tempList.addAll(arr);
        st = br.readLine();
      }
      BingoTile b = new BingoTile(tempList);
      bingoTileList.add(b);
    }
    return bingoTileList;
  }

}
