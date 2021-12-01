package com.aoc2021.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DayUtils {

  public static String readFileAsString(String fileName) throws IOException {
    String data = "";
    data = new String(Files.readAllBytes(Paths.get(fileName)));
    return data;
  }

}
