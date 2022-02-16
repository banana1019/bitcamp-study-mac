package com.eomcs.app2;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import com.eomcs.app2.table.ScoreTable;
import com.eomcs.app2.vo.Score;

public class ServerApp {

  ScoreTable scoreHandler = new ScoreTable();

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

          try {
            switch (command) {
              case "insert":
                Score score = (Score) in.readObject();
                int count = ScoreTable.insert(score);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              case "selectList":
                Score[] scores = ScoreTable.selectList();
                out.writeUTF("success");
                out.writeObject(scores);
                break;
              case "selectOne":
                int no= in.readInt();
                score = ScoreTable.selectOne(in.readInt());
                out.writeUTF("success");
                out.writeObject(score);
                break;
              case "update":
                no= in.readInt();
                score = (Score) in.readObject();
                count = ScoreTable.update(no, score);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              case "delete":
                no= in.readInt();
                count = ScoreTable.delete(no);
                out.writeUTF("success");
                out.writeInt(count);
                break;
              default:
                out.writeUTF("fail");
                out.writeUTF("해당 명령을 지원하지 않습니다.");              
            }
            out.flush();
          } catch (Exception e) {
            out.writeUTF("fail");
            out.writeUTF("실행 오류: " + e.getMessage());      
          }

        }  
      }

    } catch (Exception e) {
      System.out.println("서버 실행 오류!");
    }

    System.out.println("종료!");
  }
}
