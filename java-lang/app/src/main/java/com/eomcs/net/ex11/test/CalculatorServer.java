package com.eomcs.net.ex11.test;

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorServer {
  public static void main(String[] args) throws Exception {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {
      System.out.println("서버 실행 중...");

      while (true) {
        try (
            Socket socket = serverSocket.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream());
            ) {

          out.println("__          __  _                          _ \\");
          out.println("\\ \\        / / | |                        | |");
          out.println("\\ \\  /\\  / /__| | ___ ___  _ __ ___   ___| |");
          out.println("\\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ |");
          out.println("\\  /\\  /  __/ | (_| (_) | | | | | |  __/_|");
          out.println(" \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___(_)");
          out.println("계산식을 입력하세요!");
          out.println("예) 23 + 7");
          out.println();

          String str = in.nextLine();
          out.println(str);
          out.flush();

        } catch (Exception e) {
          System.out.println("클라이언트 요청 처리 중 오류 발생!");
        }
      }

    } catch (Exception e) {
      System.out.println("서버 소켓 생성 중 오류 발생!");
    }
  }
}
