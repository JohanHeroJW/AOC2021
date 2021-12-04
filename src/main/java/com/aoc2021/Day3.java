package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day3 {

  public static void main(String[] args) throws IOException {

    String input = readFileAsString("src/main/resources/input3.txt");
    System.out.println(part1(input));
    System.out.println(part2(input));
  }

  public static int part1(String input) {
    List<String> list = Stream.of(input.split("\n")).collect(Collectors.toList());
    StringBuilder gamaBuilder = new StringBuilder();
    StringBuilder epsilonBuilder = new StringBuilder();
    for (int j = 0; j < list.get(0).length(); j++) {
      char c = mostCommonBitInList(list, j, "0");
      gamaBuilder.append(c);
      epsilonBuilder.append(c == '0' ? '1' : '0');
    }

    return (Integer.parseInt(epsilonBuilder.toString(), 2) * Integer.parseInt(
        gamaBuilder.toString(),
        2));
  }

  public static int part2(String input) {
    List<String> list = Stream.of(input.split("\n")).collect(Collectors.toList());
    int oxygenGeneratorValue = calculateOxygenValue(list);
    int co2Scrubber = calculateCO2ScrubberValue(list);
    return (oxygenGeneratorValue * co2Scrubber);
  }

  private static int calculateOxygenValue(List<String> list) {
    ArrayList<String> tempList = new ArrayList<>();

    for (int i = 0; i < list.get(0).length(); i++) {
      char mostCommon = mostCommonBitInList(list, i, "1");
      for (String s : list) {
        if (s.charAt(i) == mostCommon && !tempList.contains(s)) {
          tempList.add(s);
        }
      }
      list = tempList;
      if (list.size() == 1) {
        return Integer.parseInt(list.get(0), 2);
      }

      tempList = new ArrayList<>();
    }
    return -1;
  }

  private static int calculateCO2ScrubberValue(List<String> list) {
    ArrayList<String> tempList = new ArrayList<>();

    for (int i = 0; i < list.get(0).length(); i++) {
      char mostCommon = mostCommonBitInList(list, i, "1");
      for (String s : list) {
        if (s.charAt(i) != mostCommon && !tempList.contains(s)) {
          tempList.add(s);
        }
      }
      list = tempList;
      if (list.size() == 1) {
        return Integer.parseInt(list.get(0), 2);
      }

      tempList = new ArrayList<>();
    }

    return -1;
  }

  private static char mostCommonBitInList(List<String> list, int bitNumber, String prioBit) {
    int one = 0;
    int zero = 0;
    for (String s : list) {
      if ('0' == s.charAt(bitNumber)){
        zero++;
      } else {
        one++;
      }
    }
    if (zero == one) {
      return prioBit.charAt(0);
    }
    return (zero > one ? '0' : '1');
  }
}
