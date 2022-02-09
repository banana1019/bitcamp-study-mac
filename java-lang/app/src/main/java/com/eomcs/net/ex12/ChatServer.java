package com.eomcs.net.ex12;

public class ChatServer {

  int port;

  public ChatServer(int port) {
    this.port = port;
  }

  public void service() {

  }

  public static void main(String[] args) {
    new ChatServer(8888).service();
  }
}
