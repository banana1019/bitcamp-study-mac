package com.eomcs.net.ex11.test;

import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      serverSocket.accept();

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }
}
