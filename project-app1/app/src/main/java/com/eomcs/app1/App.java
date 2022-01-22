package com.eomcs.app1;

public class App {
  public static void main(String[] args) {
    if (args[0].equals("add")) {
      int value1 = Integer.parseInt(args[1]);
      int value2 = Integer.parseInt(args[2]);
      System.out.printf("%d + %d = %d\n", value1, value2, value1 + value2);      
    }
  }
}
