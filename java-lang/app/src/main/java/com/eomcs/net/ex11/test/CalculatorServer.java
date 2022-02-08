package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      try (
          Socket socket = serverSocket.accept();
          Scanner in = new Scanner(socket.getInputStream());
          PrintStream out = new PrintStream(socket.getOutputStream());
          ) {

        String str = in.nextLine();
        out.println(str);
        out.flush();

        in.close();
        out.close();
        socket.close();

      } catch (Exception e) {
        System.out.println("서버 소켓 생성 중 오류 발생!");
      }
    }
  }
}
