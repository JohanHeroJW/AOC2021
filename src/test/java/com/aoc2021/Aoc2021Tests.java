package com.aoc2021;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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
  void day4Test() {
    String input = "00100\n11110\n10110\n10111\n10101\n01111\n00111\n11100\n10000\n11001\n00010\n01010";
    Assertions.assertEquals(4512, Day4.part1(input));
//    Assertions.assertEquals(230, Day4.part2(input));
  }
}
