package com.aoc2021;

import static com.aoc2021.util.DayUtils.readFileAsString;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day5 {

  public static void main(String[] args) throws IOException {
    int num = 0;
    String input = readFileAsString("src/main/resources/input5.txt");
    System.out.println(part1(input));
    System.out.println(part2(input));


  }

  public static int part1(String input) {
    List<String> lines = Arrays.stream(input.split("\\n")).collect(Collectors.toList());
    int sum = 0;
    int[][] d2Arr = new int[1000][1000];

    for (String s : lines) {
      String[] x1y1 = s.split("->");
      int x1 = Integer.parseInt(x1y1[0].split(",")[0].trim());
      int y1 = Integer.parseInt(x1y1[0].split(",")[1].trim());
      int x2 = Integer.parseInt(x1y1[1].split(",")[0].trim());
      int y2 = Integer.parseInt(x1y1[1].split(",")[1].trim());
      int xLen = Math.abs(x2 - x1);
      int yLen = Math.abs(y2 - y1);
      if (x1 == x2) {
        int start = Math.min(y1, y2);
        for (int i = start; i <= yLen + start; i++) {
          d2Arr[i][x1] = d2Arr[i][x1] + 1;

        }
      }
      if (y1 == y2) {
        int start = Math.min(x1, x2);
        for (int i = start; i <= xLen + start; i++) {
          d2Arr[y1][i] = d2Arr[y1][i] + 1;
        }
      }
    }
    return countOverlaped(d2Arr);
  }


  public static int part2(String input) {
    List<String> lines = Arrays.stream(input.split("\\n")).collect(Collectors.toList());
    int sum = 0;
    int[][] d2Arr = new int[1000][1000];

    for (String s : lines) {
      String[] x1y1 = s.split("->");
      int x1 = Integer.parseInt(x1y1[0].split(",")[0].trim());
      int y1 = Integer.parseInt(x1y1[0].split(",")[1].trim());
      int x2 = Integer.parseInt(x1y1[1].split(",")[0].trim());
      int y2 = Integer.parseInt(x1y1[1].split(",")[1].trim());
      int xLen = Math.abs(x2 - x1);
      int yLen = Math.abs(y2 - y1);
      if (x1 != x2 && y1 != y2) {

        for (int i = 0; i <= xLen; i++) {
          if(x1 < x2 && y1 < y2){
            d2Arr[y1 + i][x1 + i] = d2Arr[y1 + i][x1 + i] + 1;
          }
          else if(x1 > x2 && y1 < y2){
            d2Arr[y1 + i][x1 - i] = d2Arr[y1 + i][x1 - i] + 1;
          }
          else if(x1 < x2 && y1 > y2){
            d2Arr[y1 - i][x1 + i] = d2Arr[y1 - i][x1 + i] + 1;
          } else {
            d2Arr[y1 - i][x1 - i] = d2Arr[y1 - i][x1 - i] + 1;
          }

        }
      }
      else if (x1 == x2) {
        int start = Math.min(y1, y2);
        for (int i = start; i <= yLen + start; i++) {
          d2Arr[i][x1] = d2Arr[i][x1] + 1;

        }
      }
      else if (y1 == y2) {
        int start = Math.min(x1, x2);
        for (int i = start; i <= xLen + start; i++) {
          d2Arr[y1][i] = d2Arr[y1][i] + 1;
        }
      }


    }
    return countOverlaped(d2Arr);
  }


  public static int countOverlaped(int[][] matrix) {
    int sum = 0;
    for (int[] array : matrix) {
      for (int element : array) {
        if (element > 1) {
          sum++;
        }
      }
    }
    return sum;
  }
}
