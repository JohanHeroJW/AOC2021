package com.aoc2021.days;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day1 {

  public static void main(String[] args) throws Exception {

    String input = readFileAsString("src/main/resources/input1.txt");
    System.out.println(part1(input));
    System.out.println(part2(input));

  }

  public static String part1(String input) {

    List<Integer> list = Stream.of(input.split("\n")).map(Integer::parseInt).collect(
        Collectors.toList());
    int sum = 0;
    for (int i = 1; i < list.size(); i++) {
      if (list.get(i) > list.get(i - 1)) {
        sum++;
      }
    }
    return String.valueOf(sum);
  }

  public static String part2(String input) {

    List<Integer> list = Stream.of(input.split("\n")).map(Integer::parseInt)
        .collect(Collectors.toList());
    int sum = 0;
    for (int i = 3; i < list.size(); i++) {
      int nextThree = list.get(i) + list.get(i - 1) + list.get(i - 2);
      int firstThree = list.get(i - 1) + list.get(i - 2) + list.get(i - 3);
      if (firstThree < nextThree) {
        sum++;
      }
    }
    return String.valueOf(sum);
  }
}
