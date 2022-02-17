package com.eomcs.app2;

import java.net.ServerSocket;
import com.eomcs.app2.table.ScoreTable;

public class ServerApp {

  ScoreTable scoreHandler = new ScoreTable();

  public static void main(String[] args) {
    new ServerApp().service();
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(3336);) {
      System.out.println("서버 실행 중...");

      while (true) {
        new RequestHandler(serverSocket.accept()).start();

      } // while (true)
    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }

    System.out.println("종료!");
  }
}









