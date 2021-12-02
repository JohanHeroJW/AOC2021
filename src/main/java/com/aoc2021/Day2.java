package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day2 {

  public static void main(String[] args) throws IOException {

    String input = readFileAsString("src/main/resources/input2.txt");
    System.out.println(part1(input));
    System.out.println(part2(input));
  }

  public static String part2(String input) {
    List<String> listInput = Arrays.stream(input.split("\n")).collect(Collectors.toList());
    int x = 0;
    int y = 0;
    int aim = 0;

    for (String i : listInput) {
      String direction = i.split(" ")[0];
      int amount = Integer.parseInt(i.split(" ")[1]);
      switch (direction) {
        case "down":
          aim += amount;
          break;
        case "up":
          aim -= amount;
          break;
        case "forward":
          x += amount;
          y = y + aim * amount;
          break;
      }
    }
    return String.valueOf(x * y);
  }

  public static String part1(String input) {
    List<String> listInput = Arrays.stream(input.split("\n")).collect(Collectors.toList());
    int x = 0;
    int y = 0;

    for (String i : listInput) {
      String direction = i.split(" ")[0];
      int amount = Integer.parseInt(i.split(" ")[1]);
      switch (direction) {
        case "down":
          y += amount;
          break;
        case "up":
          y -= amount;
          break;
        case "forward":
          x += amount;
          break;
      }
    }
    return String.valueOf(x * y);
  }

}
