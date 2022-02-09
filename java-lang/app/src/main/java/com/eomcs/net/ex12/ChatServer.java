package com.eomcs.net.ex12;

import java.net.ServerSocket;

public class ChatServer {

  int port;

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {
      System.out.println("서버 실행 중...");

    } catch (Exception e) {
      System.out.println("서버 실행 오류 - " + e.getMessage());
    }
  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
