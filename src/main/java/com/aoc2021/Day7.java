package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.IOException;
import java.util.Arrays;


public class Day7 {

  public static void main(String[] args) throws IOException {
    String input = readFileAsString("src/main/resources/input7.txt");

    System.out.println(part1(input));
    System.out.println(part2(input));
  }


  public static int part1(String input) {
    int[] arr = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt)
        .toArray();
    int median = getMedian(arr);
    int fuel = 0;
    for (int j : arr) {
      fuel += Math.abs(median - j);

    }
    return fuel;
  }

  public static long part2(String input) {
    int[] arr = Arrays.stream(input.split(",")).map(String::trim).mapToInt(Integer::parseInt)
        .toArray();
    int mean = getMean(arr);
    int fuel = 0;
    for (int j : arr) {
      int rest = Math.abs(mean - j);
      for (int k = 1; k <= rest; k++) {
        fuel += k;
      }
    }
    return fuel;
  }

  private static int getMean(int[] arr) {

    double sum = 0;
    for (int a : arr) {
      sum += a;
    }
    double mean = (sum / arr.length);
    return (int) Math.floor(mean);
  }

  private static int getMedian(int[] arr) {

    Arrays.sort(arr);
    double median;
    if (arr.length % 2 == 0) {
      median = ((double) arr[arr.length / 2] + (double) arr[arr.length / 2 - 1]) / 2;
    } else {
      median = arr[arr.length / 2];
    }

    return (int) median;
  }
}
