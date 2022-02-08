package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) throws Exception {
    try (
        Scanner keyScan = new Scanner(System.in);
        Socket socket = new Socket("localhost", 8888);
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        ) {

      while (true) {
        String str = in.nextLine();
        if (str.length() == 0) {
          break;
        }
        System.out.println(str);
      }

      System.out.print("계산식> ");
      String input = keyScan.nextLine();

      out.println(input);
      out.flush();

      String str = in.nextLine();
      System.out.println(str);

    } catch (Exception e) {
      System.out.println("서버 연결 오류 발생!");
    }
  }
}
