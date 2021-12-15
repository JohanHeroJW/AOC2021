package com.aoc2021;

import com.aoc2021.day4.BingoTile;
import com.aoc2021.day4.Day4;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Aoc2021Tests {

  @Test
  void day1Test() {

    String input = "199\n200\n208\n210\n200\n207\n240\n269\n260\n2636";
    Assertions.assertEquals("7", Day1.part1(input));
    String inputPart2 = "607\n618\n618\n617\n647\n716\n769\n792\n";

    Assertions.assertEquals("5", Day1.part2(inputPart2));
  }

  @Test
  void day2Test() {
    String input = "forward 5\ndown 5\nforward 8\nup 3\ndown 8\nforward 2";
    Assertions.assertEquals("150", Day2.part1(input));
    Assertions.assertEquals("900", Day2.part2(input));
  }

  @Test
  void day3Test() {
    String input = "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010";
    Assertions.assertEquals(198, Day3.part1(input));
    Assertions.assertEquals(230, Day3.part2(input));
  }

  @Test
  void day4Test() throws IOException {
    String input = "7,4,9,5,11,17,23,2,0,14,21,24,10,16,13,6,15,25,12,22,18,20,8,19,3,26,1\n"
        + "\n"
        + "22 13 17 11  0\n"
        + " 8  2 23  4 24\n"
        + "21  9 14 16  7\n"
        + " 6 10  3 18  5\n"
        + " 1 12 20 15 19\n"
        + "\n"
        + " 3 15  0  2 22\n"
        + " 9 18 13 17  5\n"
        + "19  8  7 25 23\n"
        + "20 11 10 24  4\n"
        + "14 21 16 12  6\n"
        + "\n"
        + "14 21 17 24  4\n"
        + "10 16 15  9 19\n"
        + "18  8 23 26 20\n"
        + "22 11 13  6  5\n"
        + " 2  0 12  3  7";
    List<Integer> bingoNumbers = Arrays.stream(input.substring(0, input.indexOf("\n")).split(","))
        .map(Integer::parseInt).collect(
            Collectors.toList());
    List<BingoTile> bingoTiles = Day4.getTiles("src/main/resources/input4Test.txt");
    Assertions.assertEquals(4512, Day4.startBingo(bingoTiles,bingoNumbers));
     Assertions.assertEquals(1924, Day4.startBingo2(bingoTiles,bingoNumbers));
  }

  @Test
  void day5Test() {
    String input = "0,9 -> 5,9\n"
        + "8,0 -> 0,8\n"
        + "9,4 -> 3,4\n"
        + "2,2 -> 2,1\n"
        + "7,0 -> 7,4\n"
        + "6,4 -> 2,0\n"
        + "0,9 -> 2,9\n"
        + "3,4 -> 1,4\n"
        + "0,0 -> 8,8\n"
        + "5,5 -> 8,2";
    Assertions.assertEquals(5, Day5.part1(input));
    Assertions.assertEquals(12, Day5.part2(input));
  }
}
