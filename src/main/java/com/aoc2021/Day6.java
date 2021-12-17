package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

  public static void main(String[] args) throws IOException {

    String input = readFileAsString("src/main/resources/input6.txt");

    System.out.println(part1(input));
    System.out.println(part2(input));

  }

  public static Long part1(String input) {
    List<Integer> list = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());

    Long[] fish = new Long[9];

    for (int i = 0; i < fish.length; i++) {
      int finalI = i;
      fish[i] = (long) list.stream().filter(el -> el == finalI).count();
    }

    for (int i = 0; i < 80; i++) {
      Long newFish = null;
      for (int j = 0; j < fish.length; j++) {
        if (j == 0) {
          newFish = fish[j];
        } else {
          fish[j - 1] = fish[j];
        }
      }
      fish[6] = fish[6] + newFish;
      fish[8] = newFish;
    }
    return fish[0] + fish[1] + fish[2] + fish[3] + fish[4] + fish[5] + fish[6] + fish[7]
        + fish[8];
  }

  public static Long part2(String input) {
    List<Integer> list = Arrays.stream(input.split(","))
        .map(String::trim)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    Long[] fish = new Long[9];

    for (int i = 0; i < 9; i++) {
      int finalI = i;
      fish[i] = (long) list.stream().filter(elem -> elem == finalI).count();
    }

    Long newFish = 0L;
    for (int i = 0; i < 256; i++) {
      for (int j = 0; j < fish.length; j++) {
        if (j == 0) { //New fishes and reset to 6
          newFish = fish[j];
        } else {
          fish[j - 1] = fish[j];
        }
      }
      fish[6] = fish[6] + newFish;
      fish[8] = newFish;
    }

    return fish[0] + fish[1] + fish[2] + fish[3] + fish[4] + fish[5] + fish[6] + fish[7]
        + fish[8];
  }
}
