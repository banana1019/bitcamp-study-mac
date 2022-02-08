package com.eomcs.net.ex11.test;

import java.net.Socket;

public class CalculatorClient {
  public static void main(String[] args) throws Exception {
    try (Socket serverSocket = new Socket("localhost", 8888)) {
      System.out.println("서버 연결 성공!");
    } catch (Exception e) {
      System.out.println("서버 연결 오류 발생!");
    }
  }
}
