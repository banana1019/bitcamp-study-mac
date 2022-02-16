package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.app2.handler.ScoreHandler;

public class ServerApp {

  ScoreHandler scoreHandler = new ScoreHandler();

  public static void main(String[] args) {
    new ServerApp().service();
  }

  public void service() {
    try (ServerSocket serverSocket = new ServerSocket(3306);) {

      while (true) {
        Socket socket = serverSocket.accept();
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        while (true) {
          String command = in.readUTF();
          if (command.equals("quit")) {
            break;
          }

          switch (command) {
            case "insert":
              break;
            case "selectList":
              break;
            case "selectOne":
              break;
            case "update":
              break;
            case "delete":
              break;
            default:
          }

        }  
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }

    System.out.println("종료!");
  }
}
