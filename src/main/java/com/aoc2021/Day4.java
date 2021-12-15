package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

  public static void main(String[] args) throws IOException {
    String input = readFileAsString("src/main/resources/input4.txt");
    List<Integer> bingoNumbers = Arrays.stream(input.substring(0, input.indexOf("\n")).split(","))
        .map(Integer::parseInt).collect(
            Collectors.toList());
    List<BingoTile> bingoTiles = getTiles();

    HashMap<List<Integer>, Integer> bingo = startBingo(bingoTiles, bingoNumbers);
    //List<HashMap<List<Integer>, Integer>> bingo2 = startBingo(bingoTiles, bingoNumbers);
    List<Integer> day1 = bingo.keySet()
        .stream()
        .findFirst()
        .get()
        .stream()
        .filter(i -> i != -1)
        .collect(
            Collectors.toList());


    int sumDay1 = day1.stream().mapToInt(Integer::intValue).sum();
    System.out.println("Day1: " + sumDay1 * bingo.get(bingo.keySet().stream().findFirst().get()));
  }

  private static HashMap<List<Integer>, Integer> startBingo(List<BingoTile> bingoTiles,
      List<Integer> bingoNumber) {

    for (int j = 0; j < bingoNumber.size(); j++) {
      for (int i = 0; i < bingoTiles.size(); i++) {
        int index = bingoTiles.get(i).getBingoTile().indexOf(bingoNumber.get(j));
        if (index != -1) {
          bingoTiles.get(i).getBingoTile().set(index, -1);
          if (isBingo(bingoTiles.get(i))) {
            HashMap<List<Integer>, Integer> h = new HashMap<>();
            h.put(bingoTiles.get(i).getBingoTile(), bingoNumber.get(j));
            return h;
          }
        }
      }
    }
    return null;
  }

//  private static HashMap<List<Integer>, Integer> startBingo2(
//      List<BingoTile> bingoTiles,
//      List<Integer> bingoNumber) {
//
//    HashMap<List<Integer>, Integer> h = new HashMap<>();
//
//    for (int j = 0; j < bingoNumber.size(); j++) {
//      for (int i = 0; i < bingoTiles.size(); i++) {
//        int index = bingoTiles.get(i).getBingoTile().indexOf(bingoNumber.get(j));
//        if (index != -1) {
//          bingoTiles.get(i).getBingoTile().set(index, -1);
//          if (isBingo(bingoTiles.get(i))) {
//            h.put(bingoTiles.get(i).getBingoTile(), bingoNumber.get(j));
//
//          }
//        }
//      }
//    }
//    return h;
//  }

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
        System.out.println("BINGO!!!!!");
        return true;
      }
    }
    //Y-led
    for (int i = 0; i < 5; i = i + 1) {
      List<Integer> arr = bingoTile.getBingoTile();
      if (arr.get(i).equals(-1) && arr.get(i + 5).equals(-1) && arr.get(i + 10).equals(-1)
          && arr.get(i + 15).equals(-1) && arr.get(i + 20).equals(-1)) {
        System.out.println("BINGO!!!!!");
        return true;
      }

    }
    return false;
  }


  private static List<BingoTile> getTiles() throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("src/main/resources/input4.txt"));
    String numbers = br.readLine();
    List<BingoTile> bingoTileList = new ArrayList<>();
    String st;
    br.readLine();
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


  public static int part1(String input) {

    return 1;
  }

  private static boolean part2(String input) {
    return false;
  }


}
