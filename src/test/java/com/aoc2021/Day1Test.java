package com.aoc2021;

import com.aoc2021.days.Day1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day1Test {

  @Test
  void day1Test() {

    String input = "199\n200\n208\n210\n200\n207\n240\n269\n260\n2636";
    Assertions.assertEquals("7", Day1.part1(input));
    String inputPart2 = "607\n618\n618\n617\n647\n716\n769\n792\n";

    Assertions.assertEquals("5", Day1.part2(inputPart2));
  }
}
