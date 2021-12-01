package com.aoc2021;

import com.aoc2021.days.Day1;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Day1Test {

  @Test
  public void day1Test(){

    String input = "199\n"
        + "200\n"
        + "208\n"
        + "210\n"
        + "200\n"
        + "207\n"
        + "240\n"
        + "269\n"
        + "260\n"
        + "2636";
    Assertions.assertEquals("7", Day1.part1(input) );
    String inputPart2 = "607\n"
        + "618\n"
        + "618\n"
        + "617\n"
        + "647\n"
        + "716\n"
        + "769\n"
        + "792\n";

    Assertions.assertEquals("5", Day1.part2(inputPart2) );
  }

}
